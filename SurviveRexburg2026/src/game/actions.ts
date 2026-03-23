import type { GameState, GameMap, CharacterTemplate, FoodItem, MeleeWeapon, RangedWeapon, Facing } from './types';
import { createGameState, createPlayer, createMap, decreaseHunger, isPlayerStarved, hasPlayerWon } from './state';
import { FOOD_ITEMS, MELEE_WEAPONS, RANGED_WEAPONS } from '../data/items';
import { FORTIFY_DEGRADE_DAYS } from '../data/constants';

/** Initialize a new game with the selected character */
export function startNewGame(character: CharacterTemplate): GameState {
  const state = createGameState();
  return {
    ...state,
    phase: 'playing',
    player: createPlayer(character),
    map: createMap(),
    day: 1,
  };
}

/** Degrade fortification at unoccupied locations: -1 level per FORTIFY_DEGRADE_DAYS away */
function degradeFortifications(state: GameState, newDay: number): GameMap {
  const map = state.map!;
  const player = state.player!;
  const newLocations = map.locations.map(row =>
    row.map(loc => {
      if (loc.row === player.row && loc.col === player.col) return loc;
      if (loc.fortifyLevel <= 0 || loc.lastOccupiedDay <= 0) return loc;
      const daysAway = newDay - loc.lastOccupiedDay;
      const levelsLost = Math.floor(daysAway / FORTIFY_DEGRADE_DAYS);
      if (levelsLost <= 0) return loc;
      return { ...loc, fortifyLevel: Math.max(0, loc.fortifyLevel - levelsLost) };
    })
  );
  return { ...map, locations: newLocations };
}

/** End the current day: decrease hunger, increment day, degrade fortifications, check win/lose */
export function advanceDay(state: GameState): GameState {
  if (!state.player || !state.map) return state;
  const player = decreaseHunger(state.player);
  const newDay = state.day + 1;
  const map = degradeFortifications(state, newDay);

  // Keep current location's lastOccupiedDay current
  map.locations[player.row][player.col] = {
    ...map.locations[player.row][player.col],
    lastOccupiedDay: newDay,
  };

  if (isPlayerStarved(player)) {
    return { ...state, player, map, phase: 'game_over', currentScenario: { type: 'killed_by_hunger' } };
  }
  if (hasPlayerWon(newDay)) {
    return { ...state, player, map, day: newDay, phase: 'won' };
  }
  return { ...state, player, map, day: newDay, currentScenario: null };
}

/** Move player to a new position on the map */
export function movePlayer(state: GameState, row: number, col: number): GameState {
  if (!state.player || !state.map) return state;
  const map = { ...state.map, locations: state.map.locations.map(r => [...r]) };

  // Stamp the location the player is leaving with the current day
  const prevRow = state.player.row;
  const prevCol = state.player.col;
  map.locations[prevRow][prevCol] = { ...map.locations[prevRow][prevCol], lastOccupiedDay: state.day };

  // Mark destination visited and stamp it as occupied
  map.locations[row][col] = { ...map.locations[row][col], visited: true, lastOccupiedDay: state.day };

  let facing: Facing = state.player.facing;
  const dr = row - state.player.row;
  const dc = col - state.player.col;
  if (dr < 0) facing = 'up';
  else if (dr > 0) facing = 'down';
  else if (dc < 0) facing = 'left';
  else if (dc > 0) facing = 'right';

  return { ...state, player: { ...state.player, row, col, facing }, map };
}

/** Pick a random food item (for scavenging / finding items) */
export function pickRandomFood(): FoodItem {
  const idx = Math.floor(Math.random() * FOOD_ITEMS.length);
  return { ...FOOD_ITEMS[idx], quantity: 1 };
}

/** Pick a random weapon — skip fists/ranged_fists */
export function pickRandomWeapon(): MeleeWeapon | RangedWeapon {
  const roll = Math.floor(Math.random() * 100) + 1;
  if (roll >= 66) {
    const idx = Math.floor(Math.random() * 4) + 1; // skip ranged_fists (index 0)
    return { ...RANGED_WEAPONS[idx] };
  }
  const idx = Math.floor(Math.random() * 6) + 1; // skip fists (index 0)
  return { ...MELEE_WEAPONS[idx] };
}

/** Pick a random location */
export function pickRandomLocation(): { row: number; col: number } {
  const roll = Math.floor(Math.random() * 56) + 1;
  if (roll <= 2 || roll === 27 || roll === 28) {
    return roll <= 1 || roll === 27 ? { row: 0, col: 0 } : { row: 0, col: 1 };
  }
  return { row: 0, col: 2 };
}

/** Pick a random orthogonally adjacent location within map bounds */
export function getRandomAdjacentLocation(row: number, col: number, rows: number, cols: number): { row: number; col: number } {
  const adjacent: { row: number; col: number }[] = [];
  if (row > 0) adjacent.push({ row: row - 1, col });
  if (row < rows - 1) adjacent.push({ row: row + 1, col });
  if (col > 0) adjacent.push({ row, col: col - 1 });
  if (col < cols - 1) adjacent.push({ row, col: col + 1 });
  return adjacent[Math.floor(Math.random() * adjacent.length)];
}

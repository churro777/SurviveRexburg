import type { GameState, CharacterTemplate, FoodItem, MeleeWeapon, RangedWeapon } from './types';
import { createGameState, createPlayer, createMap, decreaseHunger, isPlayerStarved, hasPlayerWon } from './state';
import { FOOD_ITEMS, MELEE_WEAPONS, RANGED_WEAPONS } from '../data/items';

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

/** End the current day: decrease hunger, increment day, check win/lose */
export function advanceDay(state: GameState): GameState {
  if (!state.player) return state;
  const player = decreaseHunger(state.player);
  const newDay = state.day + 1;

  if (isPlayerStarved(player)) {
    return { ...state, player, phase: 'game_over', currentScenario: { type: 'killed_by_hunger' } };
  }
  if (hasPlayerWon(newDay)) {
    return { ...state, player, day: newDay, phase: 'won' };
  }
  return { ...state, player, day: newDay, currentScenario: null };
}

/** Move player to a new position on the map */
export function movePlayer(state: GameState, row: number, col: number): GameState {
  if (!state.player || !state.map) return state;
  const map = { ...state.map, locations: state.map.locations.map(r => [...r]) };
  map.locations[row][col] = { ...map.locations[row][col], visited: true };
  return { ...state, player: { ...state.player, row, col }, map };
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

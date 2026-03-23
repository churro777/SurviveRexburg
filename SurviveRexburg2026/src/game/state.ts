import type { GameState, Player, GameMap, Location, CharacterTemplate } from './types';
import { LOCATIONS } from '../data/locations';
import { STARTING_FOOD, MELEE_WEAPONS, RANGED_WEAPONS } from '../data/items';
import {
  MAP_ROWS, MAP_COLS, INITIAL_HEALTH, INITIAL_HUNGER,
  STARTING_LOCATION_ROW, STARTING_LOCATION_COL,
  HEALTH_RESTORE_FOOD, HUNGER_RESTORE_FOOD,
  HEALTH_CAP, HUNGER_CAP, HUNGER_DECREASE_PER_DAY,
  DAMAGE_MIN, DAMAGE_MAX, DAYS_TO_WIN,
} from '../data/constants';

export function createGameState(): GameState {
  return {
    phase: 'menu',
    day: 1,
    player: null,
    map: null,
    currentScenario: null,
    saveName: '',
    exploring: false,
  };
}

export function createPlayer(character: CharacterTemplate): Player {
  const startingFood = STARTING_FOOD.map(f => ({ ...f }));
  const startingWeight = startingFood.reduce((sum, f) => sum + f.weight * f.quantity, 0);
  return {
    name: character.name,
    characterId: character.id,
    strength: character.strength,
    speed: character.speed,
    charisma: character.charisma,
    luck: character.luck,
    health: INITIAL_HEALTH,
    hunger: INITIAL_HUNGER,
    row: STARTING_LOCATION_ROW,
    col: STARTING_LOCATION_COL,
    backpack: {
      maxWeight: 10 * character.strength,
      loadedWeight: startingWeight,
      items: startingFood,
    },
    facing: 'down',
    meleeWeapon: { ...MELEE_WEAPONS[0] },    // Fists
    rangedWeapon: { ...RANGED_WEAPONS[0] },   // Ranged Fists
  };
}

export function createMap(): GameMap {
  const locations: Location[][] = Array.from({ length: MAP_ROWS }, (_, row) =>
    Array.from({ length: MAP_COLS }, (_, col) => {
      const locData = LOCATIONS.find(l => l.row === row && l.col === col);
      if (!locData) throw new Error(`No location data for (${row}, ${col})`);
      return {
        id: locData.id,
        name: locData.name,
        row: locData.row,
        col: locData.col,
        visited: false,
        imagePath: locData.imagePath,
        zombieCount: 0,
        survivorStrength: 0,
        fortifyLevel: 0,
        lastOccupiedDay: 0,
      };
    })
  );

  // Mark starting location as visited
  locations[STARTING_LOCATION_ROW][STARTING_LOCATION_COL].visited = true;

  return { rows: MAP_ROWS, cols: MAP_COLS, locations };
}

export function eatFood(player: Player): Player {
  return {
    ...player,
    health: Math.min(player.health + HEALTH_RESTORE_FOOD, HEALTH_CAP),
    hunger: Math.min(player.hunger + HUNGER_RESTORE_FOOD, HUNGER_CAP),
  };
}

export function eatSpoiledFood(player: Player, healthDamage: number): Player {
  return {
    ...player,
    health: Math.max(0, player.health - healthDamage),
  };
}

export function takeDamage(player: Player): Player {
  const rawDamage = Math.floor(Math.random() * (DAMAGE_MAX - DAMAGE_MIN + 1)) + DAMAGE_MIN;
  const damage = Math.max(0, rawDamage - player.strength);
  return {
    ...player,
    health: Math.max(0, player.health - damage),
  };
}

export function decreaseHunger(player: Player): Player {
  return {
    ...player,
    hunger: Math.max(0, player.hunger - HUNGER_DECREASE_PER_DAY),
  };
}

export function isPlayerDead(player: Player): boolean {
  return player.health <= 0;
}

export function isPlayerStarved(player: Player): boolean {
  return player.hunger <= 0;
}

export function hasPlayerWon(day: number): boolean {
  return day >= DAYS_TO_WIN;
}

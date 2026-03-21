import { describe, it, expect } from 'vitest';
import { startNewGame, advanceDay, movePlayer, pickRandomLocation, pickRandomFood, pickRandomWeapon } from './actions';
import { CHARACTERS } from '../data/characters';

describe('startNewGame', () => {
  it('creates game state with selected character, map, and playing phase', () => {
    const state = startNewGame(CHARACTERS[0]); // Ben
    expect(state.phase).toBe('playing');
    expect(state.player).not.toBeNull();
    expect(state.player!.name).toBe('Ben');
    expect(state.map).not.toBeNull();
    expect(state.day).toBe(1);
  });
});

describe('advanceDay', () => {
  it('increments day, decreases hunger, checks win/lose', () => {
    const state = startNewGame(CHARACTERS[0]);
    const next = advanceDay(state);
    expect(next.day).toBe(2);
    expect(next.player!.hunger).toBe(90);
  });

  it('triggers game_over when hunger reaches 0', () => {
    const state = startNewGame(CHARACTERS[0]);
    state.player!.hunger = 5;
    const next = advanceDay(state);
    expect(next.phase).toBe('game_over');
  });

  it('triggers won when day reaches 30', () => {
    const state = startNewGame(CHARACTERS[0]);
    state.day = 29;
    state.player!.hunger = 100;
    const next = advanceDay(state);
    expect(next.phase).toBe('won');
  });
});

describe('movePlayer', () => {
  it('updates player position and marks location visited', () => {
    const state = startNewGame(CHARACTERS[0]);
    const next = movePlayer(state, 6, 3); // Alleyway
    expect(next.player!.row).toBe(6);
    expect(next.player!.col).toBe(3);
    expect(next.map!.locations[6][3].visited).toBe(true);
  });
});

describe('pickRandomFood', () => {
  it('returns one of the 8 food items', () => {
    for (let i = 0; i < 50; i++) {
      const food = pickRandomFood();
      expect(food.type).toBe('food');
    }
  });
});

describe('pickRandomWeapon', () => {
  it('returns a melee or ranged weapon (never fists)', () => {
    for (let i = 0; i < 50; i++) {
      const weapon = pickRandomWeapon();
      expect(weapon.id).not.toBe('fists');
      expect(weapon.id).not.toBe('ranged_fists');
    }
  });
});

describe('pickRandomLocation', () => {
  it('returns a valid grid position', () => {
    const { row, col } = pickRandomLocation();
    expect(row).toBeGreaterThanOrEqual(0);
    expect(row).toBeLessThan(8);
    expect(col).toBeGreaterThanOrEqual(0);
    expect(col).toBeLessThan(7);
  });
});

import { describe, it, expect, vi } from 'vitest';
import { createGameState, createPlayer, createMap, eatFood, eatSpoiledFood, takeDamage, decreaseHunger, isPlayerDead, isPlayerStarved, hasPlayerWon } from './state';
import { CHARACTERS } from '../data/characters';

describe('createGameState', () => {
  it('creates initial game state in menu phase', () => {
    const state = createGameState();
    expect(state.phase).toBe('menu');
    expect(state.day).toBe(1);
    expect(state.fortifyLevel).toBe(0);
    expect(state.player).toBeNull();
    expect(state.map).toBeNull();
  });
});

describe('createPlayer', () => {
  it('creates a player with correct initial stats', () => {
    const ben = CHARACTERS[0]; // Ben: str=10
    const player = createPlayer(ben);
    expect(player.health).toBe(100);
    expect(player.hunger).toBe(100);
    expect(player.row).toBe(6);
    expect(player.col).toBe(2); // Bunkhouse
    expect(player.meleeWeapon.id).toBe('fists');
    expect(player.rangedWeapon.id).toBe('ranged_fists');
    expect(player.backpack.maxWeight).toBe(100); // 10 * str(10)
    expect(player.backpack.items.length).toBe(8); // 8 starting food items
  });
});

describe('createMap', () => {
  it('creates 8x7 grid with 56 locations', () => {
    const map = createMap();
    expect(map.rows).toBe(8);
    expect(map.cols).toBe(7);
    expect(map.locations[6][2].name).toBe('Bunkhouse Apartments');
  });
});

describe('eatFood', () => {
  it('restores 15 health and 15 hunger, capped at 100', () => {
    const player = createPlayer(CHARACTERS[0]);
    player.health = 50;
    player.hunger = 50;
    const updated = eatFood(player);
    expect(updated.health).toBe(65);
    expect(updated.hunger).toBe(65);
  });

  it('caps health and hunger at 100', () => {
    const player = createPlayer(CHARACTERS[0]);
    player.health = 90;
    player.hunger = 95;
    const updated = eatFood(player);
    expect(updated.health).toBe(100);
    expect(updated.hunger).toBe(100);
  });
});

describe('eatSpoiledFood', () => {
  it('damages health by the spoiled food damage value', () => {
    const player = createPlayer(CHARACTERS[0]);
    const updated = eatSpoiledFood(player, 3); // sour milk = 3 damage
    expect(updated.health).toBe(97);
  });
});

describe('takeDamage', () => {
  it('reduces health by damage formula result', () => {
    const player = createPlayer(CHARACTERS[0]); // str=10
    // With str=10, damage = random(11-35) - 10 = 1-25
    // Mock Math.random for deterministic tests
    const mockRandom = vi.spyOn(Math, 'random').mockReturnValue(0); // min damage: 11 - 10 = 1
    const updated = takeDamage(player);
    expect(updated.health).toBe(99);
    mockRandom.mockRestore();
  });
});

describe('decreaseHunger', () => {
  it('decreases hunger by 10', () => {
    const player = createPlayer(CHARACTERS[0]);
    const updated = decreaseHunger(player);
    expect(updated.hunger).toBe(90);
  });
});

describe('win/lose conditions', () => {
  it('detects starvation', () => {
    const player = createPlayer(CHARACTERS[0]);
    player.hunger = 0;
    expect(isPlayerStarved(player)).toBe(true);
  });

  it('detects death', () => {
    const player = createPlayer(CHARACTERS[0]);
    player.health = 0;
    expect(isPlayerDead(player)).toBe(true);
  });

  it('detects win at day 30', () => {
    expect(hasPlayerWon(30)).toBe(true);
    expect(hasPlayerWon(29)).toBe(false);
  });
});

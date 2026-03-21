import { describe, it, expect, beforeEach } from 'vitest';
import { saveGame, loadGame, listSaves, deleteSave, exportSave, importSave } from './save-manager';
import { startNewGame } from '../game/actions';
import { CHARACTERS } from '../data/characters';

// Mock localStorage
const store: Record<string, string> = {};
const mockLocalStorage = {
  getItem: (key: string) => store[key] ?? null,
  setItem: (key: string, value: string) => { store[key] = value; },
  removeItem: (key: string) => { delete store[key]; },
};
Object.defineProperty(globalThis, 'localStorage', { value: mockLocalStorage });

beforeEach(() => {
  for (const key of Object.keys(store)) delete store[key];
});

describe('saveGame / loadGame', () => {
  it('saves and loads game state', () => {
    const state = startNewGame(CHARACTERS[0]);
    saveGame(1, state);
    const loaded = loadGame(1);
    expect(loaded).not.toBeNull();
    expect(loaded!.player!.name).toBe('Ben');
  });

  it('returns null for empty slot', () => {
    expect(loadGame(2)).toBeNull();
  });

  it('returns null for corrupted data', () => {
    store['survive_rexburg_save_3'] = 'not valid json{{{';
    expect(loadGame(3)).toBeNull();
  });
});

describe('listSaves', () => {
  it('lists all saved games', () => {
    const state = startNewGame(CHARACTERS[0]);
    saveGame(1, state);
    saveGame(2, { ...state, saveName: 'Save Two' });
    const saves = listSaves();
    expect(saves.length).toBe(2);
    expect(saves[1].saveName).toBe('Save Two');
  });
});

describe('deleteSave', () => {
  it('removes a saved game', () => {
    saveGame(1, startNewGame(CHARACTERS[0]));
    deleteSave(1);
    expect(loadGame(1)).toBeNull();
  });
});

describe('exportSave / importSave', () => {
  it('exports and imports save data', () => {
    const state = startNewGame(CHARACTERS[0]);
    saveGame(1, state);
    const json = exportSave(1);
    expect(json).not.toBeNull();
    deleteSave(1);
    expect(importSave(1, json!)).toBe(true);
    expect(loadGame(1)).not.toBeNull();
  });

  it('rejects invalid import data', () => {
    expect(importSave(1, 'bad data')).toBe(false);
  });
});

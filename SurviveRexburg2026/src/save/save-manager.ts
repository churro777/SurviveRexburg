import { GameState, SaveData } from '../game/types';

const SAVE_KEY_PREFIX = 'survive_rexburg_save_';
const SAVE_VERSION = 1;

export function saveGame(slot: number, state: GameState): void {
  const data: SaveData = {
    version: SAVE_VERSION,
    timestamp: new Date().toISOString(),
    state,
  };
  localStorage.setItem(`${SAVE_KEY_PREFIX}${slot}`, JSON.stringify(data));
}

export function loadGame(slot: number): GameState | null {
  const raw = localStorage.getItem(`${SAVE_KEY_PREFIX}${slot}`);
  if (!raw) return null;
  try {
    const data: SaveData = JSON.parse(raw);
    if (!data.version || !data.state || !data.state.phase) return null;
    return data.state;
  } catch {
    return null;
  }
}

export function listSaves(): { slot: number; timestamp: string; saveName: string }[] {
  const saves: { slot: number; timestamp: string; saveName: string }[] = [];
  for (let i = 1; i <= 3; i++) {
    const raw = localStorage.getItem(`${SAVE_KEY_PREFIX}${i}`);
    if (raw) {
      try {
        const data: SaveData = JSON.parse(raw);
        saves.push({ slot: i, timestamp: data.timestamp, saveName: data.state.saveName });
      } catch {
        // skip corrupted saves
      }
    }
  }
  return saves;
}

export function deleteSave(slot: number): void {
  localStorage.removeItem(`${SAVE_KEY_PREFIX}${slot}`);
}

export function exportSave(slot: number): string | null {
  const raw = localStorage.getItem(`${SAVE_KEY_PREFIX}${slot}`);
  return raw;
}

export function importSave(slot: number, json: string): boolean {
  try {
    const data: SaveData = JSON.parse(json);
    if (!data.version || !data.state || !data.state.phase) return false;
    localStorage.setItem(`${SAVE_KEY_PREFIX}${slot}`, json);
    return true;
  } catch {
    return false;
  }
}

import { createContext, useContext, useState, useCallback } from 'react';
import type { ReactNode } from 'react';
import type { GameState } from '../game/types';
import { createGameState } from '../game/state';

interface GameContextValue {
  state: GameState;
  setState: (updater: (prev: GameState) => GameState) => void;
}

const GameContext = createContext<GameContextValue | null>(null);

export function GameProvider({ children }: { children: ReactNode }) {
  const [state, setStateRaw] = useState<GameState>(createGameState);

  const setState = useCallback((updater: (prev: GameState) => GameState) => {
    setStateRaw(prev => updater(prev));
  }, []);

  return (
    <GameContext.Provider value={{ state, setState }}>
      {children}
    </GameContext.Provider>
  );
}

export function useGameContext(): GameContextValue {
  const ctx = useContext(GameContext);
  if (!ctx) throw new Error('useGameContext must be used within GameProvider');
  return ctx;
}

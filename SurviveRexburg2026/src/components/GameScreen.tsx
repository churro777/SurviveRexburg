import { useState, useEffect } from 'react';
import { GameCanvas } from '../engine/GameCanvas';
import { HUD } from './HUD';
import { DailyActionDialog } from './DailyActionDialog';
import { ScenarioDialog } from './ScenarioDialog';
import { InventoryPanel } from './InventoryPanel';
import { SaveLoadMenu } from './SaveLoadMenu';
import { HelpScreen } from './HelpScreen';
import { useGameState } from '../hooks/useGameState';
import './GameScreen.css';

export function GameScreen() {
  const { state, performDailyAction } = useGameState();
  const [showInventory, setShowInventory] = useState(false);
  const [showSave, setShowSave] = useState(false);
  const [showHelp, setShowHelp] = useState(false);
  const [showDailyAction, setShowDailyAction] = useState(true);

  // Toggle inventory with 'I' key, help with 'H'
  useEffect(() => {
    const handleKey = (e: KeyboardEvent) => {
      if (e.key === 'i' || e.key === 'I') {
        if (state.phase === 'playing') setShowInventory(prev => !prev);
      }
      if (e.key === 'h' || e.key === 'H') {
        if (state.phase === 'playing') setShowHelp(prev => !prev);
      }
    };
    window.addEventListener('keydown', handleKey);
    return () => window.removeEventListener('keydown', handleKey);
  }, [state.phase]);

  if (showHelp) return <HelpScreen onBack={() => setShowHelp(false)} />;
  if (showSave) return <SaveLoadMenu mode="save" onBack={() => setShowSave(false)} />;

  return (
    <div className="game-screen">
      <GameCanvas />
      <HUD />

      <div className="game-buttons">
        <button onClick={() => setShowInventory(true)} title="Inventory (I)">INV</button>
        <button onClick={() => setShowSave(true)} title="Save">SAVE</button>
        <button onClick={() => setShowHelp(true)} title="Help (H)">HELP</button>
      </div>

      {state.phase === 'playing' && showDailyAction && (
        <DailyActionDialog onAction={(action) => {
          setShowDailyAction(false);
          performDailyAction(action);
        }} />
      )}

      {state.phase === 'scenario' && state.currentScenario && (
        <ScenarioDialog />
      )}

      {showInventory && (
        <InventoryPanel onClose={() => setShowInventory(false)} />
      )}
    </div>
  );
}

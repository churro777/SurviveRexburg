import { useGameState } from '../hooks/useGameState';
import './GameOverScreen.css';

export function VictoryScreen() {
  const { state, goToMenu } = useGameState();

  return (
    <div className="game-over-screen victory">
      <h1 className="victory-title">YOU SURVIVED<br />REXBURG!</h1>
      <p className="victory-subtitle">30 Days of Zombie Apocalypse Conquered</p>
      <div className="final-stats">
        {state.player && (
          <>
            <p>Character: {state.player.name}</p>
            <p>Final Health: {state.player.health}</p>
            <p>Final Hunger: {state.player.hunger}</p>
            <p>Items Collected: {state.player.backpack.items.length}</p>
          </>
        )}
      </div>
      <button className="play-again-btn" onClick={goToMenu}>Play Again</button>
    </div>
  );
}

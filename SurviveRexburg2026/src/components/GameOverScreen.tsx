import { useGameState } from '../hooks/useGameState';
import './GameOverScreen.css';

export function GameOverScreen() {
  const { state, goToMenu } = useGameState();

  const deathCause = state.currentScenario?.type === 'killed_by_zombies'
    ? 'Devoured by zombies'
    : state.currentScenario?.type === 'killed_by_survivors'
    ? 'Killed by hostile survivors'
    : state.currentScenario?.type === 'killed_by_hunger'
    ? 'Starved to death'
    : 'Unknown cause';

  const daysSurvived = state.day;

  return (
    <div className="game-over-screen">
      <h1 className="game-over-title">GAME OVER</h1>
      <p className="death-cause">{deathCause}</p>
      <div className="final-stats">
        <p>Days Survived: {daysSurvived}</p>
        {state.player && (
          <>
            <p>Final Health: {state.player.health}</p>
            <p>Final Hunger: {state.player.hunger}</p>
          </>
        )}
      </div>
      <button className="play-again-btn" onClick={goToMenu}>Play Again</button>
    </div>
  );
}

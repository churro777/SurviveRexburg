import { useGameState } from '../hooks/useGameState';
import { MAX_FORTIFY_LEVEL } from '../data/constants';
import './HUD.css';

export function HUD() {
  const { state } = useGameState();

  if (!state.player || !state.map) return null;

  const { player, day, map } = state;
  const currentLocation = map.locations[player.row][player.col];
  const fortifyLevel = currentLocation.fortifyLevel;

  return (
    <div className="hud">
      <div className="hud-top">
        <div className="hud-stats">
          <div className="hud-stat">
            <span className="hud-label">HP</span>
            <div className="hud-bar">
              <div className="hud-bar-fill hp" style={{ width: `${player.health}%` }} />
            </div>
            <span className="hud-value">{player.health}</span>
          </div>
          <div className="hud-stat">
            <span className="hud-label">HNG</span>
            <div className="hud-bar">
              <div className="hud-bar-fill hunger" style={{ width: `${player.hunger}%` }} />
            </div>
            <span className="hud-value">{player.hunger}</span>
          </div>
          <div className="hud-stat">
            <span className="hud-label">BRC</span>
            <div className="hud-bar">
              <div className="hud-bar-fill barricade" style={{ width: `${(fortifyLevel / MAX_FORTIFY_LEVEL) * 100}%` }} />
            </div>
            <span className="hud-value">Lvl {fortifyLevel}</span>
          </div>
        </div>
        <div className="hud-info">
          <span>Day {day}</span>
          <span>{currentLocation.name}</span>
        </div>
      </div>

      <div className="hud-minimap">
        {Array.from({ length: map.rows }, (_, r) => (
          <div key={r} className="minimap-row">
            {Array.from({ length: map.cols }, (_, c) => (
              <div
                key={c}
                className={`minimap-tile ${map.locations[r][c].visited ? 'visited' : ''} ${r === player.row && c === player.col ? 'player' : ''}`}
              />
            ))}
          </div>
        ))}
      </div>
    </div>
  );
}

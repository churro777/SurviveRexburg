import { useGameState } from '../hooks/useGameState';
import { MAX_FORTIFY_LEVEL } from '../data/constants';
import type { DailyAction } from '../game/types';
import './DailyActionDialog.css';

interface Props {
  onAction: (action: DailyAction) => void;
}

export function DailyActionDialog({ onAction }: Props) {
  const { state } = useGameState();
  const isMaxFortified = state.fortifyLevel >= MAX_FORTIFY_LEVEL;

  return (
    <div className="daily-action-dialog">
      <div className="dialog-box">
        <p className="dialog-text">Day {state.day} — What do you want to do?</p>
        <div className="dialog-choices">
          <button onClick={() => onAction('explore')}>Explore Rexburg</button>
          {isMaxFortified ? (
            <button disabled className="action-disabled">Barricade fully reinforced</button>
          ) : (
            <button onClick={() => onAction('fortify')}>Fortify Location</button>
          )}
          <button onClick={() => onAction('scavenge')}>Scavenge Location</button>
          <button onClick={() => onAction('do_nothing')}>Sit and Wait</button>
        </div>
      </div>
    </div>
  );
}

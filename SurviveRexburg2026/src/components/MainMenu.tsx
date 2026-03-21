import { useGameState } from '../hooks/useGameState';
import './MainMenu.css';

interface MainMenuProps {
  onNewGame: () => void;
  onHelp: () => void;
  onAbout: () => void;
  onLoad: () => void;
}

export function MainMenu({ onHelp, onAbout, onLoad }: MainMenuProps) {
  const { goToCharacterSelect } = useGameState();

  return (
    <div className="main-menu">
      <div className="menu-title">
        <h1>SURVIVE<br />REXBURG</h1>
        <p className="subtitle">2026 Edition</p>
      </div>
      <div className="menu-buttons">
        <button onClick={goToCharacterSelect}>New Game</button>
        <button onClick={onLoad}>Load Game</button>
        <button onClick={onHelp}>Help</button>
        <button onClick={onAbout}>About</button>
      </div>
    </div>
  );
}

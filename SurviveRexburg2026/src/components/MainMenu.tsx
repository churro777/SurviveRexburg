import { useGameState } from '../hooks/useGameState';
import { audioManager } from '../engine/audio';
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
        <button onClick={() => { audioManager.play('menu_select'); goToCharacterSelect(); }}>New Game</button>
        <button onClick={() => { audioManager.play('menu_select'); onLoad(); }}>Load Game</button>
        <button onClick={() => { audioManager.play('menu_select'); onHelp(); }}>Help</button>
        <button onClick={() => { audioManager.play('menu_select'); onAbout(); }}>About</button>
      </div>
      <span className="version-tag">{__COMMIT_HASH__}</span>
    </div>
  );
}

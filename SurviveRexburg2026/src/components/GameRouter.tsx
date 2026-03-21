import { useState } from 'react';
import { useGameState } from '../hooks/useGameState';
import { MainMenu } from './MainMenu';
import { CharacterSelect } from './CharacterSelect';
import { GameScreen } from './GameScreen';
import { GameOverScreen } from './GameOverScreen';
import { VictoryScreen } from './VictoryScreen';
import { HelpScreen } from './HelpScreen';
import { AboutScreen } from './AboutScreen';
import { SaveLoadMenu } from './SaveLoadMenu';

export function GameRouter() {
  const { state } = useGameState();
  const [overlay, setOverlay] = useState<'none' | 'help' | 'about' | 'load'>('none');

  if (overlay === 'help') return <HelpScreen onBack={() => setOverlay('none')} />;
  if (overlay === 'about') return <AboutScreen onBack={() => setOverlay('none')} />;
  if (overlay === 'load') return <SaveLoadMenu mode="load" onBack={() => setOverlay('none')} />;

  switch (state.phase) {
    case 'menu':
      return (
        <MainMenu
          onNewGame={() => {}}
          onHelp={() => setOverlay('help')}
          onAbout={() => setOverlay('about')}
          onLoad={() => setOverlay('load')}
        />
      );
    case 'character_select':
      return <CharacterSelect />;
    case 'playing':
    case 'scenario':
      return <GameScreen />;
    case 'game_over':
      return <GameOverScreen />;
    case 'won':
      return <VictoryScreen />;
    default:
      return <MainMenu onNewGame={() => {}} onHelp={() => setOverlay('help')} onAbout={() => setOverlay('about')} onLoad={() => setOverlay('load')} />;
  }
}

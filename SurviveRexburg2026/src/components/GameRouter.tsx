import { useState, useEffect, useRef } from 'react';
import { useGameState } from '../hooks/useGameState';
import { audioManager, preloadAllAudio } from '../engine/audio';
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
  const [audioLoaded, setAudioLoaded] = useState(false);
  const prevPhase = useRef(state.phase);

  // Preload audio on first user interaction
  useEffect(() => {
    const loadAudio = () => {
      if (!audioLoaded) {
        preloadAllAudio().then(() => setAudioLoaded(true));
        window.removeEventListener('click', loadAudio);
        window.removeEventListener('keydown', loadAudio);
      }
    };
    window.addEventListener('click', loadAudio);
    window.addEventListener('keydown', loadAudio);
    return () => {
      window.removeEventListener('click', loadAudio);
      window.removeEventListener('keydown', loadAudio);
    };
  }, [audioLoaded]);

  // Play music based on game phase
  useEffect(() => {
    if (!audioLoaded) return;
    if (state.phase === prevPhase.current) return;
    prevPhase.current = state.phase;

    audioManager.stop();

    switch (state.phase) {
      case 'menu':
      case 'character_select':
        audioManager.play('menu_theme', true);
        break;
      case 'playing':
        audioManager.play('exploration', true);
        break;
      case 'scenario':
        if (state.currentScenario?.type === 'zombies_attack' ||
            state.currentScenario?.type === 'survivors_attack') {
          audioManager.play('combat', true);
        }
        break;
      case 'game_over':
        audioManager.play('game_over', false);
        break;
      case 'won':
        audioManager.play('victory', false);
        break;
    }
  }, [state.phase, state.currentScenario, audioLoaded]);

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

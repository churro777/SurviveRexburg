import { GameProvider } from './hooks/GameContext';
import { GameRouter } from './components/GameRouter';
import './index.css';

function App() {
  return (
    <GameProvider>
      <GameRouter />
    </GameProvider>
  );
}

export default App;

import { useState, useEffect } from 'react';
import { useGameState } from '../hooks/useGameState';
import { saveGame, loadGame, listSaves, deleteSave, exportSave, importSave } from '../save/save-manager';
import './SaveLoadMenu.css';

interface Props {
  mode: 'save' | 'load';
  onBack: () => void;
}

export function SaveLoadMenu({ mode, onBack }: Props) {
  const { state, setState } = useGameState();
  const [saves, setSaves] = useState<{ slot: number; timestamp: string; saveName: string }[]>([]);
  const [message, setMessage] = useState('');

  useEffect(() => {
    setSaves(listSaves());
  }, []);

  const handleSave = (slot: number) => {
    saveGame(slot, state);
    setSaves(listSaves());
    setMessage(`Saved to slot ${slot}!`);
  };

  const handleLoad = (slot: number) => {
    const loaded = loadGame(slot);
    if (loaded) {
      setState(() => loaded);
      onBack();
    } else {
      setMessage('Failed to load save.');
    }
  };

  const handleDelete = (slot: number) => {
    deleteSave(slot);
    setSaves(listSaves());
    setMessage(`Slot ${slot} deleted.`);
  };

  const handleExport = (slot: number) => {
    const json = exportSave(slot);
    if (!json) return;
    const blob = new Blob([json], { type: 'application/json' });
    const url = URL.createObjectURL(blob);
    const a = document.createElement('a');
    a.href = url;
    a.download = `survive_rexburg_save_${slot}.json`;
    a.click();
    URL.revokeObjectURL(url);
  };

  const handleImport = (slot: number) => {
    const input = document.createElement('input');
    input.type = 'file';
    input.accept = '.json';
    input.onchange = (e) => {
      const file = (e.target as HTMLInputElement).files?.[0];
      if (!file) return;
      const reader = new FileReader();
      reader.onload = () => {
        const success = importSave(slot, reader.result as string);
        if (success) {
          setSaves(listSaves());
          setMessage(`Imported to slot ${slot}!`);
        } else {
          setMessage('Invalid save file.');
        }
      };
      reader.readAsText(file);
    };
    input.click();
  };

  return (
    <div className="save-load-menu">
      <h2>{mode === 'save' ? 'Save Game' : 'Load Game'}</h2>
      {message && <p className="save-message">{message}</p>}

      <div className="save-slots">
        {[1, 2, 3].map(slot => {
          const save = saves.find(s => s.slot === slot);
          return (
            <div key={slot} className="save-slot">
              <div className="slot-info">
                <span className="slot-number">Slot {slot}</span>
                {save ? (
                  <>
                    <span className="slot-name">{save.saveName || 'Unnamed'}</span>
                    <span className="slot-time">{new Date(save.timestamp).toLocaleString()}</span>
                  </>
                ) : (
                  <span className="slot-empty">Empty</span>
                )}
              </div>
              <div className="slot-actions">
                {mode === 'save' && (
                  <button onClick={() => handleSave(slot)}>Save</button>
                )}
                {save && (
                  <>
                    {mode === 'load' && <button onClick={() => handleLoad(slot)}>Load</button>}
                    <button onClick={() => handleExport(slot)}>Export</button>
                    <button className="danger" onClick={() => handleDelete(slot)}>Delete</button>
                  </>
                )}
                <button onClick={() => handleImport(slot)}>Import</button>
              </div>
            </div>
          );
        })}
      </div>

      <button className="back-btn" onClick={onBack}>Back</button>
    </div>
  );
}

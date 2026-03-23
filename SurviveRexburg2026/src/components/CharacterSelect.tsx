import { useState, useCallback } from 'react';
import { useGameState } from '../hooks/useGameState';
import { CHARACTERS } from '../data/characters';
import type { CharacterTemplate } from '../game/types';
import './CharacterSelect.css';

const CONFIRM_MESSAGES: Record<string, string> = {
  ben: "Are you sure? He only has 1 Charisma.",
  bing: "Are you sure?",
  hayley: "Are you sure? Good luck.",
  megan: "Are you sure? Good choice!",
  nathan: "Are you sure? That's kinda cheap...",
};

export function CharacterSelect() {
  const { selectCharacter, goToMenu } = useGameState();
  const [declinedCharacters, setDeclinedCharacters] = useState<Set<string>>(new Set());
  const [pendingCharacter, setPendingCharacter] = useState<CharacterTemplate | null>(null);

  const normalCharacters = CHARACTERS.filter(c => !c.hidden);

  const handleDecline = useCallback((characterId: string) => {
    console.log('[Nathan] Declining character:', characterId);
    setDeclinedCharacters(prev => {
      const next = new Set(prev).add(characterId);
      console.log('[Nathan] Declined set:', [...next], 'size:', next.size);
      return next;
    });
    setPendingCharacter(null);
  }, []);

  console.log('[Nathan] declinedCharacters size:', declinedCharacters.size, 'needed:', normalCharacters.length, 'showNathan:', declinedCharacters.size >= normalCharacters.length);
  const showNathan = declinedCharacters.size >= normalCharacters.length;

  const visibleCharacters = CHARACTERS.filter(c => !c.hidden || showNathan);

  return (
    <div className="character-select">
      <h2>Choose Your Survivor</h2>
      <div className="character-grid">
        {visibleCharacters.map(char => (
          <CharacterCard key={char.id} character={char} onSelect={() => setPendingCharacter(char)} />
        ))}
      </div>
      <button className="back-btn" onClick={goToMenu}>Back</button>

      {pendingCharacter && (
        <div className="confirm-overlay" onClick={() => setPendingCharacter(null)}>
          <div className="confirm-dialog" onClick={e => e.stopPropagation()}>
            <h3>You Chose {pendingCharacter.name}</h3>
            <p>{CONFIRM_MESSAGES[pendingCharacter.id] ?? "Are you sure?"}</p>
            <div className="confirm-buttons">
              <button className="confirm-yes" onClick={() => selectCharacter(pendingCharacter)}>Yes</button>
              <button className="confirm-no" onClick={() => handleDecline(pendingCharacter.id)}>No</button>
            </div>
          </div>
        </div>
      )}
    </div>
  );
}

function CharacterCard({ character, onSelect }: { character: CharacterTemplate; onSelect: () => void }) {
  const maxStat = 10;
  return (
    <div className={`character-card ${character.hidden ? 'secret' : ''}`} onClick={onSelect}>
      <h3>{character.name}</h3>
      <div className="stats">
        <StatBar label="STR" value={character.strength} max={maxStat} color="#ef4444" />
        <StatBar label="SPD" value={character.speed} max={maxStat} color="#3b82f6" />
        <StatBar label="CHR" value={character.charisma} max={maxStat} color="#eab308" />
        <StatBar label="LCK" value={character.luck} max={maxStat} color="#a855f7" />
      </div>
    </div>
  );
}

function StatBar({ label, value, max, color }: { label: string; value: number; max: number; color: string }) {
  return (
    <div className="stat-bar">
      <span className="stat-label">{label}</span>
      <div className="stat-track">
        <div className="stat-fill" style={{ width: `${(value / max) * 100}%`, backgroundColor: color }} />
      </div>
      <span className="stat-value">{value}</span>
    </div>
  );
}

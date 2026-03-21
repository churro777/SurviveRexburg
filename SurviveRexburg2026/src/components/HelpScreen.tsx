import './HelpScreen.css';

interface Props {
  onBack: () => void;
}

export function HelpScreen({ onBack }: Props) {
  return (
    <div className="help-screen">
      <h2>How to Play</h2>
      <div className="help-content">
        <section>
          <h3>Objective</h3>
          <p>Survive 30 days in zombie-infested Rexburg, Idaho. Manage your health, hunger, and resources to stay alive.</p>
        </section>
        <section>
          <h3>Controls</h3>
          <p>WASD / Arrow Keys - Move on the map</p>
          <p>Click adjacent tile - Move</p>
          <p>I - Toggle inventory</p>
          <p>H - Toggle help</p>
        </section>
        <section>
          <h3>Daily Actions</h3>
          <p><strong>Explore</strong> - Move to a new location. May encounter survivors or zombies.</p>
          <p><strong>Fortify</strong> - Strengthen your position. Safer but uses your day.</p>
          <p><strong>Scavenge</strong> - Search for food and weapons. Risky but rewarding.</p>
          <p><strong>Sit and Wait</strong> - Rest in place. Low risk, but hunger still decreases.</p>
        </section>
        <section>
          <h3>Stats</h3>
          <p><strong>Strength (STR)</strong> - Reduces combat damage, increases carry weight.</p>
          <p><strong>Speed (SPD)</strong> - Better escape chances when running.</p>
          <p><strong>Charisma (CHR)</strong> - Better negotiation with survivors.</p>
          <p><strong>Luck (LCK)</strong> - Improves all probability rolls.</p>
        </section>
        <section>
          <h3>Tips</h3>
          <p>Eat food from your inventory to restore health and hunger.</p>
          <p>Watch out for spoiled food - it damages your health!</p>
          <p>Equip better weapons to improve combat odds.</p>
          <p>The difficulty increases each day as luck penalties grow.</p>
        </section>
      </div>
      <button className="back-btn" onClick={onBack}>Back</button>
    </div>
  );
}

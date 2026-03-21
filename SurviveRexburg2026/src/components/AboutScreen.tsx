import './HelpScreen.css';

interface Props {
  onBack: () => void;
}

export function AboutScreen({ onBack }: Props) {
  return (
    <div className="help-screen">
      <h2>About</h2>
      <div className="help-content">
        <section>
          <h3>Survive Rexburg</h3>
          <p>A zombie survival game set in Rexburg, Idaho.</p>
          <p>Originally created by Arturo Aguila and Hayley Cox, Spring 2014, BYU-Idaho CIT 260.</p>
          <p>Ported to the web in 2026.</p>
        </section>
        <section>
          <h3>Credits</h3>
          <p>Game Design: Arturo Aguila, Hayley Cox</p>
          <p>Web Port: Arturo Aguila</p>
          <p>Built with React, TypeScript, Vite, and HTML5 Canvas</p>
        </section>
      </div>
      <button className="back-btn" onClick={onBack}>Back</button>
    </div>
  );
}

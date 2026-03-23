# SurviveRexburg

## What This Is

A zombie survival game set in Rexburg, Idaho. Originally built as a Java Swing game for BYU-Idaho CIT 260 (Spring 2014) by Arturo and Hayley Cox. Now being ported to a modern web app.

## The Port: SurviveRexburg 2026

Porting the original Java game to a **React + Vite + TypeScript** web app with HTML5 Canvas rendering and a pixel art / retro aesthetic. Hosted on **GitHub Pages** as a static site.

### Status

Task 1 (project scaffolding) is complete. Tasks 2-28 remain.

### Key Docs

- **Design spec:** `docs/superpowers/specs/2026-03-20-surviveRexburg-port-design.md` — full game mechanics, architecture, data model, UI design
- **Implementation plan:** `docs/superpowers/plans/2026-03-20-surviveRexburg-port.md` — 28-task plan with step-by-step instructions

### Project Layout

```
SurvivRexburg/          # Original Java source (CIT 260, 2014)
  src/byui/cit260/      # Java packages: surviveRexburg/, survivRexburg/
SurviveRexburg2026/     # New web port (React + Vite + TS)
  src/                   # App entry point (main.tsx, App.tsx) — game/, engine/, components/, data/, etc. to be created per plan
docs/superpowers/        # Design spec + implementation plan
```

### Architecture

- **`game/`** — Pure TypeScript game logic (no React). State, combat, scenarios, inventory, probability engine.
- **`engine/`** — HTML5 Canvas rendering, game loop, sprite system, audio manager.
- **`components/`** — React UI overlays: menus, HUD, dialogs, inventory panel.
- **`data/`** — Static game data: locations (56), items, characters (5), scenarios.
- **`hooks/`** — React hooks bridging game state to UI.
- **`save/`** — Save/load via localStorage + JSON export/import.

### Tech Stack

- React 19, Vite 8, TypeScript 5.9, Vitest
- HTML5 Canvas for map/sprite rendering
- React for UI overlays on top of canvas

### Game Essentials

- 5 characters with stats (strength, speed, charisma, luck). Nathan is a hidden cheat character.
- 8x7 grid map of 56 real Rexburg locations. Player starts at Bunkhouse (index 44).
- Daily cycle: explore, fortify, scavenge, or wait. Hunger drops 10/day.
- Probability engine uses stat-based rolls minus daysPassed for difficulty scaling.
- Win condition: survive 30 days.

### Commands

```bash
cd SurviveRexburg2026
npm run dev          # Start dev server
npm run build        # Production build (tsc + vite)
npm run lint         # ESLint
npm test             # Vitest (run once)
npm run test:watch   # Vitest (watch mode)
```

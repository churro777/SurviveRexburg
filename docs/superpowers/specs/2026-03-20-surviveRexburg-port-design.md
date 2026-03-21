# SurviveRexburg 2026 — Web Port Design Spec

## Overview

Port the original SurviveRexburg Java Swing game (Spring 2014, BYU-Idaho CIT 260) to a modern web app. The port preserves the original game mechanics faithfully while modernizing the UX with a pixel art / retro aesthetic.

**Hosted on:** GitHub Pages (static site, no server)
**Stack:** React + Vite + TypeScript, HTML5 Canvas
**Project location:** `SurviveRexburg2026/` alongside the original `SurvivRexburg/` in the same repo

## Original Game Summary

- Zombie survival game set in Rexburg, Idaho
- 5 playable characters (Ben, Bing, Hayley, Megan, Nate) with stats: strength, speed, charisma, luck
- 8x8 grid map of 56 real Rexburg locations
- Inventory system: food, spoiled food, melee weapons, ranged weapons
- Scenario/decision system with branching outcomes
- Health and hunger management
- Combat against zombies and survivors
- Day progression, fortification mechanics
- 55 location images (photos/logos)
- Originally built with Java Swing, Apache Ant, NetBeans, Java 1.8

## Architecture

### Project Structure

```
SurviveRexburg2026/
├── src/
│   ├── engine/          # Canvas rendering, game loop, sprite system, audio
│   ├── game/            # Game logic (pure TS, no React) — map, combat, scenarios, inventory
│   ├── components/      # React UI — menus, dialogs, HUD, inventory screen
│   ├── assets/          # Sprites, location images, chiptune audio files
│   ├── hooks/           # React hooks bridging game state <-> UI
│   ├── data/            # Static game data (locations, items, characters, scenarios)
│   └── save/            # Save/load system (localStorage + JSON export/import)
├── public/
│   ├── images/          # Location images (from original game)
│   ├── audio/           # Chiptune music + sound effects
│   └── sprites/         # Sprite sheets
├── index.html
├── package.json
├── tsconfig.json
└── vite.config.ts
```

### Key Separation

The game logic layer (`game/`) is pure TypeScript with no React dependency. It models the game state and exposes actions. The canvas engine (`engine/`) reads game state and renders it. React (`components/`) subscribes to game state for UI overlays.

### State Flow

```
User Input (keyboard/click) -> Game Logic (update state) -> Canvas (render map/sprites)
                                                         -> React (render UI overlays)
```

## Game State & Data Model

### Core Types

- **`GameState`** — central state object: current day, fortify level, game phase (menu, playing, scenario, game_over, won), saved game name
- **`Player`** — name, character template reference, health (0-100), hunger (0-100), position (row, col), backpack, equipped weapon
- **`Character`** — the 5 templates (Ben, Bing, Hayley, Megan, Nate) with base stats: strength, speed, charisma, luck
- **`GameMap`** — 8x8 grid of `Location` objects
- **`Location`** — name, row, col, visited flag, image path, available scenarios, zombie count, survivor count
- **`BackpackItem`** — union type for Food | SpoiledFood | MeleeWeapon | RangedWeapon, each with name, description, quantity, weight, and type-specific stat (hunger value or strength)
- **`Scenario`** — name, description, type (explore/scavenge/fortify/survivor/zombie/etc.), choices array (up to 5 options), each choice leading to an outcome
- **`Survivor`** — name, strength, behavior (offer_help, ask_help, attack, capture)
- **`Zombie`** — count, strength

### Design Decisions

- All state lives in a single `GameState` object (unlike the original's scattered static fields). This makes save/load trivial and React re-rendering straightforward.
- All static game data (location definitions, item catalogs, character templates, scenario scripts) lives in `data/` as typed constants, not instantiated at runtime from constructors.

## Canvas Engine & Rendering

### Game Loop

A `requestAnimationFrame` loop running at 60fps. Since the game is turn-based, most frames are idle — the loop mainly handles smooth sprite animation and tile transitions.

### Render Layers (bottom to top)

1. **Map tiles** — 8x8 grid, only the visible viewport rendered (camera follows player)
2. **Location images** — drawn on tiles the player has visited
3. **Entities** — zombie/survivor sprites on tiles that have them
4. **Player sprite** — animated pixel art character, smooth movement between tiles (~200ms lerp)
5. **Fog of war** (optional) — unvisited tiles dimmed/obscured

### Camera

Viewport centers on the player. On desktop, approximately 5x5 or 6x6 visible tiles. Grid scrolls as the player moves. On mobile, fewer visible tiles but same behavior.

### Sprite System

Simple sprite sheet approach — each character/entity has a small sprite sheet with idle and directional walk frames. Minimal complexity, enough for retro charm.

### Input Handling

A single input manager captures keyboard (WASD/arrows) and canvas click events, translates them to game actions. Click on an adjacent tile = move there. Click on current tile = interact with location. This supports both desktop keyboard users and mobile tap users.

## React UI Overlay

React renders HTML/CSS on top of the canvas for all non-map UI.

### Screens & Components

- **Main Menu** — New Game, Load Game, About. Retro pixel-styled with chiptune playing.
- **Character Select** — pick from 5 characters, see stats visualized (pixel art portraits + stat bars)
- **HUD (always visible during gameplay)** — health bar, hunger bar, current day, location name, minimap in corner
- **Inventory Panel** — slide-out panel showing backpack contents, equipped weapon, food items. Click to eat/equip/drop.
- **Scenario Dialog** — modal during events. Shows scenario description, up to 5 choice buttons. Styled like a retro RPG text box.
- **Game Over / Victory Screen** — death cause or victory message, stats summary, play again button
- **Save/Load Menu** — list of localStorage saves, export/import JSON buttons

### State Bridge

A React context provider wraps the app, holding a reference to the game state. Game logic updates trigger re-renders of relevant UI components. The canvas reads state directly without React involvement.

### Styling

- Pixel art aesthetic: blocky borders, pixel font (Press Start 2P from Google Fonts), dark background
- Retro color palette: greens, grays, reds
- Responsive layout that works on desktop and mobile

## Audio System

### Music

- Chiptune tracks for: main menu theme, exploration loop, combat/encounter sting, game over, victory
- Web Audio API for playback
- Crossfade on state transitions
- Mute/volume toggle in the HUD

### Sound Effects

- Movement footstep blips, menu selection clicks, eating food, equipping weapon, combat hits, zombie groans, door opens, damage taken, death
- Short retro-style effects, can be generated with sfxr/jsfxr

### Implementation

An `AudioManager` class in `engine/` that preloads tracks and exposes `play`, `stop`, `setVolume`, and `crossfade` methods. React components call it for UI sounds, the game loop calls it for gameplay sounds.

### Asset Format

`.mp3` or `.ogg` files, kept small for fast loading. Programmatic audio generation (oscillators) for some effects to reduce bundle size.

## Save/Load System

### localStorage Auto-Save

- Auto-saves on each day transition and after major events (combat, scenario completion)
- Up to 3 save slots — player picks a slot when starting a new game

### Export/Import

- "Export Save" downloads a `.json` file with the game state
- "Import Save" accepts a `.json` file, validates structure, and loads it
- Validation checks required fields and sane values (health 0-100, valid position, etc.)

### Save Data Structure

```typescript
{
  version: 1,          // schema version for future migration
  timestamp: string,   // when saved
  state: GameState     // full game state
}
```

The `version` field enables migrating old saves if the data model changes.

## Deployment & Build

### Vite + GitHub Pages

- `vite build` outputs static files to `dist/`
- GitHub Actions workflow: on push to `master`, builds and deploys to GitHub Pages
- Base path configured in `vite.config.ts` for GitHub Pages URL

### Asset Loading

- Location images copied from original project into `public/images/`
- Audio files in `public/audio/`
- Sprite sheets in `public/sprites/`
- All served statically

### Performance

- Lazy-load audio files (don't block initial render)
- Sprite sheets as single images to reduce HTTP requests
- Total bundle target: well under 5MB

## Location Images

The 55 original location images (photos/logos) ship as-is for the initial release. The architecture supports easy swapping to pixel art versions later — images are referenced by location ID, so replacing them is a file swap with no code changes.

## Summary of Decisions

| Aspect | Decision |
|---|---|
| Platform | Web app, GitHub Pages |
| Stack | React + Vite + TypeScript, HTML5 Canvas |
| Project location | `SurviveRexburg2026/` alongside original |
| Fidelity | Faithful mechanics, modernized UX |
| Visual style | Pixel art / retro |
| Location images | Use originals, easy to swap later |
| Map interaction | Clickable grid + WASD/arrow keys |
| Mobile | Works via tap on grid tiles |
| Audio | Chiptune music + retro sound effects |
| Save system | localStorage auto-save + JSON export/import |
| Architecture | Canvas for map, React for UI, pure TS game logic |

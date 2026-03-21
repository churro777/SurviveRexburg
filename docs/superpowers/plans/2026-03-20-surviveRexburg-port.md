# SurviveRexburg 2026 Web Port — Implementation Plan

> **For agentic workers:** REQUIRED SUB-SKILL: Use superpowers:subagent-driven-development (recommended) or superpowers:executing-plans to implement this plan task-by-task. Steps use checkbox (`- [ ]`) syntax for tracking.

**Goal:** Port the SurviveRexburg Java game to a React + Canvas web app with pixel art styling, hosted on GitHub Pages.

**Architecture:** Pure TypeScript game logic layer (no React dependency), HTML5 Canvas for map/sprite rendering, React for UI overlays (menus, HUD, dialogs). Single `GameState` object drives both canvas and React.

**Tech Stack:** React 19, Vite, TypeScript, HTML5 Canvas, Vitest, GitHub Pages

**Spec:** `docs/superpowers/specs/2026-03-20-surviveRexburg-port-design.md`

**Original Java source:** `SurvivRexburg/src/byui/cit260/`

---

### Task 1: Project Scaffolding

**Files:**
- Create: `SurviveRexburg2026/package.json`
- Create: `SurviveRexburg2026/vite.config.ts`
- Create: `SurviveRexburg2026/tsconfig.json`
- Create: `SurviveRexburg2026/index.html`
- Create: `SurviveRexburg2026/src/main.tsx`
- Create: `SurviveRexburg2026/src/App.tsx`
- Create: `SurviveRexburg2026/src/App.css`

- [ ] **Step 1: Scaffold Vite + React + TypeScript project**

```bash
cd /Users/arturo/Projects/SurviveRexburg
npm create vite@latest SurviveRexburg2026 -- --template react-ts
```

- [ ] **Step 2: Install dependencies**

```bash
cd SurviveRexburg2026
npm install
```

- [ ] **Step 3: Install Vitest**

```bash
npm install -D vitest
```

- [ ] **Step 4: Configure Vite for GitHub Pages**

In `vite.config.ts`, set the base path:

```typescript
import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'

export default defineConfig({
  plugins: [react()],
  base: '/SurviveRexburg/',
})
```

- [ ] **Step 5: Add test script to package.json**

Add to `scripts`:
```json
"test": "vitest run",
"test:watch": "vitest"
```

- [ ] **Step 6: Verify dev server works**

```bash
npm run dev
```

Expected: Vite dev server starts, app loads in browser.

- [ ] **Step 7: Verify tests run**

```bash
npm test
```

Expected: Vitest runs (no tests yet, but no errors).

- [ ] **Step 8: Commit**

```bash
git add SurviveRexburg2026/
git commit -m "feat: scaffold Vite + React + TS project for SurviveRexburg 2026"
```

---

### Task 2: TypeScript Type Definitions

**Files:**
- Create: `SurviveRexburg2026/src/game/types.ts`

Define all core game types. No logic, just interfaces and types.

- [ ] **Step 1: Create the types file**

```typescript
// src/game/types.ts

export type GamePhase = 'menu' | 'character_select' | 'playing' | 'scenario' | 'game_over' | 'won';

export interface CharacterTemplate {
  id: string;
  name: string;
  strength: number;
  speed: number;
  charisma: number;
  luck: number;
  hidden: boolean; // true for Nathan cheat character
}

export interface Player {
  name: string;
  characterId: string;
  health: number;    // 0-100
  hunger: number;    // 0-100
  row: number;
  col: number;
  backpack: Backpack;
  meleeWeapon: MeleeWeapon;
  rangedWeapon: RangedWeapon;
}

export interface Backpack {
  maxWeight: number;
  loadedWeight: number;
  items: BackpackItem[];
}

export type BackpackItem = FoodItem | SpoiledFoodItem | MeleeWeapon | RangedWeapon;

export interface FoodItem {
  type: 'food';
  id: string;
  name: string;
  quantity: number;
  weight: number;
}

export interface SpoiledFoodItem {
  type: 'spoiled_food';
  id: string;
  name: string;
  quantity: number;
  weight: number;
  healthDamage: number;
}

export interface MeleeWeapon {
  type: 'melee_weapon';
  id: string;
  name: string;
  strengthValue: number;
}

export interface RangedWeapon {
  type: 'ranged_weapon';
  id: string;
  name: string;
  luckValue: number;
}

export interface Location {
  id: number;
  name: string;
  row: number;
  col: number;
  visited: boolean;
  imagePath: string;
  zombieCount: number;
  survivorStrength: number;
}

export interface GameMap {
  rows: number;
  cols: number;
  locations: Location[][];
}

export type DailyAction = 'do_nothing' | 'fortify' | 'explore' | 'scavenge';

export type ScenarioOutcome =
  | { type: 'nothing_happens' }
  | { type: 'day_ends' }
  | { type: 'found_food'; foodId: string }
  | { type: 'found_weapon'; weapon: MeleeWeapon | RangedWeapon }
  | { type: 'survivors_offer_help' }
  | { type: 'survivors_ask_help' }
  | { type: 'survivors_attack' }
  | { type: 'zombies_attack' }
  | { type: 'safely_fortified' }
  | { type: 'safe_trip' }
  | { type: 'find_item' }
  | { type: 'find_nothing' }
  | { type: 'survivors_give_item'; foodId: string }
  | { type: 'survivors_leave' }
  | { type: 'survivors_listen' }
  | { type: 'survivors_dont_listen' }
  | { type: 'escape_to_location'; newRow: number; newCol: number }
  | { type: 'captured_injured' }
  | { type: 'captured_injured_robbed' }
  | { type: 'killed_by_survivors' }
  | { type: 'win_fight_gain_supplies' }
  | { type: 'win_fight' }
  | { type: 'lose_fight_injured' }
  | { type: 'escape_zombies'; newRow: number; newCol: number }
  | { type: 'kill_zombies' }
  | { type: 'killed_by_zombies' }
  | { type: 'killed_by_hunger' };

export interface GameState {
  phase: GamePhase;
  day: number;
  fortifyLevel: number;
  player: Player | null;
  map: GameMap | null;
  currentScenario: ScenarioOutcome | null;
  saveName: string;
}

export interface SaveData {
  version: number;
  timestamp: string;
  state: GameState;
}
```

- [ ] **Step 2: Verify it compiles**

```bash
cd SurviveRexburg2026
npx tsc --noEmit
```

Expected: No errors.

- [ ] **Step 3: Commit**

```bash
git add src/game/types.ts
git commit -m "feat: add TypeScript type definitions for game state"
```

---

### Task 3: Static Game Data

**Files:**
- Create: `SurviveRexburg2026/src/data/characters.ts`
- Create: `SurviveRexburg2026/src/data/locations.ts`
- Create: `SurviveRexburg2026/src/data/items.ts`
- Create: `SurviveRexburg2026/src/data/constants.ts`

Port all static game data from the Java `Constants.java` and `GameControl.java`.

- [ ] **Step 1: Create constants file**

```typescript
// src/data/constants.ts
export const MAP_ROWS = 8;
export const MAP_COLS = 7;
export const DAYS_TO_WIN = 30;
export const INITIAL_HEALTH = 100;
export const INITIAL_HUNGER = 100;
export const HUNGER_DECREASE_PER_DAY = 10;
export const HEALTH_RESTORE_FOOD = 15;
export const HUNGER_RESTORE_FOOD = 15;
export const HEALTH_CAP = 100;
export const HUNGER_CAP = 100;
export const DAMAGE_MIN = 11;
export const DAMAGE_MAX = 35;
export const STARTING_LOCATION_INDEX = 44; // Bunkhouse
export const STARTING_LOCATION_ROW = 6;
export const STARTING_LOCATION_COL = 2;
```

- [ ] **Step 2: Create characters data**

```typescript
// src/data/characters.ts
import { CharacterTemplate } from '../game/types';

export const CHARACTERS: CharacterTemplate[] = [
  { id: 'ben',    name: 'Ben',    strength: 10, speed: 5,  charisma: 1,  luck: 4,  hidden: false },
  { id: 'bing',   name: 'Bing',   strength: 6,  speed: 8,  charisma: 3,  luck: 3,  hidden: false },
  { id: 'hayley', name: 'Hayley', strength: 1,  speed: 5,  charisma: 6,  luck: 8,  hidden: false },
  { id: 'megan',  name: 'Megan',  strength: 6,  speed: 2,  charisma: 8,  luck: 4,  hidden: false },
  { id: 'nathan', name: 'Nathan', strength: 10, speed: 10, charisma: 10, luck: 10, hidden: true  },
];
```

- [ ] **Step 3: Create items data**

```typescript
// src/data/items.ts
import { FoodItem, SpoiledFoodItem, MeleeWeapon, RangedWeapon } from '../game/types';

export const FOOD_ITEMS: Omit<FoodItem, 'quantity'>[] = [
  { type: 'food', id: 'canned_tuna',  name: 'Canned Tuna',  weight: 1 },
  { type: 'food', id: 'canned_beans', name: 'Canned Beans', weight: 1 },
  { type: 'food', id: 'apples',       name: 'Apples',       weight: 1 },
  { type: 'food', id: 'potatoes',     name: 'Potatoes',     weight: 1 },
  { type: 'food', id: 'bread',        name: 'Bread',        weight: 1 },
  { type: 'food', id: 'cereal',       name: 'Cereal',       weight: 1 },
  { type: 'food', id: 'top_ramen',    name: 'Top Ramen',    weight: 1 },
  { type: 'food', id: 'chocolate',    name: 'Chocolate',    weight: 1 },
];

export const SPOILED_FOOD_ITEMS: Omit<SpoiledFoodItem, 'quantity'>[] = [
  { type: 'spoiled_food', id: 'rotten_eggs',   name: 'Rotten Eggs',   weight: 1, healthDamage: 1 },
  { type: 'spoiled_food', id: 'moldy_cheese',  name: 'Moldy Cheese',  weight: 1, healthDamage: 1 },
  { type: 'spoiled_food', id: 'sour_milk',     name: 'Sour Milk',     weight: 1, healthDamage: 3 },
  { type: 'spoiled_food', id: 'moldy_bread',   name: 'Moldy Bread',   weight: 1, healthDamage: 1 },
  { type: 'spoiled_food', id: 'rotten_mango',  name: 'Rotten Mangos', weight: 1, healthDamage: 3 },
  { type: 'spoiled_food', id: 'rotten_apple',  name: 'Rotten Apples', weight: 1, healthDamage: 2 },
  { type: 'spoiled_food', id: 'rotten_banana', name: 'Rotten Bananas',weight: 1, healthDamage: 2 },
];

export const MELEE_WEAPONS: MeleeWeapon[] = [
  { type: 'melee_weapon', id: 'fists',          name: 'Fists',          strengthValue: 0  },
  { type: 'melee_weapon', id: 'baseball_bat',   name: 'Baseball Bat',   strengthValue: 4  },
  { type: 'melee_weapon', id: 'sledge_hammer',  name: 'Sledge Hammer',  strengthValue: 15 },
  { type: 'melee_weapon', id: 'hammer',         name: 'Hammer',         strengthValue: 15 },
  { type: 'melee_weapon', id: 'golf_club',      name: 'Golf Club',      strengthValue: 3  },
  { type: 'melee_weapon', id: 'steak_knife',    name: 'Steak Knife',    strengthValue: 2  },
  { type: 'melee_weapon', id: 'tennis_racket',  name: 'Tennis Racket',  strengthValue: 5  },
];

export const RANGED_WEAPONS: RangedWeapon[] = [
  { type: 'ranged_weapon', id: 'ranged_fists',   name: 'Ranged Fists',   luckValue: 0 },
  { type: 'ranged_weapon', id: 'shotgun',         name: 'Shotgun',        luckValue: 8 },
  { type: 'ranged_weapon', id: 'hunting_rifle',   name: 'Hunting Rifle',  luckValue: 7 },
  { type: 'ranged_weapon', id: 'handgun',         name: 'Handgun',        luckValue: 2 },
  { type: 'ranged_weapon', id: 'bow_and_arrow',   name: 'Bow and Arrow',  luckValue: 3 },
];

/** Starting backpack: 1 of each food item */
export const STARTING_FOOD: FoodItem[] = FOOD_ITEMS.map(f => ({ ...f, quantity: 1 }));
```

- [ ] **Step 4: Create locations data**

Create `src/data/locations.ts` with all 56 locations mapped to their grid positions. Reference the full location table from the Java Constants.java:

```typescript
// src/data/locations.ts
export interface LocationData {
  id: number;
  name: string;
  row: number;
  col: number;
  imagePath: string;
}

export const LOCATIONS: LocationData[] = [
  { id: 0,  name: 'Gun Store',                   row: 0, col: 0, imagePath: '/images/GunStoreLogo.jpeg' },
  { id: 1,  name: 'Jamba Juice',                  row: 0, col: 1, imagePath: '/images/JambaJuiceLogo.jpeg' },
  { id: 2,  name: "Broulim's",                    row: 0, col: 2, imagePath: '/images/BroulimsLogo.jpeg' },
  { id: 3,  name: 'Fire Station',                 row: 0, col: 3, imagePath: '/images/FireStationLogo.jpeg' },
  { id: 4,  name: 'Taco Bell',                    row: 0, col: 4, imagePath: '/images/TacoBellLogo.jpeg' },
  { id: 5,  name: 'Bike Store',                   row: 0, col: 5, imagePath: '/images/BikeStoreLogo.jpeg' },
  { id: 6,  name: 'Insurance Office',             row: 0, col: 6, imagePath: '/images/InsuranceOfficeLogo.jpeg' },
  { id: 7,  name: "Maverick's",                   row: 1, col: 0, imagePath: '/images/MavericksLogo.jpeg' },
  { id: 8,  name: "Domino's",                     row: 1, col: 1, imagePath: '/images/DominosLogo.jpeg' },
  { id: 9,  name: 'Salon',                        row: 1, col: 2, imagePath: '/images/SalonLogo.jpeg' },
  { id: 10, name: 'Melaluca',                     row: 1, col: 3, imagePath: '/images/MelalucaLogo.jpeg' },
  { id: 11, name: "Donut's",                      row: 1, col: 4, imagePath: '/images/DonutsLogo.jpeg' },
  { id: 12, name: "Gringo's",                     row: 1, col: 5, imagePath: '/images/GringosLogo.jpeg' },
  { id: 13, name: 'Key Bank',                     row: 1, col: 6, imagePath: '/images/KeyBankLogo.jpeg' },
  { id: 14, name: 'Porter Park Field',            row: 2, col: 0, imagePath: '/images/PorterParkFieldLogo.jpeg' },
  { id: 15, name: "Nielson's",                    row: 2, col: 1, imagePath: '/images/NielsonsLogo.jpeg' },
  { id: 16, name: 'Abandoned House',              row: 2, col: 2, imagePath: '/images/AbandonedHouseLogo.jpeg' },
  { id: 17, name: 'La Jolla Apartments',          row: 2, col: 3, imagePath: '/images/LaJollaLogo.jpeg' },
  { id: 18, name: "Little Caesar's Pizza",        row: 2, col: 4, imagePath: '/images/LittleCaesarsLogo.jpeg' },
  { id: 19, name: 'Eye Doctor',                   row: 2, col: 5, imagePath: '/images/EyeDoctorLogo.jpeg' },
  { id: 20, name: 'Pinnacle Security Office',     row: 2, col: 6, imagePath: '/images/PinnacleSecurityOfficeLogo.jpeg' },
  { id: 21, name: 'Porter Park Playground',       row: 3, col: 0, imagePath: '/images/PorterParkPlaygroundLogo.jpeg' },
  { id: 22, name: 'Kiwi Loco',                    row: 3, col: 1, imagePath: '/images/KiwiLocoLogo.jpeg' },
  { id: 23, name: 'Willows Apartments',           row: 3, col: 2, imagePath: '/images/WillowsLogo.jpeg' },
  { id: 24, name: 'Construction',                 row: 3, col: 3, imagePath: '/images/ConstructionLogo.jpeg' },
  { id: 25, name: 'Post Office',                  row: 3, col: 4, imagePath: '/images/PostOfficeLogo.jpeg' },
  { id: 26, name: 'Viking Village Apartments',    row: 3, col: 5, imagePath: '/images/VikingVillageLogo.jpeg' },
  { id: 27, name: 'Empty Lot',                    row: 3, col: 6, imagePath: '/images/EmptyLotLogo.jpeg' },
  { id: 28, name: 'Taco Time',                    row: 4, col: 0, imagePath: '/images/TacoTimeLogo.jpeg' },
  { id: 29, name: 'Birchwood Apartments West',    row: 4, col: 1, imagePath: '/images/BirchwoodWestLogo.jpeg' },
  { id: 30, name: 'Birchwood Apartments East',    row: 4, col: 2, imagePath: '/images/BirchwoodEastLogo.jpeg' },
  { id: 31, name: 'Stadium',                      row: 4, col: 3, imagePath: '/images/StadiumLogo.jpeg' },
  { id: 32, name: 'Snow Building',                row: 4, col: 4, imagePath: '/images/SnowBuildingLogo.jpeg' },
  { id: 33, name: 'Kirkham Building',             row: 4, col: 5, imagePath: '/images/KirkhamBuildingLogo.jpeg' },
  { id: 34, name: 'Crestwood Apartments',         row: 4, col: 6, imagePath: '/images/CrestwoodLogo.jpeg' },
  { id: 35, name: 'Empty Field',                  row: 5, col: 0, imagePath: '/images/EmptyFieldLogo.jpeg' },
  { id: 36, name: 'Abandoned House',              row: 5, col: 1, imagePath: '/images/AbandonedHouse2Logo.jpeg' },
  { id: 37, name: 'Royal Crest Apartments',       row: 5, col: 2, imagePath: '/images/RoyalCrestLogo.jpeg' },
  { id: 38, name: 'Hart Building',                row: 5, col: 3, imagePath: '/images/HartBuildingLogo.jpeg' },
  { id: 39, name: 'Spori Building',               row: 5, col: 4, imagePath: '/images/SporiBuildingLogo.jpeg' },
  { id: 40, name: 'Clark Building',               row: 5, col: 5, imagePath: '/images/ClarkBuildingLogo.jpeg' },
  { id: 41, name: 'Abandoned House',              row: 5, col: 6, imagePath: '/images/AbandonedHouse3Logo.jpeg' },
  { id: 42, name: 'New Fongs',                    row: 6, col: 0, imagePath: '/images/NewFongsLogo.jpeg' },
  { id: 43, name: 'Brooklyn Apartments',          row: 6, col: 1, imagePath: '/images/BrooklynLogo.jpeg' },
  { id: 44, name: 'Bunkhouse Apartments',         row: 6, col: 2, imagePath: '/images/BunkhouseLogo.jpeg' },
  { id: 45, name: 'Alleyway',                     row: 6, col: 3, imagePath: '/images/AlleywayLogo.jpeg' },
  { id: 46, name: 'Library',                      row: 6, col: 4, imagePath: '/images/LibraryLogo.jpeg' },
  { id: 47, name: 'Smith Building',               row: 6, col: 5, imagePath: '/images/SmithBuildingLogo.jpeg' },
  { id: 48, name: 'North Dorms',                  row: 6, col: 6, imagePath: '/images/NorthDormsLogo.jpeg' },
  { id: 49, name: 'Taco Bus',                     row: 7, col: 0, imagePath: '/images/TacoBusLogo.jpeg' },
  { id: 50, name: 'Subway',                       row: 7, col: 1, imagePath: '/images/SubwayLogo.jpeg' },
  { id: 51, name: 'Shake Out',                    row: 7, col: 2, imagePath: '/images/ShakeOutLogo.jpeg' },
  { id: 52, name: 'I-Center',                     row: 7, col: 3, imagePath: '/images/ICenterLogo.jpeg' },
  { id: 53, name: 'MC Building West',             row: 7, col: 4, imagePath: '/images/MCWestLogo.jpeg' },
  { id: 54, name: 'MC Building East',             row: 7, col: 5, imagePath: '/images/MCEastLogo.jpeg' },
  { id: 55, name: 'South Dorms',                  row: 7, col: 6, imagePath: '/images/SouthDormsLogo.jpeg' },
];
```

- [ ] **Step 5: Verify compilation**

```bash
npx tsc --noEmit
```

Expected: No errors.

- [ ] **Step 6: Commit**

```bash
git add src/data/
git commit -m "feat: add static game data (characters, locations, items, constants)"
```

---

### Task 4: Game State Creation & Core Mechanics

**Files:**
- Create: `SurviveRexburg2026/src/game/state.ts`
- Create: `SurviveRexburg2026/src/game/state.test.ts`

Core game state factory and health/hunger/damage mechanics.

- [ ] **Step 1: Write tests for game state creation and mechanics**

```typescript
// src/game/state.test.ts
import { describe, it, expect } from 'vitest';
import { createGameState, createPlayer, createMap, eatFood, takeDamage, decreaseHunger, isPlayerDead, isPlayerStarved, hasPlayerWon } from './state';
import { CHARACTERS } from '../data/characters';

describe('createGameState', () => {
  it('creates initial game state in menu phase', () => {
    const state = createGameState();
    expect(state.phase).toBe('menu');
    expect(state.day).toBe(1);
    expect(state.fortifyLevel).toBe(0);
    expect(state.player).toBeNull();
    expect(state.map).toBeNull();
  });
});

describe('createPlayer', () => {
  it('creates a player with correct initial stats', () => {
    const ben = CHARACTERS[0]; // Ben: str=10
    const player = createPlayer(ben);
    expect(player.health).toBe(100);
    expect(player.hunger).toBe(100);
    expect(player.row).toBe(6);
    expect(player.col).toBe(2); // Bunkhouse
    expect(player.meleeWeapon.id).toBe('fists');
    expect(player.rangedWeapon.id).toBe('ranged_fists');
    expect(player.backpack.maxWeight).toBe(100); // 10 * str(10)
    expect(player.backpack.items.length).toBe(8); // 8 starting food items
  });
});

describe('createMap', () => {
  it('creates 8x7 grid with 56 locations', () => {
    const map = createMap();
    expect(map.rows).toBe(8);
    expect(map.cols).toBe(7);
    expect(map.locations[6][2].name).toBe('Bunkhouse Apartments');
  });
});

describe('eatFood', () => {
  it('restores 15 health and 15 hunger, capped at 100', () => {
    const player = createPlayer(CHARACTERS[0]);
    player.health = 50;
    player.hunger = 50;
    const updated = eatFood(player);
    expect(updated.health).toBe(65);
    expect(updated.hunger).toBe(65);
  });

  it('caps health and hunger at 100', () => {
    const player = createPlayer(CHARACTERS[0]);
    player.health = 90;
    player.hunger = 95;
    const updated = eatFood(player);
    expect(updated.health).toBe(100);
    expect(updated.hunger).toBe(100);
  });
});

describe('takeDamage', () => {
  it('reduces health by damage formula result', () => {
    const player = createPlayer(CHARACTERS[0]); // str=10
    // With str=10, damage = random(11-35) - 10 = 1-25
    const updated = takeDamage(player);
    expect(updated.health).toBeLessThan(100);
    expect(updated.health).toBeGreaterThanOrEqual(75); // 100 - 25
  });
});

describe('decreaseHunger', () => {
  it('decreases hunger by 10', () => {
    const player = createPlayer(CHARACTERS[0]);
    const updated = decreaseHunger(player);
    expect(updated.hunger).toBe(90);
  });
});

describe('win/lose conditions', () => {
  it('detects starvation', () => {
    const player = createPlayer(CHARACTERS[0]);
    player.hunger = 0;
    expect(isPlayerStarved(player)).toBe(true);
  });

  it('detects death', () => {
    const player = createPlayer(CHARACTERS[0]);
    player.health = 0;
    expect(isPlayerDead(player)).toBe(true);
  });

  it('detects win at day 30', () => {
    expect(hasPlayerWon(30)).toBe(true);
    expect(hasPlayerWon(29)).toBe(false);
  });
});
```

- [ ] **Step 2: Run tests — verify they fail**

```bash
npm test
```

Expected: FAIL — module `./state` not found.

- [ ] **Step 3: Implement game state creation and mechanics**

```typescript
// src/game/state.ts
import { GameState, Player, GameMap, Location, CharacterTemplate } from './types';
import { LOCATIONS } from '../data/locations';
import { STARTING_FOOD, MELEE_WEAPONS, RANGED_WEAPONS } from '../data/items';
import {
  MAP_ROWS, MAP_COLS, INITIAL_HEALTH, INITIAL_HUNGER,
  STARTING_LOCATION_ROW, STARTING_LOCATION_COL,
  HEALTH_RESTORE_FOOD, HUNGER_RESTORE_FOOD,
  HEALTH_CAP, HUNGER_CAP, HUNGER_DECREASE_PER_DAY,
  DAMAGE_MIN, DAMAGE_MAX, DAYS_TO_WIN,
} from '../data/constants';

export function createGameState(): GameState {
  return {
    phase: 'menu',
    day: 1,
    fortifyLevel: 0,
    player: null,
    map: null,
    currentScenario: null,
    saveName: '',
  };
}

export function createPlayer(character: CharacterTemplate): Player {
  return {
    name: character.name,
    characterId: character.id,
    health: INITIAL_HEALTH,
    hunger: INITIAL_HUNGER,
    row: STARTING_LOCATION_ROW,
    col: STARTING_LOCATION_COL,
    backpack: {
      maxWeight: 10 * character.strength,
      loadedWeight: 0,
      items: [...STARTING_FOOD],
    },
    meleeWeapon: { ...MELEE_WEAPONS[0] },    // Fists
    rangedWeapon: { ...RANGED_WEAPONS[0] },   // Ranged Fists
  };
}

export function createMap(): GameMap {
  const locations: Location[][] = Array.from({ length: MAP_ROWS }, () =>
    Array.from({ length: MAP_COLS }, () => null as unknown as Location)
  );

  for (const loc of LOCATIONS) {
    locations[loc.row][loc.col] = {
      id: loc.id,
      name: loc.name,
      row: loc.row,
      col: loc.col,
      visited: false,
      imagePath: loc.imagePath,
      zombieCount: 0,
      survivorStrength: 0,
    };
  }

  // Mark starting location as visited
  locations[STARTING_LOCATION_ROW][STARTING_LOCATION_COL].visited = true;

  return { rows: MAP_ROWS, cols: MAP_COLS, locations };
}

export function eatFood(player: Player): Player {
  return {
    ...player,
    health: Math.min(player.health + HEALTH_RESTORE_FOOD, HEALTH_CAP),
    hunger: Math.min(player.hunger + HUNGER_RESTORE_FOOD, HUNGER_CAP),
  };
}

export function takeDamage(player: Player): Player {
  const character = getCharacterStrength(player);
  const rawDamage = Math.floor(Math.random() * (DAMAGE_MAX - DAMAGE_MIN + 1)) + DAMAGE_MIN;
  const damage = Math.max(0, rawDamage - character);
  return {
    ...player,
    health: Math.max(0, player.health - damage),
  };
}

export function decreaseHunger(player: Player): Player {
  return {
    ...player,
    hunger: Math.max(0, player.hunger - HUNGER_DECREASE_PER_DAY),
  };
}

export function isPlayerDead(player: Player): boolean {
  return player.health <= 0;
}

export function isPlayerStarved(player: Player): boolean {
  return player.hunger <= 0;
}

export function hasPlayerWon(day: number): boolean {
  return day >= DAYS_TO_WIN;
}

function getCharacterStrength(player: Player): number {
  // Look up character template strength from the player's characterId
  const { CHARACTERS } = require('../data/characters');
  const char = CHARACTERS.find((c: CharacterTemplate) => c.id === player.characterId);
  return char?.strength ?? 0;
}
```

Note: The `getCharacterStrength` helper should use a proper import. Refactor to pass the character template or store strength on the player. The implementer should use a clean approach — e.g., store `strength`, `speed`, `charisma`, `luck` directly on the `Player` type to avoid lookups.

- [ ] **Step 4: Run tests — verify they pass**

```bash
npm test
```

Expected: All tests PASS.

- [ ] **Step 5: Commit**

```bash
git add src/game/state.ts src/game/state.test.ts
git commit -m "feat: add game state creation and core mechanics (health, hunger, damage)"
```

---

### Task 5: Probability & Outcome Engine

**Files:**
- Create: `SurviveRexburg2026/src/game/scenarios.ts`
- Create: `SurviveRexburg2026/src/game/scenarios.test.ts`

Port all probability formulas from Java `ScenarioControl.java`.

- [ ] **Step 1: Write tests for the scenario engine**

Test that each action type returns valid outcomes and that the probability formulas use the correct stats. Use seeded random or test ranges of outputs.

```typescript
// src/game/scenarios.test.ts
import { describe, it, expect } from 'vitest';
import { resolveDoNothing, resolveFortify, resolveExplore, resolveScavenge, resolveFightZombies, resolveRunFromZombies, resolveFightSurvivors, resolveRunFromSurvivors, resolveAcceptHelp, resolveDenyHelp, resolveNegotiate } from './scenarios';

describe('resolveDoNothing', () => {
  it('returns one of 5 valid outcomes', () => {
    const validTypes = ['nothing_happens', 'survivors_offer_help', 'survivors_ask_help', 'survivors_attack', 'zombies_attack'];
    // Run 100 times to check all outcomes are valid
    for (let i = 0; i < 100; i++) {
      const result = resolveDoNothing({ luck: 4, charisma: 1, speed: 5, strength: 10 }, 1);
      expect(validTypes).toContain(result.type);
    }
  });
});

describe('resolveFortify', () => {
  it('returns one of 3 valid outcomes', () => {
    const validTypes = ['safely_fortified', 'survivors_offer_help', 'survivors_ask_help'];
    for (let i = 0; i < 100; i++) {
      const result = resolveFortify({ luck: 4, charisma: 1, speed: 5, strength: 10 }, 1, 0);
      expect(validTypes).toContain(result.type);
    }
  });
});

describe('resolveScavenge', () => {
  it('returns one of 6 valid outcomes', () => {
    const validTypes = ['find_item', 'find_nothing', 'survivors_offer_help', 'survivors_ask_help', 'survivors_attack', 'zombies_attack'];
    for (let i = 0; i < 100; i++) {
      const result = resolveScavenge({ luck: 4, charisma: 1, speed: 5, strength: 10 }, 1);
      expect(validTypes).toContain(result.type);
    }
  });
});

describe('resolveFightZombies', () => {
  it('returns kill_zombies or killed_by_zombies', () => {
    const validTypes = ['kill_zombies', 'killed_by_zombies'];
    for (let i = 0; i < 100; i++) {
      const result = resolveFightZombies({ luck: 4, charisma: 1, speed: 5, strength: 10 }, 1, 0, 0);
      expect(validTypes).toContain(result.type);
    }
  });
});

describe('resolveFightSurvivors', () => {
  it('returns one of 4 valid outcomes', () => {
    const validTypes = ['win_fight_gain_supplies', 'win_fight', 'lose_fight_injured', 'killed_by_survivors'];
    for (let i = 0; i < 100; i++) {
      const result = resolveFightSurvivors({ luck: 4, charisma: 1, speed: 5, strength: 10 }, 1, 0, 0);
      expect(validTypes).toContain(result.type);
    }
  });
});
```

- [ ] **Step 2: Run tests — verify they fail**

```bash
npm test
```

- [ ] **Step 3: Implement the scenario engine**

Port each probability formula from `ScenarioControl.java` faithfully. Each function takes character stats, daysPassed, and relevant modifiers, returns a `ScenarioOutcome`.

```typescript
// src/game/scenarios.ts
import { ScenarioOutcome } from './types';

interface CharStats {
  luck: number;
  charisma: number;
  speed: number;
  strength: number;
}

function rollBase(luck: number, daysPassed: number): number {
  const roll = Math.floor(Math.random() * 100) + 1;
  const luckBonus = (Math.floor(Math.random() * luck) + 1) * 4;
  return roll + luckBonus - daysPassed;
}

export function resolveDoNothing(stats: CharStats, daysPassed: number): ScenarioOutcome {
  const value = rollBase(stats.luck, daysPassed);
  if (value >= 80) return { type: 'nothing_happens' };
  if (value >= 60) return { type: 'survivors_offer_help' };
  if (value >= 40) return { type: 'survivors_ask_help' };
  if (value >= 20) return { type: 'survivors_attack' };
  return { type: 'zombies_attack' };
}

export function resolveFortify(stats: CharStats, daysPassed: number, fortifyLevel: number): ScenarioOutcome {
  const base = rollBase(stats.luck, daysPassed);
  const value = fortifyLevel + base;
  if (value >= 66) return { type: 'safely_fortified' };
  if (value >= 33) return { type: 'survivors_offer_help' };
  return { type: 'survivors_ask_help' };
}

export function resolveExplore(stats: CharStats, daysPassed: number): ScenarioOutcome {
  const value = rollBase(stats.luck, daysPassed);
  if (value >= 80) return { type: 'safe_trip' };
  if (value >= 60) return { type: 'survivors_offer_help' };
  if (value >= 40) return { type: 'survivors_ask_help' };
  if (value >= 20) return { type: 'survivors_attack' };
  return { type: 'zombies_attack' };
}

export function resolveScavenge(stats: CharStats, daysPassed: number): ScenarioOutcome {
  const value = rollBase(stats.luck, daysPassed);
  if (value >= 83) return { type: 'find_item' };
  if (value >= 66) return { type: 'find_nothing' };
  if (value >= 49) return { type: 'survivors_offer_help' };
  if (value >= 32) return { type: 'survivors_ask_help' };
  if (value >= 15) return { type: 'survivors_attack' };
  return { type: 'zombies_attack' };
}

export function resolveAcceptHelp(stats: CharStats, daysPassed: number): ScenarioOutcome {
  const charismaBonus = stats.charisma * 3;
  const roll = Math.floor(Math.random() * 100) + 1;
  const luckBonus = (Math.floor(Math.random() * stats.luck) + 1) * 4;
  const value = roll + luckBonus + charismaBonus - daysPassed;
  if (value >= 50) return { type: 'survivors_give_item', foodId: '' }; // foodId filled by caller
  return { type: 'survivors_attack' };
}

export function resolveDenyHelp(stats: CharStats, daysPassed: number): ScenarioOutcome {
  const charismaBonus = stats.charisma * 3;
  const roll = Math.floor(Math.random() * 100) + 1;
  const luckBonus = (Math.floor(Math.random() * stats.luck) + 1) * 4;
  const value = roll + luckBonus + charismaBonus - daysPassed;
  if (value >= 50) return { type: 'survivors_leave' };
  return { type: 'survivors_attack' };
}

export function resolveNegotiate(stats: CharStats, daysPassed: number): ScenarioOutcome {
  const charismaBonus = stats.charisma * 3;
  const roll = Math.floor(Math.random() * 100) + 1;
  const luckBonus = (Math.floor(Math.random() * stats.luck) + 1) * 4;
  const value = roll + luckBonus + charismaBonus - daysPassed;
  if (value >= 50) return { type: 'survivors_listen' };
  return { type: 'survivors_dont_listen' };
}

function combatRoll(stats: CharStats, daysPassed: number, meleeStr: number, rangedLuck: number): number {
  const charStrength = stats.strength * 2;
  const charLuck = (Math.floor(Math.random() * stats.luck) + 1) * 4;
  const meleeStrength = Math.ceil((meleeStr + charStrength) * 1.5);
  const rangedLuckVal = Math.ceil((rangedLuck + charLuck) * 1.5);
  const roll = Math.floor(Math.random() * 100) + 1;
  return roll + charLuck + charStrength + meleeStrength + rangedLuckVal - daysPassed;
}

export function resolveFightZombies(stats: CharStats, daysPassed: number, meleeStr: number, rangedLuck: number): ScenarioOutcome {
  const value = combatRoll(stats, daysPassed, meleeStr, rangedLuck);
  if (value >= 50) return { type: 'kill_zombies' };
  return { type: 'killed_by_zombies' };
}

export function resolveFightSurvivors(stats: CharStats, daysPassed: number, meleeStr: number, rangedLuck: number): ScenarioOutcome {
  const value = combatRoll(stats, daysPassed, meleeStr, rangedLuck);
  if (value >= 75) return { type: 'win_fight_gain_supplies' };
  if (value >= 50) return { type: 'win_fight' };
  if (value >= 25) return { type: 'lose_fight_injured' };
  return { type: 'killed_by_survivors' };
}

export function resolveRunFromSurvivors(stats: CharStats, daysPassed: number): ScenarioOutcome {
  const speedBonus = stats.speed * 3;
  const roll = Math.floor(Math.random() * 100) + 1;
  const luckBonus = (Math.floor(Math.random() * stats.luck) + 1) * 4;
  const value = roll + luckBonus + speedBonus - daysPassed;
  if (value >= 75) return { type: 'escape_to_location', newRow: 0, newCol: 0 }; // caller sets location
  if (value >= 50) return { type: 'captured_injured' };
  if (value >= 25) return { type: 'captured_injured_robbed' };
  return { type: 'killed_by_survivors' };
}

export function resolveRunFromZombies(stats: CharStats, daysPassed: number): ScenarioOutcome {
  const speedBonus = stats.speed * 3;
  const roll = Math.floor(Math.random() * 100) + 1;
  const luckBonus = (Math.floor(Math.random() * stats.luck) + 1) * 4;
  const value = roll + luckBonus + speedBonus - daysPassed;
  if (value >= 50) return { type: 'escape_zombies', newRow: 0, newCol: 0 }; // caller sets location
  return { type: 'killed_by_zombies' };
}
```

- [ ] **Step 4: Run tests — verify they pass**

```bash
npm test
```

- [ ] **Step 5: Commit**

```bash
git add src/game/scenarios.ts src/game/scenarios.test.ts
git commit -m "feat: implement probability and outcome engine from original ScenarioControl"
```

---

### Task 6: Game Action Controller

**Files:**
- Create: `SurviveRexburg2026/src/game/actions.ts`
- Create: `SurviveRexburg2026/src/game/actions.test.ts`

The main game controller — handles daily actions, processes outcomes, advances days.

- [ ] **Step 1: Write tests for game actions**

Test `startNewGame`, `performDailyAction`, `advanceDay`, `movePlayer`, `pickRandomLocation`, `pickRandomFood`, `pickRandomWeapon`.

- [ ] **Step 2: Run tests — verify they fail**

- [ ] **Step 3: Implement game action controller**

Functions that mutate `GameState` through the daily cycle: start game → choose character → playing (daily choices) → scenario resolution → day end → check win/lose.

- [ ] **Step 4: Run tests — verify they pass**

- [ ] **Step 5: Commit**

```bash
git add src/game/actions.ts src/game/actions.test.ts
git commit -m "feat: add game action controller (daily cycle, movement, item finding)"
```

---

### Task 7: Save/Load System

**Files:**
- Create: `SurviveRexburg2026/src/save/save-manager.ts`
- Create: `SurviveRexburg2026/src/save/save-manager.test.ts`

- [ ] **Step 1: Write tests for save/load**

Test `saveGame`, `loadGame`, `listSaves`, `deleteSave`, `exportSave`, `importSave`, validation of corrupted data.

- [ ] **Step 2: Run tests — verify they fail**

- [ ] **Step 3: Implement save manager**

Uses `localStorage` with keys like `survive_rexburg_save_1`, `_2`, `_3`. Export produces JSON file download. Import validates schema before loading.

- [ ] **Step 4: Run tests — verify they pass**

- [ ] **Step 5: Commit**

```bash
git add src/save/
git commit -m "feat: add save/load system with localStorage and JSON export/import"
```

---

### Task 8: React Game Context & State Bridge

**Files:**
- Create: `SurviveRexburg2026/src/hooks/useGameState.ts`
- Create: `SurviveRexburg2026/src/hooks/GameContext.tsx`

- [ ] **Step 1: Create game context provider**

React context that holds `GameState` and exposes action dispatchers. Components subscribe to specific slices of state.

```typescript
// src/hooks/GameContext.tsx
import { createContext, useContext, useState, useCallback, ReactNode } from 'react';
import { GameState } from '../game/types';
import { createGameState } from '../game/state';

interface GameContextValue {
  state: GameState;
  setState: (updater: (prev: GameState) => GameState) => void;
}

const GameContext = createContext<GameContextValue | null>(null);

export function GameProvider({ children }: { children: ReactNode }) {
  const [state, setStateRaw] = useState<GameState>(createGameState);

  const setState = useCallback((updater: (prev: GameState) => GameState) => {
    setStateRaw(prev => updater(prev));
  }, []);

  return (
    <GameContext.Provider value={{ state, setState }}>
      {children}
    </GameContext.Provider>
  );
}

export function useGameContext(): GameContextValue {
  const ctx = useContext(GameContext);
  if (!ctx) throw new Error('useGameContext must be used within GameProvider');
  return ctx;
}
```

- [ ] **Step 2: Create useGameState hook**

Convenience hook for common game operations (startGame, performAction, etc.) that wraps context.

- [ ] **Step 3: Wire up App.tsx with GameProvider**

- [ ] **Step 4: Commit**

```bash
git add src/hooks/ src/App.tsx
git commit -m "feat: add React game context and state bridge"
```

---

### Task 9: Copy Location Images to Public

**Files:**
- Copy: `SurvivRexburg/src/byui/cit260/surviveRexburg/images/*` → `SurviveRexburg2026/public/images/`

- [ ] **Step 1: Copy image files**

```bash
mkdir -p SurviveRexburg2026/public/images
cp SurvivRexburg/src/byui/cit260/surviveRexburg/images/* SurviveRexburg2026/public/images/
```

- [ ] **Step 2: Verify image filenames match location data**

Check that the filenames referenced in `src/data/locations.ts` exist in `public/images/`. Fix any mismatches.

- [ ] **Step 3: Commit**

```bash
git add SurviveRexburg2026/public/images/
git commit -m "feat: copy original location images to public assets"
```

---

### Task 10: Global Pixel Art Styling

**Files:**
- Create: `SurviveRexburg2026/src/index.css`
- Modify: `SurviveRexburg2026/index.html` (add Google Font link)

- [ ] **Step 1: Add Press Start 2P font to index.html**

```html
<link href="https://fonts.googleapis.com/css2?family=Press+Start+2P&display=swap" rel="stylesheet">
```

- [ ] **Step 2: Create global retro CSS**

Dark background, pixel font, retro color palette (greens, grays, reds), box-shadow borders instead of smooth borders, image-rendering: pixelated.

- [ ] **Step 3: Commit**

```bash
git add src/index.css index.html
git commit -m "feat: add global pixel art styling with Press Start 2P font"
```

---

### Task 11: Main Menu Screen

**Files:**
- Create: `SurviveRexburg2026/src/components/MainMenu.tsx`
- Create: `SurviveRexburg2026/src/components/MainMenu.css`

- [ ] **Step 1: Build MainMenu component**

Title "SURVIVE REXBURG", subtitle "2026 Edition". Buttons: New Game, Load Game, Help, About. Pixel-styled buttons with hover effects.

- [ ] **Step 2: Wire into App.tsx**

Render MainMenu when `state.phase === 'menu'`.

- [ ] **Step 3: Verify in browser**

```bash
npm run dev
```

Expected: Main menu shows with retro styling.

- [ ] **Step 4: Commit**

```bash
git add src/components/MainMenu.tsx src/components/MainMenu.css src/App.tsx
git commit -m "feat: add main menu screen with pixel art styling"
```

---

### Task 12: Character Select Screen

**Files:**
- Create: `SurviveRexburg2026/src/components/CharacterSelect.tsx`
- Create: `SurviveRexburg2026/src/components/CharacterSelect.css`

- [ ] **Step 1: Build CharacterSelect component**

Show 4 visible characters (Ben, Bing, Hayley, Megan) as cards with stat bars. Clicking a card selects that character and starts the game. Implement konami code listener (up up down down left right left right b a) to reveal Nathan.

- [ ] **Step 2: Wire into App.tsx**

Render when `state.phase === 'character_select'`.

- [ ] **Step 3: Verify in browser**

- [ ] **Step 4: Commit**

```bash
git add src/components/CharacterSelect.tsx src/components/CharacterSelect.css src/App.tsx
git commit -m "feat: add character select screen with stat display and hidden Nathan"
```

---

### Task 13: Canvas Engine — Game Loop & Map Rendering

**Files:**
- Create: `SurviveRexburg2026/src/engine/GameCanvas.tsx`
- Create: `SurviveRexburg2026/src/engine/renderer.ts`
- Create: `SurviveRexburg2026/src/engine/camera.ts`

- [ ] **Step 1: Create camera module**

Calculates viewport offset based on player position. Centers player on screen, clamps to map edges.

```typescript
// src/engine/camera.ts
export interface Camera {
  offsetX: number;
  offsetY: number;
  viewportTilesX: number;
  viewportTilesY: number;
}

export function createCamera(
  playerRow: number, playerCol: number,
  mapRows: number, mapCols: number,
  canvasWidth: number, canvasHeight: number,
  tileSize: number
): Camera {
  const viewportTilesX = Math.floor(canvasWidth / tileSize);
  const viewportTilesY = Math.floor(canvasHeight / tileSize);

  const offsetX = Math.max(0, Math.min(
    playerCol - Math.floor(viewportTilesX / 2),
    mapCols - viewportTilesX
  ));
  const offsetY = Math.max(0, Math.min(
    playerRow - Math.floor(viewportTilesY / 2),
    mapRows - viewportTilesY
  ));

  return { offsetX, offsetY, viewportTilesX, viewportTilesY };
}
```

- [ ] **Step 2: Create renderer module**

Draws the map grid, location tiles (visited = show image, unvisited = fog), player marker, and grid lines. Uses `CanvasRenderingContext2D`.

- [ ] **Step 3: Create GameCanvas React component**

Wraps a `<canvas>` element, runs `requestAnimationFrame` loop, reads game state from context, calls renderer.

- [ ] **Step 4: Wire into App.tsx**

Render GameCanvas when `state.phase === 'playing'` or `'scenario'`.

- [ ] **Step 5: Verify in browser**

Expected: 8x7 grid renders, player visible at Bunkhouse, camera centered.

- [ ] **Step 6: Commit**

```bash
git add src/engine/
git commit -m "feat: add canvas engine with map rendering and camera system"
```

---

### Task 14: Input Handling — Keyboard & Click

**Files:**
- Create: `SurviveRexburg2026/src/engine/input.ts`
- Modify: `SurviveRexburg2026/src/engine/GameCanvas.tsx`

- [ ] **Step 1: Create input manager**

Handles WASD/arrow key presses and canvas click events. Translates to game actions: move (direction) or interact (click current tile). Click on adjacent tile = move. Click on current tile = interact.

- [ ] **Step 2: Integrate with GameCanvas**

Register keyboard listeners on mount, canvas click listener. On valid input, call game action functions from context.

- [ ] **Step 3: Verify movement in browser**

Expected: Arrow keys and WASD move player on the grid. Clicking adjacent tiles moves player.

- [ ] **Step 4: Commit**

```bash
git add src/engine/input.ts src/engine/GameCanvas.tsx
git commit -m "feat: add keyboard and click input handling for map movement"
```

---

### Task 15: HUD Component

**Files:**
- Create: `SurviveRexburg2026/src/components/HUD.tsx`
- Create: `SurviveRexburg2026/src/components/HUD.css`

- [ ] **Step 1: Build HUD component**

Overlay on the game canvas showing: health bar (red), hunger bar (green), current day counter, current location name, minimap in corner (small 8x7 grid showing visited tiles and player position).

- [ ] **Step 2: Wire into App.tsx**

Render alongside GameCanvas during `playing` and `scenario` phases.

- [ ] **Step 3: Verify in browser**

Expected: HUD shows stats overlay on the game.

- [ ] **Step 4: Commit**

```bash
git add src/components/HUD.tsx src/components/HUD.css src/App.tsx
git commit -m "feat: add HUD with health, hunger, day counter, and minimap"
```

---

### Task 16: Daily Action Dialog

**Files:**
- Create: `SurviveRexburg2026/src/components/DailyActionDialog.tsx`
- Create: `SurviveRexburg2026/src/components/DailyActionDialog.css`

- [ ] **Step 1: Build DailyActionDialog component**

Retro RPG-style text box at bottom of screen. Shows "Day X — What do you want to do?" with 4 buttons: Explore Rexburg, Fortify Location, Scavenge Location, Sit and Wait. Styled like a classic JRPG dialog box.

- [ ] **Step 2: Wire to game state**

When player interacts with their current location (or at start of each day), show this dialog. On button click, call the appropriate game action which resolves via the scenario engine.

- [ ] **Step 3: Verify in browser**

Expected: Dialog appears, clicking a choice produces a scenario outcome.

- [ ] **Step 4: Commit**

```bash
git add src/components/DailyActionDialog.tsx src/components/DailyActionDialog.css
git commit -m "feat: add daily action dialog with 4 choices"
```

---

### Task 17: Scenario Outcome Dialog

**Files:**
- Create: `SurviveRexburg2026/src/components/ScenarioDialog.tsx`
- Create: `SurviveRexburg2026/src/components/ScenarioDialog.css`

- [ ] **Step 1: Build ScenarioDialog component**

Shows the result of a daily action. Different content per outcome type:
- **Nothing happens** → "The day passes uneventfully."
- **Survivors offer help** → Description + choices: Accept / Deny / Run Away
- **Survivors attack** → Description + choices: Fight / Run / Negotiate
- **Zombies attack** → Description + choices: Fight / Run
- **Found item** → Shows what was found
- **Combat results** → Win/lose descriptions
- **Death** → Game over message

Each sub-choice triggers further scenario resolution (fight survivors, run from zombies, etc.).

- [ ] **Step 2: Wire into game flow**

After daily action resolves, show ScenarioDialog. Player choices within the dialog chain to further resolutions until the day ends.

- [ ] **Step 3: Verify full daily cycle in browser**

Expected: Choose action → see outcome → respond to encounters → day ends → hunger decreases → next day starts.

- [ ] **Step 4: Commit**

```bash
git add src/components/ScenarioDialog.tsx src/components/ScenarioDialog.css
git commit -m "feat: add scenario outcome dialog with encounter sub-choices"
```

---

### Task 18: Inventory Panel

**Files:**
- Create: `SurviveRexburg2026/src/components/InventoryPanel.tsx`
- Create: `SurviveRexburg2026/src/components/InventoryPanel.css`

- [ ] **Step 1: Build InventoryPanel component**

Slide-out panel (toggle with 'I' key or inventory button on HUD). Shows:
- Equipped melee weapon + ranged weapon
- Backpack contents grouped by type (food, spoiled food, weapons)
- Weight used / max weight
- Click food → eat it (restores health/hunger)
- Click weapon → equip it (swap with current)
- Click to drop items

- [ ] **Step 2: Wire to game state**

Eating food calls `eatFood()` and removes item from backpack. Equipping swaps weapons.

- [ ] **Step 3: Verify in browser**

Expected: Press I → panel slides out, eat food → stats update in HUD.

- [ ] **Step 4: Commit**

```bash
git add src/components/InventoryPanel.tsx src/components/InventoryPanel.css
git commit -m "feat: add inventory panel with eat, equip, and drop actions"
```

---

### Task 19: Explore Action — Map Location Selection

**Files:**
- Modify: `SurviveRexburg2026/src/components/DailyActionDialog.tsx`
- Modify: `SurviveRexburg2026/src/engine/GameCanvas.tsx`

- [ ] **Step 1: Implement explore flow**

When player chooses "Explore Rexburg", enter a location-selection mode: highlight adjacent tiles, player clicks/moves to target. Run explore scenario resolution on arrival.

- [ ] **Step 2: Handle explore outcomes**

Safe trip → arrive and mark visited. Encounter on the way → show ScenarioDialog before arriving.

- [ ] **Step 3: Verify in browser**

- [ ] **Step 4: Commit**

```bash
git add src/components/DailyActionDialog.tsx src/engine/GameCanvas.tsx
git commit -m "feat: implement explore action with map location selection"
```

---

### Task 20: Game Over & Victory Screens

**Files:**
- Create: `SurviveRexburg2026/src/components/GameOverScreen.tsx`
- Create: `SurviveRexburg2026/src/components/VictoryScreen.tsx`
- Create: `SurviveRexburg2026/src/components/GameOverScreen.css`

- [ ] **Step 1: Build GameOverScreen**

Shows death cause (killed by zombies, killed by survivors, killed by hunger), days survived, locations visited, items collected. "Play Again" button returns to main menu.

- [ ] **Step 2: Build VictoryScreen**

"YOU SURVIVED REXBURG!" — 30 days survived, final stats, play again button. Celebratory pixel art and chiptune victory jingle (placeholder for now).

- [ ] **Step 3: Wire to game state**

Render when `state.phase === 'game_over'` or `'won'`.

- [ ] **Step 4: Verify in browser**

- [ ] **Step 5: Commit**

```bash
git add src/components/GameOverScreen.tsx src/components/VictoryScreen.tsx src/components/GameOverScreen.css
git commit -m "feat: add game over and victory screens"
```

---

### Task 21: Save/Load UI

**Files:**
- Create: `SurviveRexburg2026/src/components/SaveLoadMenu.tsx`
- Create: `SurviveRexburg2026/src/components/SaveLoadMenu.css`

- [ ] **Step 1: Build SaveLoadMenu component**

Accessible from main menu ("Load Game") and from HUD during gameplay ("Save" button). Shows:
- 3 save slots with timestamp and day number
- Save to slot (during gameplay)
- Load from slot
- Export save as JSON download
- Import save from JSON file upload
- Delete save

- [ ] **Step 2: Wire auto-save**

Auto-save to current slot on day transition and after major events.

- [ ] **Step 3: Verify in browser**

Expected: Save game → reload page → load game → resumes at correct state.

- [ ] **Step 4: Commit**

```bash
git add src/components/SaveLoadMenu.tsx src/components/SaveLoadMenu.css
git commit -m "feat: add save/load UI with slots, export, and import"
```

---

### Task 22: Help Screen

**Files:**
- Create: `SurviveRexburg2026/src/components/HelpScreen.tsx`
- Create: `SurviveRexburg2026/src/components/HelpScreen.css`

- [ ] **Step 1: Build HelpScreen component**

Retro-styled help page explaining: controls (WASD/arrows/click), game objective (survive 30 days), daily actions, inventory management, combat tips, stat explanations.

- [ ] **Step 2: Wire to main menu and in-game access**

Accessible from main menu "Help" button and via 'H' key during gameplay.

- [ ] **Step 3: Commit**

```bash
git add src/components/HelpScreen.tsx src/components/HelpScreen.css
git commit -m "feat: add help screen with controls and game guide"
```

---

### Task 23: Audio System

**Files:**
- Create: `SurviveRexburg2026/src/engine/audio.ts`
- Create: `SurviveRexburg2026/public/audio/` (directory for audio files)

- [ ] **Step 1: Create AudioManager class**

```typescript
// src/engine/audio.ts
export class AudioManager {
  private tracks: Map<string, HTMLAudioElement> = new Map();
  private currentMusic: HTMLAudioElement | null = null;
  private volume: number = 0.5;
  private muted: boolean = false;

  async preload(id: string, url: string): Promise<void> { /* ... */ }
  play(id: string, loop?: boolean): void { /* ... */ }
  stop(id?: string): void { /* ... */ }
  crossfade(fromId: string, toId: string, duration: number): void { /* ... */ }
  setVolume(volume: number): void { /* ... */ }
  toggleMute(): boolean { /* ... */ }
}
```

- [ ] **Step 2: Generate placeholder sound effects**

Use jsfxr or similar to create placeholder `.mp3` files: menu_select, footstep, eat, equip, hit, zombie_groan, damage, death. Place in `public/audio/`.

- [ ] **Step 3: Find/create placeholder chiptune tracks**

At minimum: menu_theme, exploration_loop, combat_sting, game_over, victory. Place in `public/audio/`. Can use freely-licensed chiptune tracks or generate with a tool.

- [ ] **Step 4: Integrate AudioManager with game**

Play menu theme on main menu, exploration loop during gameplay, combat sting during encounters, game over / victory tracks. Play SFX on actions (move, eat, fight, etc.).

- [ ] **Step 5: Add volume/mute toggle to HUD**

- [ ] **Step 6: Commit**

```bash
git add src/engine/audio.ts public/audio/ src/components/HUD.tsx
git commit -m "feat: add audio system with chiptune music and retro sound effects"
```

---

### Task 24: Player Sprite Animation

**Files:**
- Modify: `SurviveRexburg2026/src/engine/renderer.ts`
- Create: `SurviveRexburg2026/public/sprites/player.png` (sprite sheet)

- [ ] **Step 1: Create or source a simple pixel art player sprite sheet**

4 directions (up/down/left/right), 2-3 frames each for walk animation, 1 idle frame. 16x16 or 32x32 pixels per frame.

- [ ] **Step 2: Add sprite rendering to renderer**

Load sprite sheet, draw correct frame based on player direction and movement state. Smooth lerp between tiles (~200ms transition).

- [ ] **Step 3: Verify in browser**

Expected: Player sprite animates when moving between tiles.

- [ ] **Step 4: Commit**

```bash
git add src/engine/renderer.ts public/sprites/
git commit -m "feat: add player sprite animation with directional walk cycle"
```

---

### Task 25: Entity Sprites (Zombies & Survivors)

**Files:**
- Modify: `SurviveRexburg2026/src/engine/renderer.ts`
- Create: `SurviveRexburg2026/public/sprites/zombie.png`
- Create: `SurviveRexburg2026/public/sprites/survivor.png`

- [ ] **Step 1: Create simple zombie and survivor sprites**

Small pixel art sprites (16x16 or 32x32). Zombie = green/gray shambling figure. Survivor = human figure with different color.

- [ ] **Step 2: Render entities on map tiles**

Draw zombie sprite on tiles with zombieCount > 0, survivor sprite on tiles with survivorStrength > 0. Tile fog-of-war hides them until visited.

- [ ] **Step 3: Commit**

```bash
git add src/engine/renderer.ts public/sprites/
git commit -m "feat: add zombie and survivor sprites on map tiles"
```

---

### Task 26: GitHub Pages Deployment

**Files:**
- Create: `SurviveRexburg2026/.github/workflows/deploy.yml`

Note: The workflow file needs to be at the repo root: `.github/workflows/deploy.yml`.

- [ ] **Step 1: Create GitHub Actions workflow**

```yaml
# .github/workflows/deploy.yml
name: Deploy to GitHub Pages

on:
  push:
    branches: [master]

permissions:
  contents: read
  pages: write
  id-token: write

concurrency:
  group: pages
  cancel-in-progress: true

jobs:
  build:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v4
      - uses: actions/setup-node@v4
        with:
          node-version: 20
          cache: npm
          cache-dependency-path: SurviveRexburg2026/package-lock.json
      - run: cd SurviveRexburg2026 && npm ci
      - run: cd SurviveRexburg2026 && npm run build
      - uses: actions/upload-pages-artifact@v3
        with:
          path: SurviveRexburg2026/dist

  deploy:
    needs: build
    runs-on: ubuntu-latest
    environment:
      name: github-pages
      url: ${{ steps.deployment.outputs.page_url }}
    steps:
      - id: deployment
        uses: actions/deploy-pages@v4
```

- [ ] **Step 2: Verify build works locally**

```bash
cd SurviveRexburg2026
npm run build
```

Expected: `dist/` created with static files.

- [ ] **Step 3: Commit**

```bash
git add .github/workflows/deploy.yml
git commit -m "feat: add GitHub Actions workflow for GitHub Pages deployment"
```

- [ ] **Step 4: Push and verify deployment**

After pushing, check GitHub Actions tab — build should succeed and site should be live at `https://<username>.github.io/SurviveRexburg/`.

---

### Task 27: Polish & Responsive Layout

**Files:**
- Modify: various component CSS files

- [ ] **Step 1: Test on mobile viewport sizes**

Use browser dev tools to check 375px (iPhone), 768px (tablet), 1024px+ (desktop). Fix layout issues.

- [ ] **Step 2: Ensure canvas resizes responsively**

Canvas should fill available space, tile size adjusts so the game is playable on all screen sizes.

- [ ] **Step 3: Add touch-friendly tap targets**

Ensure buttons and interactive elements are at least 44x44px for touch.

- [ ] **Step 4: Final visual polish**

Consistent retro theme across all screens, smooth transitions between game phases.

- [ ] **Step 5: Commit**

```bash
git add -A
git commit -m "feat: add responsive layout and visual polish for mobile/desktop"
```

---

### Task 28: End-to-End Playthrough Testing

**Files:**
- No new files — manual testing task

- [ ] **Step 1: Play through a full game**

Start new game → select character → navigate map → make daily choices → encounter zombies and survivors → manage inventory → survive or die. Verify all mechanics work correctly.

- [ ] **Step 2: Test all death scenarios**

- Killed by hunger (don't eat)
- Killed by zombies (fight and lose)
- Killed by survivors (fight and lose)

- [ ] **Step 3: Test victory**

Use Nathan (cheat character) to easily survive 30 days and verify victory screen.

- [ ] **Step 4: Test save/load**

Save mid-game → reload page → load save → verify state restored correctly. Export save → import on different browser/incognito.

- [ ] **Step 5: Fix any bugs found**

- [ ] **Step 6: Commit fixes**

```bash
git add -A
git commit -m "fix: address bugs found during end-to-end playthrough testing"
```

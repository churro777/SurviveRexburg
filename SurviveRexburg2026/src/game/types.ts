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

export type Facing = 'down' | 'up' | 'left' | 'right';

export interface Player {
  name: string;
  characterId: string;
  strength: number;
  speed: number;
  charisma: number;
  luck: number;
  health: number;    // 0-100
  hunger: number;    // 0-100
  row: number;
  col: number;
  facing: Facing;
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
  description: string;
  quantity: number;
  weight: number;
}

export interface SpoiledFoodItem {
  type: 'spoiled_food';
  id: string;
  name: string;
  description: string;
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
  | { type: 'survivors_take_item_and_leave' }
  | { type: 'tricked_survivors_attack' }
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

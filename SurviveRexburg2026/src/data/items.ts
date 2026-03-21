import { FoodItem, SpoiledFoodItem, MeleeWeapon, RangedWeapon } from '../game/types';

export const FOOD_ITEMS: Omit<FoodItem, 'quantity'>[] = [
  { type: 'food', id: 'canned_tuna',  name: 'Canned Tuna',  description: 'A can of tuna fish.', weight: 1 },
  { type: 'food', id: 'canned_beans', name: 'Canned Beans', description: 'A can of beans.', weight: 1 },
  { type: 'food', id: 'apples',       name: 'Apples',       description: 'A bag of apples.', weight: 1 },
  { type: 'food', id: 'potatoes',     name: 'Potatoes',     description: 'A sack of potatoes.', weight: 1 },
  { type: 'food', id: 'bread',        name: 'Bread',        description: 'A loaf of bread.', weight: 1 },
  { type: 'food', id: 'cereal',       name: 'Cereal',       description: 'A box of cereal.', weight: 1 },
  { type: 'food', id: 'top_ramen',    name: 'Top Ramen',    description: 'A pack of ramen noodles.', weight: 1 },
  { type: 'food', id: 'chocolate',    name: 'Chocolate',    description: 'A bar of chocolate.', weight: 1 },
];

export const SPOILED_FOOD_ITEMS: Omit<SpoiledFoodItem, 'quantity'>[] = [
  { type: 'spoiled_food', id: 'rotten_eggs',   name: 'Rotten Eggs',    description: 'These eggs have gone bad.', weight: 1, healthDamage: 1 },
  { type: 'spoiled_food', id: 'moldy_cheese',  name: 'Moldy Cheese',   description: 'Cheese covered in mold.', weight: 1, healthDamage: 1 },
  { type: 'spoiled_food', id: 'sour_milk',     name: 'Sour Milk',      description: 'Milk that has curdled.', weight: 1, healthDamage: 3 },
  { type: 'spoiled_food', id: 'moldy_bread',   name: 'Moldy Bread',    description: 'Bread covered in mold.', weight: 1, healthDamage: 1 },
  { type: 'spoiled_food', id: 'rotten_mango',  name: 'Rotten Mangos',  description: 'Mangos that have rotted.', weight: 1, healthDamage: 3 },
  { type: 'spoiled_food', id: 'rotten_apple',  name: 'Rotten Apples',  description: 'Apples that have rotted.', weight: 1, healthDamage: 2 },
  { type: 'spoiled_food', id: 'rotten_banana', name: 'Rotten Bananas', description: 'Bananas that have rotted.', weight: 1, healthDamage: 2 },
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

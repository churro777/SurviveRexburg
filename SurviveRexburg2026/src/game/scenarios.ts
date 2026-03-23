import type { ScenarioOutcome } from './types';

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
  const value = (fortifyLevel * 4) + base;
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
  if (value >= 50) return { type: 'survivors_give_item', foodId: '' };
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
  if (value >= 75) return { type: 'escape_to_location', newRow: 0, newCol: 0 };
  if (value >= 50) return { type: 'captured_injured' };
  if (value >= 25) return { type: 'captured_injured_robbed' };
  return { type: 'killed_by_survivors' };
}

export function resolveRunFromZombies(stats: CharStats, daysPassed: number): ScenarioOutcome {
  const speedBonus = stats.speed * 3;
  const roll = Math.floor(Math.random() * 100) + 1;
  const luckBonus = (Math.floor(Math.random() * stats.luck) + 1) * 4;
  const value = roll + luckBonus + speedBonus - daysPassed;
  if (value >= 50) return { type: 'escape_zombies', newRow: 0, newCol: 0 };
  return { type: 'killed_by_zombies' };
}

export function resolveOfferItemToSurvivors(stats: CharStats, daysPassed: number): ScenarioOutcome {
  const charismaBonus = stats.charisma * 3;
  const roll = Math.floor(Math.random() * 100) + 1;
  const luckBonus = (Math.floor(Math.random() * stats.luck) + 1) * 4;
  const value = roll + luckBonus + charismaBonus - daysPassed;
  if (value >= 50) return { type: 'survivors_take_item_and_leave' };
  return { type: 'tricked_survivors_attack' };
}

export function resolveHelpSurvivors(stats: CharStats, daysPassed: number): ScenarioOutcome {
  const charismaBonus = stats.charisma * 3;
  const roll = Math.floor(Math.random() * 100) + 1;
  const luckBonus = (Math.floor(Math.random() * stats.luck) + 1) * 4;
  const value = roll + luckBonus + charismaBonus - daysPassed;
  if (value >= 50) return { type: 'survivors_take_item_and_leave' };
  return { type: 'tricked_survivors_attack' };
}

export function resolveRefuseHelp(stats: CharStats, daysPassed: number): ScenarioOutcome {
  const charismaBonus = stats.charisma * 3;
  const roll = Math.floor(Math.random() * 100) + 1;
  const luckBonus = (Math.floor(Math.random() * stats.luck) + 1) * 4;
  const value = roll + luckBonus + charismaBonus - daysPassed;
  if (value >= 50) return { type: 'survivors_leave' };
  return { type: 'survivors_attack' };
}

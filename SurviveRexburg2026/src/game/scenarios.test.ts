import { describe, it, expect } from 'vitest';
import { resolveDoNothing, resolveFortify, resolveExplore, resolveScavenge, resolveFightZombies, resolveRunFromZombies, resolveFightSurvivors, resolveRunFromSurvivors, resolveAcceptHelp, resolveDenyHelp, resolveNegotiate, resolveOfferItemToSurvivors, resolveHelpSurvivors, resolveRefuseHelp } from './scenarios';

describe('resolveDoNothing', () => {
  it('returns one of 5 valid outcomes', () => {
    const validTypes = ['nothing_happens', 'survivors_offer_help', 'survivors_ask_help', 'survivors_attack', 'zombies_attack'];
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

describe('resolveExplore', () => {
  it('returns one of 5 valid outcomes', () => {
    const validTypes = ['safe_trip', 'survivors_offer_help', 'survivors_ask_help', 'survivors_attack', 'zombies_attack'];
    for (let i = 0; i < 100; i++) {
      const result = resolveExplore({ luck: 4, charisma: 1, speed: 5, strength: 10 }, 1);
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

describe('resolveRunFromZombies', () => {
  it('returns escape_zombies or killed_by_zombies', () => {
    const validTypes = ['escape_zombies', 'killed_by_zombies'];
    for (let i = 0; i < 100; i++) {
      const result = resolveRunFromZombies({ luck: 4, charisma: 1, speed: 5, strength: 10 }, 1, 3, 3, 8, 7);
      expect(validTypes).toContain(result.type);
    }
  });
});

describe('resolveRunFromSurvivors', () => {
  it('returns one of 4 valid outcomes', () => {
    const validTypes = ['escape_to_location', 'captured_injured', 'captured_injured_robbed', 'killed_by_survivors'];
    for (let i = 0; i < 100; i++) {
      const result = resolveRunFromSurvivors({ luck: 4, charisma: 1, speed: 5, strength: 10 }, 1, 3, 3, 8, 7);
      expect(validTypes).toContain(result.type);
    }
  });
});

describe('resolveOfferItemToSurvivors', () => {
  it('returns survivors_take_item_and_leave or tricked_survivors_attack', () => {
    const validTypes = ['survivors_take_item_and_leave', 'tricked_survivors_attack'];
    for (let i = 0; i < 100; i++) {
      const result = resolveOfferItemToSurvivors({ luck: 4, charisma: 1, speed: 5, strength: 10 }, 1);
      expect(validTypes).toContain(result.type);
    }
  });
});

describe('resolveHelpSurvivors', () => {
  it('returns survivors_take_item_and_leave or tricked_survivors_attack', () => {
    const validTypes = ['survivors_take_item_and_leave', 'tricked_survivors_attack'];
    for (let i = 0; i < 100; i++) {
      const result = resolveHelpSurvivors({ luck: 4, charisma: 1, speed: 5, strength: 10 }, 1);
      expect(validTypes).toContain(result.type);
    }
  });
});

describe('resolveRefuseHelp', () => {
  it('returns survivors_leave or survivors_attack', () => {
    const validTypes = ['survivors_leave', 'survivors_attack'];
    for (let i = 0; i < 100; i++) {
      const result = resolveRefuseHelp({ luck: 4, charisma: 1, speed: 5, strength: 10 }, 1);
      expect(validTypes).toContain(result.type);
    }
  });
});

describe('resolveAcceptHelp', () => {
  it('returns survivors_give_item or survivors_attack', () => {
    const validTypes = ['survivors_give_item', 'survivors_attack'];
    for (let i = 0; i < 100; i++) {
      const result = resolveAcceptHelp({ luck: 4, charisma: 1, speed: 5, strength: 10 }, 1);
      expect(validTypes).toContain(result.type);
    }
  });
});

describe('resolveDenyHelp', () => {
  it('returns survivors_leave or survivors_attack', () => {
    const validTypes = ['survivors_leave', 'survivors_attack'];
    for (let i = 0; i < 100; i++) {
      const result = resolveDenyHelp({ luck: 4, charisma: 1, speed: 5, strength: 10 }, 1);
      expect(validTypes).toContain(result.type);
    }
  });
});

describe('resolveNegotiate', () => {
  it('returns survivors_listen or survivors_dont_listen', () => {
    const validTypes = ['survivors_listen', 'survivors_dont_listen'];
    for (let i = 0; i < 100; i++) {
      const result = resolveNegotiate({ luck: 4, charisma: 1, speed: 5, strength: 10 }, 1);
      expect(validTypes).toContain(result.type);
    }
  });
});

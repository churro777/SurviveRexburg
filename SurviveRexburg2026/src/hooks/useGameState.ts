import { useCallback } from 'react';
import { useGameContext } from './GameContext';
import type { CharacterTemplate, DailyAction, BackpackItem, FoodItem, SpoiledFoodItem } from '../game/types';
import { startNewGame, advanceDay, movePlayer, pickRandomFood, pickRandomWeapon, pickRandomLocation } from '../game/actions';
import { eatFood, eatSpoiledFood, takeDamage } from '../game/state';
import { resolveDoNothing, resolveFortify, resolveExplore, resolveScavenge } from '../game/scenarios';
import { audioManager } from '../engine/audio';

export function useGameState() {
  const { state, setState } = useGameContext();

  const goToCharacterSelect = useCallback(() => {
    setState(prev => ({ ...prev, phase: 'character_select' }));
  }, [setState]);

  const goToMenu = useCallback(() => {
    setState(prev => ({ ...prev, phase: 'menu' }));
  }, [setState]);

  const selectCharacter = useCallback((character: CharacterTemplate) => {
    setState(() => startNewGame(character));
  }, [setState]);

  const move = useCallback((row: number, col: number) => {
    audioManager.play('footstep');
    setState(prev => movePlayer(prev, row, col));
  }, [setState]);

  const endDay = useCallback(() => {
    setState(prev => advanceDay(prev));
  }, [setState]);

  const performDailyAction = useCallback((action: DailyAction) => {
    setState(prev => {
      if (!prev.player) return prev;
      const stats = {
        luck: prev.player.luck,
        charisma: prev.player.charisma,
        speed: prev.player.speed,
        strength: prev.player.strength,
      };

      let outcome;
      switch (action) {
        case 'do_nothing':
          outcome = resolveDoNothing(stats, prev.day);
          break;
        case 'fortify':
          outcome = resolveFortify(stats, prev.day, prev.fortifyLevel);
          break;
        case 'explore':
          outcome = resolveExplore(stats, prev.day);
          break;
        case 'scavenge':
          outcome = resolveScavenge(stats, prev.day);
          break;
      }

      let newState = { ...prev, currentScenario: outcome, phase: 'scenario' as const };

      if (outcome.type === 'safely_fortified') {
        newState = { ...newState, fortifyLevel: newState.fortifyLevel + 1 };
      }

      return newState;
    });
  }, [setState]);

  const eatFoodItem = useCallback((itemIndex: number) => {
    setState(prev => {
      if (!prev.player) return prev;
      const item = prev.player.backpack.items[itemIndex];
      if (!item) return prev;

      let player = prev.player;
      if (item.type === 'food') {
        audioManager.play('eat');
        player = eatFood(player);
      } else if (item.type === 'spoiled_food') {
        audioManager.play('eat');
        player = eatSpoiledFood(player, item.healthDamage);
      } else {
        return prev;
      }

      const newItems = [...player.backpack.items];
      const foodItem = newItems[itemIndex] as FoodItem | SpoiledFoodItem;
      if (foodItem.quantity <= 1) {
        newItems.splice(itemIndex, 1);
      } else {
        newItems[itemIndex] = { ...foodItem, quantity: foodItem.quantity - 1 };
      }

      const loadedWeight = newItems.reduce((sum, i) => {
        if (i.type === 'food' || i.type === 'spoiled_food') return sum + i.weight * i.quantity;
        return sum;
      }, 0);

      return {
        ...prev,
        player: {
          ...player,
          backpack: { ...player.backpack, items: newItems, loadedWeight },
        },
      };
    });
  }, [setState]);

  const equipWeapon = useCallback((itemIndex: number) => {
    setState(prev => {
      if (!prev.player) return prev;
      const item = prev.player.backpack.items[itemIndex];
      if (!item) return prev;

      const newItems = [...prev.player.backpack.items];
      let player = { ...prev.player };

      if (item.type === 'melee_weapon') {
        const old = player.meleeWeapon;
        player.meleeWeapon = item;
        newItems[itemIndex] = old;
      } else if (item.type === 'ranged_weapon') {
        const old = player.rangedWeapon;
        player.rangedWeapon = item;
        newItems[itemIndex] = old;
      } else {
        return prev;
      }

      audioManager.play('equip');
      return {
        ...prev,
        player: { ...player, backpack: { ...player.backpack, items: newItems } },
      };
    });
  }, [setState]);

  const dismissScenario = useCallback(() => {
    setState(prev => ({ ...prev, currentScenario: null, phase: 'playing' }));
  }, [setState]);

  const setScenario = useCallback((outcome: import('../game/types').ScenarioOutcome) => {
    setState(prev => ({ ...prev, currentScenario: outcome, phase: 'scenario' }));
  }, [setState]);

  const applyDamage = useCallback(() => {
    setState(prev => {
      if (!prev.player) return prev;
      const player = takeDamage(prev.player);
      if (player.health <= 0) {
        audioManager.play('death');
        return { ...prev, player, phase: 'game_over' };
      }
      audioManager.play('damage');
      return { ...prev, player };
    });
  }, [setState]);

  const addItemToBackpack = useCallback((item: BackpackItem) => {
    setState(prev => {
      if (!prev.player) return prev;
      const newItems = [...prev.player.backpack.items, item];
      const loadedWeight = newItems.reduce((sum, i) => {
        if (i.type === 'food' || i.type === 'spoiled_food') return sum + i.weight * (i as FoodItem).quantity;
        return sum;
      }, 0);
      return {
        ...prev,
        player: {
          ...prev.player,
          backpack: { ...prev.player.backpack, items: newItems, loadedWeight },
        },
      };
    });
  }, [setState]);

  return {
    state,
    setState,
    goToCharacterSelect,
    goToMenu,
    selectCharacter,
    move,
    endDay,
    performDailyAction,
    eatFoodItem,
    equipWeapon,
    dismissScenario,
    setScenario,
    applyDamage,
    addItemToBackpack,
    pickRandomFood,
    pickRandomWeapon,
    pickRandomLocation,
  };
}

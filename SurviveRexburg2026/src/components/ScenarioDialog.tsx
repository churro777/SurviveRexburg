import { useGameState } from '../hooks/useGameState';
import type { ScenarioOutcome } from '../game/types';
import {
  resolveFightZombies, resolveRunFromZombies,
  resolveFightSurvivors, resolveRunFromSurvivors,
  resolveAcceptHelp, resolveDenyHelp,
  resolveNegotiate, resolveOfferItemToSurvivors,
  resolveHelpSurvivors, resolveRefuseHelp,
} from '../game/scenarios';
import './ScenarioDialog.css';

function getScenarioText(outcome: ScenarioOutcome): string {
  switch (outcome.type) {
    case 'nothing_happens': return 'The day passes uneventfully. You rest and conserve energy.';
    case 'day_ends': return 'The day comes to an end.';
    case 'safely_fortified': return 'You spend the day fortifying your position. The area feels more secure.';
    case 'safe_trip': return 'You travel safely to a new location.';
    case 'find_item': return 'While scavenging, you found something useful!';
    case 'find_nothing': return 'You search the area but find nothing of value.';
    case 'survivors_offer_help': return 'A group of survivors approaches. They seem friendly and offer to help you.';
    case 'survivors_ask_help': return 'A group of survivors approaches. They look desperate and ask for your help.';
    case 'survivors_attack': return 'Hostile survivors have spotted you! They look dangerous.';
    case 'zombies_attack': return 'Zombies! A horde of the undead shambles toward you!';
    case 'survivors_give_item': return 'The survivors share some supplies with you. How generous!';
    case 'survivors_take_item_and_leave': return 'The survivors take what they need and leave peacefully.';
    case 'tricked_survivors_attack': return 'It was a trap! The survivors turn hostile!';
    case 'survivors_leave': return 'The survivors decide to leave you alone.';
    case 'survivors_listen': return 'Your negotiation works. The survivors agree to stand down.';
    case 'survivors_dont_listen': return "They don't listen. The situation escalates...";
    case 'escape_to_location': return 'You manage to escape to a nearby location!';
    case 'escape_zombies': return 'You outrun the zombies and escape!';
    case 'captured_injured': return 'You were captured and injured in the struggle.';
    case 'captured_injured_robbed': return 'You were captured, injured, and robbed of your supplies!';
    case 'killed_by_survivors': return 'The survivors overwhelmed you. Your journey ends here...';
    case 'killed_by_zombies': return 'The zombie horde was too much. You have fallen...';
    case 'killed_by_hunger': return 'Starvation has claimed another victim...';
    case 'win_fight_gain_supplies': return 'You won the fight and found some supplies!';
    case 'win_fight': return 'You fought them off! The threat is neutralized.';
    case 'lose_fight_injured': return 'You lost the fight and sustained injuries.';
    case 'found_food': return 'You found some food!';
    case 'found_weapon': return 'You found a weapon!';
    default: return 'Something happened...';
  }
}

function isTerminalOutcome(type: string): boolean {
  return ['nothing_happens', 'day_ends', 'safely_fortified', 'safe_trip',
    'find_item', 'find_nothing', 'survivors_give_item', 'survivors_take_item_and_leave',
    'survivors_leave', 'survivors_listen', 'escape_to_location', 'escape_zombies',
    'win_fight_gain_supplies', 'win_fight', 'lose_fight_injured',
    'captured_injured', 'captured_injured_robbed', 'found_food', 'found_weapon',
  ].includes(type);
}

function isDeathOutcome(type: string): boolean {
  return ['killed_by_survivors', 'killed_by_zombies', 'killed_by_hunger'].includes(type);
}

export function ScenarioDialog() {
  const { state, dismissScenario, setScenario, applyDamage, endDay, addItemToBackpack, pickRandomFood } = useGameState();
  const outcome = state.currentScenario;

  if (!outcome || !state.player) return null;

  const stats = {
    luck: state.player.luck,
    charisma: state.player.charisma,
    speed: state.player.speed,
    strength: state.player.strength,
  };
  const meleeStr = state.player.meleeWeapon.strengthValue;
  const rangedLuck = state.player.rangedWeapon.luckValue;

  const handleContinue = () => {
    if (isDeathOutcome(outcome.type)) {
      // Game over is handled by state
      return;
    }
    if (outcome.type === 'lose_fight_injured' || outcome.type === 'captured_injured' || outcome.type === 'captured_injured_robbed') {
      applyDamage();
    }
    if (outcome.type === 'find_item') {
      const food = pickRandomFood();
      addItemToBackpack(food);
    }
    if (outcome.type === 'win_fight_gain_supplies') {
      const food = pickRandomFood();
      addItemToBackpack(food);
    }
    dismissScenario();
    endDay();
  };

  const renderChoices = () => {
    // Terminal or death outcomes — just show continue
    if (isTerminalOutcome(outcome.type) || isDeathOutcome(outcome.type)) {
      return (
        <div className="scenario-choices">
          <button onClick={handleContinue}>
            {isDeathOutcome(outcome.type) ? 'Game Over...' : 'Continue'}
          </button>
        </div>
      );
    }

    switch (outcome.type) {
      case 'survivors_offer_help':
        return (
          <div className="scenario-choices">
            <button onClick={() => setScenario(resolveAcceptHelp(stats, state.day))}>Accept Help</button>
            <button onClick={() => setScenario(resolveDenyHelp(stats, state.day))}>Deny Help</button>
            <button onClick={() => setScenario(resolveRunFromSurvivors(stats, state.day))}>Run Away</button>
          </div>
        );
      case 'survivors_ask_help':
        return (
          <div className="scenario-choices">
            <button onClick={() => setScenario(resolveHelpSurvivors(stats, state.day))}>Help Them</button>
            <button onClick={() => setScenario(resolveRefuseHelp(stats, state.day))}>Refuse</button>
            <button onClick={() => setScenario(resolveOfferItemToSurvivors(stats, state.day))}>Offer Item</button>
          </div>
        );
      case 'survivors_attack':
        return (
          <div className="scenario-choices">
            <button onClick={() => setScenario(resolveFightSurvivors(stats, state.day, meleeStr, rangedLuck))}>Fight!</button>
            <button onClick={() => setScenario(resolveRunFromSurvivors(stats, state.day))}>Run!</button>
            <button onClick={() => setScenario(resolveNegotiate(stats, state.day))}>Negotiate</button>
          </div>
        );
      case 'zombies_attack':
        return (
          <div className="scenario-choices">
            <button onClick={() => setScenario(resolveFightZombies(stats, state.day, meleeStr, rangedLuck))}>Fight!</button>
            <button onClick={() => setScenario(resolveRunFromZombies(stats, state.day))}>Run!</button>
          </div>
        );
      case 'survivors_dont_listen':
        return (
          <div className="scenario-choices">
            <button onClick={() => setScenario(resolveFightSurvivors(stats, state.day, meleeStr, rangedLuck))}>Fight!</button>
            <button onClick={() => setScenario(resolveRunFromSurvivors(stats, state.day))}>Run!</button>
          </div>
        );
      case 'tricked_survivors_attack':
        return (
          <div className="scenario-choices">
            <button onClick={() => setScenario(resolveFightSurvivors(stats, state.day, meleeStr, rangedLuck))}>Fight!</button>
            <button onClick={() => setScenario(resolveRunFromSurvivors(stats, state.day))}>Run!</button>
          </div>
        );
      default:
        return (
          <div className="scenario-choices">
            <button onClick={handleContinue}>Continue</button>
          </div>
        );
    }
  };

  return (
    <div className="scenario-dialog-overlay">
      <div className="scenario-dialog">
        <p className="scenario-text">{getScenarioText(outcome)}</p>
        {renderChoices()}
      </div>
    </div>
  );
}

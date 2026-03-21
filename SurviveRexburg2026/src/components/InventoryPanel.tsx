import { useGameState } from '../hooks/useGameState';
import './InventoryPanel.css';

interface Props {
  onClose: () => void;
}

export function InventoryPanel({ onClose }: Props) {
  const { state, eatFoodItem, equipWeapon } = useGameState();

  if (!state.player) return null;

  const { backpack, meleeWeapon, rangedWeapon } = state.player;

  return (
    <div className="inventory-overlay" onClick={onClose}>
      <div className="inventory-panel" onClick={e => e.stopPropagation()}>
        <div className="inventory-header">
          <h3>Inventory</h3>
          <button className="close-btn" onClick={onClose}>X</button>
        </div>

        <div className="equipped-section">
          <h4>Equipped</h4>
          <div className="equipped-item">
            <span className="equip-label">Melee:</span>
            <span>{meleeWeapon.name} (+{meleeWeapon.strengthValue} STR)</span>
          </div>
          <div className="equipped-item">
            <span className="equip-label">Ranged:</span>
            <span>{rangedWeapon.name} (+{rangedWeapon.luckValue} LCK)</span>
          </div>
        </div>

        <div className="backpack-section">
          <h4>Backpack ({backpack.loadedWeight}/{backpack.maxWeight} wt)</h4>
          {backpack.items.length === 0 ? (
            <p className="empty-text">Empty</p>
          ) : (
            <div className="item-list">
              {backpack.items.map((item, idx) => (
                <div key={idx} className="item-row">
                  <span className="item-name">{item.name}</span>
                  {(item.type === 'food' || item.type === 'spoiled_food') && (
                    <>
                      <span className="item-qty">x{item.quantity}</span>
                      <button className="item-action" onClick={() => eatFoodItem(idx)}>Eat</button>
                    </>
                  )}
                  {(item.type === 'melee_weapon' || item.type === 'ranged_weapon') && (
                    <button className="item-action" onClick={() => equipWeapon(idx)}>Equip</button>
                  )}
                </div>
              ))}
            </div>
          )}
        </div>
      </div>
    </div>
  );
}

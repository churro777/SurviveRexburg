import type { GameMap, Player, Facing } from '../game/types';
import type { Camera } from './camera';

const TILE_COLORS = {
  visited: '#2d3748',
  unvisited: '#1a1a2e',
  grid: '#374151',
  playerGlow: 'rgba(74, 222, 128, 0.3)',
};

const imageCache = new Map<string, HTMLImageElement>();

function loadImage(src: string): HTMLImageElement | null {
  if (imageCache.has(src)) {
    const img = imageCache.get(src)!;
    return img.complete && img.naturalWidth > 0 ? img : null;
  }
  const img = new Image();
  img.src = src;
  imageCache.set(src, img);
  return null;
}

/** Draw a simple pixel-art player character facing a given direction */
function drawPlayer(ctx: CanvasRenderingContext2D, x: number, y: number, size: number, facing: Facing) {
  const s = Math.floor(size / 8);
  const cx = x + size / 2;
  const cy = y + size / 2;

  // Skin color for head
  ctx.fillStyle = '#fbbf24';
  // Head
  ctx.fillRect(cx - s, cy - s * 3.5, s * 2, s * 2);

  // Hair color based on direction (shows which way they face)
  ctx.fillStyle = '#92400e';
  if (facing === 'up') {
    ctx.fillRect(cx - s, cy - s * 3.5, s * 2, s);
  } else if (facing === 'left') {
    ctx.fillRect(cx, cy - s * 3.5, s, s * 2);
  } else if (facing === 'right') {
    ctx.fillRect(cx - s, cy - s * 3.5, s, s * 2);
  }

  // Eyes (only visible from front and sides)
  if (facing === 'down') {
    ctx.fillStyle = '#1a1a2e';
    ctx.fillRect(cx - s * 0.5, cy - s * 2.5, s * 0.3, s * 0.3);
    ctx.fillRect(cx + s * 0.2, cy - s * 2.5, s * 0.3, s * 0.3);
  }

  // Body (green shirt)
  ctx.fillStyle = '#22c55e';
  ctx.fillRect(cx - s * 1.5, cy - s * 1.5, s * 3, s * 2.5);

  // Arms
  ctx.fillStyle = '#fbbf24';
  if (facing === 'left') {
    ctx.fillRect(cx - s * 2, cy - s * 1, s * 0.5, s * 2);
    ctx.fillRect(cx + s * 1.5, cy - s * 1, s * 0.5, s * 1.5);
  } else if (facing === 'right') {
    ctx.fillRect(cx - s * 2, cy - s * 1, s * 0.5, s * 1.5);
    ctx.fillRect(cx + s * 1.5, cy - s * 1, s * 0.5, s * 2);
  } else {
    ctx.fillRect(cx - s * 2, cy - s * 1, s * 0.5, s * 1.5);
    ctx.fillRect(cx + s * 1.5, cy - s * 1, s * 0.5, s * 1.5);
  }

  // Legs (blue pants)
  ctx.fillStyle = '#3b82f6';
  const animOffset = (Date.now() % 600) < 300 ? 0 : s * 0.3;
  if (facing === 'left' || facing === 'right') {
    ctx.fillRect(cx - s, cy + s, s * 0.8, s * 2 + animOffset);
    ctx.fillRect(cx + s * 0.2, cy + s, s * 0.8, s * 2 - animOffset);
  } else {
    ctx.fillRect(cx - s, cy + s, s * 0.8, s * 2);
    ctx.fillRect(cx + s * 0.2, cy + s, s * 0.8, s * 2);
  }

  // Shoes
  ctx.fillStyle = '#78350f';
  ctx.fillRect(cx - s, cy + s * 3, s * 0.8, s * 0.5);
  ctx.fillRect(cx + s * 0.2, cy + s * 3, s * 0.8, s * 0.5);
}

/** Draw a simple pixel zombie on a tile */
function drawZombie(ctx: CanvasRenderingContext2D, x: number, y: number, size: number) {
  const s = Math.floor(size / 10);
  const cx = x + size / 2;
  const cy = y + size / 2;

  // Head (green)
  ctx.fillStyle = '#6b8e23';
  ctx.fillRect(cx - s, cy - s * 2, s * 2, s * 1.5);

  // Eyes (red)
  ctx.fillStyle = '#ef4444';
  ctx.fillRect(cx - s * 0.5, cy - s * 1.3, s * 0.4, s * 0.4);
  ctx.fillRect(cx + s * 0.2, cy - s * 1.3, s * 0.4, s * 0.4);

  // Body (torn)
  ctx.fillStyle = '#4a5a23';
  ctx.fillRect(cx - s * 1.2, cy - s * 0.5, s * 2.4, s * 2);

  // Arms (outstretched)
  ctx.fillStyle = '#6b8e23';
  ctx.fillRect(cx - s * 2.5, cy - s * 0.3, s * 1.3, s * 0.6);
  ctx.fillRect(cx + s * 1.2, cy - s * 0.1, s * 1.3, s * 0.6);
}

export function renderMap(
  ctx: CanvasRenderingContext2D,
  map: GameMap,
  player: Player,
  camera: Camera,
  tileSize: number,
  canvasWidth: number,
  canvasHeight: number
) {
  // Clear
  ctx.fillStyle = '#0a0a1a';
  ctx.fillRect(0, 0, canvasWidth, canvasHeight);

  // Draw tiles
  for (let vy = 0; vy < camera.viewportTilesY + 1; vy++) {
    for (let vx = 0; vx < camera.viewportTilesX + 1; vx++) {
      const mapRow = vy + camera.offsetY;
      const mapCol = vx + camera.offsetX;

      if (mapRow < 0 || mapRow >= map.rows || mapCol < 0 || mapCol >= map.cols) continue;

      const location = map.locations[mapRow][mapCol];
      const x = vx * tileSize;
      const y = vy * tileSize;

      if (location.visited) {
        // Try to load and draw the location image
        const img = loadImage(location.imagePath);
        if (img) {
          ctx.drawImage(img, x, y, tileSize, tileSize);
        } else {
          ctx.fillStyle = TILE_COLORS.visited;
          ctx.fillRect(x, y, tileSize, tileSize);
        }

        // Draw zombies indicator if present
        if (location.zombieCount > 0 && !(mapRow === player.row && mapCol === player.col)) {
          drawZombie(ctx, x, y, tileSize);
        }

        // Draw location name
        ctx.fillStyle = 'rgba(0, 0, 0, 0.6)';
        ctx.fillRect(x, y + tileSize - 16, tileSize, 16);
        ctx.fillStyle = '#d1d5db';
        ctx.font = '8px "Press Start 2P"';
        ctx.textAlign = 'center';
        ctx.fillText(
          location.name.length > 12 ? location.name.slice(0, 11) + '..' : location.name,
          x + tileSize / 2,
          y + tileSize - 5,
          tileSize - 4
        );
      } else {
        // Fog of war
        ctx.fillStyle = TILE_COLORS.unvisited;
        ctx.fillRect(x, y, tileSize, tileSize);
        ctx.fillStyle = '#374151';
        ctx.font = '16px serif';
        ctx.textAlign = 'center';
        ctx.fillText('?', x + tileSize / 2, y + tileSize / 2 + 6);
      }

      // Grid lines
      ctx.strokeStyle = TILE_COLORS.grid;
      ctx.lineWidth = 1;
      ctx.strokeRect(x, y, tileSize, tileSize);
    }
  }

  // Draw player
  const playerScreenX = (player.col - camera.offsetX) * tileSize;
  const playerScreenY = (player.row - camera.offsetY) * tileSize;

  // Player glow
  ctx.fillStyle = TILE_COLORS.playerGlow;
  ctx.fillRect(playerScreenX + 2, playerScreenY + 2, tileSize - 4, tileSize - 4);

  // Player sprite with directional facing
  drawPlayer(ctx, playerScreenX, playerScreenY, tileSize, player.facing);
}

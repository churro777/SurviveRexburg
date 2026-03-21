import type { GameMap, Player } from '../game/types';
import type { Camera } from './camera';

const TILE_COLORS = {
  visited: '#2d3748',
  unvisited: '#1a1a2e',
  player: '#4ade80',
  grid: '#374151',
  playerGlow: 'rgba(74, 222, 128, 0.3)',
};

const imageCache = new Map<string, HTMLImageElement>();

function loadImage(src: string): HTMLImageElement | null {
  if (imageCache.has(src)) {
    const img = imageCache.get(src)!;
    return img.complete ? img : null;
  }
  const img = new Image();
  img.src = src;
  imageCache.set(src, img);
  return null;
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

  // Player sprite (simple pixel character)
  ctx.fillStyle = TILE_COLORS.player;
  const cx = playerScreenX + tileSize / 2;
  const cy = playerScreenY + tileSize / 2;
  const s = tileSize / 6;

  // Head
  ctx.fillRect(cx - s, cy - s * 3, s * 2, s * 2);
  // Body
  ctx.fillRect(cx - s, cy - s, s * 2, s * 2);
  // Legs
  ctx.fillRect(cx - s, cy + s, s, s * 1.5);
  ctx.fillRect(cx, cy + s, s, s * 1.5);
  // Arms
  ctx.fillRect(cx - s * 2, cy - s, s, s * 2);
  ctx.fillRect(cx + s, cy - s, s, s * 2);
}

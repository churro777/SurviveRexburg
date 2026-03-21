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

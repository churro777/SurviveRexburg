import { useRef, useEffect, useCallback } from 'react';
import { useGameState } from '../hooks/useGameState';
import { createCamera } from './camera';
import { renderMap } from './renderer';

const TILE_SIZE = 80;

export function GameCanvas() {
  const canvasRef = useRef<HTMLCanvasElement>(null);
  const { state, move } = useGameState();

  const draw = useCallback(() => {
    const canvas = canvasRef.current;
    if (!canvas || !state.player || !state.map) return;

    const ctx = canvas.getContext('2d');
    if (!ctx) return;

    const camera = createCamera(
      state.player.row, state.player.col,
      state.map.rows, state.map.cols,
      canvas.width, canvas.height,
      TILE_SIZE
    );

    renderMap(ctx, state.map, state.player, camera, TILE_SIZE, canvas.width, canvas.height);
  }, [state]);

  useEffect(() => {
    const canvas = canvasRef.current;
    if (!canvas) return;

    const resize = () => {
      canvas.width = canvas.parentElement?.clientWidth ?? 640;
      canvas.height = canvas.parentElement?.clientHeight ?? 480;
      draw();
    };

    resize();
    window.addEventListener('resize', resize);

    let animId: number;
    const loop = () => {
      draw();
      animId = requestAnimationFrame(loop);
    };
    animId = requestAnimationFrame(loop);

    return () => {
      window.removeEventListener('resize', resize);
      cancelAnimationFrame(animId);
    };
  }, [draw]);

  // Keyboard input
  useEffect(() => {
    if (!state.player || !state.map) return;
    if (!state.exploring) return;

    const handleKey = (e: KeyboardEvent) => {
      if (!state.player || !state.map) return;
      const { row, col } = state.player;
      let newRow = row, newCol = col;

      switch (e.key) {
        case 'ArrowUp': case 'w': case 'W': newRow = Math.max(0, row - 1); break;
        case 'ArrowDown': case 's': case 'S': newRow = Math.min(state.map!.rows - 1, row + 1); break;
        case 'ArrowLeft': case 'a': case 'A': newCol = Math.max(0, col - 1); break;
        case 'ArrowRight': case 'd': case 'D': newCol = Math.min(state.map!.cols - 1, col + 1); break;
        default: return;
      }

      if (newRow !== row || newCol !== col) {
        e.preventDefault();
        move(newRow, newCol);
      }
    };

    window.addEventListener('keydown', handleKey);
    return () => window.removeEventListener('keydown', handleKey);
  }, [state.player, state.map, state.phase, state.exploring, move]);

  // Click input
  const handleClick = useCallback((e: React.MouseEvent<HTMLCanvasElement>) => {
    const canvas = canvasRef.current;
    if (!canvas || !state.player || !state.map || !state.exploring) return;

    const rect = canvas.getBoundingClientRect();
    const clickX = e.clientX - rect.left;
    const clickY = e.clientY - rect.top;

    const camera = createCamera(
      state.player.row, state.player.col,
      state.map.rows, state.map.cols,
      canvas.width, canvas.height,
      TILE_SIZE
    );

    const clickCol = Math.floor(clickX / TILE_SIZE) + camera.offsetX;
    const clickRow = Math.floor(clickY / TILE_SIZE) + camera.offsetY;

    // Only allow moving to adjacent tiles
    const dr = Math.abs(clickRow - state.player.row);
    const dc = Math.abs(clickCol - state.player.col);
    if ((dr + dc === 1) && clickRow >= 0 && clickRow < state.map.rows && clickCol >= 0 && clickCol < state.map.cols) {
      move(clickRow, clickCol);
    }
  }, [state, move]);

  return (
    <canvas
      ref={canvasRef}
      className="game-canvas"
      onClick={handleClick}
      style={{ display: 'block', width: '100%', height: '100%', imageRendering: 'pixelated' }}
    />
  );
}

export class AudioManager {
  private tracks: Map<string, HTMLAudioElement> = new Map();
  private currentMusic: HTMLAudioElement | null = null;
  private volume: number = 0.5;
  private muted: boolean = false;

  async preload(id: string, url: string): Promise<void> {
    return new Promise((resolve) => {
      const audio = new Audio(url);
      audio.preload = 'auto';
      audio.volume = this.volume;
      this.tracks.set(id, audio);
      audio.addEventListener('canplaythrough', () => resolve(), { once: true });
      audio.addEventListener('error', () => resolve(), { once: true });
    });
  }

  play(id: string, loop = false): void {
    const audio = this.tracks.get(id);
    if (!audio) return;
    audio.loop = loop;
    audio.volume = this.muted ? 0 : this.volume;
    audio.currentTime = 0;
    audio.play().catch(() => {});
    if (loop) this.currentMusic = audio;
  }

  stop(id?: string): void {
    if (id) {
      const audio = this.tracks.get(id);
      if (audio) {
        audio.pause();
        audio.currentTime = 0;
      }
    } else {
      this.tracks.forEach(audio => {
        audio.pause();
        audio.currentTime = 0;
      });
      this.currentMusic = null;
    }
  }

  setVolume(volume: number): void {
    this.volume = Math.max(0, Math.min(1, volume));
    this.tracks.forEach(audio => {
      audio.volume = this.muted ? 0 : this.volume;
    });
  }

  toggleMute(): boolean {
    this.muted = !this.muted;
    this.tracks.forEach(audio => {
      audio.volume = this.muted ? 0 : this.volume;
    });
    return this.muted;
  }

  isMuted(): boolean {
    return this.muted;
  }

  isPlaying(): boolean {
    return this.currentMusic !== null && !this.currentMusic.paused;
  }
}

export const audioManager = new AudioManager();

const BASE = import.meta.env.BASE_URL;

export async function preloadAllAudio(): Promise<void> {
  await Promise.all([
    // Music
    audioManager.preload('menu_theme', `${BASE}audio/music/menu_theme.wav`),
    audioManager.preload('exploration', `${BASE}audio/music/exploration.wav`),
    audioManager.preload('combat', `${BASE}audio/music/combat.wav`),
    audioManager.preload('game_over', `${BASE}audio/music/game_over.wav`),
    audioManager.preload('victory', `${BASE}audio/music/victory.ogg`),
    // SFX
    audioManager.preload('menu_select', `${BASE}audio/sfx/menu_select.wav`),
    audioManager.preload('footstep', `${BASE}audio/sfx/footstep.wav`),
    audioManager.preload('eat', `${BASE}audio/sfx/eat.wav`),
    audioManager.preload('equip', `${BASE}audio/sfx/equip.wav`),
    audioManager.preload('hit', `${BASE}audio/sfx/hit.wav`),
    audioManager.preload('damage', `${BASE}audio/sfx/damage.wav`),
    audioManager.preload('zombie_groan', `${BASE}audio/sfx/zombie_groan.wav`),
    audioManager.preload('death', `${BASE}audio/sfx/death.wav`),
    audioManager.preload('victory_jingle', `${BASE}audio/sfx/victory_jingle.wav`),
  ]);
}

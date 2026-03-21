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

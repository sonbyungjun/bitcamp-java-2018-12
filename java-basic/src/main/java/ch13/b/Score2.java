package ch13.b;

import ch13.Score;

public class Score2 extends Score {
  
  private int music;
  private int art;

  public int getMusic() {
    return this.music;
  }

  public void setMusic(int music) {
    if (music >= 0 && music <= 100) {
      this.music = music;
      this.compute2();
    }
  }
  
  public int getArt() {
    return this.art;
  }

  public void setArt(int art) {
    if (art >= 0 && art <= 100) {
      this.art = art;
      this.compute2();
    }
  }
  
  private void compute2() {
    this.compute();
    this.sum += this.music + this.art;
    this.aver = this.sum / 5f;
  }
}

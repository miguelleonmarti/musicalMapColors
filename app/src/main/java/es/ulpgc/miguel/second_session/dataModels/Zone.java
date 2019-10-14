package es.ulpgc.miguel.second_session.dataModels;

public class Zone {
  private String name;
  private int songUri, colorValue;

  public Zone(String name, int songUri, int colorValue) {
    this.name = name;
    this.songUri = songUri;
    this.colorValue = colorValue;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getSongUri() {
    return songUri;
  }

  public void setSongUri(int songUri) {
    this.songUri = songUri;
  }

  public int getColorValue() {
    return colorValue;
  }

  public void setColorValue(int colorValue) {
    this.colorValue = colorValue;
  }
}

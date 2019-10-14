package es.ulpgc.miguel.second_session.appMediator;

import android.app.Application;

import es.ulpgc.miguel.second_session.Map.MapState;

public class AppMediator extends Application {

  private MapState mapState;

  @Override
  public void onCreate() {
    super.onCreate();

    this.mapState = new MapState();
  }

  //--------------------------------------------
  //-----------GETTERS AND SETTERS--------------
  //--------------------------------------------

  public MapState getMapState() {
    return this.mapState;
  }

  public void setMapState(MapState state) {
    this.mapState = state;
  }
}

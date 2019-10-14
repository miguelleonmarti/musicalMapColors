package es.ulpgc.miguel.second_session.Map;

import android.content.Intent;
import android.content.Context;

import es.ulpgc.miguel.second_session.appMediator.AppMediator;

public class MapRouter implements MapContract.Router {

  public static String TAG = MapRouter.class.getSimpleName();

  private AppMediator mediator;

  public MapRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void navigateToNextScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, MapActivity.class);
    context.startActivity(intent);
  }

  @Override
  public void passDataToNextScreen(MapState state) {
    mediator.setMapState(state);
  }

  @Override
  public MapState getDataFromPreviousScreen() {
    MapState state = mediator.getMapState();
    return state;
  }
}

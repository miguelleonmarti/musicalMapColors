package es.ulpgc.miguel.second_session.Map;

import android.media.MediaPlayer;

import java.lang.ref.WeakReference;

import es.ulpgc.miguel.second_session.dataModels.Zone;

public class MapPresenter implements MapContract.Presenter {

  public static String TAG = MapPresenter.class.getSimpleName();

  private WeakReference<MapContract.View> view;
  private MapViewModel viewModel;
  private MapContract.Model model;
  private MapContract.Router router;

  // media player
  private MediaPlayer mediaPlayer;

  public MapPresenter(MapState state) {
    viewModel = state;
  }

  @Override
  public void injectView(WeakReference<MapContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(MapContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(MapContract.Router router) {
    this.router = router;
  }

  @Override
  public void getZone(int colorValue) {
    Zone zone = model.getZone(colorValue);

    if (zone != null) {
      viewModel.setName(zone.getName());
      viewModel.setSongUri(zone.getSongUri());

      view.get().displayData(viewModel);
    }

  }


}

package es.ulpgc.miguel.second_session.Map;

import java.lang.ref.WeakReference;

import es.ulpgc.miguel.second_session.dataModels.Zone;

interface MapContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(MapViewModel viewModel);
  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void getZone(int colorValue);
  }

  interface Model {
    Zone getZone(int colorValue);
  }

  interface Router {
    void navigateToNextScreen();

    void passDataToNextScreen(MapState state);

    MapState getDataFromPreviousScreen();
  }
}

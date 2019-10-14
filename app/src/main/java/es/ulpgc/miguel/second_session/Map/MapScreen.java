package es.ulpgc.miguel.second_session.Map;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.miguel.second_session.appMediator.AppMediator;

public class MapScreen {

  public static void configure(MapContract.View view) {

    WeakReference<FragmentActivity> context = new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    MapState state = mediator.getMapState();

    MapContract.Router router = new MapRouter(mediator);
    MapContract.Presenter presenter = new MapPresenter(state);
    MapContract.Model model = new MapModel();
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}

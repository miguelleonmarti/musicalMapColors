package es.ulpgc.miguel.second_session.Map;

import java.util.ArrayList;

import es.ulpgc.miguel.second_session.R;
import es.ulpgc.miguel.second_session.dataModels.Zone;

public class MapModel implements MapContract.Model {

  public static String TAG = MapModel.class.getSimpleName();

  private ArrayList<Zone> zoneArrayList;

  private Zone canarias, andalucia, extremadura, murcia, mancha, valencia, baleares, cataluna, aragon, navarra, vasco, rioja, cantabria, asturias, galicia, madrid, leon;

  public MapModel() {
    canarias = new Zone("Canarias", R.raw.canarias, -13659840);
    andalucia = new Zone("Andalucía",R.raw.andalucia, -8388353);
    extremadura = new Zone("Extremadura", R.raw.extremadura, -8388544);
    murcia = new Zone("Región de Murcia", R.raw.murcia, -12582784);
    mancha = new Zone("Castilla La Mancha", R.raw.mancha, -16744320);
    valencia = new Zone("Valencia", R.raw.valencia, -65408);
    baleares = new Zone("Baleares", R.raw.baleares, -12550016);
    cataluna = new Zone("Cataluña", R.raw.cataluna, -65536);
    aragon = new Zone("Aragón", R.raw.aragon, -32513);
    navarra = new Zone("Navarra", R.raw.navarra, -32576);
    vasco = new Zone("Vasco", R.raw.vasco, -8323073);
    rioja = new Zone("Rioja", R.raw.rioja, -16744193);
    cantabria = new Zone("Cantabria", R.raw.cantabria, -16711808);
    asturias = new Zone("Asturias", R.raw.asturias, -128);
    galicia = new Zone("Galicia", R.raw.galicia, -32640);
    madrid = new Zone("Madrid", R.raw.madrid, -256);
    leon = new Zone("Castilla y León", R.raw.leon, -8323200);

    zoneArrayList = new ArrayList<>();
    zoneArrayList.add(canarias);
    zoneArrayList.add(andalucia);
    zoneArrayList.add(extremadura);
    zoneArrayList.add(murcia);
    zoneArrayList.add(mancha);
    zoneArrayList.add(valencia);
    zoneArrayList.add(baleares);
    zoneArrayList.add(cataluna);
    zoneArrayList.add(aragon);
    zoneArrayList.add(navarra);
    zoneArrayList.add(vasco);
    zoneArrayList.add(rioja);
    zoneArrayList.add(cantabria);
    zoneArrayList.add(asturias);
    zoneArrayList.add(galicia);
    zoneArrayList.add(madrid);
    zoneArrayList.add(leon);
  }

  @Override
  public Zone getZone(int colorValue) {
    int length = zoneArrayList.size();
    for (int i = 0; i < length; i++) {
      if (colorValue == zoneArrayList.get(i).getColorValue()) {
        return zoneArrayList.get(i);
      }
    }
    return null;
  }
}

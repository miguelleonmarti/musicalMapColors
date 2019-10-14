package es.ulpgc.miguel.second_session.Map;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import es.ulpgc.miguel.second_session.R;

public class MapActivity
    extends AppCompatActivity implements MapContract.View {

  public static String TAG = MapActivity.class.getSimpleName();

  private MapContract.Presenter presenter;

  // declaring the buttons
  private ImageView map;

  // media player
  private MediaPlayer mediaPlayer;

  @SuppressLint("ClickableViewAccessibility")
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_map);

    // finding buttons
    map = findViewById(R.id.map);

    // listener
    map.setOnTouchListener(new View.OnTouchListener() {
      @Override
      public boolean onTouch(View view, MotionEvent event) {
        Drawable imgDrawable = ((ImageView) view).getDrawable();
        //imgDrawable will not be null if you had set src to ImageView, in case of background drawable it will be null
        Bitmap bitmap = ((BitmapDrawable) imgDrawable).getBitmap();

        Matrix inverse = new Matrix();
        ((ImageView) view).getImageMatrix().invert(inverse);
        float[] touchPoint = new float[]{event.getX(), event.getY()};
        inverse.mapPoints(touchPoint);
        int x = (int) touchPoint[0];
        int y = (int) touchPoint[1];

        int touchedRGB = bitmap.getPixel(x, y);

        //then do what you want with the pixel data, e.g
        int redValue = Color.red(touchedRGB);
        int greenValue = Color.green(touchedRGB);
        int blueValue = Color.blue(touchedRGB);
        int alphaValue = Color.alpha(touchedRGB);

        int colorValue = Color.argb(alphaValue, redValue, greenValue, blueValue);

        presenter.getZone(colorValue);

        /*Log.i("TouchedColor", "TouchedRGB: " + touchedRGB);
        Log.i("TouchedColor", "RedValue: " + redValue);
        Log.i("TouchedColor", "GreenValue: " + greenValue);
        Log.i("TouchedColor", "BlueValue: " + blueValue);
        Log.i("TouchedColor", "AlphaValue: " + alphaValue);
        Log.i("TouchedColor", "ColorValue ARGB: " + colorValue);*/

        return true;
      }
    });

    // do the setup
    MapScreen.configure(this);
  }

  @Override
  protected void onResume() {
    super.onResume();
  }

  @Override
  public void injectPresenter(MapContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void displayData(MapViewModel viewModel) {
    if (viewModel.getSongUri() != -1) {
      if (mediaPlayer == null) {
        mediaPlayer = MediaPlayer.create(getApplicationContext(), viewModel.getSongUri());
        mediaPlayer.start();
        Toast.makeText(this, viewModel.getName(), Toast.LENGTH_SHORT).show();
      } else {
        mediaPlayer.release();
        mediaPlayer = null;
        mediaPlayer = MediaPlayer.create(getApplicationContext(), viewModel.getSongUri());
        mediaPlayer.start();
        Toast.makeText(this, viewModel.getName(), Toast.LENGTH_SHORT).show();
      }
    } else {
      mediaPlayer.release();
      mediaPlayer = null;
    }
  }
}

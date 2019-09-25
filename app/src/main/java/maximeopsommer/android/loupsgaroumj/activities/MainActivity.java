package maximeopsommer.android.loupsgaroumj.activities;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Point;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.widget.Button;
import android.widget.TextView;
import maximeopsommer.android.loupsgaroumj.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainTitle();
        final Button playButton = findViewById(R.id.playButton);
        playButton.setOnClickListener(e -> switchToCreateGameView());
    }

    private void mainTitle() {
        final AssetManager assetManager = getApplicationContext().getAssets();
        final TextView textView = findViewById(R.id.mainTitle);
        final Typeface typeface = Typeface.createFromAsset(assetManager, "fonts/GypsyCurse.ttf");
        textView.setTypeface(typeface);
        final Display display = getWindowManager().getDefaultDisplay();
        final Point size = new Point();
        display.getSize(size);
        final int screenWidth = size.x;
        final int screenHeight = size.y;
        textView.setHeight((int) (screenHeight * 0.15));
    }

    private void switchToCreateGameView() {
        final Intent intent = new Intent(getApplicationContext(), GameCreationActivity.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        finish();
    }
}

package maximeopsommer.android.loupsgaroumj.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import maximeopsommer.android.loupsgaroumj.R;
import maximeopsommer.android.loupsgaroumj.utils.PlayerListAdapter;

import java.util.ArrayList;
import java.util.List;

public class GameCreationActivity extends AppCompatActivity {

    private EditText newPlayerName;
    private Button addPlayerButton;
    private ListView playersList;
    private Button cancelButton;

    private final List<String> playersName = new ArrayList<>();

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_game);
        newPlayerName = findViewById(R.id.newPlayerName);
        addPlayerButton = findViewById(R.id.addPlayerButton);
        addPlayerButton.setOnClickListener(e -> checkPlayerName());
        playersList = findViewById(R.id.playersList);

        final PlayerListAdapter playerListAdapter = new PlayerListAdapter(playersName, this);
        cancelButton = findViewById(R.id.cancelButton);
        playersList.setAdapter(playerListAdapter);
        cancelButton.setOnClickListener(e -> switchToMainView());
    }

    private void checkPlayerName() {
        final String newPlayerNameText = newPlayerName.getText().toString();
        if (!newPlayerNameText.isEmpty()) {
            if (playersName.contains(newPlayerNameText)) {
                new AlertDialog.Builder(this)
                        .setMessage("There is already a player with that name.")
                        .setTitle("ERROR")
                        .create()
                        .show();
            } else {
                addPlayer(newPlayerNameText);
                newPlayerName.setText("");
            }
        }

    }

    private void addPlayer(final String playerName) {
        playersName.add(playerName);
    }

    private void switchToMainView() {
        final Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        finish();
    }

}

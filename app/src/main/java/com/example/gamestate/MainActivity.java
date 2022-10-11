package com.example.gamestate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GameState firstInstance = new GameState();
        Log.e(" ", firstInstance.toString());

        EditText editText = findViewById(R.id.EditText);
        editText.setText(firstInstance.toString());

    }
}
package edu.up.dbgui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button testButton = findViewById(R.id.testButton);

        testButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText text = findViewById(R.id.editText);
                text.setText(" ");

                GameState firstInstance = new GameState();
                GameState firstCopy = new GameState(firstInstance);

                GameState secondInstance = new GameState();
                GameState secondCopy = new GameState(secondInstance);
                
            }
        });
    }
}
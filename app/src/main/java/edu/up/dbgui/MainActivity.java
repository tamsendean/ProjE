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
        EditText text = findViewById(R.id.editText);
        final GameState[] firstInstance = new GameState[1];

        testButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText(" ");
                firstInstance[0] = new GameState();
                //A new instance of the game state class is created using the default constructor and
                //assigned to a variable named firstInstance
                // create a deep copy of firstInstance from the perspective of player one, assign to firstCopy.
                //
            }
        });
    }
}
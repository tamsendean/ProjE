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
                String testTxt = " ";

                GameState firstInstance = new GameState();
                GameState firstCopy = new GameState(firstInstance);

                firstInstance.drawLine();
                firstInstance.mainMenu();
                firstInstance.rules();
                firstInstance.restart();
                firstInstance.quit();

                GameState secondInstance = new GameState();
                GameState secondCopy = new GameState(secondInstance);

                testTxt += firstCopy.toString();
                testTxt += secondCopy.toString();

                if (firstCopy.toString().equals(secondCopy.toString())) {
                    testTxt = "\n Copies are equal";
                } else {
                    testTxt = "\n Copies are not equal";
                }
                text.setText(testTxt);

            }
        });
    }
}
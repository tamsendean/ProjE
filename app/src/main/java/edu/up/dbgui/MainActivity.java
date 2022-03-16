/**
 * Main Activity for Dots and Boxes
 *
 * Audrey Sauter
 * Tamsen Dean
 *
 */

package edu.up.dbgui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

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
                String testTxt = "";

                DBGameState firstInstance = new DBGameState();
                DBGameState firstCopy = new DBGameState(firstInstance);

                firstInstance.drawLine();
                firstInstance.mainMenu();
                firstInstance.rules();
                firstInstance.restart();
                firstInstance.quit();

                DBGameState secondInstance = new DBGameState();
                DBGameState secondCopy = new DBGameState(secondInstance);

                testTxt += "Copy 1: " + firstCopy.toString() + "\n";
                testTxt += "Copy 2: " + secondCopy.toString() + "\n";

                if (firstCopy.toString().equals(secondCopy.toString())) {
                    testTxt += "\nCopies are equal! :)";
                } else {
                    testTxt += "\nCopies are not equal. :(";
                }
                text.setText(testTxt);

            }
        });
    }

   /** public GameConfig createDefaultConfig() {
        ArrayList<GamePlayerType> playerTypes = new ArrayList<>();
        playerTypes.add(new GamePlayerType("Local Human Player") {
            public GamePlayer createPlayer(String name) {
                return new EKHumanPlayer1(name, R.layout.activity_main);
            }
        });
        playerTypes.add(new GamePlayerType("Dumb Computer Player") {
            public GamePlayer createPlayer(String name) {
                return new EKComputerPlayer1(name);
            }
        });
        playerTypes.add(new GamePlayerType("Smart Computer Player") {
            public GamePlayer createPlayer(String name) {
                return new EKComputerPlayer2(name);
            }
        });
        GameConfig defaultConfig = new GameConfig(playerTypes, 4, 4, "Exploding Kittens", PORT_NUMBER);
        defaultConfig.addPlayer("Human", 0);
        defaultConfig.addPlayer("Computer", 1);
        defaultConfig.setRemoteData("Remote Player", "", 0);
        return defaultConfig;
    }
    */
}
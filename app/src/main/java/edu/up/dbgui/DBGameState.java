/*
    author tacopy here:
    ______
 */
package edu.up.dbgui;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class DBGameState {
    private int[] scores = new int[1];
    private int turn;
    public boolean[] playerStatus;
    public STATE gameState;
    public static final int NUM_PLAYERS = 4;
    public int playerTurn;
    STATE state;

    /** default game setup
     * $param player current players added to the game setup
     */

    public DBGameState() {
        state = STATE.INIT_ARRAYS;

    }
    /**
        constructor for your class that initializes all the variables to reflect the start
        of the game before any actions have been taken.
     */
    public DBGameState(DBGameState copy){
        //scores start from 0 for all players
        for(int i = 0; i < scores.length; i++){
            scores[i] = 0;
        }
        //player 0 always starts
        this.turn = 0;
    }

    public boolean drawLine(){
        //if valid move, return true. Else, return false
        return true;
    }
    public boolean mainMenu(){
        return true;
    }
    public boolean restart(){
        return true;
    }
    public boolean quit(){
        return true;
    }
    public boolean rules(){
        return true;
    }

    if(state == null){
        return;
    }
    else{
        this.playerTurn = state.playerTurn;
    }
        this.DBGameState = state.gameState;
        this.lastMessage = state.lastMessage;
        this.playerStatus = new boolean[state.playerStatus.length];
        for (int i = 0; i < state.playerStatus.length; i++) {
        playerStatus[i] = state.playerStatus[i];
    }



    /**
     * computes the integer number of the next player in a turn sequence (loops around through NUM PLAYERS -Written By Alex
     * @param currentPlayer - current player index whose turn it is, should only pass through playerTurn int in EKState
     * @return - returns true if a next player was found and set, false if the EKState realized the game is over
     */
    public boolean nextPlayer(int currentPlayer) {

        int outCounter = 0;
        for(int i = 0; i < playerStatus.length; i++){
            //Log.i("MSG", "Player + " + i + " " + playerStatus[i]);
            if(!playerStatus[i]){
                outCounter++;
            }
        }
        if(outCounter == 3) {
            lastMessage = "Player " + endGame(playerStatus) + " has won the game.";
            return false;
        }
        else{
            int next = (currentPlayer+1)%4;
            while(playerStatus[next] == false){
                next = (next+1)%4;
                Log.i("MSG", next + "\n");
            }
            this.playerTurn = next;
            lastMessage = "";
            Log.i("MSG"," "+ playerTurn + " " + playerStatus[playerTurn]);

            return true;

        }
    }

    /*
    describes the state of the game as a string.
    */
    @Override
    public String toString() {
        return "{scores=" + Arrays.toString(scores) +
                ", turn=" + turn +
                '}';
    }

    /**
     * PrepareGame: calls createCards(), and then shuffles the draw pile. Iterates through the 4 player hands in
     * deck, and adds the first 6 cards into a player hand iff it isnt an exploding kitten using move()
     * and finally sets the gameState to GAME_SETUP - written by alex
     * @return - true if it executed properly, false if gameState is not init_objects, probably
     *           because function was called in incorrect order
     */
    public boolean prepareGame() {
            gameState = STATE.GAME_SETUP;
        return false;
    }

    /**
     * Tests if the game is over
     * @param playerStatus - an array indicated which players are in the game (true) and which are
     *                     out (false)
     * @return - index # of winner if there is only one in (true) player in playerStatus, -1 if there are more
     * than one players still playing
     */
    public int endGame(boolean[] playerStatus){
        int out = 0;
        for(int i = 0; i < playerStatus.length; i++){
            if(playerStatus[i] == false) {
                out++;
            }
        }
        if(out == 3){
            for (int i = 0; i < playerStatus.length; i++) {
                if (playerStatus[i] == true) {
                    gameState = STATE.GAME_END;
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * getPlayerTurn
     * @return the index of the player whose turn is going
     */
    public int getPlayerTurn() { return playerTurn; }

    /**
     * gameOver - determines if the game is over
     * @return index of winning player, -1 if play is ongoing
     */
    public int gameOver() {
        return endGame(playerStatus);
    }

    /**
     * getPlayerStatus
     * @return the playerStatus boolean array
     */
    public boolean[] getPlayerStatus() { return playerStatus; }
}

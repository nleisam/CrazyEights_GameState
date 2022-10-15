package com.example.gamestate;
import java.util.ArrayList;

/**
 *  @authors Ronnie Delos Santos, Noelle Lei Sam, Emily Do, Alex Melemai
 *  @version 10/14/22
 */

public class Player {

    public ArrayList<Card> cards_in_Hand; //ArrayList of card objects for each Player object created
    public int score = 0; //int for score of player
    public boolean isTurn; //boolean for turn of player
    public int playerID; //int to track Player objects

    /**
     * Player constructor assigns playerID and initalizes cards_in_Hand
     * @param id: player id
     */
    public Player(int id)
    {
        playerID = id;
        cards_in_Hand = new ArrayList<>();
    }




}

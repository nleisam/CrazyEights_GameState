package com.example.gamestate;
import java.util.ArrayList;
/*
@authors Ronnie Delos Santos, Noelle Lei Sam, Emily Do, Alex Melemai
 */
public class Player {

    public ArrayList<Card> cards_in_Hand; //ArrayList of card objects for each Player object created
    public int score = 0; //int for score of player
    public boolean isTurn; //boolean for turn of player
    public int playerID; //int to track Player objects

    public Player(int id)//Player constructor assigns playerID and initalizes cards_in_Hand
    {
        playerID = id;
        cards_in_Hand = new ArrayList<>();
    }




}

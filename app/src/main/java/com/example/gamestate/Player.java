package com.example.gamestate;
import java.util.ArrayList;

public class Player {

    public ArrayList<Card> cards_in_Hand;
    public int score = 0;
    public boolean isTurn;
    public int playerID;

    public Player(int id)
    {
        playerID = id;
        cards_in_Hand = new ArrayList<>();
    }




}

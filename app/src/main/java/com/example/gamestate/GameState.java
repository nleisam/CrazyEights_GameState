package com.example.gamestate;

import android.util.Log;

import java.util.ArrayList;

public class GameState {

    public int numPlayerTurn;
    public ArrayList<Player> players = new ArrayList<>();
    public ArrayList<Card> discard;
    public ArrayList<Card> drawPile = new ArrayList<>();

    public GameState(){
        for (int i = 0; i < 4; i++) {
            players.add(new Player(i));
        }


        for(Card.SUIT s: Card.SUIT.values()) {
            for (Card.FACE f : Card.FACE.values()) {
                drawPile.add(new Card(f, s));
            }
        }
    }

    public void Deal() {

    }

    public void updateCardDeck()
    {

    }

    public void printPlayerList()
    {
        for (Player al: players ) {
            Log.e("",  al.playerID + "");
        }

    }

}

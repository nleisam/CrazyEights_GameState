package com.example.gamestate;

import android.util.Log;

import java.util.ArrayList;

public class GameState {

    public int numPlayerTurn;
    public ArrayList<Player> players;
    public ArrayList<Card> discard;
    public ArrayList<Card> drawPile;

    public GameState(){
        players = new ArrayList<>();
        drawPile = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            players.add(new Player(i));
        }


        for(Card.SUIT s: Card.SUIT.values()) {
            for (Card.FACE f : Card.FACE.values()) {
                drawPile.add(new Card(f, s));
            }
        }
        Deal();
    }

    public void Deal()
    {
        for (Player p : players)
        {
         for (int i = 0; i < 5; ++i)
         {
             int index = (int) Math.random() * drawPile.size();
             p.cards_in_Hand.add(drawPile.get(index));
             drawPile.remove(index); //updates the draw pile
         }
        }
    }

    @Override
    public String toString()
    {
        String string = " ";
        for (Player al: players ) {
            string += "player " + al.playerID + ": ";
            for (Card card : al.cards_in_Hand)
            {
                string += card.toString() + " ";
            }
              string += "\n";
        }
        return string;
    }

}

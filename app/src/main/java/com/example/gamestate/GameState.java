package com.example.gamestate;
import android.util.Log;

import java.util.ArrayList;
import java.util.Random;
/*
@authors Ronnie Delos Santos, Noelle Lei Sam, Emily Do, Alex Melemai
 */

public class GameState {

    public int numPlayerTurn;
    public ArrayList<Player> players;
    public ArrayList<Card> discard;
    public ArrayList<Card> drawPile;

    public GameState(){
        players = new ArrayList<>();
        drawPile = new ArrayList<>();
        discard = new ArrayList<>();

        for (int i = 0; i < 4; i++)
        {
            players.add(new Player(i));
        }

        for(Card.SUIT s: Card.SUIT.values())
        {
            for (Card.FACE f : Card.FACE.values())
            {
                drawPile.add(new Card(f, s));
            }
        }
        numPlayerTurn = new Random().nextInt(players.size());
        Log.e("", numPlayerTurn + "");
        Deal();
        testPlay();
    }

    public void Deal()
    {
        for (Player p : players)
        {
         for (int i = 0; i < 5; ++i)
         {
             int index = new Random().nextInt(drawPile.size());
             p.cards_in_Hand.add(drawPile.get(index));
             drawPile.remove(index); //updates the draw pile
         }
        }
    }

    @Override
    public String toString()
    {
        String playersHand = "";

        for (Player al: players)
        {
            playersHand += "player " + al.playerID + ": ";
            for (Card card : al.cards_in_Hand)
            {
                playersHand += card.toString() + " ";
            }
              playersHand += "\n";
        }

        String drawPileText = "Draw Pile: ";

        for (Card card : drawPile) {
            drawPileText += card.toString() + " ";
        }

        drawPileText += "\n";

        String discardPileText = "Discard Pile: ";

        for (Card card : discard) {
            discardPileText += card.toString() + " ";
        }
        discardPileText += "\n";

        String returnText = drawPileText + playersHand + discardPileText;
        return returnText;
    }

    public void placeCard(Player p, Card selectedCard) {
        p.cards_in_Hand.remove(selectedCard);
        discard.add(selectedCard);
    }

    public void difficulty() {

    }
    public void restart() {

    }


    public Card checkCardEligibility(Card card) {
        Card recentDiscardedCard;
        if (discard.size() == 0) {
            return card;
        }

        recentDiscardedCard = discard.get(discard.size()-1);
        if (card.face == recentDiscardedCard.face || card.suit == recentDiscardedCard.suit) {
            return card;
        }
       return null;
    }

    public void testPlay()
    {
        Player human = players.get(0);
        if(numPlayerTurn == 0){
            for (int i = 0; i < human.cards_in_Hand.size(); i++) {
                Card selectedCard = checkCardEligibility(human.cards_in_Hand.get(i));
                if (selectedCard == null) {
                    drawCard(human);
                    break;
                }
                placeCard(human, selectedCard);
            }
            numPlayerTurn++;
        }
        playAI();
    }

    public void robotEasy(Player p) {
        for(int i = 0; i < p.cards_in_Hand.size(); i++) {
            Card selectedCard = checkCardEligibility(p.cards_in_Hand.get(i));
            if (selectedCard == null) {
                drawCard(p);
                return;
            }
            placeCard(p, selectedCard);
        }
        setNumPlayerTurn();
    }

    public void drawCard(Player p)
    {
        int index = new Random().nextInt(drawPile.size());
        p.cards_in_Hand.add(drawPile.get(index));
        drawPile.remove(index);
    }

    public void setNumPlayerTurn()
    {
        if (numPlayerTurn == 3){
            numPlayerTurn = 0;
        } else {
            numPlayerTurn++;
        }
    }

    public void playAI()
    {
        for(int i = 0; i < 3; i++){
            if(numPlayerTurn == 0) {
                return;
            }
            robotEasy(players.get(numPlayerTurn));
        }
    }





}

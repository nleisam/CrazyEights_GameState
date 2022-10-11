package com.example.gamestate;
import android.util.Log;

import java.util.ArrayList;
import java.util.Random;
/*
@authors Ronnie Delos Santos, Noelle Lei Sam, Emily Do, Alex Melemai
 */

public class GameState implements Cloneable {

    public int numPlayerTurn;
    public ArrayList<Player> players;
    public ArrayList<Card> discard;
    public ArrayList<Card> drawPile;


    public GameState(){
        players = new ArrayList<>();
        drawPile = new ArrayList<>();
        discard = new ArrayList<>();

        setPlayers();
        setDrawPile();
        numPlayerTurn = new Random().nextInt(players.size());
    }

    public void setPlayers() {
        for (int i = 0; i < 4; i++)
        {
            players.add(new Player(i));
        }
    }

    public void setDrawPile() {
        for(Card.SUIT s: Card.SUIT.values())
        {
            for (Card.FACE f : Card.FACE.values())
            {
                drawPile.add(new Card(f, s));
            }
        }
    }

    public GameState clone() {
        try {
            return (GameState) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
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
              playersHand += "\n\n";
        }

        String drawPileText = "Draw Pile Size: " + drawPile.size() ;
        drawPileText += "\n\n";

        String discardPileText = "Discard Pile: ";

        for (Card card : discard) {
            discardPileText += card.toString() + " ";
        }
        discardPileText += "\n\n";
        String returnText = drawPileText + playersHand + discardPileText + "\nPlayer Turn: " + numPlayerTurn;

        return returnText;
    }

    public boolean placeCard(Player p, Card selectedCard) {
       if(selectedCard != null) {
           p.cards_in_Hand.remove(selectedCard);
           discard.add(selectedCard);

           return true;
       }
        return false;
    }

    public boolean difficulty() {


    return false;
    }
    public boolean restart() {

        return false;
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
        //playAI();
    }

//    public void robotEasy(Player p) {
//        for(int i = 0; i < p.cards_in_Hand.size(); i++) {
//            Card selectedCard = checkCardEligibility(p.cards_in_Hand.get(i));
//            if (selectedCard == null) {
//                drawCard(p);
//                return;
//            }
//            Log.e("===",selectedCard.face.ordinal() + "");
//            Log.e("===",selectedCard.face.name() + "");
//            placeCard(p, selectedCard);
//        }
//        setNumPlayerTurn();
//    }
//
//    public void robotHard(Player p){
//        int cardVal = 0;
//        for(int i = 0; i < p.cards_in_Hand.size(); i++) {
//            Card selectedCard = checkCardEligibility(p.cards_in_Hand.get(i));
//            cardVal = Math.max(selectedCard.face.ordinal() + 1, getCardVal(selectedCard));
//        }
//            placeCard(p, getValToCard(p, cardVal));
//            setNumPlayerTurn();
//
//            drawCard(p);
//    }
//
//    public Card getValToCard(Player p, int value){
//        for (int i = 0; i < p.cards_in_Hand.size(); i++) {
//            if (p.cards_in_Hand.get(i).face.ordinal() == value) {
//                switch (value){
//                    case 1:
//
//                }
//                return p.cards_in_Hand.get(i);
//            }
//        }
//        return null;
//    }
//
//    public int getCardVal(Card c) {
//        switch(c.face){
//            case ACE:
//                return 1;
//            case KING: case QUEEN: case JACK: case TEN:
//                return 10;
//            case NINE:
//                return 9;
//            case EIGHT:
//                return 50;
//            case SEVEN:
//                return 7;
//            case SIX:
//                return 6;
//            case FIVE:
//                return 5;
//            case FOUR:
//                return 4;
//            case THREE:
//                return 3;
//            case TWO:
//                return 2;
//        }
//        return 0;
//    }



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

//    public void playAI()
//    {
//        for(int i = 0; i < 3; i++){
//            if(numPlayerTurn == 0) {
//                return;
//            }
//            robotEasy(players.get(numPlayerTurn));
//        }
//    }





}

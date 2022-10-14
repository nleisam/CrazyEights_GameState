package com.example.gamestate;
/*
@authors Ronnie Delos Santos, Noelle Lei Sam, Emily Do, Alex Melemai
 */

public class Card {


    public Card(FACE f, SUIT s) //Card constructor assigns face value and suit
    {
        face = f;
        suit = s;
    }

    public enum FACE //enum for ace through king constants
    {
       ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, KING, QUEEN, JACK
    }

    public enum SUIT //enum for suit constants
    {
        HEART, SPADE, DIAMOND, CLUB
    }

    public FACE face; // face and suit values initalized
    public SUIT suit;

    public String toString() //toString for data of card
    {
        return suit.name() + "-" + face.name();
    }


}

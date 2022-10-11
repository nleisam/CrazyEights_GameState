package com.example.gamestate;
/*
@authors Ronnie Delos Santos, Noelle Lei Sam, Emily Do, Alex Melemai
 */

public class Card {


    public Card(FACE f, SUIT s)
    {
        face = f;
        suit = s;
    }

    public enum FACE
    {
       ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, KING, QUEEN, JACK
    }

    public enum SUIT
    {
        HEART, SPADE, DIAMOND, CLUB
    }

    public FACE face;
    public SUIT suit;

    public String toString()
    {
        return suit.name() + "-" + face.name();
    }


}

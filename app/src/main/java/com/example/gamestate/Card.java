package com.example.gamestate;

public class Card {


    public Card(FACE f, SUIT s)
    {
        face = f;
        suit = s;
    }

    public enum FACE
    {
       ACE, KING, QUEEN, JACK, TEN, NINE, EIGHT, SEVEN, SIX, FIVE, FOUR, THREE, TWO
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

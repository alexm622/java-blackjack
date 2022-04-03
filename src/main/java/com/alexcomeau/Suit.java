package com.alexcomeau;

public enum Suit {
    //suit name to value enum
    CLUBS(0),
    DIAMONDS(1),
    HEARTS(2),
    SPADES(3);

    private int value;

    Suit(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }

    public String toString(){
        switch(value){
            case 0:
                return "Clubs";
            case 1:
                return "Diamonds";
            case 2:
                return "Hearts";
            case 3:
                return "Spades";
            default:
                return "";
        }
    }
}

package com.alexcomeau;

public class HouseAI {
    private Hand h;
    private Deck d;
    public HouseAI(Hand h, Deck d){
        this.h = h;
        this.d = d;
    }

    public void play(){
        showHand();
        while(!h.isSoftSeventeen()){
            System.out.println("The House hits.");
            Card newCard = d.deal();
            //announce the new card
            System.out.println("The House draws a " + newCard.getValue().name().toLowerCase() + " of " + newCard.getSuit().name().toLowerCase());
            h.addCard(newCard);
            showHand();
        }
    }

    public Hand getHand(){
        return h;
    }

    public Deck getDeck(){
        return d;
    }

    private void showHand(){
        System.out.print("The House's ");
        h.displayHand();
        System.out.println("The house has: " + h.calculateTotalWithAces());
    }
}

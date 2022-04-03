package com.alexcomeau;

import java.util.Stack;

public class Hand {
    private Stack<Card> cards;
    private int total;
    private int aces;

    public Hand() {
        cards = new Stack<Card>();
        total = 0;
        aces = 0;
    }

    public void addCard(Card c) {
        cards.push(c);
        total += c.getValue().getValue();
        if (c.getValue() == Value.ACE) {
            aces++;
        }
    }

    public void clear(){
        cards.clear();
        total = 0;
        aces = 0;
    }

    public boolean isBust() {
        return calculateTotalWithAces() > 21;
    }

    public boolean isBlackjack() {
        return total == 21 && cards.size() == 2;
    }

    public int calculateTotalWithAces() {
        int total = this.total;
        for (int i = 0; i < aces; i++) {
            if (total < 11) {
                total += 10;
            }
        }
        return total;
    }

    public boolean isSoftSeventeen() {
        return calculateTotalWithAces() >= 17;
    }

    public int getTotal() {
        return total;
    }

    public Stack<Card> getCards() {
        return cards;
    }

    public void displayHand() {
        System.out.println("Hand: ");
        for (Card c : cards) {
            System.out.println(c.toString());
        }   
        
    }
    
}

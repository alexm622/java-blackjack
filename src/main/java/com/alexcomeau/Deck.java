package com.alexcomeau;

import java.util.Stack;

public class Deck {
    Stack<Card> cards;
    public Deck(){
        cards = new Stack<Card>();
    }

    public void generate(){
        for(Suit s : Suit.values()){
            for(Value v: Value.values()){
                cards.push(new Card(s, v));
            }
        }
    }

    public Card deal(){
        if(cardsLeft() == 0){
            generate();
            shuffle();
        }
        return cards.pop();
        
    }

    public int cardsLeft(){
        return cards.size();
    }

    public void shuffle(){
        for(int i = 0; i < cards.size(); i++){
            int rand = (int)(Math.random() * cards.size());
            Card temp = cards.get(i);
            cards.set(i, cards.get(rand));
            cards.set(rand, temp);
        }
    }

}

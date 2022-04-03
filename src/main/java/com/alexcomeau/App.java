package com.alexcomeau;

/**
 * Hello world!
 *
 */
public class App 
{
    private Deck d = new Deck();
    private Hand player, house;
    public static void main( String[] args )
    {
        new App();
    }

    public App(){
        player = new Hand();
        house = new Hand();
        System.out.println("Welcome to Blackjack!");
        System.out.println("created by Alex Comeau");
        System.out.println("Press enter to deal a card.");
        do{
            player.clear();
            house.clear();
            //the card that the house shows
            Card houseCard = d.deal();

            //deal the house's hand
            house.addCard(houseCard);
            house.addCard(d.deal());

            //house wins on tie anyways so blackjack automatically wins
            if(house.isBlackjack()){
                System.out.println("House has blackjack!");
                continue;
            }

            //deal the player's hand
            player.addCard(d.deal());
            player.addCard(d.deal());

            //show player's hand
            System.out.print("Your ");
            player.displayHand();


            //player has blackjack so player wins
            if(player.isBlackjack()){
                System.out.println("Player has blackjack!");
                continue;
            }

            //show one card of the house's hand
            System.out.println("The House shows a " + house.getCards().peek().getValue().name().toLowerCase() + " of " + house.getCards().peek().getSuit().name().toLowerCase());

            //player's score
            System.out.println("Player has " + player.calculateTotalWithAces() + ".");

            //keep going until player busts, wins, or stands
            boolean stay = false;
            while(!player.isBust() && !stay){
                stay = hitOrStay();
                System.out.println("Player has " + player.calculateTotalWithAces() + ".");
                System.out.print("Your ");
                player.displayHand();
            }

            //bust is automatically a loss
            if(player.isBust()){
                System.out.println("Player busts!");
                System.out.println("House wins!");
                continue;
            }

            System.out.println("Player stays.");

            //House's turn
            HouseAI hai = new HouseAI(house, d);
            hai.play();
            house = hai.getHand();
            d = hai.getDeck();
            if(house.isBust()){
                System.out.println("House busts!");
                System.out.println("Player wins!");
                continue;
            }

            if(player.calculateTotalWithAces() > house.calculateTotalWithAces()){
                System.out.println("Player wins!");
            } else if(player.calculateTotalWithAces() < house.calculateTotalWithAces()){
                System.out.println("House wins!");
            } else {
                System.out.println("The house always wins ties!");
            }

        }while(keepPlaying());
    }

    private boolean hitOrStay(){
        System.out.print("(H)it or (s)tay:");
        char decision;
        if(player.getTotal() > 17){
            System.out.print("[s] ");
            decision = 's';
        }
        else{
            System.out.print("[h] ");
            decision = 'h';
        }
        String next = System.console().readLine();
        if(next.length() > 0){
            decision = next.charAt(0);
        }
        //do something with decision
        if(decision == 'h'){
            System.out.println("Player hits.");
            Card newCard = d.deal();
            //announce the new card
            System.out.println("You draw a " + newCard.getValue().name().toLowerCase() + " of " + newCard.getSuit().name().toLowerCase());

            player.addCard(newCard);
            return false;
        }
        else{
            System.out.println("Player stays.");
            return true;
        }
    }

    private boolean keepPlaying(){
        System.out.print("Keep playing? (y/n):[y]");
        char decision;
        String next = System.console().readLine();
        if(next.length() > 0){
            decision = next.charAt(0);
        }
        else{
            decision = 'y';
        }
        //do something with decision
        if(decision == 'y'){
            return true;
        }
        else{
            return false;
        }
    }


}

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {

    private ArrayList<Card> deck;
    private Random random;

    public Deck() {
        this.random = new Random();
        this.deck = new ArrayList<Card>();
        makeDeck();
    }


    public void makeDeck() {
        for (Rank rank : Rank.values()) {
            for (Suit suit : Suit.values()) {
                int minValue = Rule.getMinCardValue(rank, suit);
                int maxValue = Rule.getMaxCardValue(rank, suit);
                Card card = new Card(rank, suit, minValue, maxValue);
                deck.add(card);
            }
        }
    }

    public int getCount() {
        return deck.size();
    }

    public Card getCard() {
        return deck.get(0);
    }

    public void removeCard() {
        deck.remove(0);
    }

    public void shuffleDeck() {
        Collections.shuffle(deck, random);
    }

    public String toString() {
        String output = "";
        for (Card card : deck) {
            output += card.toString();
        }

        return output;
    }

}
import java.util.ArrayList;


public abstract class GameActor {

    private String name;
    private ArrayList<Card> hand;

    public GameActor(String name) {
        this.name = name;
        hand = new ArrayList<Card>();
    }

    public String getName() {
        return this.name;
    }

    public void receiveCard(Rank rank, Suit suit, int min, int max) {
        hand.add(new Card(rank, suit, min, max));
    }


    @Override
    public String toString() {
        String output = "";
        for (Card card : hand) {
            output += card.toString();
        }

        return output;
    }

    public int showScore() {
        int sum = 0;
        for (Card card : hand) {

            if (sum < 11 &&  card.getRank() == Rank.ACE) {
                sum += card.getMaxValue();
            }
            else {
                sum += card.getMinValue();
            }
        }

        return sum;
    }


}
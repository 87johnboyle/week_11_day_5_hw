public class Card {

    private final Rank rank;
    private final Suit suit;
    private final int min;
    private final int max;

    public Card(Rank rank, Suit suit, int min, int max) {
        this.rank = rank;
        this.suit = suit;
        this.min = min;
        this.max = max;
    }

    public Rank getRank() {
        return this.rank;
    }

    public Suit getSuit() {
        return this.suit;
    }

    public int getMinValue() {
        return this.min;
    }

    public int getMaxValue() {
        return this.max;
    }

    @Override
    public String toString() {
        return this.rank.toString() + " of " + this.suit.toString() + " (min = " + this.min + ", max = " + this.max + ");" + "\n";
    }
}
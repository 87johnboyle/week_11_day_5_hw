
public class Dealer extends GameActor{

    private String name;
    private Deck deck;

    public Dealer(String name) {
        super(name);
    }

    public void setDeck(Deck deck)
    {
        this.deck = deck;
        deck.shuffleDeck();
    }

    public void dealCard(GameActor gameActor) {
        Card dealtCard = deck.getCard();
        gameActor.receiveCard(dealtCard.getRank(), dealtCard.getSuit(), dealtCard.getMinValue(), dealtCard.getMaxValue());
        deck.removeCard();
    }

    public GameActor compareScores(GameActor otherPlayer) {
        int dealerScore = showScore();
        int otherPlayerScore = otherPlayer.showScore();

        if((dealerScore <= 21 && otherPlayerScore <= 21) && (dealerScore == otherPlayerScore) || (dealerScore > 21 && otherPlayerScore > 21))
        {
            return null;
        }
        else if(dealerScore > 21)
        {
            return otherPlayer;
        }
        else if(otherPlayerScore > 21)
        {
            return this;
        }
        else
        {
            if(otherPlayerScore > dealerScore)
            {
                return otherPlayer;
            }
            else
            {
                return this;
            }
        }
    }

}
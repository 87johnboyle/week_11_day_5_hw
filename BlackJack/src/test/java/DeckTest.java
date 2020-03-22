import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DeckTest {

    Deck deck;



    @Before
    public void before(){
        deck = new Deck();
    }

    @Test
    public void deckStartsEmpty(){
        assertEquals(0, deck.getCount());
    }


    @Test
    public void deckHas52Cards(){
        deck.makeDeck();
        assertEquals(52, deck.getCount());
    }

    @Test
    public void randomCardDealt(){
        deck.makeDeck();
        deck.shuffleDeck();
        System.out.println(deck.getCard().toString());
    }



}
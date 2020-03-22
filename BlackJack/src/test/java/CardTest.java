import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CardTest {


    Card card1;
    Card card2;


    @Before
    public void before(){
        card1 = new Card(Rank.TWO, Suit.HEARTS, 2 , 2);
        card2 = new Card(Rank.KING, Suit.DIAMONDS, 10, 10);
    }


    @Test
    public void canGetSuit(){
        assertEquals(Suit.HEARTS, card1.getSuit());
    }


    @Test
    public void canGetValue(){
        assertEquals(10, card2.getMinValue());
    }



}
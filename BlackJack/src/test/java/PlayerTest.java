import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    Player player;

    @Before
    public void before() {
        player = new Player("John");
    }

    @Test
    public void hasName() {
        assertEquals("John", player.getName());
    }

}
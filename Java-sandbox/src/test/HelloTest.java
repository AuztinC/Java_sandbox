package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class HelloTest {
    private Game game;

    @Before
    public void setUp() throws Exception {
        game = new Game();
    }

    public void rollMany(int n, int pins) {
        for (int i = 0; i < n; i++)
            game.roll(pins);
    }

    @Test
    public void gutterGame() throws Exception {
        rollMany(20, 0);
        Assert.assertEquals(0, game.score());
    }

    @Test
    public void allOnes() throws Exception {
        rollMany(20, 1);
        Assert.assertEquals(20, game.score());
    }

    @Test
    public void oneSpare() throws Exception {
        rollMany(2, 5);
        game.roll(3);
        rollMany(17, 0);
        Assert.assertEquals(16, game.score());
    }

    @Test
    public void oneStrike() throws Exception {
        game.roll(10);
        game.roll(3);
        game.roll(4);
        rollMany(16, 0);
        Assert.assertEquals(24, game.score());
    }

    @Test
    public void perfectGame() throws Exception {
        rollMany(12, 10);
        Assert.assertEquals(300, game.score());
    }
}

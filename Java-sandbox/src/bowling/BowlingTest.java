package bowling;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class BowlingTest {
    private Game game;

    @Before
    public void setUp(){
        game = new Game();
    }
    private void rollMany(int times, int pins) {
        for (int i = 0; i < times; i++) {
            game.roll(pins);
        }
    }
    @Test
    public void canRollABall() throws Exception {
        game.roll(0);
    }

    @Test
    public void gutterGameScoresZero() throws Exception {
        rollMany(20,0);
        Assert.assertEquals(0, game.score());
    }

    @Test
    public void allOnesScoresTwenty() throws Exception {
        rollMany(20,1);
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
    public void oneStrikeAddsNextTwoBalls() throws Exception {
        game.roll(10);
        rollMany(2, 3);
        rollMany(16, 0);
        Assert.assertEquals(22, game.score());
    }

    @Test
    public void perfectGameScoresThreeHundred() throws Exception {
        rollMany(12, 10);
        Assert.assertEquals(300, game.score());
    }

}

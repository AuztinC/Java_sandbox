package bowl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class GameTest {
    private Game game;
    @Before
    public void setUp(){
        game = new Game();
    }

    @Test
    public void canRollABall() throws Exception {
        game.roll(0);
    }

//    @Test
//    public void gutterGameScoresZero() throws Exception {
//        int score = Game.score(new int[] {0, 0, 0, 0 /* ... */});
//        Assert.assertEquals(0, score);
//    }

    @Test
    public void gutterGameScoresZero() throws Exception {
        rollMany(20, 0);
        Assert.assertEquals(0, game.score());
        System.out.println(game);
    }

    @Test
    public void allOnesScoresTwenty() throws Exception {
        rollMany(20, 1);
        Assert.assertEquals(20, game.score());
    }

    private void rollMany(int times, int pins) {
        for (int i = 0; i < times; i++) {
            game.roll(pins);
        }
    }

    @Test
    public void oneSpareAddsNextBall() throws Exception {
        rollMany(2, 5);
        game.roll(3);
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

package StaticTest;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class GameTest {

    @Test
    public void gutterGame() throws Exception {
        int[] balls = new int[21];
        Arrays.fill(balls, 0);
        int score = Game.score(balls);
        Assert.assertEquals(0, score);
    }

    @Test
    public void allOnes() throws Exception {
        int[] balls = new int[20];
        Arrays.fill(balls, 1);
        int score = Game.score(balls);
        Assert.assertEquals(20, score);
    }
}

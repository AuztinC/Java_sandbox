package ttt;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class BoardTest {
    private Board board;
    @Before
    public void setUp() {
        board = new Board();
    }
    @Test
    public void returnEmptyBoard() throws Exception {
        Assert.assertArrayEquals(new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}, board.getBoard());
    }

    @Test
    public void updateBoardState() throws Exception {
        board.setBoard(new int[][] {{1, 0, 0}, {0, 0, 0}, {0, 0, 0}});
        Assert.assertArrayEquals(new int[][] {{1, 0, 0}, {0, 0, 0}, {0, 0, 0}}, board.getBoard());
    }

//    @Test
//    public void displayBoard() throws Exception {
//        Assert.assertEquals("""
//                |   |   |   |
//                ---------
//                |   |   |   |
//                ---------
//                |   |   |   |""", board.displayBoard(board.getBoard()));
//    }
}

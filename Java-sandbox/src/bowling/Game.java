package bowling;

public class Game {
    private int[] rolls = new int[21];
    private int currentRoll = 0;

    public void roll(int pins) {
        rolls[currentRoll++] = pins;
    }

    public int score() {
        int score = 0;
        int ballIdx = 0;
        for (int frame = 0; frame < 10; frame++) {
            if (isStrike(ballIdx)) {
                score += scoreStrike(ballIdx);
                ballIdx++;
            } else if (isSpare(ballIdx)) {
                score += scoreSpare(ballIdx);
                ballIdx += 2;
            } else {
                score += rolls[ballIdx] + rolls[ballIdx + 1];
                ballIdx += 2;
            }
        }
        return score;
    }

    private int scoreStrike(int ballIdx) {
        return 10 + rolls[ballIdx + 1] + rolls[ballIdx + 2];
    }

    private boolean isStrike(int ballIdx) {
        return rolls[ballIdx] == 10;
    }

    private int scoreSpare(int ballIdx) {
        return 10 + rolls[ballIdx + 2];
    }

    private boolean isSpare(int ballIdx) {
        return rolls[ballIdx] + rolls[ballIdx + 1] == 10;
    }
}

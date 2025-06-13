package StaticTest;

public class Game {
    public static void roll(int pins){

    }
    public static int score(int[] pins){
        int score = 0;
        for (int i = 0; i < pins.length; i++) {
            score += pins[i];
        }
        return score;
    }
}

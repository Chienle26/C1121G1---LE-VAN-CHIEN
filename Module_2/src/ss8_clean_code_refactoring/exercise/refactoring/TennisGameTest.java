package ss8_clean_code_refactoring.exercise.refactoring;

public class TennisGameTest {
    public static void main(String[] args) {
        TennisGame tennisGame = new TennisGame();
        String score = tennisGame.getScore("Chien", "Tuan", 30, 40);
        System.out.println(score);
    }
}

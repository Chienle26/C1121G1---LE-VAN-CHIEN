package ss8_clean_code_refactoring.exercise.refactoring;

public class TennisGameTest {
    public static void main(String[] args) {
        TennisGame tennisGame = new TennisGame();
        String score = tennisGame.getFinalResult("Chien", "Tuan", 3, 3);
        System.out.println(score);
        String score1 = tennisGame.getFinalResult("Chien", "Tuan", 3, 4);
        System.out.println(score1);
        String score2 = tennisGame.getFinalResult("Chien", "Tuan", 4, 4);
        System.out.println(score2);
        String score3 = tennisGame.getFinalResult("Chien", "Tuan", 2, 3);
        System.out.println(score3);
        String score4 = tennisGame.getFinalResult("Chien", "Tuan", 5, 7);
        System.out.println(score4);
        String score5 = tennisGame.getFinalResult("Chien", "Tuan", 10, 7);
        System.out.println(score5);
    }
}

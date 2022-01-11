package ss8_clean_code_refactoring.exercise.refactoring;

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;

public class TennisGame {
    String finalScore = "";
    int tempScore = 0;
    final int TOTALSCOREISZERO = 0;
    final int TOTALSCOREISONE = 1;
    final int TOTALSCOREISTWO = 2;
    final int TOTALSCOREISTHREE = 3;

    public String getFinalResult(String nameOfPlayer1, String nameOfPlayer2, int scoreOfPlayer1, int scoreOfPlayer2) {
        if (scoreOfPlayer1 == scoreOfPlayer2) {
            finalScore = getResultWhenEqualScore(scoreOfPlayer1);
        } else if (scoreOfPlayer1 >= 4 || scoreOfPlayer2 >= 4) {
            finalScore = getResultWhenScoreOfAllPlayerOver4(nameOfPlayer1, nameOfPlayer2, scoreOfPlayer1, scoreOfPlayer2);
        } else {
            for (int i = 1; i < 3; i++) {
                if (i == 1) tempScore = scoreOfPlayer1;
                else {
                    finalScore += "-";
                    tempScore = scoreOfPlayer2;
                }
                switch (tempScore) {
                    case TOTALSCOREISZERO:
                        finalScore += "Love";
                        break;
                    case TOTALSCOREISONE:
                        finalScore += "Fifteen";
                        break;
                    case TOTALSCOREISTWO:
                        finalScore += "Thirty";
                        break;
                    case TOTALSCOREISTHREE:
                        finalScore += "Forty";
                        break;
                }
            }
        }
        return finalScore;
    }

    public String getResultWhenEqualScore(int scoreOfPlayer1) {
        switch (scoreOfPlayer1) {
            case TOTALSCOREISZERO:
                finalScore = "Love-All";
                break;
            case TOTALSCOREISONE:
                finalScore = "Fifteen-All";
                break;
            case TOTALSCOREISTWO:
                finalScore = "Thirty-All";
                break;
            case TOTALSCOREISTHREE:
                finalScore = "Forty-All";
                break;
            default:
                finalScore = "Deuce";
                break;
        }
        return finalScore;
    }

    public String getResultWhenScoreOfAllPlayerOver4(String nameOfPlayer1, String nameOfPlayer2, int scoreOfPlayer1, int scoreOfPlayer2) {
        int minusResult = scoreOfPlayer1 - scoreOfPlayer2;
        if (minusResult == 1) finalScore = "Advantage " + nameOfPlayer1;
        else if (minusResult == -1) finalScore = "Advantage " + nameOfPlayer2;
        else if (minusResult >= 2) finalScore = "Win for " + nameOfPlayer1;
        else finalScore = "Win for " + nameOfPlayer2;
        return finalScore;
    }
}

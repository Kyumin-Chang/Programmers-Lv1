import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class PersonalityType {
    /*
    RT, CF, MJ, NA
    ["AN", "CF", "MJ", "RT", "NA"]	[5, 3, 2, 7, 5]	"TCMA"
    ["TR", "RT", "TR"]	[7, 1, 3]	"RCJA"
     */

    public String solution(String[] survey, int[] choices) {
        return getResult(survey, choices);
    }

    public String getResult(String[] survey, int[] choices) {
        Map<Character, Integer> personality = new HashMap<>();
        personality.put('R', 0);
        personality.put('T', 0);
        personality.put('C', 0);
        personality.put('F', 0);
        personality.put('M', 0);
        personality.put('J', 0);
        personality.put('N', 0);
        personality.put('A', 0);

        for (int i = 0; i < survey.length; i++) {
            int tmp;
            if (choices[i] < 4) {
                tmp = personality.get(survey[i].charAt(0)) + Score.findAddScore(choices[i]);
                personality.put(survey[i].charAt(0), tmp);
            }
            if (choices[i] > 4) {
                tmp = personality.get(survey[i].charAt(1)) + Score.findAddScore(choices[i]);
                personality.put(survey[i].charAt(1), tmp);
            }
        }

        List<Character> answerList = new ArrayList<>();

        getAnswerList(answerList, 'R', 'T', personality.get('R'), personality.get('T'));
        getAnswerList(answerList, 'C', 'F', personality.get('C'), personality.get('F'));
        getAnswerList(answerList, 'J', 'M', personality.get('J'), personality.get('M'));
        getAnswerList(answerList, 'A', 'N', personality.get('A'), personality.get('N'));

        StringBuilder answer = new StringBuilder();
        for (Character s : answerList) {
            answer.append(s);
        }
        return answer.toString();
    }

    public void getAnswerList(List<Character> answerList, char A, char B, int a, int b) {
        if (Objects.equals(a, b)) {
            answerList.add(A);
        }
        if (a > b) {
            answerList.add(A);
        }
        if (a < b) {
            answerList.add(B);
        }
    }

    public enum Score {
        BigReject(1, 3),
        Reject(2, 2),
        SmallReject(3, 1),
        DontKnow(4, 0),
        SmallAccept(5, 1),
        Accept(6, 2),
        BigAccept(7, 3);
        private final int score;
        private final int addScore;

        Score(int score, int addScore) {
            this.score = score;
            this.addScore = addScore;
        }

        public int getScore() {
            return score;
        }

        public int getAddScore() {
            return addScore;
        }

        public static int findAddScore(int score) {
            return match(score).getAddScore();
        }

        public static Score match(int score) {
            for (Score s : values()) {
                if (s.getScore() == score) {
                    return s;
                }
            }
            throw new IllegalArgumentException("잘못된 값입니다.");
        }
    }
}

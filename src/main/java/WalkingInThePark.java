import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;

public class WalkingInThePark {
    static int r, c;
    static char[][] map;
    static Map<String, int[]> pos;
    static Queue<String> nextPos;
    static int[] startPos;
    static int[] answer;

    public int[] solution(String[] park, String[] routes) {
        makePark(park, routes);
        getAnswer();
        return answer;
    }

    private void getAnswer() {
        int[] now = startPos.clone();
        answer = now.clone();

        while (!nextPos.isEmpty()) {
            now = answer.clone();
            String[] nextPosStr = Objects.requireNonNull(nextPos.poll()).split(" ");

            String nextDir = nextPosStr[0];
            int count = Integer.parseInt(nextPosStr[1]);

            boolean failure = false;
            for (int i = 0; i < count; i++) {
                int[] nPos = pos.get(nextDir);
                now[0] += nPos[0];
                now[1] += nPos[1];

                if (!(now[0] >= 0 && now[0] < r && now[1] >= 0 && now[1] < c) || map[now[0]][now[1]] == 'X') {
                    failure = true;
                    break;
                }
            }

            if (!failure) {
                answer = now.clone();
            }

        }
    }

    private void makePark(final String[] park, final String[] routes) {
        answer = new int[2];
        startPos = new int[2];
        pos = new LinkedHashMap<>();
        nextPos = new LinkedList<>();

        r = park.length;
        c = park[0].length();

        map = new char[r][c];
        for (int i = 0; i < r; i++) {
            String s = park[i];
            for (int j = 0; j < c; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == 'S') {
                    startPos[0] = i;
                    startPos[1] = j;
                }
            }
        }

        pos.put("E", new int[]{0, 1});
        pos.put("W", new int[]{0, -1});
        pos.put("N", new int[]{-1, 0});
        pos.put("S", new int[]{1, 0});

        nextPos.addAll(Arrays.asList(routes));
    }
}

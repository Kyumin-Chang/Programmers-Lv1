import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RearrangeDesktop {
    public int[] solution(String[] wallpaper) {
        return getResults(wallpaper);
    }

    public int[] getResults(String[] wallpaper) {
        String[][] desktop = makeDesktop(wallpaper);
        List<Integer> result = new ArrayList<>();
        List<Integer> rResult = new ArrayList<>();
        List<Integer> cResult = new ArrayList<>();
        for (int i = 0; i < desktop.length; i++) {
            for (int j = 0; j < desktop[i].length; j++) {
                if (desktop[i][j].equals("#")) {
                    rResult.add(i);
                    cResult.add(j);
                }
            }
        }
        result.add(Collections.min(rResult));
        result.add(Collections.min(cResult));
        result.add(Collections.max(rResult) + 1);
        result.add(Collections.max(cResult) + 1);

        return result.stream().mapToInt(i -> i).toArray();
    }

    public String[][] makeDesktop(String[] wallpaper) {
        String[][] desktop = new String[wallpaper.length][wallpaper[0].length()];
        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[i].length(); j++) {
                desktop[i][j] = String.valueOf(wallpaper[i].charAt(j));
            }
        }
        return desktop;
    }
}

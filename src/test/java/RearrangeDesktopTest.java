import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RearrangeDesktopTest {

    RearrangeDesktop rearrangeDesktop = new RearrangeDesktop();

    @DisplayName("바탕화면 만들기 테스트")
    @Test
    void makeDesktopTest() {
        String[] wallpaper = {".#...", "..#..", "...#."};
        String[][] deskTop = rearrangeDesktop.makeDesktop(wallpaper);
        System.out.println(Arrays.deepToString(deskTop));
        assertThat(deskTop).isNotNull();
    }

    @DisplayName("바탕화면 정리 테스트")
    @Test
    void rearrangeDesktopTest() {
        String[] wallpaper = {".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...",
                "....#...."};
        int[] answer = rearrangeDesktop.solution(wallpaper);
        int[] result = {0, 0, 7, 9};
        System.out.println(Arrays.toString(answer));
        assertThat(answer).isEqualTo(result);
    }
}

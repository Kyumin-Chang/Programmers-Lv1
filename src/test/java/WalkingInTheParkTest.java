import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WalkingInTheParkTest {
    @DisplayName("공원 산책 문제에 대한 테스트")
    @Test
    void parkTest() {
        WalkingInThePark walkingInThePark = new WalkingInThePark();
        String[] park = {"SOO", "OOO", "OOO"};
        String[] routs = {"E 2", "S 2", "W 1"};
        int[] answer = walkingInThePark.solution(park, routs);
        System.out.println(Arrays.toString(answer));
        int[] expectedResults = {2, 1};
        assertThat(answer).isEqualTo(expectedResults);
    }
}

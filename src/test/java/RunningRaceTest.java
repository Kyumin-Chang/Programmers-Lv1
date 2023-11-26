import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RunningRaceTest {

    @DisplayName("달리기경주게임")
    @Test
    void runningRaceTest() {
        RunningRace runningRace = new RunningRace();
        String[] answer = {"mumu", "kai", "mine", "soe", "poe"};
        String[] result = runningRace.solution(runningRace.getPlayers(), runningRace.getCallings());
        System.out.println(Arrays.toString(result));
        assertThat(result).isEqualTo(answer);
    }
}

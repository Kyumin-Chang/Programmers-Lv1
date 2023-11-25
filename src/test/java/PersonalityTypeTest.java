import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PersonalityTypeTest {
    /*
    RT, CF, MJ, NA
    ["AN", "CF", "MJ", "RT", "NA"]	[5, 3, 2, 7, 5]	"TCMA"
    ["TR", "RT", "TR"]	[7, 1, 3]	"RCJA"
     */
    @DisplayName("성격 유형 검사하기 테스트")
    @Test
    void personalityTypeTest() {
        PersonalityType personalityType = new PersonalityType();
        String[] survey = {"RT", "RT", "RT"};
        int[] choices = {7, 5, 2};
        String answer = "TCJA";
        String result = personalityType.solution(survey, choices);
        System.out.println(result);
        assertThat(result).isEqualTo(answer);
    }
}

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CollectPersonalInformationTest {
    CollectPersonalInformation collectPersonalInformation = new CollectPersonalInformation();

    @DisplayName("날짜 분리 테스트")
    @Test
    void separateDateTest() {
        String[] answer = {"2023", "12", "13"};
        String[] result = collectPersonalInformation.getDateArray("2023.12.13");
        System.out.println(Arrays.toString(result));
        assertThat(result).isEqualTo(answer);
    }

    
}

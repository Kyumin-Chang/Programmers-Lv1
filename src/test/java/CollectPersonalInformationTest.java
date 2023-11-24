import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Map;
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

    @DisplayName("날짜 비교 테스트")
    @Test
    void compareDateTest() {
        String[] date_1 = {"2023", "10", "13"};
        String[] date_2 = {"2023", "12", "13"};
        String[] date_3 = {"2024", "10", "13"};
        String[] result = new String[3];
        result = collectPersonalInformation.findBigDate(date_1, date_2);
        System.out.println(Arrays.toString(result));
        assertThat(result).isEqualTo(date_2);
    }

    @DisplayName("hash 테스트")
    @Test
    void hashTest() {
        String[] str = {"A 6", "B 12", "C 3"};
        Map<String, Integer> hasMap = collectPersonalInformation.makeMap(str);
        System.out.println(hasMap);
        assertThat(hasMap.get("A")).isEqualTo(6);
    }

    @DisplayName("날짜 더하기 테스트")
    @Test
    void addDateTest() {
        String date = "2022.12.13";
        int month = 36;
        String[] result = collectPersonalInformation.addDate(date, month);
        System.out.println(Arrays.toString(result));
        assertThat(result).isNotNull();
    }

    @DisplayName("개인정보 수집 유효기간 테스트")
    @Test
    void mainTest() {
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
        int[] answer = collectPersonalInformation.solution(today, terms, privacies);
        System.out.println(Arrays.toString(answer));
        int[] result = {1, 3};
        assertThat(answer).isEqualTo(result);
    }
}

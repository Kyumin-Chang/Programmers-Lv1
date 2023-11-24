import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class CollectPersonalInformation {
    /*
    입력
    today = "2022.05.19"
    terms = ["A 6", "B 12", "C 3"]
    privacies = ["2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"]
    출력
    result = [1,3]
     */

    public int[] solution(String today, String[] terms, String[] privacies) {
        return getResults(today, terms, privacies);
    }

    public int[] getResults(String today, String[] terms, String[] privacies) {
        String[] todayArray = getDateArray(today);
        Map<String, Integer> termMap = makeMap(terms);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            String[] splitPrivacy = privacies[i].split(" ");
            String[] addResult = addDate(splitPrivacy[0], termMap.get(splitPrivacy[1]));
            if (Arrays.equals(todayArray, findBigDate(todayArray, addResult))) {
                result.add(i + 1);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    public String[] findBigDate(String[] date_1, String[] date_2) {
        int[] newDate_1 = Stream.of(date_1).mapToInt(Integer::parseInt).toArray();
        int[] newDate_2 = Stream.of(date_2).mapToInt(Integer::parseInt).toArray();
        int[] result = newDate_1;
        if (result[0] < newDate_2[0]) {
            result = newDate_2;
        }
        if ((result[0] == newDate_2[0]) && (result[1] < newDate_2[1])) {
            result = newDate_2;
        }
        if ((result[0] == newDate_2[0]) && (result[1] == newDate_2[1]) && (result[2] < newDate_2[2])) {
            result = newDate_2;
        }
        String[] resultStr = Arrays.stream(result)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);
        resultStr[1] = String.format("%02d", Integer.parseInt(resultStr[1]));
        resultStr[2] = String.format("%02d", Integer.parseInt(resultStr[2]));
        return resultStr;
    }

    public String[] addDate(String date, int month) {
        String[] dateArray = getDateArray(date);
        int year = Integer.parseInt(dateArray[0]);
        int dateMonth = Integer.parseInt(dateArray[1]);
        dateMonth += month;
        while (dateMonth > 12) {
            year++;
            dateMonth -= 12;
        }
        dateArray[0] = String.valueOf(year);
        dateArray[1] = String.valueOf(dateMonth);
        return dateArray;
    }

    public String[] getDateArray(String date) {
        return date.split("\\.");
    }

    public Map<String, Integer> makeMap(String[] str) {
        Map<String, Integer> termMap = new HashMap<>();
        String[] strArray;
        for (String s : str) {
            strArray = s.split(" ");
            termMap.put(strArray[0], Integer.parseInt(strArray[1]));
        }
        return termMap;
    }
}

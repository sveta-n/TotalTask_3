import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TotalTask3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Количество строк");
        int count = scanner.nextInt();
        List<String> strings = new ArrayList<>();
        for (int i = 0; i <= count; i++) {
            strings.add(scanner.nextLine());
        }
        Map<String, Integer> strToAmountOfUniqueSymbols = strings.stream()
                .collect(Collectors.toMap(Function.identity(), str -> {
                    char[] chars = str.toCharArray();
                    Set<Character> set = new HashSet<>();
                    for (char c : chars) {
                        set.add(c);
                    }
                    return set.size();
                }));
        String result = "";
        int max = 0;
        for (Map.Entry<String, Integer> entry : strToAmountOfUniqueSymbols.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            if (value > max) {
                max = value;
                result = key;
            }
        }
        System.out.println(result);
    }
}

package preparinginterviewyatest;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task_1_IntPrTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String b = scanner.nextLine();

        Map<String, Integer> map = new HashMap<>();
        for (String s: b.split("")) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        int count = 0;
        for (String s: a.split("")) {
            count += map.getOrDefault(s, 0);
        }

        System.out.println(count);
    }
}

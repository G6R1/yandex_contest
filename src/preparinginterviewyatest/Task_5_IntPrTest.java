package preparinginterviewyatest;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Task_5_IntPrTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String b = scanner.nextLine();

        if (a.length() != b.length()) {
            System.out.println(0);
            return;
        }

        Map<String, Integer> mapA = new HashMap<>();
        for (String s: a.split("")) {
            mapA.put(s, mapA.getOrDefault(s, 0) + 1);
        }

        Map<String, Integer> mapB = new HashMap<>();
        for (String s: b.split("")) {
            mapB.put(s, mapB.getOrDefault(s, 0) + 1);
        }

        for (String s: mapA.keySet()) {
            if (!Objects.equals(mapA.get(s), mapB.get(s))) {
                System.out.println(0);
                return;
            }
        }

        System.out.println(1);
    }
}

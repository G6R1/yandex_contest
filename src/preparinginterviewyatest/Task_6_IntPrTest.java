package preparinginterviewyatest;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Task_6_IntPrTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int citiesSize = scanner.nextInt();
        int[] cities = new int[citiesSize * 2];

        for (int i = 0; i < cities.length; i++) {
            cities[i] = scanner.nextInt();
        }

        int maxDistance = scanner.nextInt();
        int start = scanner.nextInt();
        int end = scanner.nextInt();

        Map<Integer, Integer> numberDistance = new TreeMap<>();
        Map<Integer, Integer> numberFrom = new TreeMap<>();
    }
}
/*
7
0 0
0 2
2 2
0 -2
2 -2
2 -1
2 1
2
1 3

2

4
0 0
1 0
0 1
1 1
2
1 4

1

4
0 0
2 0
0 2
2 2
1
1 4

-1
 */
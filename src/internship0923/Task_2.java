package internship0923;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int aCardsSize = scanner.nextInt();
        int bCardsSize = scanner.nextInt();
        int changes = scanner.nextInt();
        int[] aCards = new int[aCardsSize];
        int[] bCards = new int[bCardsSize];
        Map<Integer, Integer> difMap = new HashMap<>();

        for (int i = 0; i < aCardsSize; i++) {
            aCards[i] = scanner.nextInt();
            difMap.put(aCards[i], difMap.getOrDefault(aCards[i], 0) - 1);
        }

        for (int i = 0; i < bCardsSize; i++) {
            bCards[i] = scanner.nextInt();
            difMap.put(bCards[i], difMap.getOrDefault(bCards[i], 0) + 1);
        }

        int dif = 0;
        for (int i: difMap.values()) {
            dif += Math.abs(i);
        }

        for (int i = 0; i < changes; i++) {
            int type = scanner.nextInt();
            String player = scanner.next();
            int card = scanner.nextInt();

            int value = difMap.getOrDefault(card, 0);

            int newValue;
            if (player.equals("A")) {
                newValue = value - type;
            } else {
                newValue = value + type;
            }
            difMap.put(card, newValue);
            if (Math.abs(newValue) > Math.abs(value)) {
                dif++;
            } else {
                dif--;
            }

            System.out.print(dif + " ");
        }
    }
}
/*
5 4 5 6 7 8 9 10 9 8 9 8 7 6 5 6 5 4 3 4
5 4 5 6 7 8 9 10 9 8 9 8 7 6 5 6 5 4 3 4
 */
package offerweek1023;

import java.util.Arrays;
import java.util.Scanner;

public class Task_2_OW1023 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int planksSize = scanner.nextInt();
        int rem = scanner.nextInt();
        int[] planks = new int[planksSize];

        for (int i = 0; i < planksSize; i++) {
            planks[i] = scanner.nextInt();
        }

        int minDif = 1000000000;
        Arrays.sort(planks);

        for (int i = 0; i <= rem; i++) {
            int dif = planks[i + planksSize - rem - 1] - planks[i];
            minDif = Math.min(dif, minDif);
        }

        System.out.println(minDif);
    }
}

package preparinginterviewyatest;

import java.util.Scanner;

public class Task_2_IntPrTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int max = 0;
        int count = 0;

        for (int i = 0; i < size; i++) {
            int a = scanner.nextInt();
            if (a == 1) {
                count++;
                max = Integer.max(max, count);
            } else {
                count = 0;
            }
        }

        System.out.println(count);
    }
}

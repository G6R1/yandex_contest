package preparinginterviewyatest;

import java.util.Scanner;

public class Task_3_IntPrTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int last = -1;

        for (int i = 0; i < size; i++) {
            int a = scanner.nextInt();
            if (a != last)
                System.out.println(a);
            last = a;
        }
    }
}

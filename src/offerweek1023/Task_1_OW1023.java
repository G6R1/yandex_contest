package offerweek1023;

import java.util.Scanner;

public class Task_1_OW1023 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long usbs = scanner.nextLong();
        long gadgets = scanner.nextLong();
        int x2cost = scanner.nextInt();
        int x5cost = scanner.nextInt();

        long need = gadgets - usbs;
        long spend = 0;

        if (need > 0) {
            if (x2cost * 4 > x5cost) {
                long rem = need % 4;
                spend += (need - rem) / 4 * x5cost;
                spend += Math.min(x5cost, rem * x2cost);
            } else {
                spend = need * x2cost;
            }
        }

        System.out.println(spend);
    }
}

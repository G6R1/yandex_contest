package internship0923;

import java.util.Scanner;

public class Task_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int yStart = scanner.nextInt();
        int mStart = scanner.nextInt();
        int dStart = scanner.nextInt();
        int hStart = scanner.nextInt();
        int minStart = scanner.nextInt();
        int sStart = scanner.nextInt();

        int yEnd = scanner.nextInt();
        int mEnd = scanner.nextInt();
        int dEnd = scanner.nextInt();
        int hEnd = scanner.nextInt();
        int minEnd = scanner.nextInt();
        int sEnd = scanner.nextInt();

        int[] monthsDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int daysInMonthsStart = 0;
        int daysInMonthsEnd = 0;

        for (int i = 0; i < mStart - 1; i++) {
            daysInMonthsStart += monthsDays[i];
        }

        for (int i = 0; i < mEnd - 1; i++) {
            daysInMonthsEnd += monthsDays[i];
        }

        long epochSecondsStart = (long) (yStart - 1) * 365 * 24 * 60 * 60
                + (daysInMonthsStart + dStart) * 24 * 60 * 60
                + hStart * 60 * 60
                + minStart * 60
                + sStart;
        long epochSecondsEnd = (long) (yEnd - 1) * 365 * 24 * 60 * 60
                + (daysInMonthsEnd + dEnd) * 24 * 60 * 60
                + hEnd * 60 * 60
                + minEnd * 60
                + sEnd;

        long live = epochSecondsEnd - epochSecondsStart;
        long seconds = live % (60 * 60 * 24);


        System.out.print((live - seconds) / (60 * 60 * 24));
        System.out.print(" ");
        System.out.print(seconds);
    }
}

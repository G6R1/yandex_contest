package internship0923;

import java.util.*;

public class Task_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = scanner.nextInt();
        int columns = scanner.nextInt();
        int limits = scanner.nextInt();
        scanner.nextLine();
        Map<String, Integer> columnsNames = new HashMap<>();
        Set<Integer> goodLines = new HashSet<>();

        int count = 0;
        for (String s: scanner.nextLine().split(" ")) {
            columnsNames.put(s, count++);
        }

        for (int i = 0; i < lines; i++) {
            goodLines.add(i);
        }

        int[][] table = new int[lines][columns];

        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < columns; j++) {
                table[i][j] = scanner.nextInt();
            }
        }

        int sum = 0;

        scanner.nextLine();
        for (int i = 0; i < limits; i++) {
            String[] limit = scanner.nextLine().split(" ");
            int column = columnsNames.get(limit[0]);
            int limitNum = Integer.parseInt(limit[2]);

            Set<Integer> badLines = new HashSet<>();

            for (int lineNum: goodLines) {
                if (limit[1].equals(">")) {
                    if (table[lineNum][column] <= limitNum ) {
                        badLines.add(lineNum);
                    }
                } else {
                    if (table[lineNum][column] >= limitNum ) {
                        badLines.add(lineNum);
                    }
                }
            }

            goodLines.removeAll(badLines);
        }

        for (int lineNum: goodLines) {
            for (int j = 0; j < columns; j++) {
                sum += table[lineNum][j];
            }
        }

        System.out.println(sum);
    }
}

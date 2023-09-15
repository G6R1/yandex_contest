import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = scanner.nextInt();
        scanner.nextLine();
        List<String> logs = new ArrayList<>(sum);

        for (int i = 0; i < sum; i++) {
            logs.add(scanner.nextLine());
        }

        Map<Integer, Integer> rocketsMovement = new TreeMap<>();

        for (String st: logs) {
            String[] split = st.split(" ");

            if (split[4].equals("B"))
                continue;

            int yearMinutes = Integer.parseInt(split[2])
                    + Integer.parseInt(split[1]) * 60
                    + Integer.parseInt(split[0]) * 24 * 60;

            int id = Integer.parseInt(split[3]);

            if (split[4].equals("A"))
                rocketsMovement.put(id, rocketsMovement.getOrDefault(id, 0) - yearMinutes);
            if (split[4].equals("S") || split[4].equals("C"))
                rocketsMovement.put(id, rocketsMovement.getOrDefault(id, 0) + yearMinutes);
        }

        for (Integer integer: rocketsMovement.values()) {
            System.out.print(integer + " ");
        }
    }
}
/*
10
50 7 25 3632 A
14 23 52 212372 S
15 0 5 3632 C
14 21 30 212372 A
50 7 26 3632 C
14 21 30 3632 A
14 21 40 212372 B
14 23 52 3632 B
59 7 25 2 A
76 3 34 2 C
 */
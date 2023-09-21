package offerweek1023;

import java.util.*;

public class Task_4_OW1023 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sidewalks = scanner.nextInt();
        int excavations = scanner.nextInt();
        int maxRepairs = scanner.nextInt();

        Map<Integer, Integer> lastExcavationDay = new HashMap<>();
        PriorityQueue<Integer> sadQueue = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        for (int i = 0; i < excavations; i++) {
            int day = scanner.nextInt();
            int sidewalk = scanner.nextInt();

            if (lastExcavationDay.containsKey(sidewalk)) {
                sadQueue.add(day - lastExcavationDay.get(sidewalk));
            }
            lastExcavationDay.put(sidewalk, day);
        }

        if (lastExcavationDay.size() > maxRepairs) {
            System.out.println(-1);
        } else {
            int opt = maxRepairs - lastExcavationDay.size();
            int answer = 0;

            for (int i = 0; i < opt; i++) {
                sadQueue.poll();
            }

            for (Integer integer: sadQueue){
                answer += integer;
            }

            System.out.println(answer);
        }
    }
}
/*
5 5 4
1 4
2 3
2 1
6 2
7 4
 */

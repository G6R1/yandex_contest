package internship0923;

import java.util.*;

public class Task_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int quantity = scanner.nextInt();
        long sum = 0;
        Map<Integer, Map<List<Integer>, Integer>> positionVars = new HashMap<>(); // позиция - (префикс - количество вхождений)

        for (int i = 0; i < quantity; i++) {
            int size = scanner.nextInt();
            int[] array = new int[size];
            int mapSize = positionVars.size();
            if (size > mapSize) {
                for (int j = size; j != mapSize ; j--) {
                    positionVars.put(positionVars.size(), new HashMap<>());
                }
            }

            for (int j = 0; j < size; j++) { // j = позиция
                int num = scanner.nextInt(); //число на j позиции
                array[j] = num;
                List<Integer> prefix = new ArrayList<>();

                for (int k = 0; k <= j; k++) {
                    prefix.add(array[k]);
                }

                if (positionVars.get(j).containsKey(prefix)) {
                    int hasBeen = positionVars.get(j).get(prefix);
                    sum += hasBeen;
                    positionVars.get(j).put(prefix, hasBeen + 1);
                } else {
                    positionVars.get(j).put(prefix, 1);
                }
            }

        }

        System.out.println(sum);
    }
}
/*
2
3
1 2 3
3
1 2 3

4
3
1 2 3
3
1 2 3
3
1 2 3
3
1 2 3

3
3
1 2 3
3
4 5 6
3
1111 2 3333
 */
package offerweek1023;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task_3_OW1023 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int repoSize = scanner.nextInt();
        Map<Integer, Integer> repos = new HashMap<>();
        Map<Integer, Integer> reposCount = new HashMap<>();

        for (int i = 0; i < repoSize; i++) {
            repos.put(i + 1, scanner.nextInt());
        }

        int max = 0;
        int num = 0;

        for (Integer key: repos.keySet()) {
            int value = count(repos, key, reposCount);
            if (value > max) {
                max = value;
                num = key;
            }
        }

        System.out.println(num);
    }

    private static int count(Map<Integer, Integer> repos, int startKey, Map<Integer, Integer> reposCount) {
        if (reposCount.containsKey(startKey)) {
            return reposCount.get(startKey);
        }

        int count = 1;
        if (repos.get(startKey) == 0) {
            reposCount.put(startKey, count);
            return count;
        }

        int rec  = count + count(repos, repos.get(startKey), reposCount);
        reposCount.put(startKey, rec);
        return rec;
    }
}

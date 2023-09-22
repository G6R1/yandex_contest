package internship0923;

import java.util.*;

public class Task_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int employees = scanner.nextInt();
        scanner.nextLine();
        Map<Integer, String> languagesMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> barrierMap = new HashMap<>();

        int count = 1;
        languagesMap.put(0, "AB");
        for (String s: scanner.nextLine().split(" ")) {
            languagesMap.put(count++, s);
        }

        stack.push(scanner.nextInt());
        while (!stack.isEmpty()) {
            int current = scanner.nextInt();

            if (stack.peek() == current) {
                stack.pop();
                Stack<Integer> copiedStack = new Stack<>();
                copiedStack.addAll(stack);
                barrierMap.put(current, barrierCount(copiedStack, languagesMap.get(current), languagesMap, 0));
            } else {
                stack.push(current);
            }
        }

        for (int i = 1; i <= employees; i++) {
            System.out.print(barrierMap.get(i) + " ");
        }
    }

    private static int barrierCount(Stack<Integer> stack, String language, Map<Integer, String> languagesMap, int barrier) {
        if (stack.isEmpty() || languagesMap.get(stack.pop()).contains(language))
            return barrier;

        return barrierCount(stack, language, languagesMap, ++barrier);
    }
}
/*
4
A B A A
0 1 2 3 3 4 4 2 1 0
 */

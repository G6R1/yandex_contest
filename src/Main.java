import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nodesNum = scanner.nextInt();
        int changesNum = scanner.nextInt();
        int[] changes = new int[changesNum];

        for (int i = 0; i < changesNum; i++) {
            changes[i] = scanner.nextInt();
        }


    }
}
/*
10 6
5 7 4 7 8 7

ответ
7 10 5 2 8 4 9 1 6 3
 */
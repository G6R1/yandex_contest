package preparinginterviewyatest;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

public class Task_4_IntPrTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();

//        strangeFun(size * 2, 0, "");
        elseFun(size, "", 0, 0);
    }

//    private static void strangeFun(int need, int notClosed, String s) { //итоговый размер, не закрыто, текущая строка
//        if (need == 0) {
//            System.out.println(s);
//        } else if (need == notClosed) {
//            System.out.println(s + ")".repeat(need));
//        } else if (notClosed == 0) {
//            strangeFun(need - 1, notClosed + 1, s + "(");
//        } else {
//            strangeFun(need - 1, notClosed + 1, s + "(");
//            strangeFun(need - 1, notClosed - 1, s + ")");
//        }
//    }

    private static void elseFun(int size, String s, int left, int right) {
        if (left < size) {
            elseFun(size, s + "(", left + 1, right);
            if (right < left)
                elseFun(size, s + ")", left, right + 1);
        } else {
            System.out.println(s + ")".repeat(size - right));
        }
    }
}
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        PriorityQueue<Integer> maxs = new PriorityQueue<>();
        maxs.add(5);
        maxs.add(5);
        maxs.add(5);
        maxs.add(1);
        maxs.add(2);
        maxs.add(3);

        System.out.println(maxs);
        System.out.println(maxs.peek());
        maxs.poll();
        maxs.add(7);
        System.out.println(maxs);

    }
}
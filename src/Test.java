import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(1);
        list1.add(1);

        list2.add(1);
        list2.add(2);
        list2.add(1);
        list2.add(1);

        System.out.println(list2.equals(list1));

    }
}
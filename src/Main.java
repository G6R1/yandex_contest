import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int[][] orders;
        int[][] ordersByEnd;

        try {
            int ordersNum = Integer.parseInt(bi.readLine());
            orders = new int[ordersNum][4]; //start end cost duration

            for (int i = 0; i < ordersNum; i++) {
                line = bi.readLine();
                String[] split = line.split(" ");
                orders[i][0] = Integer.parseInt(split[0]);
                orders[i][1] = Integer.parseInt(split[1]);
                orders[i][2] = Integer.parseInt(split[2]);
                orders[i][3] = orders[i][1] - orders[i][0];
            }

            ordersByEnd = Arrays.stream(orders).map(int[]::clone).toArray(int[][]::new);
            Arrays.sort(orders, Comparator.comparingInt(x -> x[0]));
            Arrays.sort(ordersByEnd, Comparator.comparingInt(x -> x[1]));

            int requestsNum = Integer.parseInt(bi.readLine());

            for (int i = 0; i < requestsNum; i++) {
                line = bi.readLine();
                String[] split = line.split(" ");
                int rStart = Integer.parseInt(split[0]);
                int rEnd = Integer.parseInt(split[1]);
                int type = Integer.parseInt(split[2]);

                long sum = 0;

                if (type == 1) {
                    for (int[] order : orders) {
                        if (order[0] >= rStart && order[0] <= rEnd)
                            sum += order[2];
                        if (order[0] > rEnd)
                            break;
                    }
                } else {
                    for (int[] order : ordersByEnd) {
                        if (order[1] >= rStart && order[1] <= rEnd)
                            sum += order[3];
                        if (order[1] > rEnd)
                            break;
                    }
                }

                System.out.print(sum + " ");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
/*
1
10 100 1000
6
1 10 1
1 10 2
10 100 1
10 100 2
100 1000 1
100 1000 2

1000 0 1000 90 0 90
 */
//long start = System.currentTimeMillis();
//System.out.println("init " + (System.currentTimeMillis() - start));
//System.out.println();
//System.out.println("final " + (System.currentTimeMillis() - start));
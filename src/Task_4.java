import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task_4 {
    public static void main(String[] args) {
        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int[] orders;

        try {
            int ordersNum = Integer.parseInt(bi.readLine());
            orders = new int[ordersNum * 4]; //start end cost duration

            for (int i = 0; i < ordersNum * 4; i = i + 4) {
                line = bi.readLine();
                String[] split = line.split(" ");
                orders[i] = Integer.parseInt(split[0]);
                orders[i+1] = Integer.parseInt(split[1]);
                orders[i+2] = Integer.parseInt(split[2]);
                orders[i+3] = orders[i+1] - orders[i];
            }

            int requestsNum = Integer.parseInt(bi.readLine());

            for (int i = 0; i < requestsNum; i++) {
                line = bi.readLine();
                String[] split = line.split(" ");
                int rStart = Integer.parseInt(split[0]);
                int rEnd = Integer.parseInt(split[1]);
                int type = Integer.parseInt(split[2]);

                long sum = 0;

                if (type == 1) {
                    for (int j = 0; j < orders.length; j = j + 4) {
                        if (orders[j] >= rStart && orders[j] <= rEnd)
                            sum += orders[j + 2];
                    }
                } else {
                    for (int j = 0; j < orders.length; j = j + 4) {
                        if (orders[j + 1] >= rStart && orders[j + 1] <= rEnd)
                            sum += orders[j + 3];
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
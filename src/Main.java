import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));

        String line;
        List<Order> orders;
        List<Request> requests;

        try {
            int ordersNum = Integer.parseInt(bi.readLine());
            orders = new ArrayList<>(ordersNum);

            for (int i = 0; i < ordersNum; i++) {
                line = bi.readLine();
                String[] split = line.split(" ");
                orders.add(new Order(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2])));
            }

            int requestsNum = Integer.parseInt(bi.readLine());
            requests = new ArrayList<>(requestsNum);

            for (int i = 0; i < requestsNum; i++) {
                line = bi.readLine();
                String[] split = line.split(" ");
                requests.add(new Request(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2])));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("init " + (System.currentTimeMillis() - start));

        PrintWriter out = new PrintWriter(System.out);
        int count = 0;
        for (Request request : requests) {
            long sum;

            if (request.getType() == 1) {
                sum = orders.stream()
                        .filter(x -> x.getStart() >= request.getStart() && x.getStart() <= request.getEnd())
                        .mapToLong(Order::getCost)
                        .sum();
            } else {
                sum = orders.stream()
                        .filter(x -> x.getEnd() >= request.getStart() && x.getEnd() <= request.getEnd())
                        .mapToLong(x -> x.getEnd() - x.getStart())
                        .sum();
            }

            out.print(sum + " ");
            count++;
            if (count % 100 == 0 || count == requests.size())
                out.flush();
        }

        System.out.println();
        System.out.println("final " + (System.currentTimeMillis() - start));
    }

    private static class Order {
        private int start;
        private int end;
        private int cost;

        public Order(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public int getCost() {
            return cost;
        }
    }

    private static class Request {
        private int start;
        private int end;
        private int type;

        public Request(int start, int end, int type) {
            this.start = start;
            this.end = end;
            this.type = type;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public int getType() {
            return type;
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

5
5 20 5
6 21 4
6 22 3
7 23 2
10 24 1
3
6 11 1
4 6 1
7 11 1

10 12 3

35
3 6 1
4 6 2
3 4 3
4 10 100500
4 11 777
3 8 365
4 8 31
12 57 234
12 57 234
12 57 234
12 57 234
12 57 234
12 57 234
65 333 567
65 333 567
65 333 567
65 333 567
65 333 567
65 333 567
65 333 567
100 1000 47
100 1000 47
100 1000 47
100 1000 47
100 1000 47
200 689 23
200 689 23
200 689 23
200 689 23
200 689 23
1000 2000 100
1000 2000 100
1000 2000 100
1000 2000 100
1000 2000 100
30
6 6 2
6 8 2
5 9 2
3 12 2
9 12 2
8 12 2
5 15 1
5 15 2
5 15 1
15 30 2
15 30 1
15 30 2
30 60 1
30 60 2
30 60 1
60 120 2
60 120 1
60 120 2
120 240 1
120 240 2
120 240 1
240 480 2
240 480 1
240 480 1
480 960 2
480 960 2
480 960 1
960 1800 2
960 1800 1
960 1800 2

5 14 14 28 13 22
 */
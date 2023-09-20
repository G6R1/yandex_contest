import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        generate(n * 2, 0, "");
    }

    private static void generate(int n, int a, String xs) {
        if (n == 0) {
            System.out.println(new StringBuilder(xs).reverse().toString());
        } else if (n == a) {
            generate(n - 1, a - 1, ")" + xs);
        } else if (a == 0) {
            generate(n - 1, a + 1, "(" + xs);
        } else {
            generate(n - 1, a + 1, "(" + xs);
            generate(n - 1, a - 1, ")" + xs);
        }
    }

}
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = scanner.nextInt();
        scanner.nextLine();
        List<String> trainees = new ArrayList<>(sum);

        for (int i = 0; i < sum; i++) {
            trainees.add(scanner.nextLine());
        }

        for (String st: trainees) {
            String[] split = st.split(",");

            String fio = split[0] + split[1] + split[2];
            int fioCount = (int) fio.chars().distinct().count();

            int dayMonth64 = Arrays.stream((split[3] + split[4]).split(""))
                    .mapToInt(Integer::parseInt)
                    .sum()
                    * 64;

            int firstLetter256 = (split[0].charAt(0) - 64) * 256;

            String hex = Integer.toHexString(fioCount + dayMonth64 + firstLetter256);
            String hex3AndMore = String.format("%3s", hex).replace(' ', '0');

            System.out.print(hex3AndMore.substring(hex3AndMore.length() - 3).toUpperCase() + " ");
        }
    }
}

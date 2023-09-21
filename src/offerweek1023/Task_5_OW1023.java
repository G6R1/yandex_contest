package offerweek1023;

import java.util.*;

public class Task_5_OW1023 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int students = scanner.nextInt();
        int programs = scanner.nextInt();

        int[] freeSlots = new int[programs];

        for (int i = 0; i < programs; i++) {
            freeSlots[i] = scanner.nextInt();
        }

        List<Student> ratingList = new ArrayList<>();
        Map<Integer, Integer> answerMap = new HashMap<>();

        for (int i = 0; i < students; i++) {
            int rating = scanner.nextInt();
            int[] wishes = new int[scanner.nextInt()];

            for (int j = 0; j < wishes.length; j++) {
                wishes[j] = scanner.nextInt();
            }

            ratingList.add(new Student(i, rating, wishes));
        }

        ratingList.sort(Comparator.comparingInt(Student::getRating));

        for (Student student: ratingList) {
            for (int i: student.getWishes()) {
                if (freeSlots[i - 1] != 0) {
                    freeSlots[i - 1] -= 1;
                    answerMap.put(student.getId(), i);
                    break;
                }
            }
        }

        for (int i = 0; i < students; i++) {
            System.out.print(answerMap.getOrDefault(i, -1) + " ");
        }
    }

    private static class Student {
        private int id;
        private int rating;
        private int[] wishes;

        public Student(int id, int rating, int[] wishes) {
            this.id = id;
            this.rating = rating;
            this.wishes = wishes;
        }

        public int getId() {
            return id;
        }

        public int getRating() {
            return rating;
        }

        public int[] getWishes() {
            return wishes;
        }
    }
}

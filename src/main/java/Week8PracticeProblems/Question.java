import java.util.*;

abstract class Question {
    protected String correct;
    protected String student;
    protected double points;

    Question(String correct, String student, double points) {
        this.correct = correct;
        this.student = student;
        this.points = points;
    }

    abstract double grade();
}

class MCQ extends Question {
    MCQ(String correct, String student, double points) {
        super(correct, student, points);
    }

    double grade() {
        return student.equals(correct) ? points : 0;
    }
}

class TF extends Question {
    TF(String correct, String student, double points) {
        super(correct, student, points);
    }

    double grade() {
        return student.equals(correct) ? points : 0;
    }
}

class Essay extends Question {
    Essay(String correct, String student, double points) {
        super(correct, student, points);
    }

    double grade() {
        String[] keywords = correct.split(",");
        String answer = student.toLowerCase();

        int found = 0;

        for (String keyword : keywords) {
            if (answer.contains(keyword.trim().toLowerCase())) {
                found++;
            }
        }

        if (found >= 2)
            return points * 0.75;
        else if (found == 1)
            return points * 0.50;
        else
            return 0;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        double total = 0;

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();

            String[] parts = line.split("\"");

            String type = parts[0].trim().split("\\s+")[0];

            String correct = parts[3].trim();
            String student = parts[5].trim();

            String last = parts[parts.length - 1].trim();
            double points = Double.parseDouble(last);

            Question q;

            if (type.equals("MCQ"))
                q = new MCQ(correct, student, points);
            else if (type.equals("TF"))
                q = new TF(correct, student, points);
            else
                q = new Essay(correct, student, points);

            double score = q.grade();
            total += score;

            System.out.printf("%s: %.2f%n", type, score);
        }

        System.out.printf("Total Score: %.2f%n", total);
    }
}

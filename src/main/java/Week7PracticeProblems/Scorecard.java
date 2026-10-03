class Scorecard {
    private boolean[] results;
    private int count;

    Scorecard(int questions) {
        results = new boolean[questions];
        count = 0;
    }

    public void recordAnswer(boolean correct) {
        if (count < results.length) {
            results[count] = correct;
            count++;
        }
    }

    public int getScore() {
        int score = 0;

        for (int i = 0; i < count; i++) {
            if (results[i]) {
                score++;
            }
        }

        return score;
    }
}

public class Main {
    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);

        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        System.out.println(sc.getScore());
    }
}

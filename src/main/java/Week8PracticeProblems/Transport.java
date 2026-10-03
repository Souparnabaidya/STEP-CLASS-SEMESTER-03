import java.util.*;

abstract class Transport {
    protected double distance;

    Transport(double distance) {
        this.distance = distance;
    }

    abstract double calculateFare();
}

class Bus extends Transport {
    Bus(double distance) {
        super(distance);
    }

    double calculateFare() {
        return Math.min(2 + 0.10 * distance, 10);
    }
}

class Train extends Transport {
    Train(double distance) {
        super(distance);
    }

    double calculateFare() {
        return 3 + 0.15 * distance;
    }
}

class Metro extends Transport {
    private double peakFactor;

    Metro(double distance, double peakFactor) {
        super(distance);
        this.peakFactor = peakFactor;
    }

    double calculateFare() {
        return (1.50 + 0.20 * distance) * peakFactor;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double distance = sc.nextDouble();

            Transport t;

            if (type.equals("BUS")) {
                t = new Bus(distance);
            } else if (type.equals("TRAIN")) {
                t = new Train(distance);
            } else {
                double peakFactor = sc.nextDouble();
                t = new Metro(distance, peakFactor);
            }

            double fare = t.calculateFare();
            total += fare;

            System.out.printf("%s: %.2f%n", type, fare);
        }

        System.out.printf("Total: %.2f%n", total);
    }
}

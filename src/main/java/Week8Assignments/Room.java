import java.util.*;

abstract class Room {
    double units;

    Room(double units) {
        this.units = units;
    }

    abstract double calculate();
}

class Single extends Room {
    Single(double units) {
        super(units);
    }

    double calculate() {
        return units * 8;
    }
}

class Shared extends Room {
    int occupants;

    Shared(double units, int occupants) {
        super(units);
        this.occupants = occupants;
    }

    double calculate() {
        return (units * 6) / occupants;
    }
}

class AC extends Room {
    AC(double units) {
        super(units);
    }

    double calculate() {
        return units * 10 + 200;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double units = sc.nextDouble();

            Room r;

            if (type.equals("SHARED")) {
                int occupants = sc.nextInt();
                r = new Shared(units, occupants);
            } else if (type.equals("SINGLE")) {
                r = new Single(units);
            } else {
                r = new AC(units);
            }

            double bill = r.calculate();
            total += bill;

            System.out.printf("%s: %.2f%n", type, bill);
        }

        System.out.printf("Total: %.2f%n", total);
    }
}

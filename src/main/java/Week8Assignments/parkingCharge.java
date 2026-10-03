import java.util.*;

abstract class parkingCharge {
    int hours;

    Vehicle(int hours) {
        this.hours = hours;
    }

    abstract double calculate();
}

class Bike extends Vehicle {
    Bike(int hours) {
        super(hours);
    }

    double calculate() {
        return hours * 10;
    }
}

class Car extends Vehicle {
    Car(int hours) {
        super(hours);
    }

    double calculate() {
        if (hours <= 1)
            return 30;

        return 30 + (hours - 1) * 20;
    }
}

class Truck extends Vehicle {
    Truck(int hours) {
        super(hours);
    }

    double calculate() {
        return Math.max(100, hours * 50);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int hours = sc.nextInt();

            Vehicle v;

            if (type.equals("BIKE"))
                v = new Bike(hours);
            else if (type.equals("CAR"))
                v = new Car(hours);
            else
                v = new Truck(hours);

            double charge = v.calculate();
            total += charge;

            System.out.printf("%s: %.2f%n", type, charge);
        }

        System.out.printf("Total: %.2f%n", total);
    }
}

class messWallet {

    private double balance;

    public MessWallet(double balance) {

        if (balance < 0) {
            System.out.println(
                    "Warning: Negative balance not allowed");

            this.balance = 0;
        } else {
            this.balance = balance;
        }
    }

    public void topUp(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid top-up amount");
        } else {
            balance += amount;

            System.out.println(
                    "Balance after top-up: " + balance);
        }
    }

    public void deduct(double amount) {

        if (amount > balance) {

            System.out.println(
                    "Deduct rejected: insufficient balance");

        } else if (amount <= 0) {

            System.out.println(
                    "Invalid deduction amount");

        } else {

            balance -= amount;

            System.out.println(
                    "Amount deducted: " + amount);
        }
    }

    public double getBalance() {
        return balance;
    }

    public static void main(String[] args) {

        MessWallet wallet =
                new MessWallet(500);

        wallet.topUp(200);
        wallet.deduct(1000);

        System.out.println(
                "Final balance: " + wallet.getBalance());
    }
}

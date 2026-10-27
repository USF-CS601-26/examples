package multithreading.synchronizedkeyword;

public class BankAccount {
    private double balance = 0;

    public BankAccount(double balance) {
        this.balance = balance;
    }
    public synchronized void withdraw(double amount) {
        if (balance >= amount) {
            System.out.println(Thread.currentThread().getName()
                    + " is withdrawing $" + amount);

            balance -= amount;

            System.out.println("Remaining balance: $" + balance);
        } else {
            System.out.println(Thread.currentThread().getName()
                    + ": Insufficient funds");
        }
    }

    public synchronized double getBalance() {
        return balance;
    }

    static void main(String[] args) throws InterruptedException {
        BankAccount account = new BankAccount(120);

        Runnable task = () -> {
            for (int i = 0; i < 3; i++) {
                account.withdraw(20);
            }
        };

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final balance: $" + account.getBalance());
    }
}

package multithreading.basic;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableExample {
    static void main(String[] args) {
        class SumTask implements Callable<Integer> {
            private final int n;
            public SumTask(int n) {
                this.n = n;
            }
            @Override
            public Integer call() {
                int sum = 0;
                for (int i = 1; i <= n; i++) {
                    sum += i;
                }
                return sum;
            }
        }

        FutureTask<Integer> result = new FutureTask<>(new SumTask(1000));
        Thread t = new Thread(result);
        t.start();
        try {
            System.out.println(result.get()); // the current thread will wait until the result is ready
        } catch (ExecutionException | InterruptedException e) {
            System.out.println(e);
        }

    }
}

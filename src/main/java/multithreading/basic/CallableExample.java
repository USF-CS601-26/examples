package multithreading.basic;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableExample {
    static void main(String[] args) {
        Callable callable  = new Callable() {
            @Override
            public Object call()  {
                return 4;
            }
        };

        FutureTask<Integer> result = new FutureTask<>(callable);
        Thread t = new Thread(result);
        t.start();
        try {
            System.out.println(result.get()); // the current thread will wait until the result is ready
        } catch (ExecutionException | InterruptedException e) {
            System.out.println(e);
        }

    }
}

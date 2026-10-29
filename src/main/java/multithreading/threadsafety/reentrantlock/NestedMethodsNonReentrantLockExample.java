package multithreading.threadsafety.reentrantlock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.StampedLock;

class NestedMethodsNonReentrantLockExample {
    private final List<Integer> data = new ArrayList<>();
    private final StampedLock lock = new StampedLock();

    public List<Integer> readData() {
        long s = lock.readLock();
        try {
            return readNested(); // calling a method that also needs the read lock
        } finally {
            lock.unlockRead(s);
        }
    }

    private List<Integer> readNested() {
        long s = lock.readLock();
        try {
            return new ArrayList<>(data);
        } finally {
            lock.unlockRead(s);
        }
    }

    public void writeData(int value)  {
        long s = lock.writeLock();
        try {
            // do some work ...
            Thread.sleep(100);
            writeInNested(value); // calling a method that also requires a write lock
            // do more work...
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlockWrite(s);
        }
    }

    public void writeInNested(int value) {
        long s = lock.writeLock();
        try {
            data.add(value);
        } finally {
            lock.unlockWrite(s);
        }
    }

    static void main(String[] args) {
        NestedMethodsNonReentrantLockExample ex = new NestedMethodsNonReentrantLockExample();

        Thread t1 = new Thread(() -> {
           ex.writeData(5);
        });

        Thread t2 = new Thread(() -> {
            ex.writeData(10);
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        }
        catch(InterruptedException e) {
            System.out.println(e);
        }
        System.out.println(ex.readData());
    }
}

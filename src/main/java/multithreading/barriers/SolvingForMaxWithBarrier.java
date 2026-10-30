package multithreading.barriers;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SolvingForMaxWithBarrier {
    public static final int NUM_ROWS = 10;
    private static final double[][] matrix = generateBigMatrix(NUM_ROWS, 1_000_000);
    private static final double[] rowMax = new double[NUM_ROWS];

    static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(NUM_ROWS, () -> {
            // Barrier action runs once when all threads arrive
            double globalMax = Double.MIN_VALUE;
            for (double val : rowMax) globalMax = Math.max(globalMax, val);
            System.out.println("All rows done. Global maximum = " + globalMax);
        });

        ExecutorService exec = Executors.newFixedThreadPool(NUM_ROWS);
        for (int i = 0; i < NUM_ROWS; i++) {
            final int row = i;
            exec.submit(() -> {
                double max = Double.MIN_VALUE;
                for (double val : matrix[row]) max = Math.max(max, val);
                rowMax[row] = max;
                System.out.println(Thread.currentThread().getName() + " done, local max = " + max);
                try {
                    barrier.await(); // wait for all rows
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

        exec.shutdown();
    }

    private static double[][] generateBigMatrix(int n, int m) {
        double[][] matrix = new double[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                matrix[i][j] = Math.random();
        return matrix;
    }
}


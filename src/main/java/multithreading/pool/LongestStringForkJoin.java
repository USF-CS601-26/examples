package multithreading.pool;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class LongestStringForkJoin {

    static class LongestStringTask extends RecursiveTask<String> {
        private static final int THRESHOLD = 3;

        private final String[] words;
        private final int start;
        private final int end; // inclusive

        public LongestStringTask(String[] words, int start, int end) {
            this.words = words;
            this.start = start;
            this.end = end;
        }

        @Override
        protected String compute() {
            // Base case: find longest string directly
            if (end - start + 1 <= THRESHOLD) {
                String longest = "";
                for (int i = start; i <= end; i++) {
                    if (words[i].length() > longest.length()) {
                        longest = words[i];
                    }
                }
                return longest;
            }

            // Recursive case: split into two subtasks
            int mid = (start + end) / 2;

            LongestStringTask left =
                    new LongestStringTask(words, start, mid);

            LongestStringTask right =
                    new LongestStringTask(words, mid + 1, end);

            left.fork(); // computes asynchronously
            String rightResult = right.compute(); // compute in this thread
            String leftResult = left.join(); // wait for the left task to finish

            // Combine results
            return leftResult.length() >= rightResult.length()
                    ? leftResult : rightResult;
        }
    }

    static void main(String[] args) {
        String[] words = {
                "cat", "elephant", "dog", "butterfly",
                "ant", "hippopotamus", "tiger", "giraffe"
        };

        ForkJoinPool pool = new ForkJoinPool();

        String longest = pool.invoke(
                new LongestStringTask(words, 0, words.length - 1));

        System.out.println("Longest string: " + longest);

        pool.shutdown();
    }
}

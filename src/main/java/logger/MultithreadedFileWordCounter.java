package logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.*;
import java.util.concurrent.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MultithreadedFileWordCounter {

    private static final Logger logger =
            LogManager.getLogger(MultithreadedFileWordCounter.class);

    private int count;
    private final ExecutorService poolManager =
            Executors.newCachedThreadPool();

    public MultithreadedFileWordCounter() {
        count = 0;
    }

    // Each worker counts words in one file
    class CounterWorker implements Runnable {
        private final Path file;

        public CounterWorker(Path file) {
            this.file = file;
        }

        @Override
        public void run() {
            int localWordCount = 0;

            logger.info("Starting processing file: {}", file);

            try (BufferedReader br = Files.newBufferedReader(file)) {
                String line;
                while ((line = br.readLine()) != null) {
                    if (!line.isBlank()) {
                        String[] words = line.split("[,;!\\. ]+");
                        localWordCount += words.length;
                    }
                }
            } catch (IOException e) {
                logger.error("Error reading file: {}", file, e);
            }

            logger.info("Finished processing file: {}. Words: {}",
                    file, localWordCount);

            updateCount(localWordCount);
        }
    }

    // Safely update the shared total
    public synchronized void updateCount(int localCount) {
        count += localCount;
    }

    public synchronized int getCount() {
        return count;
    }

    // Traverse directories and submit tasks for .txt files
    public void countWordsInFiles(Path directory) {
        try (DirectoryStream<Path> filesAndFolders =
                     Files.newDirectoryStream(directory)) {

            for (Path path : filesAndFolders) {
                if (Files.isDirectory(path)) {
                    countWordsInFiles(path);
                } else if (path.toString().endsWith(".txt")) {
                    logger.debug("Submitting task for file: {}", path);
                    poolManager.execute(new CounterWorker(path));
                }
            }

        } catch (IOException e) {
            logger.error("Error traversing directory: {}", directory, e);
        }
    }

    // Submit tasks and wait for all workers to finish
    public void traverseAndGatherResults(Path dir) {
        logger.info("Starting directory traversal: {}", dir);

        try (poolManager) {
            countWordsInFiles(dir);
        }
        // close() waits for all tasks to finish; it is called automatically if we use "try with resources" above

        logger.info("All tasks completed. Total words: {}", getCount());
    }

    static void main(String[] args) {
        MultithreadedFileWordCounter counter =
                new MultithreadedFileWordCounter();

        counter.traverseAndGatherResults(Paths.get("dir"));
        logger.info("Final word count: {}", counter.getCount());
    }
}

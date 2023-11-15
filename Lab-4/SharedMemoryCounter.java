import java.util.concurrent.atomic.AtomicInteger;

public class SharedMemoryCounter {
    public static void main(String[] args) {
        // Create an AtomicInteger with an initial value of 0
        AtomicInteger counter = new AtomicInteger(0);

        // Create multiple threads to increment the counter
        int numThreads = 4;
        Thread[] threads = new Thread[numThreads];

        for(int i=0; i<numThreads; i++) {
            threads[i] = new Thread(() -> {
                for(int j=0; j<10000; j++) {
                    // Increment the counter atomically
                    counter.incrementAndGet();
                }
            });
            threads[i].start();
        }

        // Wait for all threads to finish
        try {
            for (Thread thread: threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print the final value of the counter
        System.out.println("Final Counter Value: " + counter.get());
    }
}
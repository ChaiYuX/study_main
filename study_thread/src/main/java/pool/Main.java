package pool;

public class Main {
    public static void main(String[] args) {
        ThreadPool threadPool = new ThreadPool(5);

        for (int i = 0; i < 10; i++) {
            final int taskId = i;
            threadPool.execute(() -> {
                System.out.println("Task " + taskId + " is running in thread " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("Task " + taskId + " is completed");
            });
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        threadPool.shutdown();
    }
}

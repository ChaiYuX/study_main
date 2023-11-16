package pool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPool {
    private final int poolSize;
    private final BlockingQueue<Runnable> taskQueue;
    private final List<WorkerThread> workerThreads;

    public ThreadPool(int poolSize) {
        this.poolSize = poolSize;
        this.taskQueue = new LinkedBlockingQueue<>();
        this.workerThreads = new ArrayList<>();

        for (int i = 0; i < poolSize; i++) {
            WorkerThread workerThread = new WorkerThread();
            workerThreads.add(workerThread);
            workerThread.start();
        }
    }

    public void execute(Runnable task) {
        try {
            taskQueue.put(task);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void shutdown() {
        for (WorkerThread workerThread : workerThreads) {
            workerThread.stopThread();
        }
    }

    public int getPoolSize() {
        return poolSize;
    }

    public int getActiveCount() {
        int count = 0;
        for (WorkerThread workerThread : workerThreads) {
            if (workerThread.isWorking()) {
                count++;
            }
        }
        return count;
    }

    private class WorkerThread extends Thread {
        private volatile boolean working = true;

        @Override
        public void run() {
            while (working) {
                try {
                    Runnable task = taskQueue.take();
                    task.run();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }

        public void stopThread() {
            working = false;
            interrupt();
        }

        public boolean isWorking() {
            return working;
        }
    }
}
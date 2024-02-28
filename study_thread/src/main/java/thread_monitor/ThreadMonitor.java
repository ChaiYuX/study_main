package thread_monitor;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadMonitor {

    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public static void startMonitoring() {
        // 设置一个定时任务，每秒钟输出一次线程信息
        scheduler.scheduleAtFixedRate(ThreadMonitor::printThreadInfo, 0, 1, TimeUnit.SECONDS);
    }

    private static void printThreadInfo() {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        long[] threadIds = threadMXBean.getAllThreadIds();
        ThreadInfo[] threadInfos = threadMXBean.getThreadInfo(threadIds);

        for (ThreadInfo threadInfo : threadInfos) {
            if (threadInfo != null) {
                System.out.println("Thread Name: " + threadInfo.getThreadName());
                System.out.println("Thread State: " + threadInfo.getThreadState());
                System.out.println("Blocked Time: " + threadInfo.getBlockedTime());
                System.out.println("Blocked Count: " + threadInfo.getBlockedCount());
                System.out.println("Waited Time: " + threadInfo.getWaitedTime());
                System.out.println("Waited Count: " + threadInfo.getWaitedCount());
                System.out.println("-------------------------");
            }
        }
    }

    public static void stopMonitoring() {
        scheduler.shutdown();
    }

    public static void main(String[] args) {
        // 启动线程监控
        ThreadMonitor.startMonitoring();

        // 示例：启动一些新线程
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(3000); // 让线程休眠3秒
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread " + Thread.currentThread().getName() + " finished.");
            }, "Thread-" + i).start();
        }

        // 让主线程休眠一段时间，以便观察其他线程的状态
        try {
            Thread.sleep(10000); // 主线程休眠10秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 停止线程监控
        ThreadMonitor.stopMonitoring();
    }

}

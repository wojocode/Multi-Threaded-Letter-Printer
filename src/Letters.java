/**
 * @ Wojciech Natkaniec
 */

import java.util.ArrayList;
import java.util.List;

public class Letters extends Thread {
    private final String input;
    private List<Thread> threads = new ArrayList<>();
    private final int totalThreadsRuntimeInSeconds;
    private final int threadIntervalInSeconds;
    public static boolean isRunning = true;

    public Letters(String input, int totalThreadsRuntimeInSeconds, int threadRunTimeInterval) {
        this.input = input;
        this.totalThreadsRuntimeInSeconds = totalThreadsRuntimeInSeconds;
        this.threadIntervalInSeconds = threadRunTimeInterval;

        for (int i = 0; i < input.length(); i++) {
            int cursor = i;
            Thread thread = new Thread(() -> {
                while (isRunning) {
                    try {
                        Thread.sleep(getThreadIntervalInSeconds());
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.print(input.charAt(cursor));
                }
            });
            thread.setDaemon(true);
            thread.setName("Thread " + input.charAt(cursor));
            threads.add(thread);
        }
    }

    public List<Thread> getThreads() {
        return threads;
    }

    public int getTotalThreadsRuntimeInSeconds() {
        return totalThreadsRuntimeInSeconds * 1000;
    }

    public int getThreadIntervalInSeconds() {
        return threadIntervalInSeconds * 1000;
    }

    public static void setRunning(boolean running) {
        isRunning = running;
    }
}

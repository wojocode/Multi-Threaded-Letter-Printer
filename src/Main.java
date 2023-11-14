public class Main {

    public static void main(String[] args) throws InterruptedException {
        Letters letters = new Letters("ABCD", 5, 1);
        for (Thread t : letters.getThreads()) System.out.println(t.getName());
        for (Thread thread : letters.getThreads()) thread.start();

        Thread.sleep(letters.getTotalThreadsRuntimeInSeconds());
        letters.setRunning(false);
        System.out.println("\nProgram finished");
    }
}


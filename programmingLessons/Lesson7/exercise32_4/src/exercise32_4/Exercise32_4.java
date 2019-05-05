
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exercise32_4 {

    private static Integer sum = 0;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 0; i < 1000; i++) {
            executor.execute(new AddOne());
        }

        executor.shutdown();

        while (!executor.isTerminated()) {
        }

        System.out.println("sum = " + sum);
    }

    private static class AddOne implements Runnable {

        Exercise32_4 ex;

        private AddOne() {
            this.ex = new Exercise32_4();
        }

        @Override
        public void run() {
            synchronized (ex) {
                sum++;
            };

        }
    }
}

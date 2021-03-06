package thread.HTTPMonitor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author badrikant.soni
 */
public class Executor {

    private static int CHECK_INTERVAL = 5;   // Check every 5 seconds
    private static int NUM_THREADS = 3;      // Number of threads

    // Thread pool to process domains
    private static ExecutorService threadPool = Executors.newFixedThreadPool(NUM_THREADS);

    // Executor to run the check and run reports on a service
    private static ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);

    public static void main(String[] args) {
        for (String domain : Constants.DOMAINS) {
            // Check every domain at an interval
            ses.scheduleAtFixedRate(() -> {
                ses.submit(() -> HttpMonitor.check(domain));
            }, 0, CHECK_INTERVAL, TimeUnit.SECONDS);
        }

        ses.scheduleAtFixedRate(() -> {
            // Clear previously displayed report
            System.out.print("\033[H\033[2J");
            System.out.flush();

            // Display uptime report
            System.out.println(HttpMonitor.log.toString());
        }, 0, CHECK_INTERVAL, TimeUnit.SECONDS);

    }
}

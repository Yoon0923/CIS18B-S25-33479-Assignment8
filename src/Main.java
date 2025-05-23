import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
public class Main {
    public static void main(String[] args) {
        TicketPool pool = new TicketPool(5);

        ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();

        for (int i = 1; i <= 10; i++) {
            String customerName = "Customer-" + i;
            executor.execute(new Customer(customerName, pool));
        }

        executor.shutdown();
try {
            executor.awaitTermination(3, TimeUnit.SECONDS); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }
}

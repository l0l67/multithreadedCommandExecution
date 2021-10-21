import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class main {
  private final ExecutorService pool;

  public main(int max_concurrent_threads) {
    pool = Executors.newFixedThreadPool(max_concurrent_threads);
  }

  public void addThread(String[] cmd) {
    task task = new task(cmd);
    pool.execute(task);
  }

  public void done() {
    pool.shutdown();
  }
}

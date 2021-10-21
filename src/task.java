import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class task implements Runnable {
  private final String[] command;

  public task(String[] command) {
    this.command = command;
  }

  public void run() {
    try {
      System.out.println(Arrays.toString(command));

      ProcessBuilder processBuilder = new ProcessBuilder(command);

      BufferedReader reader = new BufferedReader(new InputStreamReader(processBuilder.start().getInputStream()));

      String str = "-";
      while ((reader.readLine()) != null) {
        str = reader.readLine();
      }

      System.out.println("Thread " + Thread.currentThread().getName() + " Finished! : "  + str);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

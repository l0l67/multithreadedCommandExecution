import java.io.File;
import java.util.*;

public class test {
  private final static main main = new main(2);
  private final static String dir = "C:\\source\\test2\\TEST";

  public static void main(String[] args) {
    List<String> files = listFileNames(dir, ".txt");

    int startFrom = 0;
    if (args.length > 1 && args[0].equals("-r")) {
      startFrom = Integer.parseInt(args[1]);
    }

    for (int i = startFrom; i < files.size(); i++) {
      String filename = files.get(i);
      main.addThread(new String[]{"type", dir + "\\" + filename});
    }
    main.done();
  }

  private static List<String> listFileNames(String dir, String endswith) {
    List<String> out = new ArrayList<>();
    File f = new File(dir);

    for (File file : Objects.requireNonNull(f.listFiles())) {
      if (file.isFile() && file.getName().endsWith(endswith)) {
        out.add(file.getName());
      }
    }
    Collections.sort(out);
    return out;
  }
}

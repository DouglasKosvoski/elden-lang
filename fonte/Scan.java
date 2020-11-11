import java.util.Scanner;
import java.io.File;

public class Scan {
  private String filename;

  public Scan() {
  }

  public Scan(String filename) {
    this.filename = filename;
  }

  public void read() {
    if(filename == null) {
      System.out.println("Arquivo Indefinido");
      return;
    }
    try {
      Scanner input = new Scanner(this.filename);
      File file = new File(input.nextLine());

      input = new Scanner(file);
      while (input.hasNextLine()) {
        String line = input.nextLine();
        System.out.println(line);
      }
      input.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

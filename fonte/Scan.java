import java.util.Scanner;
import java.io.File;

public class Scan {
  private String filename, VariableStr = "summon";
  // private String filename;

  public Scan() {
  }

  public Scan(String filename) {
    this.filename = filename;
  }

  // cria ou faz load de um arquivo a partir do argumento passado
  private Scanner content(String filename) {
    Scanner file = new Scanner(filename);
    return file;
  }

  public void read() {
    // verificacao interna caso alguem esqueca de inicializar o arquivo
    if(filename == null) {
      System.out.println("Arquivo Indefinido");
      return;
    }

    // faz a leitura linha-a-linha do arquivo
    try {
      Scanner input = this.content(this.filename);
      File file = new File(input.nextLine());
      System.out.println("\t**Conteudo do Arquivo**");

      input = new Scanner(file);
      while (input.hasNextLine()) {
        String line = input.nextLine();
       
        System.out.println(line);
       
        if (line.contains("summon")){
          System.out.println("Creating a variable");
          Variable n = new Variable();
          String Line = n.createVariable(line);
          System.out.println(Line);
        
        } else {
          System.out.println("Summon was not there...");
        }
        
        }
      input.close();
    
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

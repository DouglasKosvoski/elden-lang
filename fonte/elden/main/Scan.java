package fonte.elden.main;

import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

public class Scan {
  private String filename;
  private String VariableStr = "summon";

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

  public ArrayList read(Boolean showContent) {
    // String[] conteudo;
    ArrayList<String> conteudo = new ArrayList<String>();

    // verificacao interna caso alguem esqueca de inicializar o arquivo
    if(filename == null) {
      System.out.println("Arquivo Indefinido");
      return null;
    }

    try {
      Scanner input = this.content(this.filename);
      File file = new File(input.nextLine());

      input = new Scanner(file);
      while (input.hasNextLine()) {
        String line = input.nextLine();
        conteudo.add(line);

        if(showContent) {
          System.out.println(line);
        }
      }
      input.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
    return conteudo;
  }
}

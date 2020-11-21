package fonte.elden.main;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class Leitor {
  private String filename;
  private Scanner conteudo;
  ArrayList<String> conteudoAnalisado = new ArrayList<String>();

  // Constructors
  public Leitor(String filename) {
    this.setNomeDoArquivo(filename);
    this.setConteudo();
    this.analisaScanner();
  }

  // setters
  private void setNomeDoArquivo(String filename) {
    this.filename = filename;
  }
  private void setConteudo() {
    // cria ou faz load de um arquivo a partir do argumento passado
    this.conteudo = new Scanner(this.filename);
  }

  // getters
  public String getNomeDoArquivo() {
    return this.filename;
  }
  public Scanner getConteudo() {
    return this.conteudo;
  }
  public ArrayList getConteudoAnalisado() {
    return this.conteudoAnalisado;
  }

  private void analisaScanner() {
    try {
      Scanner entrada = this.conteudo;
      File arquivo = new File(entrada.nextLine());
      entrada = new Scanner(arquivo);

      while(entrada.hasNextLine()) {
        String linha = entrada.nextLine();
        this.conteudoAnalisado.add(linha);
      }
      entrada.close();

    } catch(Exception e) {
      e.printStackTrace();
    }
  }
}

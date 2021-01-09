package fonte.elden.main;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

import fonte.elden.main.Interpretador;

public class Leitor {
  /*  */
  private Interpretador interpretador = new Interpretador();
  /*  String com o nome do arquivo passado */
  private String filename;
  /* conteudo bruto do arquivo passado */
  private Scanner conteudo;

  /* ArrayList com o conteudo de Strings, analisado a partir do Scanner com o conteudo bruto */
  ArrayList<String> conteudoAnalisado = new ArrayList<String>();

  // Constructors
  public Leitor(String filename) {
    this.setNomeDoArquivo(filename);
    this.setConteudo();
    this.analisaScanner();
  }

  public void roda() {
    this.interpretador.interpreta(this.conteudoAnalisado);
  }

  /* modifica a variavel para armazenar o nome do arquivo (String) */
  private void setNomeDoArquivo(String filename) {
    this.filename = filename;
  }

  /* cria ou carrega um arquivo a partir do argumento passado */
  private void setConteudo() {
    this.conteudo = new Scanner(this.filename);
  }

  /* retorna uma String com o nome do arquivo passado ao programa */
  public String getNomeDoArquivo() {
    return this.filename;
  }

  /* retorna um Scanner com o conteudo bruto do arquivo passado */
  public Scanner getConteudo() {
    return this.conteudo;
  }

  /* retorna um ArrayList com o conteudo (strings) */
  public ArrayList getConteudoAnalisado() {
    return this.conteudoAnalisado;
  }

  /* analisa a partir do Scanner o seu conteudo e entao salva em uma variavel
  para entao ser utilizada no decorrer da execucao do programa */
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

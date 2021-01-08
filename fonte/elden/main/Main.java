package fonte.elden.main;

import fonte.elden.main.Leitor;

public class Main {
  public static void main(String[] args) {
    /* Se nenhum arquivo foi passado o programa se encerra */
    if(!foiPassadoArgumento(args)) return;

    /* pega o nome do arquivo a partir do primeiro argumento */
    String filename = args[0];

    /* verifica se a extensao do arquivo eh valida */
    if(!verificaExtensao(filename)) return;

    /* executa e interpreta o arquivo passado ao programa */
    Executa(filename);
  }

  /* metodo que vai chamar o interpretador responsavel por analisar e realizar
  as funcoes declaradas do arquivo passado */
  private static void Executa(String filename) {
    Leitor leitor = new Leitor(filename);
	  leitor.interpreta();
  }

  /* verifica se algum argumento foi passado ao programa */
  private static Boolean foiPassadoArgumento(String[] args) {
    if(args.length == 0) {
      System.out.println("Tente passar algum Arquivo ao Programa!");
      return false;
    }
    return true;
  }

  /* verifica extensao do arquivo passado...
  uma vez que a intencao eh interpretar o arquivo especifico
  da nossa linguagem ex: teste.el */
  private static Boolean verificaExtensao(String arquivo) {

    if(arquivo.endsWith(".el")) {
      return true;
    }
    System.out.println("Extensao invalida! Extensoes suportadas: *.el\n");
    return false;
  }
}

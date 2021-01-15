package fonte.elden.main;

import fonte.elden.main.Leitor;

/*
  Classe responsável pela chamada do Leitor (o qual vai analisar e executar o código),
  e por verificações do arquivo passado.

  Métodos suportados:
    foiPassadoArgumento  // Verifica se foi passado algum arquivo como argumento ao programa.
    verificaExtensao     // Verifica se a extensão do arquivo passado é suportada.
    Executa              // Faz a chamada do Leitor responsável por analisar e executar o código.

  @autor Douglas Kosvoski <douglas.contactpro@gmail.com>.
*/

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
	  leitor.roda();
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

package fonte.elden.main;

import java.util.ArrayList;
import fonte.elden.main.Leitor;

public class Main {
  public static void main(String[] args) {
    if(!foiPassadoArgumento(args)) {
      return;
    }

    // criado o nome do arquivo a partir do primeiro argumento
    String filename = args[0];

    if(!verificaExtensao(filename)) {
      return;
    }

    // le o arquivo
    Leitor scan = new Leitor(filename);
    System.out.println("Nome do Arq: " + scan.getNomeDoArquivo());
    // retorna um ArrayList de strings
    System.out.println("Conteudo do Arq: " + scan.getConteudoAnalisado());

  }

  private static Boolean foiPassadoArgumento(String[] args) {
    // verifica se algum argumento foi passado ao programa
    if(args.length == 0) {
      System.out.println("Tente Passar Algum Arquivo Como Argumento ao Programa!");
      return false;
    }
    return true;
  }

  private static Boolean verificaExtensao(String arquivo) {
    // verifica extensao do arquivo passado...
    // uma vez que a intencao eh interpretar o arquivo especifico
    // da nossa linguagem ex: teste.el
    if(arquivo.endsWith(".el")) {
      System.out.println("Extensao Valida!\n");
      return true;
    }
    System.out.println("Extensao Invalida! \nExtensoes suportadas: *.el\n");
    return false;
  }
}

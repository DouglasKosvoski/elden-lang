public class Main {
  public static void main(String[] args) {
    // verifica se algum argumento foi passado ao programa
    if(args.length == 0) {
      System.out.println("Tente Passar Algum Arquivo Como Argumento ao Programa!");
      return;
    }

    // criado o nome do arquivo a partir do primeiro argumento
    String filename = args[0];

    // verifica se a extensao do arquivo eh aceita pelo programa
    if(!verificaExtensao(filename)) {
      System.out.println("Extensao Invalida! \nExtensoes suportadas: *.el\n");
      return;
    } else {
      System.out.println("Extensao Valida!\n");
    }

    // le o arquivo
    Scan scan = new Scan(filename);
    scan.read();
  }

  private static Boolean verificaExtensao(String arquivo) {
    // verifica extensao do arquivo passado...
    // uma vez que a intencao eh interpretar o arquivo especifico
    // da nossa linguagem ex: teste.el
    if(arquivo.endsWith(".el")) {
      return true;
    }
    return false;
  }

}

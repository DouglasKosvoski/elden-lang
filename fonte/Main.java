public class Main {
  public static void main(String[] args) {
    if(args.length == 0) {
      System.out.println("Passe algum argumento ao programa!");
      return;
    }
    String filename = args[0];

    // le o arquivo
    Scan scan = new Scan(filename);
    scan.read();
  }
}

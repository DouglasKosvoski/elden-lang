package fonte.elden.main;

import java.util.ArrayList;
import fonte.elden.main.Leitor;
import fonte.elden.vars.TipoDouble;
import fonte.elden.vars.TipoString;
import fonte.elden.vars.TipoBooleano;
import fonte.elden.vars.TipoInteiro;

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

    Testes(filename);

  }

  private static void Testes(String filename) {
    Leitor leitor = new Leitor(filename); // instancia um novo leitor
    // System.out.println("Nome do Arq: " + leitor.getNomeDoArquivo()); // nome do arquivo passado como argumento
    // System.out.println("Conteudo do Arq: " + leitor.getConteudoAnalisado()); // retorna um ArrayList de strings

    // TipoBooleano b = new TipoBooleano("boolVar", "true");
    // System.out.println("Nome: " + b.getNome());
    // System.out.println("Tipo: " + b.getTipo());
    // System.out.println("Valor: " + b.getValor());

    // TipoDouble d = new TipoDouble("doubleVar");
    // System.out.println("Nome: " + d.getNome());
    // System.out.println("Tipo: " + d.getTipo());
    // System.out.println("Valor: " + d.getValor());
    // d.setValor(6.24);
    // System.out.println("Valor: " + d.getValor());

    // TipoInteiro i = new TipoInteiro("intVar");
    // System.out.println("Nome: " + i.getNome());
    // System.out.println("Tipo: " + i.getTipo());
    // System.out.println("Valor: " + i.getValor());
    // i.setValor(-12);
    // System.out.println("Valor: " + i.getValor());

    // TipoString s = new TipoString("stringVar", "asdasdasd");
    // System.out.println("Nome: " + s.getNome());
    // System.out.println("Tipo: " + s.getTipo());
    // System.out.println("Valor: " + s.getValor());
    // s.setValor("vrauvaru");
    // System.out.println("Valor: " + s.getValor());
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

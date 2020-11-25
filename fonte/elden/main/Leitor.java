package fonte.elden.main;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.util.HashMap;

import fonte.elden.vars.TipoInteiro;
import fonte.elden.vars.TipoDouble;
import fonte.elden.vars.TipoString;
import fonte.elden.vars.TipoBooleano;

public class Leitor {
  private String filename;
  private Scanner conteudo;
  ArrayList<String> conteudoAnalisado = new ArrayList<String>();
  HashMap<String, TipoInteiro> vInt = new HashMap<String, TipoInteiro>();
  HashMap<String, TipoDouble> vDouble = new HashMap<String, TipoDouble>();
  HashMap<String, TipoString> vString = new HashMap<String, TipoString>();
  HashMap<String, TipoBooleano> vBoolean = new HashMap<String, TipoBooleano>();

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

  public void show() {
    for(int i = 0; i < this.conteudoAnalisado.size(); i++) {
      String linha = this.conteudoAnalisado.get(i);
      String[] linhaSplit = linha.split(" ");
      String nome;

      if(linha.endsWith(".") == false || linha.length() < 1) {
        // System.out.println("assad");
        continue;
      }

      switch(linhaSplit[0]) {
      	case "summon":
          switch (linhaSplit[1]) {
            case "int":
              TipoInteiro intVar = new TipoInteiro();
              nome = linhaSplit[2].replace(".", "");
              intVar.setNome(nome);
              this.vInt.put(nome, intVar);
              break;

            case "double":
              TipoDouble doubleVar = new TipoDouble();
              nome = linhaSplit[2].replace(".", "");
              doubleVar.setNome(nome);
              this.vDouble.put(nome, doubleVar);
              break;

            case "string":
              TipoString stringVar = new TipoString();
              nome = linhaSplit[2].replace(".", "");
              stringVar.setNome(nome);
              this.vString.put(nome, stringVar);
              break;

            case "boolean":
              TipoBooleano booleanVar = new TipoBooleano();
              nome = linhaSplit[2].replace(".", "");
              booleanVar.setNome(nome);
              this.vBoolean.put(nome, booleanVar);
              break;
          }
      	  break;

        case "cast":
          // System.out.println(linhaSplit[1]);

          if (this.vInt.containsKey(linhaSplit[1])) {
            int valor = linhaSplit[3].replace(".", "").length();
            this.vInt.get(linhaSplit[1]).setValor(valor);
            System.out.println(linhaSplit[1] + " \t: int" + "\t: valor: " + valor);
          }

          else if (this.vDouble.containsKey(linhaSplit[1])) {
            int valor = linhaSplit[3].replace(".", "").length();
            this.vDouble.get(linhaSplit[1]).setValor(valor);
            System.out.println(linhaSplit[1] + " \t: double" + "\t: valor: " + valor);
          }

          else if (this.vString.containsKey(linhaSplit[1])) {
            String valor = linhaSplit[3].replace(".", "");
            this.vString.get(linhaSplit[1]).setValor(valor);
            System.out.println(linhaSplit[1] + " \t: string" + "\t: valor: " + valor);
          }

          else if (this.vBoolean.containsKey(linhaSplit[1])) {
            String valor = linhaSplit[3].replace(".", "");
            this.vBoolean.get(linhaSplit[1]).setValor(valor);
            System.out.println(linhaSplit[1] + " \t: boolean" + "\t: valor: " + valor);
          }

      }
    }
  }

}

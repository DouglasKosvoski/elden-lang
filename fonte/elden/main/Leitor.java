package fonte.elden.main;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.io.File;

import fonte.elden.vars.*;

public class Leitor {
  private String filename;
  private Scanner conteudo;
  ArrayList<String> conteudoAnalisado = new ArrayList<String>();
  HashMap<String, TipoInteiro>  vInt     = new HashMap<String, TipoInteiro>();
  HashMap<String, TipoDouble>   vDouble  = new HashMap<String, TipoDouble>();
  HashMap<String, TipoString>   vString  = new HashMap<String, TipoString>();
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
  public Boolean startWithUpperCase(String s) {
    if(null == s || s.isEmpty()){
      return false;
    }
    else {
      return (Character.isUpperCase(s.codePointAt(0)));
    }
  }

  public void show() {
    for(int i = 0; i < this.conteudoAnalisado.size(); i++) {
      String linha = this.conteudoAnalisado.get(i);
      String[] linhaSplit = linha.split(" ");
      String nome;

      if(linha.startsWith("//") || linha.endsWith(".") == false || linha.length() < 1) {
        continue;
      }

      // Math Operations
      if(startWithUpperCase(linhaSplit[0])) {
        // value which will be used to modify the original variable value
        int valor = linhaSplit[3].replace(".", "").length();

        Variavel A = new Variavel();

        if (this.vInt.containsKey(linhaSplit[0])) {
          A.setTipo(this.vInt.get(linhaSplit[0]).getTipo());
        }
        else if (this.vDouble.containsKey(linhaSplit[0])) {
          A.setTipo(this.vDouble.get(linhaSplit[0]).getTipo());
        }

        // System.out.println("Tipo: " + A.getTipo());

        // Math Operations
        switch(linhaSplit[1]) {
          // increase
          case "ascend":
            switch(A.getTipo()) {
              case "int":
                this.vInt.get(linhaSplit[0]).Increase(valor);
                break;
              case "Double":
                this.vDouble.get(linhaSplit[0]).Increase(valor);
                break;
              default:
                System.out.println(A.getTipo() + " does not support 'Ascend' operation");
                break;
            }
            break;

          // decrease
          case "descend":
            switch(A.getTipo()) {
              case "int":
                this.vInt.get(linhaSplit[0]).Decrease(valor);
                break;
              case "Double":
                this.vDouble.get(linhaSplit[0]).Decrease(valor);
                break;
              default:
                System.out.println(A.getTipo() + " does not support 'Descend' operation");
                break;
            }
            break;

          // multiplication
          case "strengthen":
            switch(A.getTipo()) {
              case "int":
                this.vInt.get(linhaSplit[0]).Multiply(valor);
                break;
              case "Double":
                this.vDouble.get(linhaSplit[0]).Multiply(valor);
                break;
              default:
                System.out.println(A.getTipo() + " does not support 'Strengthen' operation");
                break;
            }
            break;


          // division
          case "weaken":
            if(valor == 0) {
              System.out.println("Division by Zero caught: line: " + (i+1));
              return;
            }
            switch(A.getTipo()) {
              case "int":
                this.vInt.get(linhaSplit[0]).Divide(valor);
                break;
              case "Double":
                this.vDouble.get(linhaSplit[0]).Divide(valor);
                break;
              default:
                System.out.println(A.getTipo() + " does not support 'Weaken' operation");
                break;
            }
            break;

          // comparision
          case "matches":
            System.out.println(linhaSplit[0] + " == " + (linhaSplit[2].length()-1));
            break;

          default:
            System.out.println("Error at line: " + (i+1) + " Unknown Expression: " + linha);
            break;
        }
        continue;
      }

      // Variable Declaration, Inicialization and Reveal
      switch(linhaSplit[0]) {
        // Variable Declaration
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

        // Variable Inicialization
        case "cast":
          if (this.vInt.containsKey(linhaSplit[1])) {
            int valor = linhaSplit[3].replace(".", "").length();
            this.vInt.get(linhaSplit[1]).setValor(valor);
            // System.out.println(linhaSplit[1] + " \t: int" + "\t: valor: " + this.vInt.get(linhaSplit[1]).getValor());
          }

          else if (this.vDouble.containsKey(linhaSplit[1])) {
            int valor = linhaSplit[3].replace(".", "").length();
            this.vDouble.get(linhaSplit[1]).setValor(valor);
            // System.out.println(linhaSplit[1] + " \t: double" + "\t: valor: " + this.vDouble.get(linhaSplit[1]).getValor());
          }

          else if (this.vString.containsKey(linhaSplit[1])) {
            String valor = linhaSplit[3].replace(".", "");
            this.vString.get(linhaSplit[1]).setValor(valor);
            // System.out.println(linhaSplit[1] + " \t: string" + "\t: valor: " + this.vString.get(linhaSplit[1]).getValor());
          }

          else if (this.vBoolean.containsKey(linhaSplit[1])) {
            String valor = linhaSplit[3].replace(".", "");
            this.vBoolean.get(linhaSplit[1]).setValor(valor);
            // System.out.println(linhaSplit[1] + " \t: boolean" + "\t: valor: " + this.vBoolean.get(linhaSplit[1]).getValor());
          }
          break;

        // Print Variable Value
        case "reveal":
          String var = linhaSplit[1].replace(".", "");
          if (this.vInt.containsKey(var)) {
            int valor = this.vInt.get(var).getValor();
            System.out.println(valor);
          }
          else if (this.vDouble.containsKey(var)) {
            double valor = this.vDouble.get(var).getValor();
            System.out.println(valor);
          }
          else if (this.vString.containsKey(var)) {
            String valor = this.vString.get(var).getValor();
            System.out.println(valor);
          }
          else if (this.vBoolean.containsKey(var)) {
            Boolean valor = this.vBoolean.get(var).getValor();
            System.out.println(valor);
          }
          else {
            System.out.println("Unexpected '" + var + "' | Line: " + (i+1));
          }
          break;

        default:
          System.out.println("Error at line: " + (i+1) + " | " + linha);
          break;
      }
    }
  }
}

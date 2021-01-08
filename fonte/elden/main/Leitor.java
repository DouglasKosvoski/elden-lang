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
  HashMap<String, TipoInteiro>  HMint     = new HashMap<String, TipoInteiro>();
  HashMap<String, TipoDouble>   HMdouble  = new HashMap<String, TipoDouble>();
  HashMap<String, TipoString>   HMstring  = new HashMap<String, TipoString>();
  HashMap<String, TipoBooleano> HMboolean = new HashMap<String, TipoBooleano>();

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
  public Boolean verificaContinuidadeLinha(String linha) {
    // Retorna TRUE quando a linha esta nos conformes do programa, se nao retorna False
    return (linha.startsWith("//") || linha.endsWith(".") == false || linha.length() < 1);
  }

  public void mathOperations(String[] linha, int linhaIndex) {
    linhaIndex += 1;
    int valorNumerico = 0;
    String valorString = "";
    String varName = linha[0];
    String operation = linha[1];

    Variavel variavelGenerica = new Variavel();

    // verifica qual HM contem a varivel
    if (this.HMint.containsKey(varName)) {
      variavelGenerica.setTipo(this.HMint.get(varName).getTipo());
    }
    else if (this.HMdouble.containsKey(varName)) {
      variavelGenerica.setTipo(this.HMdouble.get(varName).getTipo());
    }
    else if (this.HMstring.containsKey(varName)) {
      variavelGenerica.setTipo(this.HMstring.get(varName).getTipo());
    }
    else if (this.HMboolean.containsKey(varName)) {
      variavelGenerica.setTipo(this.HMboolean.get(varName).getTipo());
    }

    if(linha.length > 3) {
      valorNumerico = linha[3].replace(".", "").length();
    }
    else {
      valorString = linha[2].replace(".", "");
    }

    // Math Operations
    switch(operation) {
      // Ascend is supported only for INT and DOUBLE type
      case "ascend":
        switch(variavelGenerica.getTipo()) {
          case "int":
            this.HMint.get(varName).Increase(valorNumerico);
            break;
          case "Double":
            this.HMdouble.get(varName).Increase(valorNumerico);
            break;
          default:
            System.out.println(variavelGenerica.getTipo() + " does not support 'Ascend' operation");
            break;
        } break;

      // Descend is supported only for INT and DOUBLE type
      case "descend":
        switch(variavelGenerica.getTipo()) {
          case "int":
            this.HMint.get(varName).Decrease(valorNumerico);
            break;
          case "Double":
            this.HMdouble.get(varName).Decrease(valorNumerico);
            break;
          default:
            System.out.println(variavelGenerica.getTipo() + " does not support 'Descend' operation");
            break;
        }
        break;

      // Strengthen is supported only for INT and DOUBLE type
      case "strengthen":
        switch(variavelGenerica.getTipo()) {
          case "int":
            this.HMint.get(varName).Multiply(valorNumerico);
            break;
          case "Double":
            this.HMdouble.get(varName).Multiply(valorNumerico);
            break;
          default:
            System.out.println(variavelGenerica.getTipo() + " does not support 'Strengthen' operation");
            break;
        }
        break;

      // Weaken is supported only for INT and DOUBLE type
      case "weaken":
        if(valorNumerico == 0) {
          System.out.println("Division by Zero Error caught: line: " + linhaIndex);
          return;
        }
        switch(variavelGenerica.getTipo()) {
          case "int":
            this.HMint.get(varName).Divide(valorNumerico);
            break;
          case "Double":
            this.HMdouble.get(varName).Divide(valorNumerico);
            break;
          default:
            System.out.println(variavelGenerica.getTipo() + " does not support 'Weaken' operation");
            break;
        }
        break;

      // Matches supports all variable types
      case "matches":
        switch(variavelGenerica.getTipo()) {
          case "int":
            Boolean asd = this.HMint.get(varName).Compare(valorString.length());
            System.out.println(asd);
            break;

          case "Double":
            Boolean asd1 = this.HMdouble.get(varName).Compare(valorString.length());
            System.out.println(asd1);
            break;

          case "String":
            Boolean asd2 = this.HMstring.get(varName).Compare(valorString);
            System.out.println(asd2);
            break;

          case "Booleano":
            Boolean asd3 = this.HMboolean.get(varName).Compare(valorString);
            System.out.println(asd3);
            break;

          default:
            System.out.println("Malformed Expression. Line: " + (linhaIndex+1));
            break;
          }
          break;

      default:
        System.out.println("Error at line: " + linhaIndex + " Unknown Expression: " + linha);
        break;
    }
  }

  public void variableMethods(String[] linha, int linhaIndex) {
    linhaIndex += 1;
    String method = linha[0];
    String tipo, varName;

    switch(method) {
      case "summon":
        tipo = linha[1];
        varName = linha[2].replace(".", "");

        switch (tipo) {
          case "int":
            TipoInteiro intVar = new TipoInteiro();
            intVar.setNome(varName);
            this.HMint.put(varName, intVar);
            break;

          case "double":
            TipoDouble doubleVar = new TipoDouble();
            doubleVar.setNome(varName);
            this.HMdouble.put(varName, doubleVar);
            break;

          case "string":
            TipoString stringVar = new TipoString();
            stringVar.setNome(varName);
            this.HMstring.put(varName, stringVar);
            break;

          case "boolean":
            TipoBooleano booleanVar = new TipoBooleano();
            booleanVar.setNome(varName);
            this.HMboolean.put(varName, booleanVar);
            break;
        }
        break;

      // Variable Inicialization
      case "cast":
        varName = linha[1];
        String valorString = linha[3].replace(".", "");
        int valorNumerico = linha[3].replace(".", "").length();

        if (this.HMint.containsKey(varName)) {
          this.HMint.get(varName).setValor(valorNumerico);
        }
        else if (this.HMdouble.containsKey(varName)) {
          this.HMdouble.get(varName).setValor(valorNumerico);
        }
        else if (this.HMstring.containsKey(varName)) {
          this.HMstring.get(varName).setValor(valorString);
        }
        else if (this.HMboolean.containsKey(varName)) {
          this.HMboolean.get(varName).setValor(valorString);
        }
        break;

      // Print Variable Value
      case "reveal":
        varName = linha[1].replace(".", "");

        if (this.HMint.containsKey(varName)) {
          System.out.println(this.HMint.get(varName).getValor());
        }
        else if (this.HMdouble.containsKey(varName)) {
          System.out.println(this.HMdouble.get(varName).getValor());
        }
        else if (this.HMstring.containsKey(varName)) {
          System.out.println(this.HMstring.get(varName).getValor());
        }
        else if (this.HMboolean.containsKey(varName)) {
          System.out.println(this.HMboolean.get(varName).getValor());
        }
        else {
          System.out.println("Unexpected '" + varName + "' | Line: " + linhaIndex);
        }
        break;

      default:
        System.out.println("Error at line: " + linhaIndex + " | " + linha);
        break;
    }
  }

  public void show() {
    int tamanho = this.conteudoAnalisado.size();
    // System.out.println("Qtd linhas: " + tamanho);

    for(int linhaNumero = 0; linhaNumero < tamanho; linhaNumero++) {
      String linha = this.conteudoAnalisado.get(linhaNumero);
      String[] linhaSplit = linha.split(" ");
      String nome;

      if(verificaContinuidadeLinha(linha)) continue;
      if(startWithUpperCase(linhaSplit[0])) {
        mathOperations(linhaSplit, linhaNumero);
        continue;
      }

      // Variable Declaration, Inicialization and Reveal
      variableMethods(linhaSplit, linhaNumero);
    }
  }
}

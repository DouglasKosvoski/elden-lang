package fonte.elden.main;

/* importa os tipos primitivos de variaveis */
import fonte.elden.vars.*;
import java.io.*;
import java.util.*;

public class Estatico {

  /* metodo responsavel pela identificacao das palavras-chaves
  para que as variaveis possam ser declaradas, inicializadas
  e tambem alguns outros metodos estaticos */
  public String variableMethods(KeyMap KMdict, HashMap<String, TipoInteiro> HMint,
    HashMap<String, TipoDouble> HMdouble, HashMap<String, TipoString> HMstring,
    HashMap<String, TipoBooleano> HMboolean, String[] linha, int linhaIndex) {

    linhaIndex += 1;
    String method = linha[0];
    String tipo, varName;

    /* responsavel por indentificar qual metodo esta sendo executado
    seja declaracao, inicializacao ou mesmo print */
    if (method.equals(KMdict.getValue("declaration"))) {
      tipo = linha[1];
      varName = linha[2].replace(".", "");

      if (tipo.equals(KMdict.getValue("tInt"))) {
        TipoInteiro intVar = new TipoInteiro();
        intVar.setNome(varName);
        HMint.put(varName, intVar);
      }
      else if (tipo.equals(KMdict.getValue("tDouble"))) {
        TipoDouble doubleVar = new TipoDouble();
        doubleVar.setNome(varName);
        HMdouble.put(varName, doubleVar);
      }
      else if (tipo.equals(KMdict.getValue("tString"))) {
        TipoString stringVar = new TipoString();
        stringVar.setNome(varName);
        HMstring.put(varName, stringVar);
      }
      else if (tipo.equals(KMdict.getValue("tBool"))) {
        TipoBooleano booleanVar = new TipoBooleano();
        booleanVar.setNome(varName);
        HMboolean.put(varName, booleanVar);
      }
    }

    // Variable Inicialization
    else if (method.equals(KMdict.getValue("inicialization"))) {
      varName = linha[1];

      String[] valorStringLista = Arrays.copyOfRange(linha, 3, linha.length);
      String valorString = "";

      for (int i=0; i<valorStringLista.length; i++) {
        valorString += valorStringLista[i] + " ";
      }

      valorString = valorString.replace(".", "");
      int valorNumerico = valorString.replace(".", "").replace(" ", "").length();

      if (HMint.containsKey(varName)) {
        HMint.get(varName).setValor(valorNumerico);
      }
      else if (HMdouble.containsKey(varName)) {
        HMdouble.get(varName).setValor(valorNumerico);
      }
      else if (HMstring.containsKey(varName)) {
        HMstring.get(varName).setValor(valorString);
      }
      else if (HMboolean.containsKey(varName)) {
        HMboolean.get(varName).setValor(valorString);
      }
    }

    // Print Variable Value
    else if (method.equals(KMdict.getValue("print"))) {
      varName = linha[1].replace(".", "");

      if (HMint.containsKey(varName)) {
        System.out.println(HMint.get(varName).getValor());
      }
      else if (HMdouble.containsKey(varName)) {
        System.out.println(HMdouble.get(varName).getValor());
      }
      else if (HMstring.containsKey(varName)) {
        System.out.println(HMstring.get(varName).getValor());
      }
      else if (HMboolean.containsKey(varName)) {
        System.out.println(HMboolean.get(varName).getValor());
      }
      else {
        System.out.println("Unexpected '" + varName + "' | Line: " + linhaIndex);
      }
      return "";
    }
    // Recebe um imput do teclado

    else if (method.equals(KMdict.getValue("input"))) {
      varName = linha[1].replace(".", "");
      Scanner keyboard = new Scanner(System.in);
      String asd = keyboard.nextLine();

      if (HMint.containsKey(varName)) {
        HMint.get(varName).setValor(asd);
      }
      else if (HMdouble.containsKey(varName)) {
        HMdouble.get(varName).setValor(asd);
      }
      else if (HMstring.containsKey(varName)) {
        HMstring.get(varName).setValor(asd);
      }
      else if (HMboolean.containsKey(varName)) {
        HMboolean.get(varName).setValor(asd);
      }
      else {
        System.out.println("Unexpected '" + varName + "' | Line: " + linhaIndex);
      }
      return "";
    }

    else if (method.equals("if")) {
      String retornoDaFuncao = "";
      for (int i=1; i<linha.length; i++) {
        retornoDaFuncao += linha[i] + " ";
      }
      return retornoDaFuncao;
    }

    else {
      System.out.println("Error at line: " + linhaIndex + " | " + linha);
      return "";
    }
    return "";
  }
}

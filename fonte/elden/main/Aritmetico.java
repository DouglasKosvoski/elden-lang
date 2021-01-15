package fonte.elden.main;

/* importa os tipos primitivos de variaveis */
import fonte.elden.vars.*;
import java.util.HashMap;

/*
  Classe responsável por classificar e interpretar métodos
  relacionados a matemática.

  Responsável por toda a lógica relacionada a qual método será chamada
  dependendo do tipo primitivo da variável.

  @autor Douglas Kosvoski <douglas.contactpro@gmail.com>.
*/

public class Aritmetico {
  /* responsavel por realizar todas as funcoes matematicas
  como por exemplo: adicao, subtracao, multiplicacao, divisao e comparacoes */
  public void mathOperations(KeyMap KMdict, HashMap<String, TipoInteiro> HMint,
    HashMap<String, TipoDouble> HMdouble, HashMap<String, TipoString> HMstring,
    HashMap<String, TipoBooleano> HMboolean, String[] linha, int linhaIndex) {

    /* soma 1, uma vez que a linha numero 0 nao existe */
    linhaIndex += 1;
    /* valor responsavel pelas modificacoes das variaveis de tipos Int e Double */
    int valorNumerico = 0;
    /* valor responsavel pelas modificacoes das variaveis de tipos String e Boolean */
    String valorString = "";
    /* extrai o nome da variavel a ser manipulada */
    String varName = linha[0];

    /* pega a operacao a ser realizada */
    String operation = linha[1];

    /* variavel generica a qual sera atribuida o tipo da variavel em questao*/
    Variavel variavelGenerica = new Variavel();
    Variavel variavelGenerica2 = new Variavel();

    /* verifica em qual HashMap a varivel esta contida */
    if (HMint.containsKey(varName)) {
      variavelGenerica.setTipo(HMint.get(varName).getTipo());
    }
    else if (HMdouble.containsKey(varName)) {
      variavelGenerica.setTipo(HMdouble.get(varName).getTipo());
    }
    else if (HMstring.containsKey(varName)) {
      variavelGenerica.setTipo(HMstring.get(varName).getTipo());
    }
    else if (HMboolean.containsKey(varName)) {
      variavelGenerica.setTipo(HMboolean.get(varName).getTipo());
    }

    if(linha.length > 3) {
      valorNumerico = linha[3].replace(".", "").length();
    }
    else {
      valorString = linha[2].replace(".", "");
    }

    if(linha[2].equals(KMdict.getValue("different"))) {
      operation = linha[2];
      valorNumerico = linha[3].replace(".", "").length();
      valorString = linha[3].replace(".", "");
    }
    else if(operation.equals("is")) {
      operation = linha[2];
      valorNumerico = linha[4].replace(".", "").length();
    }

    if (operation.equals(KMdict.getValue("addition"))) {
      if (variavelGenerica.getTipo().equals("int")) {
        HMint.get(varName).Increase(valorNumerico);
      }
      else if (variavelGenerica.getTipo().equals("Double")) {
        HMdouble.get(varName).Increase(valorNumerico);
      }
      else {
        System.out.println(variavelGenerica.getTipo() + " does not support 'Ascend' operation");
      }
    }
    else if (operation.equals(KMdict.getValue("subtraction"))) {
      if (variavelGenerica.getTipo().equals("int")) {
        HMint.get(varName).Decrease(valorNumerico);
      }
      else if (variavelGenerica.getTipo().equals("Double")) {
        HMdouble.get(varName).Decrease(valorNumerico);
      }
      else {
        System.out.println(variavelGenerica.getTipo() + " does not support 'Descend' operation");
      }
    }
    else if (operation.equals(KMdict.getValue("multiplication"))) {
      if (variavelGenerica.getTipo().equals("int")) {
        HMint.get(varName).Multiply(valorNumerico);
      }
      else if (variavelGenerica.getTipo().equals("Double")) {
        HMdouble.get(varName).Multiply(valorNumerico);
      }
      else {
        System.out.println(variavelGenerica.getTipo() + " does not support 'Strengthen' operation");
      }
    }
    else if (operation.equals(KMdict.getValue("division"))) {
      /* evita divisao por zero */
      if(valorNumerico == 0) {
        System.out.println("Division by Zero Error caught: line: " + linhaIndex);
        return;
      }

      if (variavelGenerica.getTipo().equals("int")) {
        HMint.get(varName).Divide(valorNumerico);
      }
      else if (variavelGenerica.getTipo().equals("Double")) {
        HMdouble.get(varName).Divide(valorNumerico);
      }
      else {
        System.out.println(variavelGenerica.getTipo() + " does not support 'Weaken' operation");
      }
    }
    else if (operation.equals(KMdict.getValue("comparision"))) {
      if (variavelGenerica.getTipo().equals("int")) {
        Boolean asd = HMint.get(varName).Compare(valorString.length());
        System.out.println(asd);
      }
      else if (variavelGenerica.getTipo().equals("Double")) {
        Boolean asd1 = HMdouble.get(varName).Compare(valorString.length());
        System.out.println(asd1);
      }
      else if (variavelGenerica.getTipo().equals("String")) {
        Boolean asd2 = HMstring.get(varName).Compare(valorString);
        System.out.println(asd2);
      }
      else if (variavelGenerica.getTipo().equals("Booleano")) {
        Boolean asd3 = HMboolean.get(varName).Compare(valorString);
        System.out.println(asd3);
      }
      else {
        System.out.println("Malformed Expression. Line: " + (linhaIndex+1));
      }
    }
    else if (operation.equals(KMdict.getValue("greaterThan"))) {
      if (variavelGenerica.getTipo().equals("int")) {
        Boolean asd = HMint.get(varName).biggerThan(valorNumerico);
        System.out.println(asd);
      }
      else if (variavelGenerica.getTipo().equals("Double")) {
        Boolean asd1 = HMdouble.get(varName).biggerThan(valorNumerico);
        System.out.println(asd1);
      }
      else {
        System.out.println("Malformed Expression. Line: " + (linhaIndex+1));
      }
    }
    else if (operation.equals(KMdict.getValue("greaterOrEquals"))) {
      if (variavelGenerica.getTipo().equals("int")) {
        Boolean asd = HMint.get(varName).biggerOrEqualThan(valorNumerico);
        System.out.println(asd);
      }
      else if (variavelGenerica.getTipo().equals("Double")) {
        Boolean asd1 = HMdouble.get(varName).biggerOrEqualThan(valorNumerico);
        System.out.println(asd1);
      }
      else {
        System.out.println("Malformed Expression. Line: " + (linhaIndex+1));
      }
    }
    else if (operation.equals(KMdict.getValue("smallerThan"))) {
      if (variavelGenerica.getTipo().equals("int")) {
        Boolean asd = HMint.get(varName).lessThan(valorNumerico);
        System.out.println(asd);
      }
      else if (variavelGenerica.getTipo().equals("Double")) {
        Boolean asd1 = HMdouble.get(varName).lessThan(valorNumerico);
        System.out.println(asd1);
      }
      else {
        System.out.println("Malformed Expression. Line: " + (linhaIndex+1));
      }
    }
    else if (operation.equals(KMdict.getValue("smallerOrEquals"))) {
      if (variavelGenerica.getTipo().equals("int")) {
        Boolean asd = HMint.get(varName).lessOrEqualThan(valorNumerico);
        System.out.println(asd);
      }
      else if (variavelGenerica.getTipo().equals("Double")) {
        Boolean asd1 = HMdouble.get(varName).lessOrEqualThan(valorNumerico);
        System.out.println(asd1);
      }
      else {
        System.out.println("Malformed Expression. Line: " + (linhaIndex+1));
      }
    }
    else if (operation.equals(KMdict.getValue("different"))) {
      if (variavelGenerica.getTipo().equals("int")) {
        Boolean asd = HMint.get(varName).diff(valorNumerico);
        System.out.println(asd);
      }
      else if (variavelGenerica.getTipo().equals("Double")) {
        Boolean asd1 = HMdouble.get(varName).diff(valorNumerico);
        System.out.println(asd1);
      }
      else if (variavelGenerica.getTipo().equals("String")) {
        Boolean asd1 = HMstring.get(varName).diff(valorString);
        System.out.println(asd1);
      }
      else if (variavelGenerica.getTipo().equals("Booleano")) {
        Boolean asd1 = HMboolean.get(varName).diff(valorString);
        System.out.println(asd1);
      }
      else {
        System.out.println("Malformed Expression. Line: " + (linhaIndex+1));
      }
    }
    else if (operation.equals(KMdict.getValue("modulo"))) {
      valorNumerico = linha[2].replace(".", "").length();

      if (variavelGenerica.getTipo().equals("int")) {
        int asd = HMint.get(varName).mod(valorNumerico);
        System.out.println(asd);
      }
      else if (variavelGenerica.getTipo().equals("Double")) {
        double asd1 = HMdouble.get(varName).mod(valorNumerico);
        System.out.println(asd1);
      }
      else {
        System.out.println("Malformed Expression. Line: " + (linhaIndex+1));
      }
    }
    else if (operation.equals(KMdict.getValue("power"))) {
      if (variavelGenerica.getTipo().equals("int")) {
        int asd = HMint.get(varName).power(valorNumerico);
        System.out.println(asd);
      }
      else if (variavelGenerica.getTipo().equals("Double")) {
        double asd1 = HMdouble.get(varName).power(valorNumerico);
        System.out.println(asd1);
      }
      else {
        System.out.println("Malformed Expression. Line: " + (linhaIndex+1));
      }
    }
    else if (operation.equals(KMdict.getValue("receives"))) {
      String varName2 = linha[2].replace(".", "");
      /* verifica em qual HashMap a varivel esta contida */
      if (HMint.containsKey(varName2)) {
        variavelGenerica2.setTipo(HMint.get(varName2).getTipo());
      }
      else if (HMdouble.containsKey(varName2)) {
        variavelGenerica2.setTipo(HMdouble.get(varName2).getTipo());
      }
      else if (HMstring.containsKey(varName2)) {
        variavelGenerica2.setTipo(HMstring.get(varName2).getTipo());
      }
      else if (HMboolean.containsKey(varName2)) {
        variavelGenerica2.setTipo(HMboolean.get(varName2).getTipo());
      }

      if (variavelGenerica.getTipo().equals("int")) {
        if (variavelGenerica2.getTipo().equals("int")) {
          HMint.get(varName).setValor(HMint.get(varName2).getValor());
        }
        else if (variavelGenerica2.getTipo().equals("Double")) {
          HMint.get(varName).setValor(HMdouble.get(varName2).getValor());
        }
      }
      else if (variavelGenerica.getTipo().equals("Double")) {
        if (variavelGenerica2.getTipo().equals("int")) {
          HMdouble.get(varName).setValor(HMint.get(varName2).getValor());
        }
        else if (variavelGenerica2.getTipo().equals("Double")) {
          HMdouble.get(varName).setValor(HMdouble.get(varName2).getValor());
        }
      }
      else if (variavelGenerica.getTipo().equals("String")) {
        if (variavelGenerica2.getTipo().equals("int")) {
          HMstring.get(varName).setValor(String.valueOf(HMint.get(varName2).getValor()));
        }
        else if (variavelGenerica2.getTipo().equals("Double")) {
          HMstring.get(varName).setValor(String.valueOf(HMdouble.get(varName2).getValor()));
        }
        else if (variavelGenerica2.getTipo().equals("String")) {
          HMstring.get(varName).setValor(String.valueOf(HMstring.get(varName2).getValor()));
        }
        else if (variavelGenerica2.getTipo().equals("Booleano")) {
          HMstring.get(varName).setValor(String.valueOf(HMboolean.get(varName2).getValor()));
        }
      }
      else if (variavelGenerica.getTipo().equals("Booleano")) {
        if (variavelGenerica2.getTipo().equals("Booleano")) {
          HMboolean.get(varName).setValor(HMboolean.get(varName2).getValor());
        }
      }
      else {
        System.out.println("Malformed Expression. Line: " + (linhaIndex+1));
      }
    }
    else {
      System.out.println("Error at line: " + linhaIndex + " Unknown Expression: " + linha);
    }
  }
}

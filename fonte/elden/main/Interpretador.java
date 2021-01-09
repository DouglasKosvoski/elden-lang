package fonte.elden.main;

import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;

/* importa os tipos primitivos de variaveis */
import fonte.elden.vars.*;
/* importa o dicionario com a chave-valor */
import fonte.elden.main.KeyMap;


public class Interpretador {

  Interpretador() {
    this.setDict();
  }

  /* dicionario com as chaves-valores */
  KeyMap KMdict = new KeyMap();

  /* diferentes HashMap's para salvar cada tipo de variavel */
  HashMap<String, TipoInteiro>  HMint     = new HashMap<String, TipoInteiro>();
  HashMap<String, TipoDouble>   HMdouble  = new HashMap<String, TipoDouble>();
  HashMap<String, TipoString>   HMstring  = new HashMap<String, TipoString>();
  HashMap<String, TipoBooleano> HMboolean = new HashMap<String, TipoBooleano>();


  /* inicializa o dicionario contendo as chaves-valor */
  private void setDict() {
    this.KMdict.createDict();
  }

  /* retorna True caso o primeiro caracter seja Maiusculo e False caso seja Null ou Minusculo  */
  public Boolean startWithUpperCase(String s) {
    if(null == s || s.isEmpty()){
      return false;
    }
    else {
      return (Character.isUpperCase(s.codePointAt(0)));
    }
  }

  /* Retorna False quando a linha esta nos conformes do programa, se nao retorna True */
  public Boolean verificaContinuidadeLinha(String linha) {
    return (linha.startsWith("//") || linha.endsWith(".") == false || linha.length() < 1);
  }

  /* responsavel por realizar todas as funcoes matematicas
  como por exemplo: adicao, subtracao, multiplicacao, divisao e comparacoes */
  public void mathOperations(String[] linha, int linhaIndex) {
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

    if(linha[2].equals("unlike")) {
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
        this.HMint.get(varName).Increase(valorNumerico);
      }
      else if (variavelGenerica.getTipo().equals("Double")) {
        this.HMdouble.get(varName).Increase(valorNumerico);
      }
      else {
        System.out.println(variavelGenerica.getTipo() + " does not support 'Ascend' operation");
      }
    }
    else if (operation.equals(KMdict.getValue("subtraction"))) {
      if (variavelGenerica.getTipo().equals("int")) {
        this.HMint.get(varName).Decrease(valorNumerico);
      }
      else if (variavelGenerica.getTipo().equals("Double")) {
        this.HMdouble.get(varName).Decrease(valorNumerico);
      }
      else {
        System.out.println(variavelGenerica.getTipo() + " does not support 'Descend' operation");
      }
    }
    else if (operation.equals(KMdict.getValue("multiplication"))) {
      if (variavelGenerica.getTipo().equals("int")) {
        this.HMint.get(varName).Multiply(valorNumerico);
      }
      else if (variavelGenerica.getTipo().equals("Double")) {
        this.HMdouble.get(varName).Multiply(valorNumerico);
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
        this.HMint.get(varName).Divide(valorNumerico);
      }
      else if (variavelGenerica.getTipo().equals("Double")) {
        this.HMdouble.get(varName).Divide(valorNumerico);
      }
      else {
        System.out.println(variavelGenerica.getTipo() + " does not support 'Weaken' operation");
      }
    }
    else if (operation.equals(KMdict.getValue("comparision"))) {
      if (variavelGenerica.getTipo().equals("int")) {
        Boolean asd = this.HMint.get(varName).Compare(valorString.length());
        System.out.println(asd);
      }
      else if (variavelGenerica.getTipo().equals("Double")) {
        Boolean asd1 = this.HMdouble.get(varName).Compare(valorString.length());
        System.out.println(asd1);
      }
      else if (variavelGenerica.getTipo().equals("String")) {
        Boolean asd2 = this.HMstring.get(varName).Compare(valorString);
        System.out.println(asd2);
      }
      else if (variavelGenerica.getTipo().equals("Booleano")) {
        Boolean asd3 = this.HMboolean.get(varName).Compare(valorString);
        System.out.println(asd3);
      }
      else {
        System.out.println("Malformed Expression. Line: " + (linhaIndex+1));
      }
    }
    else if (operation.equals(KMdict.getValue("greaterThan"))) {
      if (variavelGenerica.getTipo().equals("int")) {
        Boolean asd = this.HMint.get(varName).biggerThan(valorNumerico);
        System.out.println(asd);
      }
      else if (variavelGenerica.getTipo().equals("Double")) {
        Boolean asd1 = this.HMdouble.get(varName).biggerThan(valorNumerico);
        System.out.println(asd1);
      }
      else {
        System.out.println("Malformed Expression. Line: " + (linhaIndex+1));
      }
    }
    else if (operation.equals(KMdict.getValue("greaterOrEquals"))) {
      if (variavelGenerica.getTipo().equals("int")) {
        Boolean asd = this.HMint.get(varName).biggerOrEqualThan(valorNumerico);
        System.out.println(asd);
      }
      else if (variavelGenerica.getTipo().equals("Double")) {
        Boolean asd1 = this.HMdouble.get(varName).biggerOrEqualThan(valorNumerico);
        System.out.println(asd1);
      }
      else {
        System.out.println("Malformed Expression. Line: " + (linhaIndex+1));
      }
    }
    else if (operation.equals(KMdict.getValue("smallerThan"))) {
      if (variavelGenerica.getTipo().equals("int")) {
        Boolean asd = this.HMint.get(varName).lessThan(valorNumerico);
        System.out.println(asd);
      }
      else if (variavelGenerica.getTipo().equals("Double")) {
        Boolean asd1 = this.HMdouble.get(varName).lessThan(valorNumerico);
        System.out.println(asd1);
      }
      else {
        System.out.println("Malformed Expression. Line: " + (linhaIndex+1));
      }
    }
    else if (operation.equals(KMdict.getValue("smallerOrEquals"))) {
      if (variavelGenerica.getTipo().equals("int")) {
        Boolean asd = this.HMint.get(varName).lessOrEqualThan(valorNumerico);
        System.out.println(asd);
      }
      else if (variavelGenerica.getTipo().equals("Double")) {
        Boolean asd1 = this.HMdouble.get(varName).lessOrEqualThan(valorNumerico);
        System.out.println(asd1);
      }
      else {
        System.out.println("Malformed Expression. Line: " + (linhaIndex+1));
      }
    }
    else if (operation.equals(KMdict.getValue("different"))) {
      if (variavelGenerica.getTipo().equals("int")) {
        Boolean asd = this.HMint.get(varName).diff(valorNumerico);
        System.out.println(asd);
      }
      else if (variavelGenerica.getTipo().equals("Double")) {
        Boolean asd1 = this.HMdouble.get(varName).diff(valorNumerico);
        System.out.println(asd1);
      }
      else if (variavelGenerica.getTipo().equals("String")) {
        Boolean asd1 = this.HMstring.get(varName).diff(valorString);
        System.out.println(asd1);
      }
      else if (variavelGenerica.getTipo().equals("Booleano")) {
        Boolean asd1 = this.HMboolean.get(varName).diff(valorString);
        System.out.println(asd1);
      }
      else {
        System.out.println("Malformed Expression. Line: " + (linhaIndex+1));
      }
    }
    else if (operation.equals(KMdict.getValue("modulo"))) {
      valorNumerico = linha[2].replace(".", "").length();

      if (variavelGenerica.getTipo().equals("int")) {
        int asd = this.HMint.get(varName).mod(valorNumerico);
        System.out.println(asd);
      }
      else if (variavelGenerica.getTipo().equals("Double")) {
        double asd1 = this.HMdouble.get(varName).mod(valorNumerico);
        System.out.println(asd1);
      }
      else {
        System.out.println("Malformed Expression. Line: " + (linhaIndex+1));
      }
    }
    else if (operation.equals(KMdict.getValue("power"))) {
      if (variavelGenerica.getTipo().equals("int")) {
        int asd = this.HMint.get(varName).power(valorNumerico);
        System.out.println(asd);
      }
      else if (variavelGenerica.getTipo().equals("Double")) {
        double asd1 = this.HMdouble.get(varName).power(valorNumerico);
        System.out.println(asd1);
      }
      else {
        System.out.println("Malformed Expression. Line: " + (linhaIndex+1));
      }
    }
    else if (operation.equals(KMdict.getValue("receives"))) {
      String varName2 = linha[2].replace(".", "");
      /* verifica em qual HashMap a varivel esta contida */
      if (this.HMint.containsKey(varName2)) {
        variavelGenerica2.setTipo(this.HMint.get(varName2).getTipo());
      }
      else if (this.HMdouble.containsKey(varName2)) {
        variavelGenerica2.setTipo(this.HMdouble.get(varName2).getTipo());
      }
      else if (this.HMstring.containsKey(varName2)) {
        variavelGenerica2.setTipo(this.HMstring.get(varName2).getTipo());
      }
      else if (this.HMboolean.containsKey(varName2)) {
        variavelGenerica2.setTipo(this.HMboolean.get(varName2).getTipo());
      }

      if (variavelGenerica.getTipo().equals("int")) {
        if (variavelGenerica2.getTipo().equals("int")) {
          this.HMint.get(varName).setValor(this.HMint.get(varName2).getValor());
        }
        else if (variavelGenerica2.getTipo().equals("Double")) {
          this.HMint.get(varName).setValor(this.HMdouble.get(varName2).getValor());
        }
      }
      else if (variavelGenerica.getTipo().equals("Double")) {
        if (variavelGenerica2.getTipo().equals("int")) {
          this.HMdouble.get(varName).setValor(this.HMint.get(varName2).getValor());
        }
        else if (variavelGenerica2.getTipo().equals("Double")) {
          this.HMdouble.get(varName).setValor(this.HMdouble.get(varName2).getValor());
        }
      }
      else if (variavelGenerica.getTipo().equals("String")) {
        if (variavelGenerica2.getTipo().equals("int")) {
          this.HMstring.get(varName).setValor(String.valueOf(this.HMint.get(varName2).getValor()));
        }
        else if (variavelGenerica2.getTipo().equals("Double")) {
          this.HMstring.get(varName).setValor(String.valueOf(this.HMdouble.get(varName2).getValor()));
        }
        else if (variavelGenerica2.getTipo().equals("String")) {
          this.HMstring.get(varName).setValor(String.valueOf(this.HMstring.get(varName2).getValor()));
        }
        else if (variavelGenerica2.getTipo().equals("Booleano")) {
          this.HMstring.get(varName).setValor(String.valueOf(this.HMboolean.get(varName2).getValor()));
        }
      }
      else if (variavelGenerica.getTipo().equals("Booleano")) {
        if (variavelGenerica2.getTipo().equals("Booleano")) {
          this.HMboolean.get(varName).setValor(this.HMboolean.get(varName2).getValor());
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

  /* metodo responsavel pela identificacao das palavras-chaves
  para que as variaveis possam ser declaradas, inicializadas
  e tambem alguns outros metodos estaticos */
  public void variableMethods(String[] linha, int linhaIndex) {
    linhaIndex += 1;
    String method = linha[0];
    String tipo, varName;

    /* responsavel por indentificar qual metodo esta sendo executado
    seja declaracao, inicializacao ou mesmo print */
    if (method.equals("summon")) {
      tipo = linha[1];
      varName = linha[2].replace(".", "");

      if (tipo.equals("int")) {
        TipoInteiro intVar = new TipoInteiro();
        intVar.setNome(varName);
        this.HMint.put(varName, intVar);
      }
      else if (tipo.equals("double")) {
        TipoDouble doubleVar = new TipoDouble();
        doubleVar.setNome(varName);
        this.HMdouble.put(varName, doubleVar);
      }
      else if (tipo.equals("string")) {
        TipoString stringVar = new TipoString();
        stringVar.setNome(varName);
        this.HMstring.put(varName, stringVar);
      }
      else if (tipo.equals("boolean")) {
        TipoBooleano booleanVar = new TipoBooleano();
        booleanVar.setNome(varName);
        this.HMboolean.put(varName, booleanVar);
      }
    }
    // Variable Inicialization
    else if (method.equals("cast")) {
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
    }
    // Print Variable Value
    else if (method.equals("reveal")) {
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
    }
    // Recebe um imput do teclado
    else if (method.equals("input")) {
      varName = linha[1].replace(".", "");
      Scanner keyboard = new Scanner(System.in);
      String asd = keyboard.nextLine();

      if (this.HMint.containsKey(varName)) {
        this.HMint.get(varName).setValor(asd);
      }
      else if (this.HMdouble.containsKey(varName)) {
        this.HMdouble.get(varName).setValor(asd);
      }
      else if (this.HMstring.containsKey(varName)) {
        this.HMstring.get(varName).setValor(asd);
      }
      else if (this.HMboolean.containsKey(varName)) {
        this.HMboolean.get(varName).setValor(asd);
      }
      else {
        System.out.println("Unexpected '" + varName + "' | Line: " + linhaIndex);
      }
    }
    else {
      System.out.println("Error at line: " + linhaIndex + " | " + linha);
    }
  }

  /* metodo principal responsavel por fazer a chamada de todos os outros
  metodos em tempo de execucao, como verificacoes, manipulacoes e operacoes*/
  public void interpreta(ArrayList conteudoAnalisado) {
    /* quatidade de linhas do arquivo passado ao programa e que sera interpretado */
    int tamanho = conteudoAnalisado.size();

    /* looping que passa por todas as linhas do arquivo passado */
    for(int linhaNumero = 0; linhaNumero < tamanho; linhaNumero++) {
      /* pega as linhas do ArrayList a partir de um indice passado */
      String linha = String.valueOf(conteudoAnalisado.get(linhaNumero));
      /* separa essa linha passada em uma sublista onde o separador em o espaco em branco */
      String[] linhaSplit = linha.split(" ");

      // verifica se eh ou nao uma linha comentada por '//', se termina em '.'
      if(verificaContinuidadeLinha(linha)) continue;

      /* se a linha comeca com letra maiucula, significa que eh uma variavel
      entao metodos aritmeticos sao chamados */
      if(startWithUpperCase(linhaSplit[0])) {
        mathOperations(linhaSplit, linhaNumero);
        continue;
      }

      /* se o programa chegou ate aqui significa que nao estamos trabalhando com
      uma expressao aritimetica mas sim, algum caso de declaracao, inicializacao de variavel */
      variableMethods(linhaSplit, linhaNumero);
    }
  }
}

package fonte.elden.main;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.io.File;

/* importa os tipos primitivos de variaveis */
import fonte.elden.vars.*;
/* importa o dicionario com a chave-valor */
import fonte.elden.main.KeyMap;

public class Leitor {
  /*  String com o nome do arquivo passado */
  private String filename;
  /* conteudo bruto do arquivo passado */
  private Scanner conteudo;

  /* dicionario com as chaves-valores */
  KeyMap KMdict = new KeyMap();

  /* ArrayList com o conteudo de Strings, analisado a partir do Scanner com o conteudo bruto */
  ArrayList<String> conteudoAnalisado = new ArrayList<String>();

  /* diferentes HashMap's para salvar cada tipo de variavel */
  HashMap<String, TipoInteiro>  HMint     = new HashMap<String, TipoInteiro>();
  HashMap<String, TipoDouble>   HMdouble  = new HashMap<String, TipoDouble>();
  HashMap<String, TipoString>   HMstring  = new HashMap<String, TipoString>();
  HashMap<String, TipoBooleano> HMboolean = new HashMap<String, TipoBooleano>();

  // Constructors
  public Leitor(String filename) {
    this.setNomeDoArquivo(filename);
    this.setConteudo();
    this.analisaScanner();
    this.setDict(this.KMdict);
  }

  /* modifica a variavel para armazenar o nome do arquivo (String) */
  private void setNomeDoArquivo(String filename) {
    this.filename = filename;
  }

  /* cria ou carrega um arquivo a partir do argumento passado */
  private void setConteudo() {
    this.conteudo = new Scanner(this.filename);
  }

  /* inicializa o dicionario contendo as chaves-valor */
  private void setDict(KeyMap d) {
    d.createDict();
  }

  /* retorna uma String com o nome do arquivo passado ao programa */
  public String getNomeDoArquivo() {
    return this.filename;
  }

  /* retorna um Scanner com o conteudo bruto do arquivo passado */
  public Scanner getConteudo() {
    return this.conteudo;
  }

  /* retorna um ArrayList com o conteudo (strings) */
  public ArrayList getConteudoAnalisado() {
    return this.conteudoAnalisado;
  }

  /* analisa a partir do Scanner o seu conteudo e entao salva em uma variavel
  para entao ser utilizada no decorrer da execucao do programa */
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

    /* switch-case responsavel por identificar a expressao aritmetica */
    switch(operation) {
      /* Ascend (Adicao) eh suportado apenas pelos tipos Inteiros e Doubles */
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

      /* Descend (subtracao) eh suportado apenas pelos tipos Inteiros e Doubles */
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

      /* Strengthen (multiplicacao) eh suportado apenas pelos tipos Inteiros e Doubles */
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

      /* Weaken (divisao) eh suportado apenas pelos tipos Inteiros e Doubles */
      case "weaken":
        /* evita divisao por zero */
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

      /* Matches (comparacao) eh suportada por todos os tipos primitivos de variaveis */
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

      /* se nenhuma expressao foi condizente */
      default:
        System.out.println("Error at line: " + linhaIndex + " Unknown Expression: " + linha);
        break;
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

  /* metodo principal responsavel por fazer a chamada de todos os outros
  metodos em tempo de execucao, como verificacoes, manipulacoes e operacoes*/
  public void interpreta() {
    /* quatidade de linhas do arquivo passado ao programa e que sera interpretado */
    int tamanho = this.conteudoAnalisado.size();

    /* looping que passa por todas as linhas do arquivo passado */
    for(int linhaNumero = 0; linhaNumero < tamanho; linhaNumero++) {
      /* pega as linhas do ArrayList a partir de um indice passado */
      String linha = this.conteudoAnalisado.get(linhaNumero);
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

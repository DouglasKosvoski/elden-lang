package fonte.elden.main;

import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;

/* importa os tipos primitivos de variaveis */
import fonte.elden.vars.*;
/* importa o dicionario com a chave-valor */
import fonte.elden.main.KeyMap;
import fonte.elden.main.Estatico;
import fonte.elden.main.Aritmetico;

public class Interpretador {
  private Estatico estatico = new Estatico();
  private Aritmetico aritmetico = new Aritmetico();

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

      /* se a linha comeca com letra maiuscula, significa que eh uma variavel
      entao metodos aritmeticos serao chamados */
      String retornoA = "";
      String retornoV = "";

      if(startWithUpperCase(linhaSplit[0])) {
        retornoA = this.aritmetico.mathOperations(KMdict, HMint, HMdouble, HMstring, HMboolean, linhaSplit, linhaNumero);

        if (!retornoA.equals("")) {
          System.out.println("IF FOI VERDADEIRO");
        }
        continue;
      }

      /* se o programa chegou ate aqui significa que nao estamos trabalhando com
      uma expressao aritimetica mas sim, algum caso de declaracao, inicializacao de variavel */
      retornoV = this.estatico.variableMethods(KMdict, HMint, HMdouble, HMstring, HMboolean, linhaSplit, linhaNumero);
      if (!retornoV.equals("")) {
        retornoA = this.aritmetico.mathOperations(KMdict, HMint, HMdouble, HMstring, HMboolean, retornoV.split(" "), linhaNumero);
        System.out.println(retornoA);
      }
    }
  }
}

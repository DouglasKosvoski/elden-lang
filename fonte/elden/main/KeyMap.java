package fonte.elden.main;

import java.util.HashMap;

/*
  Classe responsável pela configuração chave-valor de todas as keywords utilizadas
  na elden-lang.

  Motivação: visando o crescimento e expansão da linguagem para outros idiomas,
  a facilidade de acesso e acessibilidade se resume em apenas traduzir essas
  keywords pré-definidas para o idioma em questão.

  Métodos suportados:
    createDict // adiciona os valores ao HashMap
    getValue   // retorna o valor a partir da chave passada
    getHashMap // retorna todo o HashMap

  Chamada pelo Interpretador.

  @autor Douglas Kosvoski <douglas.contactpro@gmail.com>.
*/

public class KeyMap {
  /* HashMap que sera utilizado como dicionario ao longo da execucao */
  private HashMap<String, String>  HMkeymap = new HashMap<String, String>();

  /* adiciona todos os valores ao dicionario */
  public void createDict() {
    /* primitive types */
    this.HMkeymap.put("tInt", "int");
    this.HMkeymap.put("tDouble", "double");
    this.HMkeymap.put("tString", "string");
    this.HMkeymap.put("tBool",   "boolean");

    /* math operations */
    this.HMkeymap.put("addition",       "ascend");
    this.HMkeymap.put("subtraction",    "descend");
    this.HMkeymap.put("multiplication", "strengthen");
    this.HMkeymap.put("division",       "weaken");
    this.HMkeymap.put("comparision",    "matches");

    this.HMkeymap.put("greaterThan",    "stronger");
    this.HMkeymap.put("greaterOrEquals","stronger_or_equivalent");

    this.HMkeymap.put("smallerThan",    "weaker");
    this.HMkeymap.put("smallerOrEquals","weaker_or_equivalent");

    this.HMkeymap.put("different",      "unlike");
    this.HMkeymap.put("modulo",         "residual");
    this.HMkeymap.put("power",          "powered");

    /* static methods */
    this.HMkeymap.put("declaration",    "summon");
    this.HMkeymap.put("inicialization", "cast");
    this.HMkeymap.put("print",          "reveal");
    this.HMkeymap.put("input",          "input");
    this.HMkeymap.put("receives",       "obtain");
  }

  /* retorna uma String a partir da chave passada*/
  public String getValue(String key) {
    return HMkeymap.get(key);
  }

  /* retorna o HashMap contendo todo os chaves-valores*/
  public HashMap getHashMap() {
    return this.HMkeymap;
  }
}

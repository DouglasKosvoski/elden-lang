package fonte.elden.main;

import java.util.HashMap;

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

    /* static methods */
    this.HMkeymap.put("declaration",    "summon");
    this.HMkeymap.put("inicialization", "cast");
    this.HMkeymap.put("print",          "reveal");
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

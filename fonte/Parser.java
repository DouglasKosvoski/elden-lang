import java.util.ArrayList;

public class Parser {

  ArrayList<String> conteudo = new ArrayList<String>();

  public Parser() {

  }

  public Parser(ArrayList conteudo) {
    this.conteudo = conteudo;
    this.format(conteudo);
  }

  public void show() {
    if(this.conteudo != null) {
      System.out.println(this.conteudo);
    } else {
      System.out.println("Conteudo n especificado");
    }
  }

  private void format(ArrayList expression) {
    ArrayList[][] linhas = new ArrayList[][];

    System.out.println(expression.size());
    for(int i = 0; i < expression.size(); i++) {
      //System.out.println("i:" + i + " " + expression.get(i));
      linhas.add(expression.get(i));
      // String pedacos = expression.replaceAll(" ", "");
    }

    System.out.println("sizeI:" + expression.size());
    System.out.println("sizeJ:" + expression.size());
    // for(int i = 0; i < expression.size(); i++) {
    //   for(int j = 0; j < expression.get(i).size(); j++) {
    //     System.out.println("i:" + i + " " + expression.get(i).get(j));
    //   }
    // }
       // "summon   var    cast as 6"
    // [["summon", "var", "cast", "as", "6"],
    // ["summon", "var", "cast", "as", "6"],
    // ["summon", "var", "cast", "as", "6"],
    // ["summon", "var", "cast", "as", "6"]]


    // Creating array of string length
    // char[] c = new char[pedacos.length()];
    // for (int i = 0; i < pedacos.length(); i++) {
    //     c[i] = pedacos.charAt(i);
    // }

    // if (line.contains("summon")){
    //   System.out.println("Creating a variable");
    //   Variable n = new Variable();
    //   String Line = n.createVariable(line);
    //   System.out.println(Line);
    //
    // } else {
    //   System.out.println("Summon was not there...");
    }
}

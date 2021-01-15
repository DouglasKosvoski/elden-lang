package fonte.elden.vars;

/*
  Classe responsável pela variável primitiva Booleana, extende a classe mãe Variavel.

  Chamada por outras classes como:
    Interpretador, Aritmético e Estático.

  Métodos suportados:
    getValor, setValor, ==, !=.

  Valor Default:
    false.

  @autor Guilherme Nerling <guilherme.devon@hotmail.com>.
*/

public class TipoBooleano extends Variavel {
  private boolean valorLogico;

  // Construtor
  public TipoBooleano() {
    super("undefined", "Booleano");
    this.setValor(false);
  }
  public TipoBooleano(String nome, String valorLogico) {
    super(nome, "Booleano");
    this.setValor(valorLogico);
  }

  // Getters
  public boolean getValor() {
    return this.valorLogico;
  }

  // Setters
  public void setValor(Boolean valorLogico) {
    this.valorLogico = valorLogico;
  }
  public void setValor(String valorLogico) {
    this.valorLogico = Boolean.parseBoolean(valorLogico);
  }

  public Boolean Compare(String s) {
    return (this.valorLogico == Boolean.parseBoolean(s));
  }
  public Boolean diff(String s) {
    return !(this.valorLogico == Boolean.parseBoolean(s));
  }
}

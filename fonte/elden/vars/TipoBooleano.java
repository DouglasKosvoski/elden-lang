package fonte.elden.vars;

public class TipoBooleano extends Variavel {
  private boolean valorLogico;

  // Construtor
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
}

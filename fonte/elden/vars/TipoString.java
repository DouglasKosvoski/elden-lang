package fonte.elden.vars;

public class TipoString extends Variavel {
	private String valor;

	// Construtor
  public TipoString(String nome, String valor) {
    super(nome, "String");
		this.setValor(valor);
  }
  public TipoString(String nome) {
    super(nome, "String");
		this.setValor(null);
  }

	// Setters
  public void setValor(String valor) {
    this.valor = valor;
  }

	// Getters
	public String getValor() {
		return this.valor;
	}
}

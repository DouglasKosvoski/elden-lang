package fonte.elden.vars;

public class TipoDouble extends Variavel {
	private double value;

	// Construtor
  public TipoDouble(String nome) {
		super(nome, "Double");
		this.setValor(0);
  }
  public TipoDouble(String nome, int valor) {
		super(nome, "Double");
		this.setValor(valor);
  }
  public TipoDouble(String nome, double valor) {
		super(nome, "Double");
		this.setValor(valor);
  }
  public TipoDouble(String nome, String valor) {
		super(nome, "Double");
		this.setValor(valor);
  }

	// Getters
  public double getValor() {
    return this.value;
  }

	// Setters
	public void setValor(String valor) {
		this.value = Double.parseDouble(valor);
	}
	public void setValor(double valor) {
		this.value = valor;
	}
}

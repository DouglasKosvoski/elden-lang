package fonte.elden.vars;

public class TipoDouble extends Variavel {
	private double valor;

	// Construtor
  public TipoDouble() {
		super("undefined", "Double");
		this.setValor(0);
  }
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
    return this.valor;
  }

	// Setters
	public void setValor(String valor) {
		this.valor = Double.parseDouble(valor);
	}
	public void setValor(double valor) {
		this.valor = valor;
	}

  public void Increase(double a) {
    this.setValor(this.valor + a);
  }
  public void Decrease(double a) {
    this.setValor(this.valor - a);
  }
  public void Multiply(double a) {
    this.setValor(this.valor * a);
  }
  public void Divide(double a) {
    this.setValor(this.valor / a);
  }
  public Boolean Compare(int a) {
    return (this.valor == a);
  }
  public Boolean Compare(double a) {
    return (this.valor == a);
  }

}

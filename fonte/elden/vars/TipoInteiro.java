package fonte.elden.vars;

public class TipoInteiro extends Variavel {
	private int valor;

	// Construtor
  public TipoInteiro() {
    super();
		this.setValor(0);
		this.setTipo("int");
  }
  public TipoInteiro(String nome) {
    super(nome, "Inteiro");
		this.setValor(0);
  }
  public TipoInteiro(String nome, String valor) {
    super(nome, "Inteiro");
		this.setValor(valor);
  }
  public TipoInteiro(String nome, int valor) {
    super(nome, "Inteiro");
		this.setValor(valor);
  }

	// Setters
	public void setValor(String valor) {
		this.valor = Integer.parseInt(valor);
	}
	public void setValor(int valor) {
		this.valor = valor;
	}

	// Getters
  public int getValor() {
    return this.valor;
  }

  public void Increase(int a) {
    this.setValor(this.valor + a);
  }
  public void Decrease(int a) {
    this.setValor(this.valor - a);
  }
  public void Multiply(int a) {
    this.setValor(this.valor * a);
  }
  public void Divide(int a) {
    this.setValor(this.valor / a);
  }
  public Boolean Compare(int a) {
    return (this.valor == a);
  }
  public Boolean Compare(double a) {
    return (this.valor == a);
  }

}

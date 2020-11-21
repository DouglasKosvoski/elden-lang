package fonte.elden.vars;

public class TipoInteiro extends Variavel {
	private int valor;

	// Construtor
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
}

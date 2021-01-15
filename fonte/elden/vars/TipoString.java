package fonte.elden.vars;

/*
  Classe responsável pela variável primitiva String, extende a classe mãe Variavel.

  Chamada por outras classes como:
    Interpretador, Aritmético e Estático.

  Métodos suportados:
    getValor, setValor, ==, !=.

  Valor Default:
    "".

  @autor Guilherme Nerling <guilherme.devon@hotmail.com>.
*/

public class TipoString extends Variavel {
	private String valor;

	// Construtor
  public TipoString() {
    super("undefined", "String");
		this.setValor(null);
  }
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

  public Boolean Compare(String s) {
    return (this.valor.equals(s));
  }
  public Boolean diff(String s) {
    return (!this.valor.equals(s));
  }
}

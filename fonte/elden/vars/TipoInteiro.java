package fonte.elden.vars;

import java.lang.Math;

/*
  Classe responsável pela variável primitiva Int, extende a classe mãe Variavel.

  Chamada por outras classes como:
    Interpretador, Aritmético e Estático.

  Métodos suportados:
    getValor, setValor, +, -, *, /, ==, >, >=, <, <=, !=, %, ^.

  Valor Default:
    0.

  @autor Guilherme Nerling <guilherme.devon@hotmail.com>.
*/

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
	public void setValor(double valor) {
		this.valor = (int) valor;
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

  public Boolean biggerThan(int a) {
    return (this.valor > a);
  }
  public Boolean biggerOrEqualThan(int a) {
    return (this.valor >= a);
  }
  public Boolean lessThan(int a) {
    return (this.valor < a);
  }
  public Boolean lessOrEqualThan(int a) {
    return (this.valor <= a);
  }
  public Boolean diff(int a) {
    return (this.valor != a);
  }
  public int mod(int a) {
    return (this.valor % a);
  }
  public int power(int a) {
    return ((int) Math.pow(this.valor, a));
  }
}

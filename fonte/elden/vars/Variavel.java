package fonte.elden.vars;

public class Variavel {
  private String nome;
  private String tipo;

  public Variavel() {
    this.setTipo("undefined");
    this.setNome("undefined");
  }
  public Variavel(String nome, String tipo) {
    this.setTipo(tipo);
    this.setNome(nome);
  }

  // getters
  public String getNome() {
    return this.nome;
  }
  public String getTipo() {
    return this.tipo;
  }

  // setters
  public void setNome(String setNome) {
    this.nome = setNome;
  }
  public void setTipo(String tipo) {
    this.tipo = tipo;
  }
}

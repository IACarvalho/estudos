public class ControleBonificacao {
  private double bionificaGeral;

  public void registra(Funcionario funcionario) {
    double bonificacao = funcionario.getBonificacao();
    this.bionificaGeral += bonificacao;
  }

  public double getBonificaoGeral() {
    return this.bionificaGeral;
  }
}

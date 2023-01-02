public class ContaConrrente extends Conta {

  public ContaConrrente(int agencia, int numero, Cliente titular) {
    super(agencia, numero, titular);
  }
  
  @Override
  public boolean sacar(double valor) {
    return super.sacar((valor + 0.2));
  }
}

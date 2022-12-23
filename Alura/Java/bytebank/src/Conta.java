public class Conta {
  private double saldo;
  private int agencia;
  private int numero;
  private Cliente titular;
  private  static int totalDeContas;

  public Conta(int agencia, int numero, Cliente titular){
    if(agencia > 0){
      this.agencia = agencia;
    }
    else this.agencia = 1;

    if(numero > 0){
      this.numero = numero;
    }
    else this.numero = 1;

    this.titular = titular;
    totalDeContas++;
  }

  public void depositar(double valor) {
    this.saldo += valor;
  }

  public boolean sacar(double valor) {
    if(this.saldo >= valor){
      this.saldo -= valor;
      return true;
    }

    return false;
  }

  public double getSaldo() {
    return this.saldo;
  }

  public boolean transferir(double valor, Conta conta){
    if(this.saldo >= valor){
      this.saldo -= valor;
      conta.depositar(valor);
      return true;
    }
    
    return false;
  }

  public int getAgencia() {
    return this.agencia;
  }

  public void setAgencia(int agencia) throws Exception{
    if(agencia <= 0)
      throw new Exception("Número da agência não pode ser menor ou igual a 0");
    this.agencia = agencia;
  }

  public int getNumero() {
    return this.numero;
  }

  public void setNumero(int numero) throws Exception{
    if(numero <= 0)
      throw new Exception("Número da conta não pode ser menor ou igual a 0");
    this.numero = numero;
  }

  public Cliente getTitular() {
    return this.titular;
  }
  
  public static int getTotalDeContas() {
    return Conta.totalDeContas;
  }
}

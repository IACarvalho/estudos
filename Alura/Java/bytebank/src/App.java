public class App {
  public static void main(String[] args) {
    Cliente cliente = new Cliente();
    Conta conta = new Conta(0, 1, cliente);
    ContaConrrente contaCorrente = new ContaConrrente(0, 1, cliente);
    ContaPoupanca contaPoupanca = new ContaPoupanca(0, 1, cliente);

    cliente.setNome("Israel Afonso");

    conta.depositar(1500);
    contaCorrente.depositar(100.0);
    contaPoupanca.depositar(800.0);

    conta.transferir(500, contaPoupanca);
    contaPoupanca.transferir(250, contaCorrente);
    contaCorrente.transferir(100, conta);

    System.out.println("Conta: " + conta.getSaldo());
    System.out.println("Conta Poupança: " + contaPoupanca.getSaldo());
    System.out.println("Conta Corrente: " + contaCorrente.getSaldo());

  }
}

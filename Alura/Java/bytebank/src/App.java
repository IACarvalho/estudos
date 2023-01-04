public class App {
  public static void main(String[] args) {
    Cliente cliente = new Cliente();
    ContaConrrente contaCorrente = new ContaConrrente(0, 1, cliente);
    ContaPoupanca contaPoupanca = new ContaPoupanca(0, 1, cliente);

    cliente.setNome("Israel Afonso");

    contaCorrente.depositar(100.0);
    contaPoupanca.depositar(800.0);

    contaPoupanca.transferir(250, contaCorrente);

    System.out.println("Conta Poupança: " + contaPoupanca.getSaldo());
    System.out.println("Conta Corrente: " + contaCorrente.getSaldo());

  }
}

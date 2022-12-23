public class App {
  public static void main(String[] args) {
    Cliente cliente = new Cliente();
    Conta conta = new Conta(0, 1, cliente);
    Conta conta2 = new Conta(0, 1, cliente);
    Conta conta3 = new Conta(0, 1, cliente);

    cliente.setNome("Israel Afonso");

    conta.depositar(1500);

    System.out.println(conta.getSaldo());
    System.out.println(conta.getTitular().getNome());
    System.out.println(Conta.getTotalDeContas());

  }
}

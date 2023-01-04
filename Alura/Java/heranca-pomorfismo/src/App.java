public class App {
  public static void main(String[] args) {
    
    Funcionario gerente = new Gerente();
    gerente.setNome("Fulano");
    gerente.setSalario(5000.0);

    Funcionario funcionario = new Funcionario();
    funcionario.setSalario(3500);

    Funcionario editorDeVideo = new EditorDeVideo();
    editorDeVideo.setSalario(4000);

    ControleBonificacao controleBonificacao = new ControleBonificacao();
    controleBonificacao.registra(gerente);
    controleBonificacao.registra(funcionario);
    controleBonificacao.registra(editorDeVideo);

    System.out.println(controleBonificacao.getBonificaoGeral());
  }
}

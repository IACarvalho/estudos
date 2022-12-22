public class App {
    public static void main(String[] args) throws Exception {
        int idade;

        idade = 30;
        System.out.println(idade);

        double salario = 1250.9;
        System.out.println(salario);

        // casting
        int valorIntereiDoSalario = (int)salario;
        System.out.println(valorIntereiDoSalario);

        String nome = "Israel Afonso";
        System.out.println(nome);

        if(idade >= 18){
            System.out.println("Pode entrar no clube!");
            System.out.println(nome + ", seja bem-vindo");
        }
        else System.out.println("Espere alguns anos, garoto");

        int contador = 0;
        while(contador <= 10){
            System.out.println(contador);
            contador++;
        }
        System.out.println(contador);
    }
}

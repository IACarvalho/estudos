import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        boolean continueLoop = true;

        while(continueLoop) {
            String a = JOptionPane.showInputDialog("Numerador: ");
            String b = JOptionPane.showInputDialog("Denominador: ");

            try {
                int resultado = dividir(Integer.parseInt(a), Integer.parseInt(b));
                JOptionPane.showMessageDialog(null, "Resultado: " + resultado);
                continueLoop = false;
            } 
            catch(NumberFormatException ex) {
                ex.printStackTrace();
                String errorMessage = "Erro: " + ex.getMessage();
                JOptionPane.showMessageDialog(null, errorMessage);
            }
            catch(ArithmeticException ex) {
                ex.printStackTrace();
                String errorMessage = "Erro: " + ex.getMessage();
                JOptionPane.showMessageDialog(null, "Impossível dividir um número por 0! \n" + errorMessage);
            }
            finally {
                System.out.println("Finally acabou");
            }
        }
    }

    public static int dividir(int a, int b) {
        return a / b;
    }
}

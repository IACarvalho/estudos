public class PersonalizedException2 {
  public static void main(String[] args) {
    int[] numerador = {4, 5, 8, 10};
    int[] denominador = {2, 4, 0, 2, 8};

    for (int i = 0; i < denominador.length; i++) {

      try {
        if(numerador[i] % 2 != 0) 
          throw new DivisaoNaoExataException("Divião não exata!", numerador[i], denominador[i]);

        int resultado = numerador[i] / denominador[i];
        System.out.println(resultado);
      }
      catch (DivisaoNaoExataException ex) {
        System.out.println(ex.getMessage());
      }
      catch(ArithmeticException ex) {
        System.out.println(ex.getMessage());
      }
      catch(ArrayIndexOutOfBoundsException ex) {
        System.out.println(ex.getMessage());
      }

      System.out.println("O programa continua");
    }
  }
}

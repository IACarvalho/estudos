import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.swing.JOptionPane;

public class CheckedException {
  public static void main(String[] args) {
    String nomedDoArquivo = "teste.txt";
    try {
      imprimirArquivoNoConsole(nomedDoArquivo);
    }
    catch(FileNotFoundException ex) {
      JOptionPane.showMessageDialog(null, "Revise o nome do arquivo. \n" + ex.getCause());
      ex.printStackTrace();
    }
    catch(IOException ex) {
      JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado \nErro: " + ex.getCause());
      ex.printStackTrace();
    }

    System.out.println("Apesar da exception ou não, o programa continua...");
  }

  public static void imprimirArquivoNoConsole(String nomeDoArquivo) throws IOException{
    File file = new File(nomeDoArquivo);

    BufferedReader br = new BufferedReader(new FileReader(file.getName()));
    String line = br.readLine();

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    do {
      bw.write(line);
      bw.newLine();
      line=br.readLine();
    } while(line != null);
    bw.flush();
    br.close();
  }
}

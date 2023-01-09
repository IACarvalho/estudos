import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.swing.JOptionPane;

public class PersonalizedException {
  public static void main(String[] args) {
    String nomedDoArquivo = "teste.txt";
    
    imprimirArquivoNoConsole(nomedDoArquivo);

    System.out.println("Apesar da exception ou não, o programa continua...");
  }

  public static void imprimirArquivoNoConsole(String nomedDoArquivo) {

    try {
      BufferedReader br = lerArquivo(nomedDoArquivo);

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
    catch(ImpossivelAberturaDeArquivoException ex) {
      JOptionPane.showMessageDialog(null, ex.getMessage());
    }
    catch(FileNotFoundException ex) {
      JOptionPane.showMessageDialog(null, "Revise o nome do arquivo. \n" + ex.getCause());
      ex.printStackTrace();
    }
    catch(IOException ex) {
      JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado \nErro: " + ex.getCause());
      ex.printStackTrace();
    }
  }

  public static BufferedReader lerArquivo(String nomeDoArquivo) throws ImpossivelAberturaDeArquivoException{
    File file = new File(nomeDoArquivo);

    try {
      return new BufferedReader(new FileReader(file.getName()));
    }
    catch(FileNotFoundException ex) {
      throw new ImpossivelAberturaDeArquivoException(file.getName(), file.getPath());
    }
  }
}

class ImpossivelAberturaDeArquivoException extends Exception {
  private String nomeDoArquivo;
  private String diretorio;

  public ImpossivelAberturaDeArquivoException( String nomeDoArquivo, String diretorio) {
    super("O arquivo " + nomeDoArquivo + " não foi encontrado no diretório " + diretorio);
    this.nomeDoArquivo = nomeDoArquivo;
    this.diretorio = diretorio;
  }

  public String getNomeDoArquivo() {
    return nomeDoArquivo;
  }
  public void setNomeDoArquivo(String nomeDoArquivo) {
    this.nomeDoArquivo = nomeDoArquivo;
  }
  public String getDiretorio() {
    return diretorio;
  }
  public void setDiretorio(String diretorio) {
    this.diretorio = diretorio;
  }

  
}

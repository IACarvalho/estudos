package com.estudos.collections;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class ExercicioPropostoSet2 {
  /*
   * Crie uma classe LinguagemFavorita que possua os atributos
   * nome, anoDeCriacao e ide. Em seguida, crie um conjunto com
   * 3 linguagens e faça um programa que ordene esse conjunto
   * por:
   * [x] A - Ordem de Inserção
   * [x] B - Ordem Natural (nome)
   * [x] C - IDE
   * [x] D - Ano de criação e nome
   * [x] E - Nome, ano de criacao e IDE 
   * [x] Ao final, exiba as linguagens no console, um abaixo da outra.
   */
  private static final String List = null;

  public static void main(String[] args) {
    // Ordem de insert
    Set<LinguagemFavorita> listaLinguagensFavoritas = new LinkedHashSet<LinguagemFavorita>() {
      {
        add(new LinguagemFavorita("JavaScript", 1995, "VS Code"));
        add(new LinguagemFavorita("C#", 1999, "Visual Studio Code"));
        add(new LinguagemFavorita("Java", 1991, "Eclipse"));
      }
    };
    // Ordenacao natural
    Set<LinguagemFavorita> linguagemOrdemNatural = new TreeSet<>(listaLinguagensFavoritas);

    // Ordenacao usando Comparator
    Set<LinguagemFavorita> linguagensOrdenadas = new TreeSet<>(new CompareIdeAnoNome());
    linguagensOrdenadas.addAll(listaLinguagensFavoritas);

    showListItems(listaLinguagensFavoritas);
    showListItems(linguagemOrdemNatural);
    showListItems(linguagensOrdenadas);
  }

  private static void showListItems(Set<LinguagemFavorita> linguagemFavoritas) {
    System.out.println();
    for (LinguagemFavorita linguagemFavorita : linguagemFavoritas) {
      System.out.println(linguagemFavorita.getNome());
    }
    System.out.println();
  }
}

class LinguagemFavorita implements Comparable<LinguagemFavorita> {
  private String nome;
  private int anoDeCriacao;
  private String ide;

  public LinguagemFavorita(String nome, int anoDeCriacao, String ide) {
    this.nome = nome;
    this.anoDeCriacao = anoDeCriacao;
    this.ide = ide;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getAnoDeCriacao() {
    return anoDeCriacao;
  }

  public void setAnoDeCriacao(int anoDeCriacao) {
    this.anoDeCriacao = anoDeCriacao;
  }

  public String getIde() {
    return ide;
  }

  public void setIde(String ide) {
    this.ide = ide;
  }

  @Override
  public String toString() {
    return "LinguagemFavorita [nome=" + nome + ", anoDeCriacao=" + anoDeCriacao + ", ide=" + ide + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((nome == null) ? 0 : nome.hashCode());
    result = prime * result + anoDeCriacao;
    result = prime * result + ((ide == null) ? 0 : ide.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    LinguagemFavorita other = (LinguagemFavorita) obj;
    if (nome == null) {
      if (other.nome != null)
        return false;
    } else if (!nome.equals(other.nome))
      return false;
    if (anoDeCriacao != other.anoDeCriacao)
      return false;
    if (ide == null) {
      if (other.ide != null)
        return false;
    } else if (!ide.equals(other.ide))
      return false;
    return true;
  }

  @Override
  public int compareTo(LinguagemFavorita lang) {
    int nomeLang = nome.compareTo(lang.getNome());
    if (nomeLang != 0)
      return nomeLang;

    int ano = Integer.compare(anoDeCriacao, lang.getAnoDeCriacao());
    if (ano != 0)
      return ano;

    return ide.compareTo(lang.getIde());
  }

}

class CompareIdeAnoNome implements Comparator<LinguagemFavorita> {

  @Override
  public int compare(LinguagemFavorita lang1, LinguagemFavorita lang2) {
    int ide = lang1.getIde().compareTo(lang2.getIde());
    if(ide != 0)
      return ide;
    
      int ano = Integer.compare(lang1.getAnoDeCriacao(), lang2.getAnoDeCriacao());
      if(ano != 0)
        return ano;
    
    return lang1.getNome().compareTo(lang2.getNome());
  }
  
}
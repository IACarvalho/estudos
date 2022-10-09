package com.estudos.collections;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class OrdenacaoSet {
  /*
   * Dadas as seguintes informações sobre minhas séries favoritas,
   * crie um conjunto e orde este conjunto exibindo:
   * (nome - genero - tempo de episodio);
   * 
   * Série 1 = nome: got, genero: fantasia, tempoEpisodio: 60
   * Série 2 = nome: dark, genero: drama, tempoEpisodio: 60
   * Série 3 = nome: that '70s show, genero: comedia, tempoEpisodio: 25
   */

  public static void main(String[] args) {

    // Ordem aleatoria
    Set<Serie> series = new HashSet<>(){{
      add(new Serie("got", "fantasia", 60));
      add(new Serie("dark", "drama", 60));
      add(new Serie("that '70s show", "comedia", 25));
    }};


    for (Serie serie : series) {
      System.out.printf(serie.getNome() + " - ");
      System.out.printf(serie.getGenero() + " - ");
      System.out.println(serie.getTempoEpisodio().toString());
    }
    System.out.println();

    // Mostrar por ordem de inserção
    Set<Serie> series1 = new LinkedHashSet<>(){{
      add(new Serie("got", "fantasia", 60));
      add(new Serie("dark", "drama", 60));
      add(new Serie("that '70s show", "comedia", 25));
    }};


    for (Serie serie : series1) {
      System.out.printf(serie.getNome() + " - ");
      System.out.printf(serie.getGenero() + " - ");
      System.out.println(serie.getTempoEpisodio().toString());
    }
    System.out.println();

    // Ordem natural (tempoEpisodio)
    Set<Serie> series2 = new TreeSet<>(series1);
    for (Serie serie : series2) {
      System.out.printf(serie.getNome() + " - ");
      System.out.printf(serie.getGenero() + " - ");
      System.out.println(serie.getTempoEpisodio().toString());
    }
    System.out.println();

    // OrdemNome/Gênero/Duração
    Set<Serie> series3 = new TreeSet<>(new CompareNomeGeneroDuracao());
    series3.addAll(series);
    for (Serie serie : series3) {
      System.out.printf(serie.getNome() + " - ");
      System.out.printf(serie.getGenero() + " - ");
      System.out.println(serie.getTempoEpisodio().toString());
    }
    System.out.println();
  }

}

class Serie implements Comparable<Serie>{

  private String nome;
  private String genero;
  private Integer tempoEpisodio;

  public Serie(String nome, String genero, Integer tempoEpisodio) {
    this.nome = nome;
    this.genero = genero;
    this.tempoEpisodio = tempoEpisodio;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getGenero() {
    return genero;
  }

  public void setGenero(String genero) {
    this.genero = genero;
  }

  public Integer getTempoEpisodio() {
    return tempoEpisodio;
  }

  public void setTempoEpisodio(Integer tempoEpisodio) {
    this.tempoEpisodio = tempoEpisodio;
  }

  @Override
  public String toString() {
    return "Serie [nome=" + nome + ", genero=" + genero + ", tempoEpisodio=" + tempoEpisodio + "]";
  }

  @Override
  public int hashCode() {
    return Objects.hash(nome, genero, tempoEpisodio);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Serie other = (Serie) obj;
    if (nome == null) {
      if (other.nome != null)
        return false;
    } else if (!nome.equals(other.nome))
      return false;
    if (genero == null) {
      if (other.genero != null)
        return false;
    } else if (!genero.equals(other.genero))
      return false;
    if (tempoEpisodio == null) {
      if (other.tempoEpisodio != null)
        return false;
    } else if (!tempoEpisodio.equals(other.tempoEpisodio))
      return false;
    return true;
  }

  @Override
  public int compareTo(Serie serie) {
    int tempoEpisodio = Integer.compare(this.tempoEpisodio, serie.getTempoEpisodio());
    if(tempoEpisodio != 0 ) return tempoEpisodio;

    return this.getGenero().compareTo(serie.getGenero());
  }
}

class CompareNomeGeneroDuracao implements Comparator<Serie> {

  @Override
  public int compare(Serie serie, Serie serie1) {
    int nome = serie.getNome().compareTo(serie1.getNome());
    if(nome != 0) return nome;

    int genero = serie.getGenero().compareTo(serie1.getGenero());
    if(genero != 0) return genero;

    return Integer.compare(serie.getTempoEpisodio(), serie1.getTempoEpisodio());
  }}
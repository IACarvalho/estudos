package com.estudos.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrdenedList {
  public static void main(String[] args) {
    /*
     * Dadas as seguintes informações sobre meus gatos, crie uma lista
     * e ordene esta lista exibindo:
     * (nome - idade - cor)
     * 
     * Gato 1  = nome: Jon, idade: 18, cor: preto
     * Gato 2 = nome: Simba, idade: 6, cor: tigrado
     * gato 3 = nome: Garfield, idade: 12, cor: amarelo
     */

    List<Gato> meusGatos = new ArrayList<>(){{
      add(new Gato("Jon", 18, "preto"));
      add(new Gato("Simba", 6, "tigrado"));
      add(new Gato("jon", 12, "amarelo"));
    }};

    // Ordem de inserção
    System.out.println(meusGatos);

    // Ordem aleatória
    // O método Collections.shuffle() embaralha os itens de uma lista
    Collections.shuffle(meusGatos);
    System.out.println(meusGatos);

    // Ordem natural
    // O método Collections.sort() ordena uma lista de objetos usando o comparable sobrescrito da classe
    Collections.sort(meusGatos);
    System.out.println(meusGatos);

    // Ordem iadde
    // Collections.sort(meusGatos, new CompararIdade());
    meusGatos.sort(new CompararIdade());
    System.out.println(meusGatos);

    // Ordem cor
    meusGatos.sort(new CompararCor());
    System.out.println(meusGatos);

    // Ordenar Nome/Cor/Idade
    meusGatos.sort(new CompararNomeIdadeCor());
    System.out.println(meusGatos);

  }
}

class Gato implements Comparable<Gato>{

  private String nome;
  private Integer idade;
  private String cor;

  public Gato(String nome, Integer idade, String cor){
    this.nome = nome;
    this.idade = idade;
    this.cor = cor;
  }

  //#region getters and setters
  public String getCor() {
    return cor;
  }

  public void setCor(String cor) {
    this.cor = cor;
  }

  public Integer getIdade() {
    return idade;
  }

  public void setIdade(Integer idade) {
    this.idade = idade;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }
  //#endregion
  
  @Override
  public String toString() {
    return '{'+
            "nome = '" + nome + '\'' +
            ", idade = " + idade +
            ", cor = '" + cor + '\'' +
            '}';
  }
  /*
   * Para atribuir a capacidade de ordenação de ordem natural uma lsit de uma classe
   * é necessário implementar a interface Comparable, assim os objetos da classe podem ser
   * comparados.
   */

  // Método usado para comparar strings
  @Override
  public int compareTo(Gato gato) {
    return this.getNome().compareToIgnoreCase(gato.getNome());
  }
}

/*
 * Classe criada para poder comparar atributos do tipo inteiro
 * Para fazer ordenação de coleções com objetos é obrigatório criar
 * essa classe e passar como parâmetro
 */
class CompararIdade implements Comparator<Gato> {

  @Override
  public int compare(Gato g1, Gato g2) {
    return Integer.compare(g1.getIdade(), g2.getIdade());
  }}

class CompararCor implements Comparator<Gato>{

  @Override
  public int compare(Gato g1, Gato g2) {
    return g1.getCor().compareToIgnoreCase(g2.getCor());
  }}

class CompararNomeIdadeCor implements Comparator<Gato>{

  @Override
  public int compare(Gato g1, Gato g2) {
    int nome = g1.getNome().compareToIgnoreCase(g2.getNome());
    if (nome != 0)
      return nome;

    int cor = g1.getNome().compareToIgnoreCase(g2.getNome());
    if(cor != 0)
      return cor;

    return Integer.compare(g1.getIdade(), g2.getIdade());
  }}
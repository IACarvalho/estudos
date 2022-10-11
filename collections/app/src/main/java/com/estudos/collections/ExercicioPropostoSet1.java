package com.estudos.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ExercicioPropostoSet1 {
  /*
   * Crie um conjunto contendo as cores do arco-íris e:
   * A - Exiba todas as cores uma abaixo da outra
   * B - A quantidade de cores que o arco-íris tem
   * C - Exiba as cores em ordem alfabética
   * D - Exiba as cores na ordem inversa da que foi informada
   * E - Exiba todas as cores que começam com a letra ”v”
   * F - Remova todas as cores que não começam com a letra “v”
   * G - Limpe o conjunto
   * H - Confira se o conjunto está vazio
   */
  public static void main(String[] args) {
    Set<String> coresDoArcoIres = new HashSet<String>() {
      {
        add("Vermelho");
        add("Laranja");
        add("Amarelo");
        add("Verde");
        add("Azul");
        add("Indigo");
        add("Violeta");
      }
    };

    Iterator<String> iteratorCores = coresDoArcoIres.iterator();
    while (iteratorCores.hasNext())
      System.out.println(iteratorCores.next());

    System.out.println("Quantidades de cores: " + coresDoArcoIres.size());

    /*
     * O Set é apenas uma interface. A ordem depende da implementação
     * O HashSet não tem garantia nenhuma de ordem. Na prática é aleatório
     * O LinkedHasSet mantém a ordem na qual os elementos são inseridos
     * O TreeSet ordena os elementos na ordenação natural(crescente, alfabética, etc).
     * É possível passar um Comparator no construtor para especificar como ele
     * deve ordenar caso a ordenação natural não exista ou não seja desejada.
     */
    Set<String> coresDoArcoIresOrdenadas = new TreeSet<String>(coresDoArcoIres);

    for (String cor : coresDoArcoIresOrdenadas) {
      System.out.println(cor);
    }

    Set<String> coresNaOrdemInsercao = new LinkedHashSet<>(){{
      add("Vermelho");
      add("Laranja");
      add("Amarelo");
      add("Verde");
      add("Azul");
      add("Indigo");
      add("Violeta");
    }};
    
    List<String> coresInvertidas = new ArrayList<String>(coresNaOrdemInsercao);
    Collections.reverse(coresInvertidas);

    List<String> invertedRainbowColors = new LinkedList<>(coresInvertidas);
    System.out.println("Cores na ordem de irserção");
    for (String cor : coresNaOrdemInsercao)
      System.out.println(cor);
    System.out.println("Cores invertidas");
    for (String cor : invertedRainbowColors)
      System.out.println(cor);

    System.out.println("Cores que iniciam com \"V\"");
    for (String cor : coresNaOrdemInsercao) {
      String[] splitedColor = cor.toLowerCase().split("");
      if(splitedColor[0].equals("v")){
        System.out.println(cor);
      }
    }

    System.out.println("Remover todas as palavras com letra \"V\"");
    Iterator<String> iteratorRemotion = coresNaOrdemInsercao.iterator();
    while(iteratorRemotion.hasNext()){
      String[] splitedWord = iteratorRemotion.next().toLowerCase().split("");
      if(splitedWord[0].equals("v")){
        iteratorRemotion.remove();
      }
    }
    System.out.println("Cores foram removidas");
    for (String color : coresNaOrdemInsercao) {
      System.out.println(color);
    }

    coresNaOrdemInsercao.clear();

    System.out.println(coresNaOrdemInsercao.isEmpty());
  }
}
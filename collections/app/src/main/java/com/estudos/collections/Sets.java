package com.estudos.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Sets {
  /*
   * ** Caracteríscticas da Set **
   * - Assim como List set está no pacote util (java.util.Set)
   * - Não possui elementos duplicados
   * - Não possui índice
   */
  public static void main(String[] args) {
    /*
     * Dada uma lista com 7 notas de um aluno [7, 8.5, 9.3, 5, 7, 0, 3.6], faça:
     * Set<Double> ntoas = new HasSet<>(); // Generics (JDK 5) - Diamont Operator(
     * JDK 7 )
     * HasSet<Double> notas = new HashSet<>();
     * Set<Double> notas = new HasSet<>(Arrays.asList(7d, 8.5, 9.3, 5, 7d, 0d,
     * 3.6));
     * Set<Double> ntoas = Set.of(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6);
     * notas.add(1d);
     * notas.remove(5d);
     * System.out.println(ntoas);
     */

    // Crie um conjunto e adicione as ntoas
    Set<Double> notas = new HashSet<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));
    // Ficará com um elemetno a menos porque no Set não se repete elementos
    System.out.println(notas.toString());

    // Exiba a posição da nota 5.0
    // Como set não possui índice é impossívcel recuperar a posição de um elemento

    // Adiciona na lista a nota 8.0 na posição 4
    // Do mesmo modo que não consigo recuperar um elemento por posição, também não
    // posso adicionar um elemento em uma posição específica.

    // Substitua a nota 5.0 pela ntoa 6.0
    // Também não consigo fazer isso em um Set

    // Confira se a nota 5.0 está no ocnjunto
    System.out.println("Possui a nota 5.0: " + notas.contains(5d));

    // Exiba a terceira nota adicionada
    // Impossível por não haver índice

    // Exiba a menor nota
    // O método Collections.min retorna o menor elemento de uma coleção
    System.out.println("Menor nota: " + Collections.min(notas));

    // Exiba a maior ntoa
    // Com funcionamento semelhante ao anterior o Collections.max() retorna o maior
    // elemento
    System.out.println("Maior nota: " + Collections.max(notas));

    // Exiba a soma dos valores
    // Assim como em List pode ser feito usando o Iterator
    Iterator<Double> iterator = notas.iterator();
    Double soma = 0d;
    while (iterator.hasNext())
      soma += iterator.next();
    System.out.println("A soma: " + soma);

    // Exiba a média das notas
    System.out.println("Média das notas: " + (soma / notas.size()));

    // Remova a ntoa 0
    notas.remove(0d);
    System.out.println(notas.toString());

    // Remova a nota da posição 0
    // Impossível por não haver índice

    // Remova as notas menores que 7 e exiba a lista
    Iterator<Double> iteratorNotas = notas.iterator();
    
    while (iteratorNotas.hasNext()) {
      Double nota = iteratorNotas.next();
      if (nota < 7)
        iteratorNotas.remove();
    }
    System.out.println(notas.toString());

    // Exiba todos as ntoas na ordem em que foram informadas
    Set<Double> notas2 = new LinkedHashSet<Double>();
    notas2.add(7d);
    notas2.add(8.5);
    notas2.add(9.3);
    notas2.add(5d);
    notas2.add(7d);
    notas2.add(0d);
    notas2.add(3.6);
    System.out.println(notas2);

    // Exibir todos os itens em ordem crescente
    Set<Double> notas3 = new TreeSet<Double>(notas2);
    System.out.println(notas3);

    // Apague todo o conjunto
    notas.clear();
    System.out.println(notas);

    // COnfira se o conjunto esta vazio
    System.out.println("O conjunto esta vazio:  " + notas.isEmpty());
  }
}

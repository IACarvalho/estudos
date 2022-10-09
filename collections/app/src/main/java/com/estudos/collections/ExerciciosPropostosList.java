package com.estudos.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ExerciciosPropostosList {
  /*
   * Faça um programa que receba a temperatura média dos 6 primeiros meses do
   * ano e armazene-as em uma lista. Após isto, calcule a média semestral
   * das temperaturas e mostre todas as temperaturas acima desta média, e em que
   * mês elas ocorrem (mostre o mês por extenso: 1 - janeiro,
   * 2 - fevereiro e etc).
   * 
   * 
   * Utilizando listas, faça um programa que faça 5 perguntas para uma pessoa
   * sobre um crime. As perguntas são:
   * 1 - "Telefonou para a vítima?"
   * 2 - "Esteve no local do crime?"
   * 3 - "Mora perto da vítima?"
   * 4 - "Devia para a vítima?"
   * 5 - "Já trabalhou com a vítima?"
   * 
   * Se a pessoa responder positivamente a 2 questões ela deve ser
   * classificada como "Suspeita", entre 3 e 4 como "Cúmplice" e 5 como
   * "Assassina". Caso contrário, ela será classificado como "Inocente".
   */

  public static void main(String[] args) {
    temperaturaMedia();

    investigacao();
  }

  static String converterMesesParaExtenso(Integer mes) {
    switch (mes) {
      case 1:
        return "Janeiro";
      case 2:
        return "Fevereiro";
      case 3:
        return "Março";
      case 4:
        return "Abril";
      case 5:
        return "Maio";
      case 6:
        return "Junho";
      case 7:
        return "Julho";
      case 8:
        return "Agosto";
      case 9:
        return "Setembro";
      case 10:
        return "Outubro";
      case 11:
        return "Novembro";
      case 12:
        return "Dezembro";
      default:
        return "Inválido";
    }
  }

  static void temperaturaMedia() {
    List<Double> mediaTemperaturasSemestral = new ArrayList<Double>();

    for (int i = 0; i < 6; i++) {
      Scanner input = new Scanner(System.in);
      System.out.println("Digite a média do mês de " + converterMesesParaExtenso(i + 1));
      Double mes = input.nextDouble();

      mediaTemperaturasSemestral.add(mes);

      input.close();
    }
    Iterator<Double> interatorMedia = mediaTemperaturasSemestral.iterator();

    Double soma = 0.0;
    while (interatorMedia.hasNext())
      soma += interatorMedia.next();

    Double media = soma / mediaTemperaturasSemestral.size();

    Iterator<Double> iteratorResultado = mediaTemperaturasSemestral.iterator();
    while (iteratorResultado.hasNext()) {
      Double mediaMensal = iteratorResultado.next();
      if (mediaMensal > media)
        System.out.println("A média do mês de " +
            converterMesesParaExtenso(mediaTemperaturasSemestral.indexOf(mediaMensal) + 1) +
            " é: " +
            mediaMensal);
    }
  }

  static void investigacao() {
    List<String> perguntas = new ArrayList<String>();
    perguntas.add("Telefonou para a vítima?");
    perguntas.add("Esteve no local do crime?");
    perguntas.add("Mora perto da vítima?");
    perguntas.add("Devia para a vítima?");
    perguntas.add("Já trabalhou com a vítima?");

    int respostaPositivas = 0;
    System.out.println("Responda 1 para sim 0 para não");
    for (String pergunta : perguntas) {
      Scanner input = new Scanner(System.in);

      System.out.println(pergunta);
      int resposta = input.nextInt();

      if (resposta == 1)
        respostaPositivas++;

      input.close();
    }

    String nivelDeSuspeita;

    switch (respostaPositivas) {
      case 2:
        nivelDeSuspeita = "Suspeito(a)";
        break;
      case 3:
      case 4:
        nivelDeSuspeita = "Cúmplice";
        break;
      case 5:
        nivelDeSuspeita = "Assassino(a)";
        break;
      default:
        nivelDeSuspeita = "Inocente";
    }

    System.out.println("Você é considerado(a) " + nivelDeSuspeita);
  }
}

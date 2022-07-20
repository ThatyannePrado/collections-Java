package com.dio.lists;

import java.util.*;

public class Notas {
    public static void main(String[] args) {
        System.out.println("Cria nova lista e adiciona sete notas: ");

        List<Double> notas = new ArrayList<>();
        notas.add(7d);
        notas.add(8.5d);
        notas.add(9d);
        notas.add(6.75d);
        notas.add(5d);
        notas.add(8.25d);
        notas.add(3.25d);

        System.out.println(notas);
        System.out.println("Exibe a posição da nota 5: "+notas.indexOf(5d));
        System.out.println("Adiciona a nota 8.8 na posiçção 4: ");
        notas.add(4,8d);
        System.out.println(notas);
        System.out.println("Substitui a nota 5.0 por 6.0");
        notas.set(notas.indexOf(5d),6d);
        System.out.println(notas);
        System.out.println("Confere se a nota 5.0 está na lista: "+notas.contains(5d));
        System.out.println("Exiba a terceira nota adicionada: "+notas.get(2));
        System.out.println("Exiba a menor notas: "+ Collections.min(notas));
        System.out.println("Exiba a maior notas: "+ Collections.max(notas));
        Iterator<Double> iterator = notas.iterator();
        Double soma = 0d;
        while (iterator.hasNext()){
            Double next = iterator.next();
            soma += next;
        }
        System.out.println("Soma dos valores: "+soma);
        System.out.println("Média dos valores: "+soma/ notas.size());
        System.out.println("Remove nota 8.0 e nota posição 0: ");
        notas.remove(8d);
        notas.remove(0);
        System.out.println(notas);
        System.out.println("Remove as notas menores que 8.0: ");
        Iterator<Double> iterator1 = notas.iterator();
        while (iterator1.hasNext()){
            Double next = iterator1.next();
            if (next<8d) iterator1.remove();
        }
        System.out.println(notas);
        System.out.println("Apaga toda a lista");
        notas.clear();
        System.out.println(notas);
        System.out.println("Verifica se lista está vazia: "+notas.isEmpty());




    }
}

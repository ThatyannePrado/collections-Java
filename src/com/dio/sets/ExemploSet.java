package com.dio.sets;

import java.util.*;

public class ExemploSet {
    public static void main(String[] args) {
        System.out.println("Cria um conjunto e adiciona as notas: ");
        Set<Double> notas = new HashSet<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));
        System.out.println(notas.toString());

        System.out.println("Confira de a nota 5.0 está no conjunto: "+notas.contains(5d));
        System.out.println("Exiba a menor nota: "+ Collections.min(notas));
        System.out.println("Exiba a maior nota: "+ Collections.max(notas));

        Iterator<Double> iterator = notas.iterator();
        Double soma = 0.0;
        while (iterator.hasNext()){
            Double next = iterator.next();
            soma += next;
        }

        System.out.println("Soma das notas: "+soma);
        System.out.println("Média das notas: "+soma/ notas.size());
        System.out.println("Remove nota zero: ");
        notas.remove(0d);
        System.out.println(notas);

        System.out.println("Remove as notas menores que 7: ");
        Iterator<Double> iterator1 = notas.iterator();
        while (iterator1.hasNext()){
            Double next = iterator1.next();
            if(next<7) iterator1.remove();
        }
        System.out.println(notas);

        Set<Double> notas2 = new LinkedHashSet<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));
        System.out.println(notas2);
        System.out.println("Exiba todas as notas em ordem crescente: ");
        Set<Double> notas3 = new TreeSet<>(notas2);
        System.out.println(notas3);

        System.out.println("Apague todo o conjunto: ");
        notas.clear();
        System.out.println("Checar se o conjunto está vazio: "+notas.isEmpty());



    }
}

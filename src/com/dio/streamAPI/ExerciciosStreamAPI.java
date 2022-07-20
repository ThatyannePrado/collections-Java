package com.dio.streamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

public class ExerciciosStreamAPI {
    public static void main(String[] args) {
        List<String> numerosAleatorios =
                Arrays.asList("1","0","4","1","2","3","9","9","6","5");
        System.out.println("Imprime todos os elementos da lista de Strings: ");
        /*numerosAleatorios.stream().forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });*/

        numerosAleatorios.forEach(System.out::println);

        System.out.println("Pega os 5 primeiros números e coloca-os em um set: ");
        numerosAleatorios.stream()
                .limit(5)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        System.out.println("TRansforma lista de strings em lista de inteiros: ");
        /*numerosAleatorios.stream().map(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return Integer.parseInt(s);
            }
        });*/

        List<Integer> collectList = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        System.out.println("Pega os números pares e maiores que 2 e coloca em uma lista: ");
        List<Integer> listParesMaiores2 = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .filter( i -> (i % 2 == 0 && i > 2))
                .collect(Collectors.toList());
        System.out.println(listParesMaiores2);

        System.out.println("Média do números: ");
        numerosAleatorios.stream()
                .mapToInt(Integer::parseInt)
                .average()
                .ifPresent(System.out::println);
        System.out.println("Remove valores ímpares: ");

        collectList.removeIf(i->(i%2 != 0) );
        System.out.println(collectList);
    }

}

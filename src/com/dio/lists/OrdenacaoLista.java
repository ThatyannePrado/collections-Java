package com.dio.lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoLista {
    public static void main(String[] args) {
        List<Gato> meusGatos = new ArrayList<>(){{
            add(new Gato("Jan", 4, "preto"));
            add(new Gato("Peludinho", 2, "frajola"));
            add(new Gato("Jan", 12, "branco"));
        }};

        System.out.println("---Ordem de inserção---");
        System.out.println(meusGatos);

        System.out.println("---Ordem Aleatória---");
        Collections.shuffle(meusGatos);
        System.out.println(meusGatos);

        System.out.println("---Ordem Natural (nome)");
        Collections.sort(meusGatos);
        System.out.println(meusGatos);

        System.out.println("---Ordem Idade");
//        Collections.sort(meusGatos, new ComparatorIdade());
        meusGatos.sort(new ComparatorIdade());
        System.out.println(meusGatos);

        System.out.println("---Ordem Cor---");
        Collections.sort(meusGatos, new ComparatorCor());
//        meusGatos.sort(new ComparatorCor());
        System.out.println(meusGatos);

        System.out.println("---Ordem Nome/Cor/Idade");
        Collections.sort(meusGatos, new ComparatorNomeCorIdade());
//        meusGatos.sort(new ComparatorNomeCorIdade());
        System.out.println(meusGatos);
    }
}

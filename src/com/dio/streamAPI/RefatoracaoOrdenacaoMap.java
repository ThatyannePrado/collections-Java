package com.dio.streamAPI;

import java.util.*;
import java.util.function.Function;

public class RefatoracaoOrdenacaoMap {
    public static void main(String[] args) {
        System.out.println("---Ordem Aleatória---");
        Map<Integer, Contato> agenda = new HashMap<>(){{
            put(1, new Contato("Ana", 5555));
            put(4, new Contato("Pedro", 1111));
            put(3, new Contato("Carla", 2222));
        }};

        for (Map.Entry<Integer, Contato> entry: agenda.entrySet()) {
            System.out.println(entry.getKey()+" - "+entry.getValue().getNome()+" - "+entry.getValue().getNumero());
        }

        System.out.println("---Ordem Inserção---");
        Map<Integer, Contato> agenda1 = new LinkedHashMap<>(){{
            put(1, new Contato("Ana", 5555));
            put(4, new Contato("Pedro", 1111));
            put(3, new Contato("Carla", 2222));
        }};
        for (Map.Entry<Integer, Contato> entry: agenda1.entrySet()) {
            System.out.println(entry.getKey()+" - "+entry.getValue().getNome()+" - "+entry.getValue().getNumero());
        }

        System.out.println("---Ordem id---");
        Map<Integer, Contato> agenda2 = new TreeMap<>(agenda);
        for (Map.Entry<Integer, Contato> entry: agenda2.entrySet()) {
            System.out.println(entry.getKey()+" - "+entry.getValue().getNome()+" - "+entry.getValue().getNumero());
        }

        System.out.println("---Ordem Numero telefone---");
       /*Set<Map.Entry<Integer, Contato>> agenda3 = new TreeSet<>(new Comparator<Map.Entry<Integer, Contato>>() {
           @Override
           public int compare(Map.Entry<Integer, Contato> cont1, Map.Entry<Integer, Contato> cont2) {
               return Integer.compare(cont1.getValue().getNumero(), cont2.getValue().getNumero());
           }
       });*/

        /*Set<Map.Entry<Integer, Contato>> agenda3 = new TreeSet<>(Comparator.comparing(
                new Function<Map.Entry<Integer, Contato>, Integer>() {
                    @Override
                    public Integer apply(Map.Entry<Integer, Contato> cont) {
                        return cont.getValue().getNumero();
                    }
                }
        ));*/

        Set<Map.Entry<Integer, Contato>> agenda3 = new TreeSet<>(Comparator.comparing(
                cont -> cont.getValue().getNumero()));

        agenda3.addAll(agenda.entrySet());
        for (Map.Entry<Integer, Contato> entry: agenda3) {
            System.out.println(entry.getKey()+" - "+entry.getValue().getNome()+" - "+entry.getValue().getNumero());
        }


        System.out.println("---Ordem Nome Contato---");
        /*Set<Map.Entry<Integer, Contato>> agenda4 = new TreeSet<>(new Comparator<Map.Entry<Integer, Contato>>() {
            @Override
            public int compare(Map.Entry<Integer, Contato> cont1, Map.Entry<Integer, Contato> cont2) {
                return cont1.getValue().getNome().compareToIgnoreCase(cont2.getValue().getNome());
            }
        });*/
        /*Set<Map.Entry<Integer, Contato>> agenda4 = new TreeSet<>(Comparator.comparing(
                new Function<Map.Entry<Integer, Contato>, String>() {
                    @Override
                    public String apply(Map.Entry<Integer, Contato> cont) {
                        return cont.getValue().getNome();
                    }
                }
        ));*/

        Set<Map.Entry<Integer, Contato>> agenda4 = new TreeSet<>(Comparator.comparing(
                cont -> cont.getValue().getNome()));

        agenda4.addAll(agenda.entrySet());
        for (Map.Entry<Integer, Contato> entry: agenda4) {
            System.out.println(entry.getKey()+" - "+entry.getValue().getNome()+" - "+entry.getValue().getNumero());
        }

    }
}

class Contato {
    private String nome;
    private Integer numero;

    public Contato(String nome, Integer numero) {
        this.nome = nome;
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public Integer getNumero() {
        return numero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contato contato = (Contato) o;
        return nome.equals(contato.nome) && numero.equals(contato.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, numero);
    }

    @Override
    public String toString() {
        return "Contato{" +
                "nome='" + nome + '\'' +
                ", numero=" + numero +
                '}';
    }
}

package com.dio.maps;

import java.util.*;

public class Ordenacao {
    public static void main(String[] args) {
        System.out.println("---Ordem Aleatória---");
        Map<String, Livro> meusLivros = new HashMap<>(){{
            put("Maria",new Livro("História",300));
            put("Carlos",new Livro("Crônicas",256));
            put("João",new Livro("Narrativas",500));
        }};
        for (Map.Entry<String,Livro> livro: meusLivros.entrySet()) {
            System.out.println(livro.getKey()+" - "+livro.getValue().getNome()+" - "+livro.getValue().getPaginas());

        }

        System.out.println("---Ordem de Inserção---");
        Map<String, Livro> meusLivros2 = new LinkedHashMap<>(){{
            put("Maria",new Livro("História",300));
            put("Carlos",new Livro("Crônicas",256));
            put("João",new Livro("Narrativas",500));
        }};
        for (Map.Entry<String,Livro> livro: meusLivros2.entrySet()) {
            System.out.println(livro.getKey()+" - "+livro.getValue().getNome()+" - "+livro.getValue().getPaginas());

        }

        System.out.println("---Ordem alfabética do autores---");
        Map<String, Livro> meusLivros3 = new TreeMap<>(meusLivros);
        for (Map.Entry<String,Livro> livro: meusLivros3.entrySet()) {
            System.out.println(livro.getKey()+" - "+livro.getValue().getNome()+" - "+livro.getValue().getPaginas());

        }

        System.out.println("Ordem alfabética nome dos livros: ");
        Set<Map.Entry<String,Livro>> meusLivros4 = new TreeSet<>(new ComparatorNome());
        meusLivros4.addAll(meusLivros.entrySet());
        for (Map.Entry<String,Livro> livro: meusLivros4) {
            System.out.println(livro.getKey()+" - "+livro.getValue().getNome()+" - "+livro.getValue().getPaginas());

        }


    }
}

class Livro {
    private String Nome;
    private Integer paginas;

    public Livro(String nome, Integer paginas) {
        Nome = nome;
        this.paginas = paginas;
    }

    public String getNome() {
        return Nome;
    }

    public Integer getPaginas() {
        return paginas;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return Nome.equals(livro.Nome) && paginas.equals(livro.paginas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Nome, paginas);
    }

    @Override
    public String toString() {
        return "Livro{" +
                "Nome='" + Nome + '\'' +
                ", paginas=" + paginas +
                '}';
    }
}

class ComparatorNome implements Comparator<Map.Entry<String,Livro>>{

    @Override
    public int compare(Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
        return l1.getValue().getNome().compareToIgnoreCase(l2.getValue().getNome());
    }
}

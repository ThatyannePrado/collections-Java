package com.dio.sets;

import java.util.*;

public class Ordenacao {
    public static void main(String[] args) {
        System.out.println("---Ordem Aleatória---");

        Set<Serie> minhaSerie = new HashSet<>(){{
            add(new Serie("got", "fantasia",60));
            add(new Serie("dark", "ficção-científica",60));
            add(new Serie("the office", "comédia",25));
        }};
        for (Serie serie:minhaSerie) System.out.println(serie.getNome()+" - "+serie.getGenero()+
                " - "+serie.getTempoEpisodio());

        System.out.println("---Ordem de Inserção---");

        Set<Serie> minhaSerie1 = new LinkedHashSet<>(){{
            add(new Serie("got", "fantasia",60));
            add(new Serie("dark", "ficção-científica",60));
            add(new Serie("the office", "comédia",25));
        }};
        for (Serie serie:minhaSerie1) System.out.println(serie.getNome()+" - "+serie.getGenero()+
                " - "+serie.getTempoEpisodio());

        System.out.println("---Ordem Natural (tempoEpisodio)---");
        Set<Serie> minhaSerie2 = new TreeSet<>(minhaSerie1);
        for (Serie serie:minhaSerie2) System.out.println(serie.getNome()+" - "+serie.getGenero()+
                " - "+serie.getTempoEpisodio());

        System.out.println("---Ordem Nome/Gênero/TempoEpisódio");

        Set<Serie> minhaSerie3 = new TreeSet<>(new ComparatorNomeGeneroTempo());
        minhaSerie3.addAll(minhaSerie);
        for (Serie serie:minhaSerie3) System.out.println(serie.getNome()+" - "+serie.getGenero()+
                " - "+serie.getTempoEpisodio());



    }
}

class Serie implements Comparable<Serie>{
    private String nome;
    private String genero;
    private Integer tempoEpisodio;

    public Serie(String nome, String genero, Integer tempoEpisodio) {
        this.nome = nome;
        this.genero = genero;
        this.tempoEpisodio = tempoEpisodio;
    }

    public String getNome() {
        return nome;
    }

    public String getGenero() {
        return genero;
    }

    public Integer getTempoEpisodio() {
        return tempoEpisodio;
    }

    @Override
    public String toString() {
        return "Serie{" +
                "nome='" + nome + '\'' +
                ", genero='" + genero + '\'' +
                ", tempoEpisodio=" + tempoEpisodio +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Serie serie = (Serie) o;
        return Objects.equals(nome, serie.nome) && Objects.equals(genero, serie.genero) && Objects.equals(tempoEpisodio, serie.tempoEpisodio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, genero, tempoEpisodio);
    }

    @Override
    public int compareTo(Serie serie) {
        int tempo =  Integer.compare(this.getTempoEpisodio(), this.getTempoEpisodio());
        if (tempo != 0) return tempo;

        return this.getGenero().compareToIgnoreCase(serie.getGenero());
    }
}

class ComparatorNomeGeneroTempo implements Comparator<Serie>{

    @Override
    public int compare(Serie s1, Serie s2) {
        int nome = s1.getNome().compareToIgnoreCase(s2.getNome());
        if (nome != 0) return nome;
        int genero = s1.getGenero().compareToIgnoreCase(s2.getGenero());
        if (genero != 0) return genero;

        return   Integer.compare(s1.getTempoEpisodio(), s2.getTempoEpisodio());

    }
}

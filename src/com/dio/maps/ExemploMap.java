package com.dio.maps;

import java.util.*;

public class ExemploMap {
    public static void main(String[] args) {
        System.out.println("Cria dicionario que relaciona modelos e seus repectivos consumos: ");
        Map<String, Double> carrosPopulares = new HashMap<>(){{
            put("gol",14.4);
            put("uno",15.6);
            put("mobi",16.1);
            put("hb20",14.5);
            put("kwid",15.6);
        }};

        System.out.println("Substitua o consumo do gol por 16.2: ");
        carrosPopulares.put("gol", 16.2);
        System.out.println(carrosPopulares.toString());
        System.out.println("Verifica se Tucson está entre modelos: "+carrosPopulares.containsKey("tucson"));
        System.out.println("Exiba o consumo do uno: "+carrosPopulares.get("uno"));
        Set<String> strings = carrosPopulares.keySet();
        System.out.println(strings);
        Collection<Double> values = carrosPopulares.values();
        System.out.println(values);
        System.out.println("Exibe o modelo mais econômico e seu consumo: ");
        Double maxConsumo = Collections.max(values);
        Set<Map.Entry<String, Double>> entries = carrosPopulares.entrySet();
        String modeloMaisEficiente = "";
        for (Map.Entry<String, Double> entry: entries) {
            if (entry.getValue().equals(maxConsumo))
                modeloMaisEficiente = entry.getKey();
        }

        System.out.println("Modelo mais eficiente: "+modeloMaisEficiente);
        System.out.println("Consumo mais eficiente: "+maxConsumo);

        System.out.println("Exibe modelo menos eficiente e seu consumo: ");
        Double minConsumo = Collections.min(carrosPopulares.values());
        String modeloMenosEficiente = "";
        for (Map.Entry<String, Double> entry: carrosPopulares.entrySet()) {
            if(entry.getValue().equals(minConsumo))
                modeloMenosEficiente = entry.getKey();
        }
        System.out.println("Modelo menos eficiente: "+modeloMenosEficiente +
                " - "+minConsumo);

        Iterator<Double> iterator = carrosPopulares.values().iterator();
        Double soma = 0d;
        while (iterator.hasNext()){
            soma += iterator.next();
        }
        System.out.println("Soma dos consumos: "+soma);
        System.out.println("Média dos consumos: "+soma/carrosPopulares.size());
        System.out.println("Remove modelos com consumo igual a 15,6km/l");
        Iterator<Double> iterator1 = carrosPopulares.values().iterator();
        while (iterator1.hasNext()){
            if (iterator1.next().equals(15.6d)) iterator1.remove();
        }
        System.out.println(carrosPopulares);
        System.out.println("Exibe os carros na ordem em que foram informados: ");
        Map<String, Double> carrosPopulares1 = new LinkedHashMap<>(){{
            put("gol",14.4);
            put("uno",15.6);
            put("mobi",16.1);
            put("hb20",14.5);
            put("kwid",15.6);
        }};
        System.out.println(carrosPopulares1.toString());
        System.out.println("Exibe carros ordenados pelo modelo: ");

        Map<String, Double> carrosPopulares3 = new TreeMap<>(carrosPopulares1);
        System.out.println(carrosPopulares3.toString());
        System.out.println("Apaga dicionário: ");
        carrosPopulares.clear();
        System.out.println("Confere se está vazio: "+carrosPopulares.isEmpty());

    }
}

package com.example;

import java.util.*;

/**
 * Write a list and add an aleatory number of Strings. In the end, print out how
 * many distinct itens exists on the list.
 */
public class TASK3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Adicionando strings aleatórias com o metodo getStrings()
        List<String> aleatoryStrings = getStrings();

        System.out.println("Lista: " + aleatoryStrings);

        // Metodo que conta a quantidade de strings distintas
        int qntUnicaString = numberOfStringsDistinct(aleatoryStrings);

        System.out.printf("Quantidades de itens distintos: %d%n", qntUnicaString);

        sc.close();

    }

    // Metodo que carrega um numero aleatório de strings
    private static List<String> getStrings() {
        List<String> strings = new ArrayList<>();

        Random random = new Random();

        // Adicionando de 15 a 20 strings na lista
        for (int i=0; i<=random.nextInt(15,20); i++){
            // Adicionando string de valores de 10 a 35
            strings.add(String.valueOf(random.nextInt(10, 35)).toLowerCase());
        }

        return strings;
    }

    // Metodo que conta strings distintas
    public static int numberOfStringsDistinct(List<String> list) {
        List<String> stringsUnicas = new ArrayList<>();

        // Verificando se a String é unica
        for (int i = 0; i <= list.size() - 1; i++) {
            String letraAtual = list.get(i);
            if (!stringsUnicas.contains(letraAtual)) {
                stringsUnicas.add(letraAtual);
            }
        }

        return stringsUnicas.size();
    }

}
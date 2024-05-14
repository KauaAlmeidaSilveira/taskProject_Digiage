package TASK2;

import java.util.ArrayList;
import java.util.List;

/**
 * Task here is to write a list. Each element must know the element before and
 * after it. Print out your list and them remove the element in the middle of
 * the list. Print out again.
 */


public class TASK2 {
    public static void main(String[] args) {
        List<Integer> listaSolucao1 = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        List<Integer> listaSolucao2 = new ArrayList<>(List.of(1, 2, 3, 4, 5));

        // Encontrando o elemento do meio usando 2 index
        int indexLento = 0;
        int indexRapido = 0;

        // A ideia é que o index rápido seja o dobro do index lento
        while (indexRapido < listaSolucao1.size() && listaSolucao1.get(indexRapido) != null) {
            indexRapido += 2;
            indexLento++;
        }
        System.out.println("Solução 1 - Usando 2 index, o rapido e o lento");
        System.out.println("Lista antes de remover o elemento do meio:");
        System.out.println(listaSolucao1);
        System.out.println("Lista após remover o elemento do meio:");
        listaSolucao1.remove(indexLento - 1);
        System.out.println(listaSolucao1);

        System.out.println("\n----------------------------------------");

        System.out.println("\nSolução 2 - Usando o size da lista");
        System.out.println("Lista antes de remover o elemento do meio:");
        System.out.println(listaSolucao2);
        System.out.println("Lista após remover o elemento do meio:");
        // Removendo o elemento do meio
        listaSolucao2.remove(listaSolucao2.size() / 2);
        System.out.println(listaSolucao2);

    }
}
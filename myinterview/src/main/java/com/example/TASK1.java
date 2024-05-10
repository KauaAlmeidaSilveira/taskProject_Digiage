package com.example;
import java.util.Scanner;
/**
 * 
 *
 * Task here is to implement a function that says if a given string is
 * palindrome.
 * 
 * 
 * 
 * Definition=> A palindrome is a word, phrase, number, or other sequence of
 * characters which reads the same backward as forward, such as madam or
 * racecar.
 */
public class TASK1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite a string para verificar se é um palindromo: ");
        String resp = sc.nextLine();

        System.out.println(isPalindromo(resp) ? "É um palindromo": "Não é um palindromo");

        sc.close();
    }

    public static boolean isPalindromo(String palindromo) {
        StringBuilder palindromoInvertido = new StringBuilder();

        for (int i = palindromo.length() - 1; i >= 0; i--) {
            // Adiciona cada caractere da string original, invertendo sua ordem
            palindromoInvertido.append(palindromo.charAt(i));
        }

        // Retorna true se a string invertida for igual à string original, caso contrário, retorna false
        return palindromoInvertido.toString().equals(palindromo);
    }
 
}
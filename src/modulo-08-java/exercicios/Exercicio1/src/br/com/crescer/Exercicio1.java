/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer;

import java.util.Scanner;

/**
 *
 * @author marcelo.moura
 */
public class Exercicio1 {
    public static void main(String[] args) {
        System.out.print("Informe um número: ");
        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);
            System.out.println(scanner.nextInt() % 2 == 0 ? "Par" : "Ímpar");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
    
}

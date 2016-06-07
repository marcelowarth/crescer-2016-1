package br.cwi.crescer.aula1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Exercicio7_3_1 {
    
    public static void main (String[] args) {
        StringBuffer stBuffer = new StringBuffer("");
        boolean first = true;
        for(Estados est : Estados.values()){
            if(!first) {
                stBuffer.append(", ");
            }
            stBuffer.append(est.getNome());
            if(first) {
                first = false;
            }
        }
        System.out.println(stBuffer);
    }
    
}


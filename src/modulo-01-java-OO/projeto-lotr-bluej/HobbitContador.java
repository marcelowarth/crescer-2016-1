import java.util.*;

public class HobbitContador
{
    public int calcularDiferenca(ArrayList<ArrayList<Integer>> array) {
        int produtos = 0, mmc = 0, vl1, vl2;
        
        for (int i = 0; i < array.size(); i++) {
            vl1 = array.get(i).get(0);
            vl2 = array.get(i).get(1);
            produtos += (vl1*vl2);
            
            if(vl1>=vl2)
                mmc += calculaMMC(vl1, vl2);
            else
                mmc += calculaMMC(vl2, vl1);
        }
        return produtos - mmc;
    }
    
    private int calculaMMC(int vl1, int vl2) {
        boolean aindaMaior = true;
        int auxVl1 = vl1, auxVl2 = vl2;
        int retorno = 0;
        if(vl1 == vl2) {
            aindaMaior = false;
            retorno = auxVl2;
        }
        if(vl1 == 0 || vl2 == 0) {
            aindaMaior = false;
        }
        while(aindaMaior) {
            auxVl2 += vl2;
            if (auxVl2 > auxVl1) {
                auxVl1 += vl1;
            } else if (auxVl2 == auxVl1) {
                aindaMaior = false;
                retorno = auxVl2;
            }
        }
        return retorno;
    }
    
    public int obterMaiorMultiploDeTresAte(int numero) {
        int multiplos = 0; //ArrayList não necessário pois possui somente 1 valor
    
        for (int i = 1; i <= numero; i++) { //nao existia variavel limite
            if (i % 3 == 0) {
                multiplos = i; //continue nao necessario
            }
        }
    
        return multiplos; // deve retornar somente o ultimo multiplo
    }
    
    public ArrayList<Integer> obterMultiplosDeTresAte(int numero) {
        ArrayList<Integer> multiplos = new ArrayList<>(Arrays.asList(0));
    
        for (int i = 1; i <= numero; i++) { //nao existia variavel limite
            if (i % 3 == 0) { //break nao necessario
                multiplos.add(i); //continue nao necessario
            }
        }
        
        return multiplos;
    }
}

import java.util.*;

public class HobbitContador
{
    public HobbitContador () {
    }
    
    public int calcularDiferenca(ArrayList<ArrayList<Integer>> array) {
        int produtos = 0, mmc = 0, vl1, vl2;
        
        for (int i = 0; i < array.size(); i++) {
            vl1 = array.get(i).get(0);
            vl2 = array.get(i).get(1);
            produtos += (vl1*vl2);
            
            switch ((vl1>=vl2) ? 1 : 2) {
                case 1:
                    mmc += calculaMMC(vl1, vl2);
                    break;
                case 2:
                    mmc += calculaMMC(vl2, vl1);
                    break;
            }
        }
        
        return produtos - mmc;
    }
    
    private int calculaMMC(int vl1, int vl2) {
        boolean aindaMaior = true, igual = false;
        int auxVl1 = vl1, auxVl2 = vl2;
        if(vl1 == vl2) {
            igual = true;
            aindaMaior = false;
        }
        while(aindaMaior) {
            auxVl2 += vl2;
            if (auxVl2 > auxVl1) {
                auxVl1 += vl1;
            } else if (auxVl2 == auxVl1) {
                aindaMaior = false;
                igual = true;
            }
        }
        return auxVl2;
    }
}

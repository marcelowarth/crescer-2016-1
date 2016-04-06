
/**
 * Escreva a descrição da classe CestodeLembas aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class CestodeLembas
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private int qtdeLembas;
    
    public CestodeLembas(int Lembas){
        qtdeLembas = Lembas;
    }
    
    public boolean podeDividirEmPares()
    {
        int aux = qtdeLembas % 2;
        if(aux > 0 || qtdeLembas == 2){
            return false;
        }else{
            return true;
        }
    }
}

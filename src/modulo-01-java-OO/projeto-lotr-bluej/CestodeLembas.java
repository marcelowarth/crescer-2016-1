
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
        return (qtdeLembas % 2 == 0 && qtdeLembas != 2);
    }
}


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
        /*ternario
        boolean podeDividir = qtdeLembas % 2 == 0 && qtdeLembas > 2 && qtdeLembas <=100
        return podeDividir ? true : false;
        */
        return (qtdeLembas % 2 == 0 && qtdeLembas > 2 && qtdeLembas <=100);
    }
}

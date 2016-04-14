import java.util.*;

public class SindarinParaIngles implements TradutorSindarin
{
    private HashMap <String, String> dicionario = new HashMap<String, String>() {
        {
            put("amar", "earth");
            put("naur", "fire");
            put("gwaew", "wind");
            put("nen", "water");
            put("gûr", "hearth");
        }
    };
    
    public String traduzir(String palavraEmSindarin) {
        return dicionario.get(palavraEmSindarin);
    }
}

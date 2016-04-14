import java.util.*;

public class DicionarioSindarin
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem vindo ao tradutor Sindarin! Escolha a linguagem: ");
        System.out.println("[P]ortuguês [I]nglês");
        String idioma = scanner.nextLine();
        TradutorSindarin tradutor = null;
        switch (idioma.toLowerCase()) {
            case "i":
                tradutor = new SindarinParaIngles();
                break;
            default:
                tradutor = new SindarinParaPortugues();
                break;
        }
        System.out.println("Digite a palavra a traduzir: ");
        String palavra = scanner.nextLine();
        System.out.println("Palavra " + palavra + " significa " + 
                        tradutor.traduzir(palavra.toLowerCase()));
        // radarExemplosHashMap();
    }
    
    private static void rodarExemplosHashMap() {
        HashMap<String, String> dicionarioSindarin = new HashMap<>();
        dicionarioSindarin.put("terra", "amar");
        dicionarioSindarin.put("fogo", "naur");
        dicionarioSindarin.put("vento", "gwaew");
        dicionarioSindarin.put("água", "nen");
        dicionarioSindarin.put("coração", "gûr");
        
        String terraEmSindarin = dicionarioSindarin.get("terra");
    }
}

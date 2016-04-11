public class ElfosVerdes extends Elfo
{
    protected int ganhaExpEV = (super.getGanhaExp()*2);
    
    public ElfosVerdes(String nome)
    {
        super(nome);
    }

    public ElfosVerdes(String nome, int flechas)
    {
        super(nome, flechas);
    }
    
    public void atirarFlechaDwarfs(Dwarf dwarf) {
        dwarf.recebeDano();
        super.flechas--;
        super.experiencia += ganhaExpEV;
    }
    
    public void adicionarItem(Item item) {
        if (item.getDesc().equals("Espada de aço valiriano") || item.getDesc().equals("Arco e Flecha de Vidro"))
            inventario.adicionarItem(item);
    }
}

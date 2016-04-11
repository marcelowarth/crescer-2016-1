public class ElfosVerdes extends Elfo
{
    public ElfosVerdes(String nome)
    {
        super(nome);
    }

    public ElfosVerdes(String nome, int flechas)
    {
        super(nome, flechas);
    }
    
    public void atirarFlechaDwarfs(Dwarf dwarf) {
        super.atirarFlechaDwarfs(dwarf);
        super.experiencia++;
    }
    
    public void adicionarItem(Item item) {
        if (item.getDesc().equals("Espada de aço valiriano") || item.getDesc().equals("Arco e Flecha de Vidro"))
            inventario.adicionarItem(item);
    }
}

public class Item
{
    // instance variables - replace the example below with your own
    private int qtde;
    private String desc;
    
    public Item(String desc, int qtde)
    {
        this.desc = desc;
        this.qtde = qtde;
    }
    
    public int getQtde() {
        return qtde;
    }
    
    public String getDesc() {
        return desc;
    }
    
    public void setQtde(int qtde) {
        this.qtde = qtde;
    }
    
    public boolean equals(Object obj) {
        Item outro = (Item)obj;
        return this.getQtde() == outro.getQtde() && 
        this.getDesc() != null && 
        outro.getDesc() != null && 
        this.getDesc() == outro.getDesc();
    }
}


//Example of Factory pattern
public abstract class Tool
{
   private String tool_name;
   public int avaliable = 0;
   private int price;
   public void give_price(int price){this.price = price;}
   public void give_name(String name){this.tool_name = name;}
   public String get_name(){return this.tool_name;}
   public int get_price(){return this.price;}
   public void rent_out(){ avaliable = 1;}
   public void return_back(){ avaliable = 0;}

}

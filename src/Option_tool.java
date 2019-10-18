
//use decorate pattern in optional tools
//this class is similar to the class Tool
public abstract class Option_tool
{

  private String tool_name;
  private int price;
  public void give_price(int price){this.price = price;}
  public void give_name(String name){this.tool_name = name;}
  public String get_name(){return this.tool_name;}
  public int get_price(){return this.price;}
}

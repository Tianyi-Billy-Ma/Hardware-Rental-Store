
import java.util.Random;
public class Optional_assemble
{

  private int num_accessory_kit = 0;
  private int num_extension_cord = 0;
  private int num_protective_gear = 0;
  public Optional_assemble()
  {
    Random rand = new Random();
    int num_option = rand.nextInt(7);
    for(int i = 0; i < num_option; i++)
    {
      int opt = rand.nextInt(3);
      if(opt == 0){this.num_accessory_kit = this.num_accessory_kit +  1;}
      else if(opt ==1){this.num_extension_cord = this.num_extension_cord + 1;}
      else{this.num_protective_gear = this.num_protective_gear + 1;}
    }

  }
  public int get_accessory_kit(){return this.num_accessory_kit;}
  public int get_extension_cord(){return this.num_extension_cord;}
  public int get_protective_gear(){return this.num_protective_gear;}
  public int get_price_option()
  {
    int price = 0;
    Accessory_kit one = new Accessory_kit();
    Extension_cord two = new Extension_cord();
    Protective_gear three = new Protective_gear();
    price = price + one.get_price() * this.num_accessory_kit;
    price = price + two.get_price() * this.num_extension_cord;
    price = price + three.get_price() * this.num_protective_gear;
    return price;
  }
}

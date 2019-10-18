import java.util.Arrays;
import java.util.List;
import java.util.Random;
public class Rent_record
{
  private int days;
  private int restdays;
  private Customer person;
  private Tool[] tools;
  public int size;
  private int price = 0;
  private Optional_assemble option_tools;
  private int completed = 1;
  public int check_status(){ return completed;}
  public void comp_record(){ completed = 0;}
  public void init_Rent_record( Customer person, Tool[] tools,int size, int days, Optional_assemble option_tools)
  {
    this.person = person;
    this.tools = tools;
    this.days = days;
    this.restdays = days;
    this.size = size;
    this.option_tools = option_tools;
    for(int i = 0; i < size; i++)
    {
      this.price = this.price + tools[i].get_price();
    }
    this.price = this.price * days + this.option_tools.get_price_option();

  }
  public void move_one_day()
  {
    if(this.restdays>0){this.restdays = this.restdays -1;}
    if(this.restdays== 0){completed = 0;}
  }
  public int get_rest_days(){return this.restdays;}
  public Customer get_customer(){return this.person;}
  public Tool[] get_tools(){return this.tools;}
  public int get_price(){return this.price;}
  public int get_size(){return this.size;}
  public String print_out()
  {
    String text = "";
    text  = text + person.get_name() + " rents ";
    for(int i = 0; i < this.size; i++)
    {
      text = text + tools[i].get_name() + " ";
    }
    text = text + "and " + Integer.toString(this.option_tools.get_accessory_kit())+ " accessory_kit " + Integer.toString(this.option_tools.get_extension_cord())+ " extension_cord " + Integer.toString(this.option_tools.get_protective_gear()) + " protective_gear";
    text = text + " for " + Integer.toString(this.days) + " days.";
    return text;
  }
}

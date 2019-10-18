package Store;
import Customer_folder.Customer;
import Customer_folder.Customer_assemble;
import Tool_folder.Tool;
import Tool_folder.Tool_assemble;
import Option.Option_tool;
import Store.Store;
import Option.Optional_assemble;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
public class Comp_record extends Rent_record
{
  private int completed = 1;
  public int check_status(){ return completed;}
  public void comp_record(){ completed = 0;}
}

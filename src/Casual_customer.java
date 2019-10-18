import java.util.Arrays;
import java.util.List;
import java.util.Random;
public class Casual_customer extends Customer
{
  public Casual_customer(String name){super.give_name(name);}
  @Override
  public int getmindays(){return 1;}
  public int getmaxdays(){return 2;}
  public int getmaxtools(){return 2;}
  public int getmintools(){return 1;}
  public String get_customer_type(){return "Casual";}

}

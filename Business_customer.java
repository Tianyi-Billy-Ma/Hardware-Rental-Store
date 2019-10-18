
public class Business_customer extends Customer
{
  public Business_customer(String name){super.give_name(name);}
  @Override
  public int getmindays(){return 7;}
  public int getmaxdays(){return 7;}
  public int getmaxtools(){return 3;}
  public int getmintools(){return 3;}
  public String get_customer_type(){return "Business";}
}

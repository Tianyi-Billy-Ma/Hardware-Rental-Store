

public class Regular_customer extends Customer
{
  public Regular_customer(String name){super.give_name(name);}
  @Override
  public int getmindays(){return 3;}
  public int getmaxdays(){return 5;}
  public int getmaxtools(){return 3;}
  public int getmintools(){return 1;}
  public String get_customer_type(){return "Regular";}
}



public abstract class Customer
{
  private String customer_name;
  public void give_name(String name){this.customer_name = name;}
  public String get_name(){ return this.customer_name;}
  public abstract int getmindays();
  public abstract int getmaxdays();
  public abstract int getmaxtools();
  public abstract int getmintools();
  public String get_customer_type(){return "customer";}
}

public class Comp_record extends Rent_record
{
  private int completed = 1;
  public int check_status(){ return completed;}
  public void comp_record(){ completed = 0;}
}

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Store
{
  private int num_rental = 0;
  private int revenue = 0;
  private Customer[] customers;
  private Tool[] tools;
  private Rent_record[] rent_records;
  public int rent_record_size = 0;
  private int date = 0;
  private int[] avaliable_items = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23};
  private int[] unavaliable_items = new int[24];
  private int today_revenue;
  private int total_revenue;
  public int get_total_revenue(){return this.total_revenue;}
  public Rent_record[] get_records(){return rent_records;}
  public void init_store(Customer[] customers,Tool[] tools)
  {
    this.date = 0;
    this.customers = customers;
    this.tools = tools;
    this.rent_records = new Rent_record[1000];
    this.rent_record_size = 0;
    this.today_revenue = 0;
    this.total_revenue = 0;
  }
  public void simulation(int date)
  {
    this.today_revenue = 0;
    System.out.println("Day " + Integer.toString(date));
    if(this.rent_record_size > 0)
    {
      System.out.println("Here is the completed records");
      for(int j = 0; j < rent_record_size; j++)
      {
        this.rent_records[j].move_one_day();
        if(this.rent_records[j].check_status() == 0)
        {
          System.out.println(this.rent_records[j].print_out());}
          for(int m = 0; m < this.rent_records[j].size; m++)
          {
            for(int n = 0; n <  24; n++)
            {
              if(this.rent_records[j].get_tools()[m].get_name() == this.tools[n].get_name() && this.tools[n].avaliable == 1)
              {
                this.tools[n].return_back();
                System.out.println(this.tools[n].get_name());
                Context context = new Context(new Return_tools());
                context.execute();
              }
            }
          }
        }
      }
    else
    {
      System.out.println("There is no completed record");
    }
    Random rand = new Random();
    int visit_customers = rand.nextInt(4) + 1;
    System.out.println("Today active record:");
    for(int k = 0 ; k < visit_customers; k ++)
    {
        int customer_idx = rand.nextInt(12);
        Customer person = this.customers[customer_idx];
        Rent_record person_record = do_rent(person);
        if(person_record != null)
        {
          this.rent_records[rent_record_size] = person_record;
          rent_record_size = rent_record_size + 1;
          this.today_revenue = this.today_revenue + person_record.get_price();

          System.out.println(person_record.print_out());
        }
    }
    System.out.println("The following tools left in the store");
    String text = "";
    for(int k = 0; k < 24; k++)
    {
      if(tools[k].avaliable == 0)
      { text = text  + tools[k].get_name() + " ";}
    }
    this.total_revenue = this.total_revenue + this.today_revenue;
    System.out.println(text);
    System.out.println("Today, Billy store earned " + Integer.toString(this.today_revenue) + "  dollars.");

  }

  public Rent_record do_rent(Customer person)
  {
    Random r = new Random();
    //List<String> types = Arrays.asList("Painting", "Concrete", "Plumbing", "Woodwork", "Yardwork");
    int rent_days = r.nextInt((person.getmaxdays() - person.getmindays()) + 1) + person.getmindays();
    int num_tools_rent = r.nextInt((person.getmaxtools() - person.getmintools()) + 1) + person.getmintools();
    Tool[] rent_tools = new Tool[num_tools_rent];
    int tools_idx = 0;
    for(int i = 0; i < num_tools_rent; i++)
    {
      for(int j = 0; j < 24; j++)
      {
        if(this.tools[j].avaliable == 0 &&  tools_idx< num_tools_rent)
        {
          rent_tools[tools_idx] = this.tools[j];
          tools_idx = tools_idx + 1;
          this.tools[j].rent_out();
          System.out.println(this.tools[j].get_name());
          Context context = new Context( new Borrow_tools());
          context.execute();
        }
      }
    }
    if(tools_idx  == num_tools_rent)
    {
      Optional_assemble tmp = new Optional_assemble();
      Rent_record tmp_record = new Rent_record();
      tmp_record.init_Rent_record(person,rent_tools,tools_idx,rent_days,tmp);
      return tmp_record;
    }
    else{return null;}
  }
}

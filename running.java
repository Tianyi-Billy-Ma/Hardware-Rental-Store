import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;
public class running{
  private Rent_record[] rent_records = new Rent_record[24];
  private int rent_record_size = 0;
    public static void main(String[] args)
    {
        Customer[] customers = create_customers();
        /*
        for(int i = 0; i < 12 ; i++)
        {System.out.println(customers[i].get_name());}
        */
        //Create Tools;
        Tool[] tools = create_tools();
        //Optional_assemble tmp = new Optional_assemble();
        //System.out.println(tmp.get_price_option());
        Store Billy_store = create_store();
        for(int date = 1; date<=35; date++ )
        {Billy_store.simulation(date);}

        Rent_record[] total_record = Billy_store.get_records();
        int casual_rents = 0;
        int business_rents = 0;
        int regular_rents = 0;
        for(int i = 0; i < Billy_store.rent_record_size; i ++)
        {
          if(total_record[i].get_customer().get_customer_type() == "Business"){business_rents = business_rents + 1; }
          else if(total_record[i].get_customer().get_customer_type() == "Regular")
            {
              regular_rents = regular_rents + 1;
            }
          else{casual_rents = casual_rents + 1; }
        }
        System.out.println("The Casual customer make " + Integer.toString(casual_rents) + " rents");
        System.out.println("The Regualr customer make " + Integer.toString(regular_rents) + " rents");
        System.out.println("The Business customer make " + Integer.toString(business_rents) + " rents");
        System.out.println("The total revenue is " + Integer.toString(Billy_store.get_total_revenue()));
      }

    public static Customer[] create_customers()
    {
      Customer[] customers = new Customer[12];
      //Create customers;
      List<String> customer_list = Arrays.asList("Cathine", "Chairly", "Cara","Carman","Billy","Baily","Bella","Barbie","Raven","Rena","Raymond","Ralph");
      for(int i = 0; i < 12 ; i++)
      {
        String customer_name = customer_list.get(i);
        String firstChar = customer_name.substring(0,1);
        if(firstChar.equals("C")){customers[i] = Customer_assemble.get_customer("Casual",customer_name);}
        else if(firstChar.equals("B")){customers[i] = Customer_assemble.get_customer("Business",customer_name);}
        else{customers[i] = Customer_assemble.get_customer("Regular",customer_name);}
      }
      return customers;
    }
    public static Tool[] create_tools()
    {
      int[] tool_numbers = {5,5,5,5,4};
      Tool[] tools = new Tool[24];
      int idx = 0;
      //tools[idx] = Tool_assemble.get_category("Painting","Paint " + Integer.toString(1));
      for(int i = 0; i < 5; i++)
      {
        for(int j = 0; j < tool_numbers[i]; j++)
        {
          if(i == 0)
          {
            tools[idx] = Tool_assemble.get_category("Painting","Paint " + Integer.toString(j));
            idx = idx + 1;
          }
          else if (i == 1)
          {
            tools[idx] = Tool_assemble.get_category("Concrete","Concrete " + Integer.toString(j));
            idx = idx + 1;
          }
          else if (i == 2)
          {
            tools[idx] = Tool_assemble.get_category("Plumbing","Plumbing " + Integer.toString(j));
            idx = idx + 1;
          }
          else if (i == 3)
          {
            tools[idx] = Tool_assemble.get_category("Woodwork","Woodwork " + Integer.toString(j));
            idx = idx + 1;
          }
          else if (i == 4)
          {
            tools[idx] = Tool_assemble.get_category("Yardwork","Yardwork " + Integer.toString(j));
            idx = idx + 1;
          }
        }
      }
      return tools;
    }
    public static Store create_store()
    {
      Store Billy_store = new Store();
      Customer[] customers = create_customers();
      Tool[] tools = create_tools();
      Billy_store.init_store(customers,tools);
      return Billy_store;
    }

}

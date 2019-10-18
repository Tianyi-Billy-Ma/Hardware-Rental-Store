

public class Customer_assemble{

    public static Customer get_customer(String type,String name)
    {
        if(type.equals("Regular")) {return new Regular_customer(name);}
        if(type.equals("Business")){return new Business_customer(name);}
        if(type.equals("Casual")) {return new Casual_customer(name);}
        else{return null;}
    }
}

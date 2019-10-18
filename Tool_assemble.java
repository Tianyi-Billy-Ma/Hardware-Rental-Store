
public class Tool_assemble
{
  public static Tool get_category(String type, String name)
  {
    if(type.equals("Painting")) {return new Painting_tool(name);}
    if(type.equals("Concrete")) {return new Concrete_tool(name);}
    if(type.equals("Plumbing")) {return new Plumbing_tool(name);}
    if(type.equals("Woodwork")) {return new Woodwork_tool(name);}
    if(type.equals("Yardwork")) {return new Yardwork_tool(name);}
    else{return null;}

  }
}

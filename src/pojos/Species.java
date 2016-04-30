package pojos;

public class Species extends BasicObject
{
  public String getString()
  {
    return getID() + " - " + getName();
  }
}

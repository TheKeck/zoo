package pojos;

public class Zoo extends BasicObject
{
  public String getString()
  {
    return getID() + " - " + getName();
  }
}

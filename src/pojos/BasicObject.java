package pojos;

public abstract class BasicObject
{
  private long ID;
  private String name;

  public long getID()
  {
    return ID;
  }

  public void setID(long ID)
  {
    this.ID = ID;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public abstract String getString();
}

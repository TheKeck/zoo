package pojos;

public class Animal extends BasicObject
{
  private long speciesID;
  private long zooID;

  public long getSpeciesID()
  {
    return speciesID;
  }

  public void setSpeciesID(long speciesID)
  {
    this.speciesID = speciesID;
  }

  public long getZooID()
  {
    return zooID;
  }

  public void setZooID(long zooID)
  {
    this.zooID = zooID;
  }

  public String getString()
  {
    return getID() + " - " + getName() + " - " + getSpeciesID() + " - " + getZooID();

  }
}

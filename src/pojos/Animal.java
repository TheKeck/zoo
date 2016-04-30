package pojos;

import db.ZooDatabaseMock;

public class Animal extends BasicObject
{
  private long speciesID;
  private long zooID;
  private Species species = null;
  private Zoo zoo = null;

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

  public Zoo getZoo()
  {
    if (zoo != null)
      return zoo;

    zoo = ZooDatabaseMock.getInstance().loadZoo(zooID);
    return zoo;
  }


  public Species getSpecies()
  {
    if (species != null)
      return species;

    species = ZooDatabaseMock.getInstance().loadSpecies(speciesID);
    return species;
  }

  public String getString()
  {
    return getID() + " - " + getName() + " - " + (getSpecies() != null ? getSpecies().getName() : "??") + " - " + (getZoo() != null ? getZoo().getName() : "??");
  }
}

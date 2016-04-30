package db;

import pojos.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;

public class ZooDatabaseMock
{
  private List<Animal> animalList = new Vector<>();
  private List<Zoo> zooList = new Vector<>();
  private List<Species> speciesList = new Vector<>();
  private List<Feeding> feedingList = new Vector<>();

  private static ZooDatabaseMock _global = new ZooDatabaseMock();

  public static ZooDatabaseMock getInstance()
  {
    return _global;
  }

  private ZooDatabaseMock()
  {
  }

  public void insertAnimal(Animal newAnimal)
  {
    newAnimal.setID(getNextID(animalList));
    animalList.add(newAnimal);
  }
  public void insertFeeding(long animalID, float amount, Date feeddate)
  {
    Feeding feeding = new Feeding();
    feeding.setID(getNextID(feedingList));
    feeding.setAnimalID(animalID);
    feeding.setAmount(amount);
    feeding.setFeeddate(feeddate);
    feedingList.add(feeding);
  }

  public List<Animal> getAnimalList()
  {
    return animalList;
  }

  public List<Animal> getAnimalGroup(long zooID, long speciesID)
  {
    List<Animal> groupAnimals = new Vector<>();
    for (Animal animal : animalList)
    {
      if (animal.getZooID() == zooID && animal.getSpeciesID() == speciesID)
        groupAnimals.add(animal);
    }
    return groupAnimals;
  }

  public List<Zoo> getZooList()
  {
    return zooList;
  }

  public List<Species> getSpeciesList()
  {
    return speciesList;
  }

  public void insertZoo(String name)
  {
    Zoo newZoo = new Zoo();
    newZoo.setID(getNextID(zooList));
    newZoo.setName(name);
    zooList.add(newZoo);
  }

  public void insertSpecies(String name)
  {
    Species newSpecies = new Species();
    newSpecies.setID(getNextID(speciesList));
    newSpecies.setName(name);
    speciesList.add(newSpecies);
  }

  public long getNextID(List<? extends BasicObject> list)
  {
    long largestID = 0;
    for (BasicObject object : list)
    {
      if (object.getID() > largestID)
        largestID = object.getID();
    }
    return largestID + 1;
  }

  public Zoo loadZoo(long id)
  {
    for (Zoo zoo : zooList)
    {
      if (id == zoo.getID())
        return zoo;
    }
    return null;
  }

  public Species loadSpecies(long id)
  {
    for (Species species : speciesList)
    {
      if (id == species.getID())
        return species;
    }
    return null;
  }

  public Animal loadAnimal(long id)
  {
    for (Animal animal : animalList)
    {
      if (id == animal.getID())
        return animal;
    }
    return null;
  }

  public List<Feeding> getFeedingList()
  {
    return feedingList;
  }
}

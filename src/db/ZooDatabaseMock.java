package db;

import pojos.Animal;

import java.util.List;
import java.util.Vector;

public class ZooDatabaseMock
{
  private List<Animal> animalList = new Vector<>();

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
    animalList.add(newAnimal);
  }

  public List<Animal> getAnimalList()
  {
    return animalList;
  }
}

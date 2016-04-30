import db.ZooDatabaseMock;
import org.apache.commons.lang.StringUtils;
import pojos.Animal;

import java.io.Console;
import java.util.List;

public class Main
{
  public static void main (String[] args)
  {
    String input = null;
    while (!StringUtils.equalsIgnoreCase("0", input))
    {
      System.out.println("\n\nWhat would you like to do?");
      System.out.println("1) Add a new animal");
      System.out.println("2) See list of animals");
      System.out.println("0) Exit (Data will not be saved!)");
      Console console = System.console();
      input = console.readLine();

      if (StringUtils.equalsIgnoreCase("1", input))
        addAnimal();
      else if (StringUtils.equalsIgnoreCase("2", input))
        listAnimals();
      else if (StringUtils.equalsIgnoreCase("0", input))
        System.out.println("Goodbye!");
      else
        System.out.println("Command not understood");
    }
  }

  private static void addAnimal()
  {
    Animal animal = new Animal();
    animal.setID(1);
    animal.setName("Animal");
    animal.setSpeciesID(1);
    animal.setZooID(1);
    ZooDatabaseMock.getInstance().insertAnimal(animal);
  }

  private static void listAnimals()
  {
    List<Animal> animals = ZooDatabaseMock.getInstance().getAnimalList();
    for (Animal animal : animals)
      System.out.println(animal.getString());
  }
}

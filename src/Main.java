import db.ZooDatabaseMock;
import org.apache.commons.lang.StringUtils;
import pojos.Animal;
import pojos.Feeding;
import pojos.Species;
import pojos.Zoo;
import services.ReportService;

import java.io.Console;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Main
{
  public static void main (String[] args)
  {
    if (args.length > 0 && StringUtils.equalsIgnoreCase(args[0], "debug"))
      populateSomeData();

    String input = null;
    while (!StringUtils.equalsIgnoreCase("0", input))
    {
      System.out.println("\n\nWhat would you like to do?");
      System.out.println("1) Add a new animal");
      System.out.println("2) See list of animals");
      System.out.println("3) Add a zoo");
      System.out.println("4) Add a species");
      System.out.println("5) List feedings");
      System.out.println("6) Record a feeding");
      System.out.println("7) Individual Animal Feeding Record Report");
      System.out.println("0) Exit (Data will not be saved!)");
      Console console = System.console();
      input = console.readLine();

      if (StringUtils.equalsIgnoreCase("1", input))
        addAnimal();
      else if (StringUtils.equalsIgnoreCase("2", input))
        listAnimals();
      else if (StringUtils.equalsIgnoreCase("3", input))
        addZoo();
      else if (StringUtils.equalsIgnoreCase("4", input))
        addSpecies();
      else if (StringUtils.equalsIgnoreCase("5", input))
        listFeedings();
      else if (StringUtils.equalsIgnoreCase("6", input))
        addFeeding();
      else if (StringUtils.equalsIgnoreCase("7", input))
        displayFeedingReport();
      else if (StringUtils.equalsIgnoreCase("0", input))
        System.out.println("Goodbye!");
      else
        System.out.println("Command not understood");
    }
  }

  private static void addAnimal()
  {
    Animal animal = new Animal();

    System.out.println("What is the name of the animal?");
    Console console = System.console();
    String input = console.readLine();
    animal.setName(input);

    System.out.println("What is the species of the animal?");
    listSpecies();
    input = console.readLine();
    animal.setSpeciesID(Long.parseLong(input));

    System.out.println("What is the zoo of the animal?");
    listZoos();
    input = console.readLine();
    animal.setZooID(Long.parseLong(input));

    ZooDatabaseMock.getInstance().insertAnimal(animal);
  }

  private static void addFeeding()
  {
    try
    {
      System.out.println("What zoo are you at?");
      listZoos();
      Console console = System.console();
      String input = console.readLine();
      long zooID = Long.parseLong(input);

      System.out.println("What is the species being fed?");
      listSpecies();
      input = console.readLine();
      long speciesID = Long.parseLong(input);

      System.out.println("Which animal was fed?");
      listAnimalsInGroup(zooID, speciesID);
      input = console.readLine();
      long animalID = Long.parseLong(input);

      System.out.println("How much did the animal eat?");
      input = console.readLine();
      float amount = Float.parseFloat(input);

      System.out.println("When was the feeding (mm/dd/yyyy)?");
      input = console.readLine();
      Date  feeddate = Feeding.sdf.parse(input);
      ZooDatabaseMock.getInstance().insertFeeding(animalID, amount, feeddate);
    }
    catch (Exception e)
    {
      System.out.println("Couldn't store feeding: " + e.getMessage());
      return;
    }
  }

  private static void listAnimals()
  {
    System.out.println("ID - Name - Species - Zoo");
    List<Animal> animals = ZooDatabaseMock.getInstance().getAnimalList();
    for (Animal animal : animals)
      System.out.println(animal.getString());
  }

  private static void listAnimalsInGroup(long zooID, long speciesID)
  {
    System.out.println("ID - Name - Species - Zoo");
    List<Animal> animals = ZooDatabaseMock.getInstance().getAnimalGroup(zooID, speciesID);
    for (Animal animal : animals)
      System.out.println(animal.getString());
  }

  private static void listFeedings()
  {
    System.out.println("Animal - Amount - Date");
    List<Feeding> feedings = ZooDatabaseMock.getInstance().getFeedingList();
    for (Feeding feeding : feedings)
      System.out.println(feeding.getString());
  }

  private static void listSpecies()
  {
    for (Species species : ZooDatabaseMock.getInstance().getSpeciesList())
      System.out.println(species.getString());
  }

  private static void listZoos()
  {
    for (Zoo zoo : ZooDatabaseMock.getInstance().getZooList())
      System.out.println(zoo.getString());
  }

  private static void addZoo()
  {
    System.out.println("What is the name of the zoo?");
    Console console = System.console();
    String input = console.readLine();
    ZooDatabaseMock.getInstance().insertZoo(input);
  }


  private static void addSpecies()
  {
    System.out.println("What is the name of the species?");
    Console console = System.console();
    String input = console.readLine();
    ZooDatabaseMock.getInstance().insertSpecies(input);
  }


  private static void populateSomeData()
  {
    ZooDatabaseMock.getInstance().insertSpecies("Lion");
    ZooDatabaseMock.getInstance().insertSpecies("Monkey");
    ZooDatabaseMock.getInstance().insertZoo("San Diego");
    ZooDatabaseMock.getInstance().insertZoo("Washington DC");
    Animal animal = new Animal();
    animal.setName("Leo");
    animal.setZooID(1);
    animal.setSpeciesID(1);
    ZooDatabaseMock.getInstance().insertAnimal(animal);
    animal = new Animal();
    animal.setName("George");
    animal.setZooID(2);
    animal.setSpeciesID(2);
    ZooDatabaseMock.getInstance().insertAnimal(animal);
    ZooDatabaseMock.getInstance().insertFeeding(1, 3, Calendar.getInstance().getTime());
    ZooDatabaseMock.getInstance().insertFeeding(1, 2.5f, Calendar.getInstance().getTime());
    ZooDatabaseMock.getInstance().insertFeeding(2, .25f, Calendar.getInstance().getTime());
    ZooDatabaseMock.getInstance().insertFeeding(2, .3f, Calendar.getInstance().getTime());
  }

  private static void displayFeedingReport()
  {
    ReportService.displayFeedingReport();
  }

}

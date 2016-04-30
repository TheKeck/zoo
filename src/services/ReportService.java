package services;

import db.ZooDatabaseMock;
import pojos.Animal;
import pojos.Feeding;

import java.util.*;

public class ReportService
{
  public static void displayFeedingReport()
  {
    List<Animal> animalList = ZooDatabaseMock.getInstance().getAnimalList();
    for (Animal animal : animalList)
    {
      List<Feeding> feedings = ZooDatabaseMock.getInstance().loadFeedingsForAnimal(animal.getID());
      float totalAmount = 0;
      Set<String> days = new HashSet<>();
      for (Feeding feeding : feedings)
      {
        String date = feeding.getFeeddateString();
        days.add(date);
        totalAmount += feeding.getAmount();
      }
      int numDays = days.size();
      float averageAmount = totalAmount / Float.valueOf(numDays);
      System.out.println(animal.getString() + " - " + averageAmount + " per day (avg)");
    }
  }
}

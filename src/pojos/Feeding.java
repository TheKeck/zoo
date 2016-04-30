package pojos;

import db.ZooDatabaseMock;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Feeding extends BasicObject
{
  private long animalID;
  private Animal animal = null;
  private float amount;
  private Date feeddate;
  public static SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

  public long getAnimalID()
  {
    return animalID;
  }

  public void setAnimalID(long animalID)
  {
    this.animalID = animalID;
  }

  public float getAmount()
  {
    return amount;
  }

  public void setAmount(float amount)
  {
    this.amount = amount;
  }

  public Date getFeeddate()
  {
    return feeddate;
  }

  public void setFeeddate(Date feeddate)
  {
    this.feeddate = feeddate;
  }
  
  public Animal getAnimal()
  {
    if (animal != null)
      return animal;

    animal = ZooDatabaseMock.getInstance().loadAnimal(animalID);
    return animal;
  }
  

  @Override
  public String getString()
  {
    return (getAnimal() != null ? getAnimal().getName() : "??") + " - " + amount + " - " + Feeding.sdf.format(feeddate);
  }
}

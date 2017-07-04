// Exercise 5.8: ParkingCharges5_8.java
// Write the method calculateCharge to determine
// how much each customer owes for parking
import java.util.Scanner;

public class ParkingCharges5_8
{
  double hours;
  double cost;
  double totalReceipts;

  public void calculateCharge()
  {
    Scanner input = new Scanner(System.in);

    System.out.print("Enter hours parked or -1 to quit\n");
    hours = input.nextDouble();

    while (hours != -1)
    {
      double minutes = hours * 60;

      if(minutes <= 180)
      {
        cost = 2.00;
      }

      if(minutes > 180)
      {
        if(minutes % 60 == 0)
        {
          cost = 2.00 + (((minutes - 180) / 60) * 0.50);
        }
        else
        {
          minutes = minutes - (minutes % 60);
          cost = 2.50 + (((minutes - 180) / 60) * 0.50);
        }
      }

      if(cost > 10.00)
        cost = 10.00;

      System.out.printf("The total charge for this customer is %.02f\n", cost);

      totalReceipts += cost;

      System.out.print("Enter hours parked or -1 to quit\n");
      hours = input.nextDouble();
    }

    System.out.printf("The total receipts are %.02f\n", totalReceipts);

  }

  public static void main(String[] args)
  {
    ParkingCharges5_8 customers = new ParkingCharges5_8();

    customers.calculateCharge();
  }
}

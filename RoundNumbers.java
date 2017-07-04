// Exercise 5.10: RoundNumbers.java
// Write a program that reads a value and displays the original value
// the number rounded to the nearest integer, nearest tenth,
// nearest hundredth and nearest thousandth
import java.util.Scanner;

public class RoundNumbers
{
  public static void main(String[] args)
  {
    double number;

    Scanner input = new Scanner(System.in);

    System.out.print("Please enter a value with at least 5 decimal points: ");
    number = input.nextDouble();

    System.out.printf("Original Value: %f%n", number);
    roundToInteger(number);
    roundToTenths(number);
    roundToHundredths(number);
    roundToThousandths(number);
  }

  public static void roundToInteger(double number)
  {
    double integerValue = Math.floor(number + 0.5);
    System.out.printf("Rounded to Integer: %.02f%n", integerValue);
  }

  public static void roundToTenths(double number)
  {
    double tenth = Math.floor(number * 10 + 0.5) / 10;
    System.out.printf("Rounded to Tenths: %.02f%n", tenth);
  }

  public static void roundToHundredths(double number)
  {
    double hundreth = Math.floor(number * 100 + 0.5) / 100;
    System.out.printf("Rounded to Hundredths: %.03f%n", hundreth);
  }

  public static void roundToThousandths(double number)
  {
    double thousandth = Math.floor(number * 1000 + 0.5) / 1000;
    System.out.printf("Rounded to Thousandths: %.04f%n", thousandth);
  }
}

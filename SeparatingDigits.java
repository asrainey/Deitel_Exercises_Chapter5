// Exercise 5.21 SeparatingDigits.java
// Write methods to accomplish three tasks:
// a) Calculate the integer part of the quotient when int a is divided by int b
// b) Calculate the integer remainder when int a is divided by int b
// c) Use the methods above to write a method displayDigits that receives
// an integer between 1 and 99999 and displays it as a sequence of digits
// each separated by 2 spaces
import java.util.Scanner;

public class SeparatingDigits
{
  public static void main(String[] args)
  {

    displayDigits();
  }

  public static int integerDivision(int a, int b)
  {
    int quotient = a / b;
    return quotient;
  }

  public static int integerRemainder(int a, int b)
  {
    int remainder = a % b;
    return remainder;
  }

  public static void displayDigits()
  {
	Scanner input = new Scanner(System.in);

	System.out.print("Please enter a value between 1 and 99999: ");
    int number = input.nextInt();

    int tenThousandsPlace = integerDivision(number, 10000);
    if(tenThousandsPlace > 0)
      System.out.printf("%d  ", tenThousandsPlace);
    else
      System.out.printf("   ");

    number = number - (tenThousandsPlace * 10000);

    int thousandsPlace = integerDivision(number, 1000);
    if(thousandsPlace > 0)
      System.out.printf("%d  ", thousandsPlace);
    else
      System.out.printf("   ");

    number = number - (thousandsPlace * 1000);

	int hundredsPlace = integerDivision(number, 100);
	    if(hundredsPlace > 0)
	      System.out.printf("%d  ", hundredsPlace);
	    else
      System.out.printf("   ");

	number = number - (hundredsPlace * 100);

    int tensPlace = integerDivision(number, 10);
    if(tensPlace > 0)
      System.out.printf("%d  ", tensPlace);
    else
      System.out.printf("   ");

    int onesPlace = integerRemainder(number, 10);
    System.out.printf("%d%n", onesPlace);
  }
}

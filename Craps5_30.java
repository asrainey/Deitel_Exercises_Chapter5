// Exercise 5.30: Craps5_30.java
// Craps class simulates the dice game craps.
// This version allows for wagering. Player starts with $1000
// Prompt player to enter a wager (compare to balance to make sure it is valid)
// Track the player's balance and end game when it is zero
// Also add chatter messages randomly

// 6-18 -> still need to add validation of wager and chatter messages

import java.security.SecureRandom;
import java.util.Scanner;

public class Craps5_30
{
  // create secure random number generator for use in method rollDice
  private static final SecureRandom randomNumbers = new SecureRandom();

  // enum type with constants that represent the game status
  private enum Status {CONTINUE, WON, LOST};

  // constants that represent common rolls of the dice
  private static final int SNAKE_EYES = 2;
  private static final int TREY = 3;
  private static final int SEVEN = 7;
  private static final int YO_LEVEN = 11;
  private static final int BOX_CARS = 12;

  // plays one game of craps
  public static void main(String[] args)
  {
    double bankBalance = 1000.00;

    while (bankBalance > 0)
    {
      double wager = makeWager(bankBalance);
      boolean result = playCraps();
      bankBalance = updateBalance(result, wager, bankBalance);
      if(bankBalance == 0)
      {
        System.out.println("Sorry. You busted");
      }
      else
      {
      makeChatter();
      keepPlaying();
      }
    }


  }

  public static boolean playCraps()
  {
    Status gameStatus;
    int myPoint = 0;
    int sumOfDice = rollDice();  // first roll of the dice

    // determine game status and point based on first roll
    switch(sumOfDice)
    {
      case SEVEN:    // win with 7 on the first roll
      case YO_LEVEN: // win with 11 on the first roll
      gameStatus = Status.WON;
      break;
      case SNAKE_EYES:  // lose with 2 on first roll
      case TREY:        // lose with 3 on first roll
      case BOX_CARS:    // lose with 12 on first roll
      gameStatus = Status.LOST;
      break;
      default:     // did not win or lose so remember point
      gameStatus = Status.CONTINUE;   // game is not over
      myPoint = sumOfDice;     // remember the point
      System.out.printf("Point is %d\n", myPoint);
      break;
    }
    // while game is not complete
    while(gameStatus == Status.CONTINUE)  // not WON or LOST
    {
      sumOfDice = rollDice();   // roll dice again

      // determine game status
      if(sumOfDice == myPoint) // win by making point
        gameStatus = Status.WON;
      else
      if(sumOfDice == SEVEN)   // lose by rolling 7 before point
        gameStatus = Status.LOST;
    }

    // display won or lost message
    if(gameStatus == Status.WON)
    {
      System.out.println("Player wins");
      return true;
    }
    else
    {
      System.out.println("Player loses");
      return false;
    }
  }

  // roll dice, calculate sum and display results
  public static int rollDice()
  {
    // pick random die values
    int die1 = 1 + randomNumbers.nextInt(6); // first die roll
    int die2 = 1 + randomNumbers.nextInt(6); // second die roll

    int sum = die1 + die2; // sum of die values

    // display the results of this roll
    System.out.printf("Player rolled %d + %d = %d\n", die1, die2, sum);

    return sum;
  }

  public static double makeWager(double bankBalance)
  {
    Scanner input = new Scanner(System.in);
    double wager;

    do
    {
    System.out.print("Please enter a valid wager: ");
    wager = input.nextDouble();
    } while (bankBalance < wager);

    return wager;
  }

  public static double updateBalance(boolean result, double wager,
    double bankBalance)
  {
    if(result == true)
    {
      bankBalance += wager;
      System.out.printf("Your current balance is %.2f\n", bankBalance);
    }
    else
    {
      bankBalance -= wager;
      System.out.printf("Your current balance is %.2f\n", bankBalance);
    }

    return bankBalance;
  }

  public static void keepPlaying()
  {
    Scanner input = new Scanner(System.in);

    System.out.print("Do you want to play again? Y/N: ");
      String status = input.nextLine();

    if (status.equalsIgnoreCase("N"))
    {
      System.out.println("Thank you for playing.");
      System.exit(0);
    }
  }

  public static void makeChatter()
  {
    int randomNumber = randomNumbers.nextInt(7);

    switch(randomNumber)
    {
        case 0:
          break;

        case 1:
          System.out.println("Oh, you're going for broke, huh?");
          break;

        case 2:
          System.out.println("Aw c'mon, take a chance!");
          break;

        case 3:
          break;

        case 4:
          System.out.println(
            "You're up big. Now's the time to cash in your chips!");
          break;

        case 5:
          System.out.println("Looks like we've got a pro over here!");
          break;

        default:
          break;
    }
  }
}

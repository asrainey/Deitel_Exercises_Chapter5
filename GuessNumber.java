// Exercise 5.30: GuessNumber.java
// This program choses a random integer between 1 and 1000
// It asks the user to guess the number
// If guess is incorrect, program says if guess was too high or too low

import java.util.Random;
import java.util.Scanner;

public class GuessNumber
{
  public static void main(String[] args)
  {
    GuessNumber game = new GuessNumber();

    game.guessNumber();
  }

  public void guessNumber()
  {
    Random randomNumber = new Random();
    Scanner input = new Scanner(System.in);

    int answer = 1 + randomNumber.nextInt(1000);

    System.out.print("Guess a number between 1 and 1000: ");
      int guess = input.nextInt();

      while (guess != answer)
      {
        if(guess > answer)
        {
          System.out.println("Too high. Try again");
          System.out.print("Guess a number between 1 and 1000: ");
            guess = input.nextInt();
        }
        else
        {
          System.out.println("Too low. Try again");
          System.out.print("Guess a number between 1 and 1000: ");
            guess = input.nextInt();
        }
      }

    System.out.println("Congratulations. You guessed the number!");
    GuessNumber g = new GuessNumber();
    g.keepPlaying();
  }

  public void keepPlaying()
  {
    Scanner input = new Scanner(System.in);
    GuessNumber g1 = new GuessNumber();

    System.out.print("Do you want to play again? Y/N: ");
      String status = input.nextLine();

    if (status.equalsIgnoreCase("Y"))
    {
      g1.guessNumber();
    }
    else
    {
      System.out.println("Thank you for playing.");
      System.exit(0);
    }
  }
}

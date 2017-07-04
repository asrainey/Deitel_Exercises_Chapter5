// Exercise 5.30: GuessNumberMod.java
// This program choses a random integer between 1 and 1000
// It asks the user to guess the number
// If guess is incorrect, program says if guess was too high or too low

import java.util.Random;
import java.util.Scanner;

public class GuessNumberMod
{
  public static void main(String[] args)
  {
    GuessNumberMod game = new GuessNumberMod();

    game.guessNumber();
  }

  public void guessNumber()
  {
    Random randomNumber = new Random();
    Scanner input = new Scanner(System.in);

    int answer = 1 + randomNumber.nextInt(1000);

    System.out.print("Guess a number between 1 and 1000: ");
      int guess = input.nextInt();
      int guessCount = 1;

      while (guess != answer)
      {
        if(guess > answer)
        {
          System.out.println("Too high. Try again");
          System.out.print("Guess a number between 1 and 1000: ");
            guess = input.nextInt();
          guessCount++;
        }
        else
        {
          System.out.println("Too low. Try again");
          System.out.print("Guess a number between 1 and 1000: ");
            guess = input.nextInt();
          guessCount++;
        }
      }

    System.out.println("Congratulations. You guessed the number!");

    if(guessCount < 10)
    {
      System.out.println("Either you know the secret or you got lucky.");
    }
    else if (guessCount == 10)
    {
      System.out.println("Aha! You know the secret!");
    }
    else
    {
      System.out.println("You should be able to do better");
    }

    GuessNumberMod g = new GuessNumberMod();
    g.keepPlaying();
  }

  public void keepPlaying()
  {
    Scanner input = new Scanner(System.in);
    GuessNumberMod g1 = new GuessNumberMod();

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

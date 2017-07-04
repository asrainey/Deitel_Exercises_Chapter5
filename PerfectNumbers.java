// Exercise 5.24: PerfectNumbers.Java
// Perfect number - number whose factors (including 1, but not the number)
// total up to the number itself
// Method isPerfect determines whether the parameter number is perfect
// Application should display all perfect numbers from 1 to 1000
// Display the factors for each of these numbers
// Test numbers larger than 1000

public class PerfectNumbers
{

	public static void main(String[] args)
	{
		PerfectNumbers n1 = new PerfectNumbers();

  	n1.displayPerfect();

	}

	public boolean isPerfect(int number)
	{
		int k = 1;
		int factorTotal = 0;

		while (k < number)
		{
			if(number % k == 0)
			{
				factorTotal +=k;
				k++;
			}
			else
				k++;
		}

		if (factorTotal == number)
		{
			System.out.printf("%d: ", number);

			for (int i = 1; i < number; i++)
			{
				if(number % i == 0)
				{
				System.out.printf("%d ", i);
				}
			}
			System.out.println();
			return true;
		}
		else
		{
			return false;
		}
	}

	public void displayPerfect()
	{
		System.out.printf("The perfect numbers from 1 to 1000 are:\n");

		PerfectNumbers n = new PerfectNumbers();
		int number = 1;

		while(number <= 1000)
		{
			n.isPerfect(number);
			number++;
		}
			//int n1 = isPerfect(number);

			//if(n1 != 0)
			//  System.out.printf("%d %n", n1);

			//	System.out.printf("\nOriginal number: %d\nFactor Total: %d\n",
			//		number, factorTotal);

	}
}

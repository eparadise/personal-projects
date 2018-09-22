/*Program that creates a guessing game where the computer picks a random number between 1 and 100 and the user has to guess the number.
The program tells the user if their guess is too high or too low after every guess and prints the total number of guesses (and a
statement about how good the guesser was) at the end. */
import java.util.Random;
import java.util.Scanner;
public class NumGuess {
	public static void Guess() {
		int max = 100;
		int numGuesses = 0;
		Random rand = new Random();
		int myNum = rand.nextInt(max + 1);
		int user = 0;
		System.out.println("I'm thinking of a number between 1 and 100. Think you can guess it? Enter a guess below.");
		Scanner scan = new Scanner(System.in);

		while (!scan.hasNextInt()) {
			System.out.println("Please enter an Integer.");
			scan.next();
		}
		user = scan.nextInt();
		numGuesses++;
		while (user != myNum) {
			if (user > myNum) {
				System.out.println("Your guess is too high. Try again.");
			}
			if (user < myNum) {
				System.out.println("Your guess is too low. Try again.");
			}
			while (!scan.hasNextInt()) {
				System.out.println("Please enter an integer.");
				scan.next();
			}
			user = scan.nextInt();
			numGuesses++;
		}

		System.out.println("Congrats! You guessed my number in " + numGuesses + " guesses.");
		if (numGuesses <= 5) {
			System.out.println("You're a pro!");
		}
		else if (numGuesses <= 10) {
			System.out.println("Not bad!");
		}
		else {
			System.out.println("You can do better than that!");
		}
		scan.close();
	}


	public static void main(String[] args) {
		Guess();
	}
}


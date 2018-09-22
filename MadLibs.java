import java.util.Scanner;

public class MadLibs {
	public static void MadLibGen() {
		String[] words = new String[6];
		System.out.println("Hi! Welcome to MadLibs. To complete the story 'A Day at the Park' please enter words as directed.");
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter an adjective.");
		words[0] = scan.next();
		System.out.println("Please enter a plural noun.");
		words[1] = scan.next();
		System.out.println("Please enter a verb.");
		words[2] = scan.next();
		System.out.println("Please enter an adjective.");
		words[3] = scan.next();
		System.out.println("Please enter an adverb.");
		words[4] = scan.next();
		System.out.println("Please enter a past tense verb.");
		words[5] = scan.next();
		scan.close();
		System.out.println("Here is your final story! Thanks for playing :).");
		System.out.println("Today I took a trip to the park. It is a very " + words[0] + " park.");
		System.out.println("There are many " + words[1] + " in the park. I decided to watch them " 
				+ words[2] + ".");
		System.out.println("After I watched them " + words[2] + " I felt very " + words[3] + ".");
		System.out.println("Because I felt " + words[3] + ", I " + words[4] + " " + words[5] + 
				". Wow! What a fun day.");
	}

	public static void main(String[] args) {
		MadLibGen();
	}

}

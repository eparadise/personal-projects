/*Program that simulates the roll of a die, printing the number the die "lands" on*/
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
public class DiceSim {
	public static int Dice() {
		int num = 0;
		int min = 1;
		int max = 6;
		
		/*Algorithm 1
		 * Uses a Random object to generate numbers
		Random rand = new Random();
		num = rand.nextInt(max + 1);
		return num;  */
		
		/* Algorithm 2
		 * Makes a list with the die values in it and shuffles it, returning whichever integer ends up at the first index
		 ArrayList<Integer> die = new ArrayList<>();
		 
		for (int i = min; i < max + 1; i++) {
			die.add(i);
		}
		Collections.shuffle(die);
		num = die.get(0);
		return num;
		*/
		return num;
	} 
	
	public static void main (String[] args) {
	for (int i = 0; i < 6; i++) {
		System.out.println(Dice());
	}
	}

}

package ovning10;

import java.util.Random;
import java.util.Scanner;

public class GuessWork {

	int numberOfTries = 0;
	int aRandomNumber = 0;
	
	public void runGuessLoop() {
		Scanner scanner = new Scanner(System.in);
		int scannedInt = -1;
		generateRandomNumber();
		boolean hasInt;
		while(true){
			hasInt= scanner.hasNextInt();
			if(hasInt == false){
				System.out.println("Gimme an int please.");
				scanner.next();
				continue;
			}
			scannedInt = scanner.nextInt();
			evaluateGuess(scannedInt);	
			
		}
	}
	
	private void evaluateGuess(int guessedInt){
		numberOfTries++;
		String higherLowerString = null;
		if(guessedInt < this.aRandomNumber){
			higherLowerString = "low";
		}else if(guessedInt > this.aRandomNumber){
			higherLowerString = "high";
		}else{
			reset();
		}
		if(higherLowerString != null){
			System.out.println("Too " + higherLowerString);
		}
	}
	
	private void generateRandomNumber(){
		Random aRandomObject = new Random();
		this.aRandomNumber = aRandomObject.nextInt(101);
	}
	
	private void reset(){
		String resultString = String.format("Success after %d %d %d tries", this.numberOfTries);
		System.out.println(resultString);
		this.numberOfTries = 0;
		generateRandomNumber();
	}
}

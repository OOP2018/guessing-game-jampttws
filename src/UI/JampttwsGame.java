package UI;
import java.util.Random;

/**
 * Game of guessing a secret number. 
 * @author Tanasorn Tritawisup
 *
 */
public class JampttwsGame extends NumberGame {
	
	private int upperBound;
	private int secret;
	public static int count;
	
	/** 
	 * Initialize a new game.
	 * @param upperBound is the max value for the secret number (>1)
	 */
	public JampttwsGame(int upperBound) {
		this.upperBound = upperBound;
		
		Random rand = new Random();
		this.secret = rand.nextInt(upperBound)+1;
		
		System.out.print(secret);
		
		super.setMessage("I'm thinking of a number between 1 and " + upperBound);
	}
	
	/**
	 * @param a number you guess.
     * @return true if you put the correct number.
	 */
	@Override
	public boolean guess(int number) {
		count++;
		setChanged();
		notifyObservers();
		if(number == secret){
			super.setMessage("Correct!!");
			return true;
		} else if(number > secret){
			super.setMessage("Your answer is too large.");
		} else if(number < secret){
			super.setMessage("Your answer is too small.");
		}
		return false;
	}

	/** Get the game upper bound. */
	public int getUpperBound() {
		return upperBound;
	}
	
	public String toString() {
		return "Guess a secret number between 1 and " + upperBound;
	}
	
	/**
	 * Get the times that you had guessed.
	 * @return count
	 */
	@Override
    public int getCount(){
		return count;   	
    }

}

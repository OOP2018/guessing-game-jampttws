package UI;
import java.util.Random;

/**
 * Automatically find the secret to any NumberGame.
 * @author Tanasorn Tritawisup
 *
 */
public class GameSolver {

	/**
	 * this class is use to find the answer o
	 * @param game is the NumberGame to solve.
	 * @return the correct answer of the game.
	 */
	public int play(NumberGame game){
		
		Random rand = new Random();
		int maxGuess = game.getUpperBound();
		int minGuess = 1;
		
		int guess = 0;
		boolean correct = game.guess(guess);
		
		while (!correct) {
			guess = rand.nextInt(maxGuess) + 1;
			while (guess < minGuess) {
				guess = rand.nextInt(maxGuess) + 1;
			}
			correct = game.guess(guess);
			if (correct) {
				break;
			}
			if (game.getMessage().contains("small")) {
				minGuess = guess + 1;
			}
			if (game.getMessage().contains("large")) {
				maxGuess = guess - 1;
			}
		}
		return guess;
	}
	
}

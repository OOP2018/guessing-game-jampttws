import java.util.Scanner;

/**
 * Play guessing game on the console.
 */
public class GameConsole {

	/** play the game. */
	public int play(NumberGame game) {
		Scanner console = new Scanner(System.in);

		// describe the game
		System.out.println(game.toString());

		// This is just an example.
		while (true) {
			System.out.println(game.getMessage());
			System.out.print("Your answer? ");
			int guess = console.nextInt();
			boolean correct = game.guess(guess);
			if (correct) {
				return guess;
			}

		}
	}

}

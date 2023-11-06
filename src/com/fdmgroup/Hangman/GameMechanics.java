package com.fdmgroup.Hangman;

import java.util.Scanner;

public class GameMechanics {
	
	private String randomGuessWord;
	private StringBuilder hiddenWord;
	private StringBuilder guessedLetters;
	private int maxGuesses;
	
	public GameMechanics(String randomGuessWord) {
		this.randomGuessWord = randomGuessWord.toUpperCase();
		this.hiddenWord = new StringBuilder("-".repeat(randomGuessWord.length()));
		this.guessedLetters = new StringBuilder();
		this.maxGuesses = 8;		
	}
	
	public void startHangmanGame() {
		
		Scanner scanner = new Scanner(System.in);
		
		while ( maxGuesses != 0 && hiddenWord.indexOf("-") != -1 ) {
			System.out.println("The word now looks like this: " + hiddenWord);
			//Displays number of guesses left
			if ( maxGuesses >1 )
				System.out.println("You have " + (maxGuesses) + " guesses left");
			else
				System.out.println("You only have " + (maxGuesses) + " guess left");
			//Displaying previous guessed letters
			System.out.println("Guessed Letters: " + guessedLetters.toString());
			
			System.out.print("Guess a letter: ");
			String input = scanner.nextLine().toUpperCase(); //toUpperCase changes all letters to upper case
			
			//Check if there is more than one character being input
			if ( input.length() != 1 ) {
				System.out.println("Please enter a single valid letter.");
				continue;
			}
			
			char guess = input.charAt(0);
			
			//Check that the guess is a valid letter
			if ( !Character.isLetter(guess) ) {
				System.out.println("Please enter a valid letter.");
				continue;
			}
			
			//Check for repeated guess
			if ( guessedLetters.indexOf(String.valueOf(guess)) != -1 ) {
				System.out.println("You've already guessed that letter. Try another letter");
				continue;
			}
			
			//For every guess added to the string guessed letter, add a space
			guessedLetters.append(guess).append(" ");
			
			//Guess is a valid and non-repeated letter
			if (randomGuessWord.indexOf(guess) != -1) {
				for ( int i = 0; i < randomGuessWord.length() ; i++ ) {
					if (randomGuessWord.charAt(i) == guess ) {
						hiddenWord.setCharAt(i, guess); //Correct letter guess and set the correct letter into the hidden word
														//No decrement of number of guesses for correct guess
					}
				}
				
				System.out.println("That guess is correct.");
			} else {
				System.out.println("There are no " + guess + "'s in the word." );
				maxGuesses--; //Number of guesses decrements on incorrect letter guess
			}
		}
		
		if (hiddenWord.indexOf("-") == -1) {
			//Display win message
			System.out.println("Congratulations! You guessed the word: " + randomGuessWord);
			System.out.println("You win.");
		} else {
			//Display lose message
			System.out.println("You're completely hung.");
			System.out.println("The word was: " + randomGuessWord);
			System.out.println("You lose.");
		}
		
		scanner.close();
	}

}

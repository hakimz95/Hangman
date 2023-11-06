package com.fdmgroup.Hangman;

public class HangmanGame {

	public static void main(String[] args) {
		//Guess word initialization
		RandomWord rWord = new RandomWord();
//		System.out.println(rWord.GuessWord());
		String randomGuessWord = rWord.GuessWord();
				
		//Hangman Game logic initialized
		GameMechanics gMech = new GameMechanics(randomGuessWord);
		gMech.startHangmanGame();
	}

}

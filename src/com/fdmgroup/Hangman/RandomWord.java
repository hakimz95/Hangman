package com.fdmgroup.Hangman;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class RandomWord {
	
	//Point to text file with the list of 30 words to be used for Hangman game
	private String filename = "guess_words.txt";
	private ArrayList<String> guessWords = new ArrayList<>();
		
	public String GuessWord() {
		//Read the file guess_words.txt
		try (BufferedReader bReader = new BufferedReader(new FileReader(filename))) {
			String line;
			while ((line = bReader.readLine()) != null) {
				//Add every line found in the file to the array list
				guessWords.add(line);
			}
		} catch (IOException e) {
			//Catch any error message when trying to read the file
			System.err.println("Error reading the file: " + e.getMessage());
			return e.getMessage();
		}
			
		//If the text file is empty
		if (guessWords.isEmpty()) {
			System.out.println("The file is empty");
			return null;
		}
			
		//Get a random entry from the array list guessWords
		Random random = new Random();
		int rIndex = random.nextInt(guessWords.size());
		String rGuessWord = guessWords.get(rIndex);
		return rGuessWord;
	}
	
}

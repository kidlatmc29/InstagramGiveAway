/* Copyright (C) 2018 Krystal Graylin, Isabel Ovalles - All Rights Reserved
 */

package com.krysabel.sort;
import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<String> people = new ArrayList<String>();
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner userInput = new Scanner(System.in); 
		System.out.println("Hello! Welcome to the random raffle picker.");
		
		boolean fileExists = false; 
		File inputFile = getInputFile(userInput, fileExists);
		
		
		addNamesToList(inputFile);
		pickWinner();
	}
	
	/**
	 * Private method that gets an input file name from user.
	 * 
	 * @param console
	 * @param fileExists
	 * @return inputFile
	 */
	private static File getInputFile(Scanner console, boolean fileExists) {
		File inputFile = null;

		while (!fileExists) {
			System.out.print("> Please enter input file name with file extention: ");
			String inputFileName = console.next();

			inputFile = new File(inputFileName.trim());

			fileExists = inputFile.exists();
			if (!inputFile.exists()) {

				System.out.println("> " + inputFileName + " does not exist!");
			}

		}
		return inputFile;
	}
	
	//puts file contents into ArrayList
	private static void addNamesToList (File inputFile) throws FileNotFoundException {
		Scanner readFile = new Scanner (inputFile);
	
		while (readFile.hasNextLine()) {
			//parse!!!!

			String line = readFile.nextLine();
			String[] person = line.split(",");
			String username = person[0]; 
			int numEntries = Integer.parseInt(person[1]);
			
			//Adding number of username entries based on how many entries the user has
			//Ex.) user: bob.xD number: 5 - > the username bob.xD will be added 5 times
			for(int x = numEntries; x > 0; x--){
				people.add(username);				
			}  
			
		}
	}
	
	
	
	//looking at ArrayList people then randomly picking a winner
	private static void pickWinner () {
	
		//find how many entries
		int size = people.size();
		//pick number from 0 to totalEntries - 1
		int picked = (int) (Math.random() * size);
		//refer to ArrayList and print winner name
		System.out.println("Out of a total of " + people.size() + " entries, the giveaway winner is @" + people.get(picked));
		
	}

	
	
	
}

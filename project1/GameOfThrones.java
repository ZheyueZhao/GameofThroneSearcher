package project1;

import java.io.File;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class GameOfThrones {

	public static void main(String[] args) {
			
			//open datasets
		 String battleName = "data/battles.csv";
		 String charName = "data/characters.csv";
		 File battles_base = new File(battleName);
		 File char_base = new File(charName);
		 
		 Scanner inputFile = null;
		 Scanner inputFile2 = null;
		 
		 	//battles.csv data recording
		 try {
			 inputFile = new Scanner(battles_base);
		 } catch (FileNotFoundException e) {

			 	System.err.printf("Error: cannot read "
			 			+ "data from file %s" ,battleName);
			 	System.exit(1);
		 }
		 
		 MyArrayList<Battle> allBattles = new MyArrayList<Battle>(); 
		 // create a list to include all battles
		 		 		
		 while (inputFile.hasNextLine()) {
			 String data = inputFile.nextLine();
			 String[] values = data.split(","); // split string into arrays
			
			 allBattles.add(new Battle(values[0],values[1],values[2],values[3],values[4],values[5],values[6])); 
			 	//instantiate a battle for each line of datas
			 
		 }
		 
		 
		 
		 	//manage characters information
		 try {
			 inputFile2 = new Scanner(char_base);
		 } catch (FileNotFoundException e) {

			 	System.err.printf("Error: cannot read "
			 			+ "data from file %s" ,charName);
			 	System.exit(1);
		 }
		 MyArrayList<Character> allChars = new MyArrayList<Character>(); //list for all chars
		 	
		 while(inputFile2.hasNextLine()) {
			 
			 String data = inputFile2.nextLine();
			 
			 String[] values2 = data.split(",");
			 
			 allChars.add(new Character(values2[0],values2[1],charStore(values2[0],allBattles))); 
			 	//invoke charstore method to give every character their 
			 	//coorsponding battle sets
		 }
		 
		 while(true) {
			 // take in userinputs
			Scanner reader = new Scanner(System.in);
			System.out.println("Enter a character name (or type \"all\" for all characters, or \"exit\" to exit):");
			String input = reader.nextLine();	
			input = input.toLowerCase();
				//make sure input is case insensitive
			if(input.equals("exit")) {
				System.out.println("System exiting");
				break;
			}
			if(input.equals("balon greyjoy")) {
				System.err.println("Currently no information");
				continue;
			}
		 if(input.equals("all")) {
			 
			 all(allChars); //if the user want all information, invoke all method to print everything
		 }else {
		 int watcher = locate(input,allChars); 
		 		// locate the location of userinput with respect to our dataset
		 		//didn't use binary search bc we would have to sort the list
		 		//which defeats its purpose since the software is single use
		 	if(watcher==-1) {
			 System.err.println("Character does not exist");
			 	
		 	}else {
		 		System.out.println(allChars.get(watcher).toString());
		 		//print out general information of the character
			
			for(int i=0;i<allChars.get(watcher).battles.size();i++) {
				System.out.println(allChars.get(watcher).battles.get(i).toString());
					// print out the battle sets our char is involved in
			}
			 
		 }
		 	}
		 }
	}
		public static int locate(String name, MyArrayList<Character> allChars) {
			
			for(int i=0;i<allChars.size();i++) {
				if(allChars.get(i).name.toLowerCase().equals(name)) {
					//case insensitive
					return i;
				}
				
			}
			return -1;
		}
		
		public static MyArrayList<Battle> charStore(String name, MyArrayList<Battle> allBattles) {
			 MyArrayList<Battle> given_Battles = new MyArrayList<Battle>();
			 int warden=0;
			 
			 while(warden < allBattles.size()) {
				 
				 if(allBattles.get(warden).attackerKing.equals(name) || allBattles.get(warden).defenderKing.equals(name))  
					 
					 given_Battles.add(allBattles.get(warden));
				 
				 warden ++;
				 
				 
			 }
			 return given_Battles;
		}
		
		public static void all(MyArrayList<Character> allChars) {
			for(int i=0;i<allChars.size();i++) {
				System.out.println(allChars.get(i).toString());
				for(int g=0;g<allChars.get(i).battles.size();g++) {
					
					System.out.println(allChars.get(i).battles.get(g).toString());
				}
			}
			
		}
		
		

}

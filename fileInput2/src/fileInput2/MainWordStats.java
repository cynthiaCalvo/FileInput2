/*
 * Cynthia C.
 * 20th March 2020
 */
package fileInput2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MainWordStats {

	public static void main(String[] args) {
		int character, y;
		String word = "";
		boolean first = true;
		
		try {
			FileReader reader = new FileReader("glob.txt");
			BufferedReader br = new BufferedReader(reader);
			
			ArrayList<WordStats> obj = new ArrayList<WordStats>();
			ArrayList<String> single = new ArrayList<String>();
			ArrayList<String> multiple = new ArrayList<String>();
			ArrayList<Integer> occurances = new ArrayList<Integer>();
			
			//will loop until there are no lines left
			while((character = br.read()) != -1) {
				y = 0;
				char c = (char)character;
				//will decide if charcter is a letter or not - and will do different actions depending on the answer
				if((c >= 'a') && (c <= 'z') || (c >= 'A') && (c <= 'Z')) {
					word+=c;
				}else {
					word = word.toLowerCase();
					//will decide of it's the first word or not
					if(first) {
						obj.add(new WordStats(word));
						obj.get(0).changeOccurance();
						first = false;
					}else {
						//will loop until the word matches one from an idex of the arraylist or will set a new one
						while(!word.equals(obj.get(y).returnWord())) {
							if(y >= (obj.size() - 1)) {
								obj.add(new WordStats(word));
								y = 0;
							}
							y++;
						}
						obj.get(y).changeOccurance();
					}
					word = "";
				}
			}
			
			//will loop for the number of words in the file
			for(int i = 0; i < obj.size(); i++) {
				//will set word as single or multiple dependingon number of occurances
				if(obj.get(i).returnOccurances() == 1) {
					single.add(obj.get(i).returnWord());
				}else {
					multiple.add(obj.get(i).returnWord());
					occurances.add(obj.get(i).returnOccurances());
				}
			}

			System.out.println("Word Occurances: ");
			
			//will print out all the words with multiple occurances as well as the number of occurances
			for(int i = 0; i < multiple.size(); i++) {
				System.out.println(multiple.get(i) + " " + occurances.get(i));
			}
			
			System.out.println("Unique Words: ");
			
			//will print out all the words with one occurance(unique words)
			for(String str:single) {
				System.out.println(str);
			}
			
			reader.close();
			
		}catch(IOException e) {
			System.out.println("This Doesn't Work");
		}

	}

}

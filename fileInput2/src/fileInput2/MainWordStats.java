/*
 * Cynthia C.
 * 20th March 2020
 */
package fileInput2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Input {

	public static void main(String[] args) {
		int character, y;
		String word = "";
		
		try {
			FileReader reader = new FileReader("glob.txt");
			BufferedReader br = new BufferedReader(reader);
			
			ArrayList<WordStats> obj = new ArrayList<WordStats>();
			ArrayList<String> single = new ArrayList<String>();
			ArrayList<String> multiple = new ArrayList<String>();
			ArrayList<Integer> occurances = new ArrayList<Integer>();
			
			while((character = br.read()) != -1) {
				y = 0;
				char c = (char)character;
				//
				if((c >= 'a') && (c <= 'z') || (c >= 'A') && (c <= 'Z')) {
					word+=c;
				}else {
					while(!word.equals(obj.get(y).returnWord())) {
						if(y >= obj.size()) {
							obj.add(new WordStats(word));
						}
						y++;
					}
					
					obj.get(y - 1).changeOccurance();
					word = "";
				}
			}
			
			for(int i = 0; i < obj.size(); i++) {
				if(obj.get(i).returnOccurances() == 1) {
					single.add(obj.get(i).returnWord());
				}else {
					multiple.add(obj.get(i).returnWord());
					occurances.add(obj.get(i).returnOccurances());
				}
			}

			System.out.println("Word Occurances: ");
			
			for(int i = 0; i < multiple.size(); i++) {
				System.out.println(multiple.get(i) + " " + occurances.get(i));
			}
			
			System.out.println("Unique Words: ");
			
			for(String str:single) {
				System.out.println(str);
			}
			
			reader.close();
			
		}catch(Exception e) {
			System.out.println("This doesn't work");
		}

	}

}

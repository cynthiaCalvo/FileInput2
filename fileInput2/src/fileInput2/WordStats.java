package fileInput2;

public class WordStats {
	private String word;
	private int occurance;
	
	public WordStats(String w) {
		word = w;
		occurance = 0;
	}
	
	public void changeOccurance() {
		occurance++;
	}
	
	public String returnWord() {
		return word;
	}
	
	public int returnOccurances() {
		return occurance;
	}

}

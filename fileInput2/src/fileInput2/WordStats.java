package fileInput2;

public class WordStats {
	private String word;
	private int occurance;
	
	/**
	 * will initialize word & occurances
	 * @param w
	 */
	public WordStats(String w) {
		word = w;
		occurance = 0;
	}
	
	/**
	 * will add one to occurances when called
	 */
	public void changeOccurance() {
		occurance++;
	}
	
	/**
	 * will return word
	 * @return
	 */
	public String returnWord() {
		return word;
	}
	
	/**
	 * will return the number of occurances for the word
	 * @return
	 */
	public int returnOccurances() {
		return occurance;
	}

}

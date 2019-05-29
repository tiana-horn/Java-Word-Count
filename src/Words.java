/* 
 Input[A URL]
 Output[The top 25 words on  that URL with 
 the number of  times that word is on the page]

Steps: 
Use Jsoup to parse info and get all words from page
Loop through and store count of how many times each word appears
sort through data to find biggest numbers
 */

import java.io.IOException;
import org.jsoup.Jsoup;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Map;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.HashMap;



public class Words {
	
	public int count;
	public int num=1;
	static Scanner userurl = new Scanner(System.in); {

	try {
		// Request URL from user
		System.out.println("Please paste a url and hit enter: ");
		
		// Make sure user input is a string
		if (userurl.hasNextLine()) {
			String url = userurl.nextLine();
		
		//Let user know the text is loading
		System.out.println("Thank you, text from your url will appear below shortly \n");	
		
		// Parse through url and get text
		String[] words = Jsoup.connect(url).get().text().split(" ");
		
		// Make a map of the words
		Map<String,Integer> wordCount = new HashMap<String,Integer>();
		
		// for each word taken from the url
		for(String word : words) {
			
			// calculate how many times that word appears
			String searchKey = word;
			if(wordCount.containsKey(searchKey)) {
				int num = wordCount.get(word);
				num++;
				wordCount.put(word, num);
							
			} else {
				wordCount.put(word,num);
			}
			
	
//			int[] sortCount = {num};
//			Arrays.sort(sortCount);
//			
//			for(int num: sortCount) {
//				System.out.println(wordCount.get(word) + ":" + word);
//			}
			
//			 working code to print unsorted Map 
//		for(Object key: wordCount.keySet()) {
//			System.out.println("\"" + key + "\"" + " appears " + wordCount.get(key) + " times.");	
//		System.out.println();
//		}
		
		}

		System.out.println(wordCount);
		System.out.println();
		
		Map.Entry<String,Integer> maxEntry = null;
		for(int i = 0;i <=25; i++) {
		
		for (Map.Entry<String,Integer> entry: wordCount.entrySet()) {
			
			 while(maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
			{		
				maxEntry = entry;
	
			} 
			wordCount.remove(maxEntry);
		}
		}
		
		System.out.println(maxEntry);
		}
		
//		LinkedList<Map.Entry<String,Integer>> list = new LinkedList<>(counter.entrySet());
//		Comparator<Map.Entry<String,Integer>> comparator = Comparator.comparing(Map.Entry::getValue);
//		Collections.sort(list, comparator);
//		}
		
		
		
	
	// log any errors
	} catch (IOException e) {
		e.printStackTrace(); }
	}
	


	// Call function
	public static void main(String[] args) {
		Words theWords = new Words();
		
	}
}

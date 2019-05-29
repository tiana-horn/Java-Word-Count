/* 
 Input[A URL]
 Output[The top 25 words on  that URL with 
 the number of  times that word is on the page]

Steps: 
Use Jsoup to parse info and get all words from page
Loop through and store count of how many times each word appears
sort through data to find biggest numbers

 * 
 * 
 * 
 */


import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.Scanner;
import java.util.Hashtable;
import java.util.Map;



public class Words {
	
	private static String words;
	public int count;
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
		
		
		// get the number of words in the url
		int size = words.length;
		System.out.println(size);
		
		// Make a map of the words
		Map wordCount = new Hashtable();
		
		
		// set the words as keys in the map
		for(String word : words) {
			wordCount.put(word, count);	
			
		}
		
		// print out the Map
		for(Object key: wordCount.keySet()) {
			System.out.println(key + ":" + wordCount.get(key));	
		}
		

		
		
		}
	
	// log any errors
	} catch (IOException e) {
		e.printStackTrace(); }
	}

	// Call function
	public static void main(String[] args) {
		Words theWords = new Words();
		
	}
		
		
		

}



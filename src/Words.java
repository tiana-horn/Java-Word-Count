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
import java.util.Map;
import java.util.HashMap;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


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
		System.out.println("Thank you, the top 25 words from your url will appear below, along with the number of times they are seen on the page \n");	
		
		// Parse through url and get text
		String[] words = Jsoup.connect(url).get().text().split(" ");
		
		// Make a map of the words
		Map<String,Integer> wordCount = new HashMap<String,Integer>();
		
		// for each word taken from the url
		for(String word : words) {
			
			// ignore special characters
			String spec[] = {"!", "@", "#", "$", "%", "^", "&", "*", "•", "-", ",","","/","=", "//", "{", "("};
			
			for(String c:spec) {
				wordCount.remove(c);
			}
			
			// calculate how many times that word appears
			String searchKey = word;
			
			
			if(wordCount.containsKey(searchKey)) {
				int num = wordCount.get(word);
				num++;
				wordCount.put(word, num);
							
			} else {
				wordCount.put(word,num);
			}		
		}
		// finds max value in list, loops 25 times
		Map.Entry<String,Integer> maxEntry = null;
		for(int i = 0;i < 25; i++) {
		for (Map.Entry<String,Integer> entry: wordCount.entrySet()) {
			 if(maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
			{		
				maxEntry = entry;
			} 
		}
		// prints out the max value and word, then sets that value to 0 so the next highest value can be found
		 System.out.println(maxEntry);
		 maxEntry.setValue(0);
		}		
		}
	// log any errors
	} catch (IOException e) {
		e.printStackTrace(); }
	}
	// Call main function
	public static void main(String[] args) {
		new Words();
	}
}

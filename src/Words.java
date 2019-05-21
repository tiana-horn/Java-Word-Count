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


public class Words {

	public static void main(String[] args) {
		System.out.println("running...");
		String words;
		try {
			// Parse through url and get text
			words = Jsoup.connect("https://people.com/tag/meghan-markle/").get().text();
			print("Text: "+ words);
		
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		print("done");
		
	}
	
	public static void print(String string) {
		System.out.println(string);
	}
		
		
		

}



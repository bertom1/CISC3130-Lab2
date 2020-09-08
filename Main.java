/* Class: CISC 3130
 * Section: TY9
 * EMPLID: 23908757
 * Name: Roberto Melchor
 */
import java.util.*;
import java.io.File;
import java.io.PrintWriter;

//separated Main and file reading/writing for better readability. 
public class Main {

	public static void main(String[] args) {
		//creates object for class that reads csv file and writes output file
		fileReadWrite test = new fileReadWrite();
		//runs object method to read file
		test.getArtistList();
		//prints number of artist
		System.out.println( "Number of artists: " + test.getNumberOfArtists());
		//creates and writes output file
		test.writeArtistList();
	}

}

//this class handles reading the input file and writing the output file
class fileReadWrite {
	
	//class variables that can only be accessed within the class
	private int numberOfArtists;
	//created HashMap as class variable to use within both read/write methods without creating a new HashMap
	private HashMap<String, Integer> hmap = new HashMap<String, Integer>();
	
	//returns the value of the private variable numberOfArtists
	int getNumberOfArtists() {
		return this.numberOfArtists;
	}
	
	//method to parse the csv file
	void getArtistList() {
			
		try {
			//variable for name of csv file
			//uses actual file name since it is stored in the same folder, can also use file path if stored elsewhere 
			String fileName = "regional-global-weekly-latest.csv";
			//Scanner with generic name to read from specified csv file
			Scanner scan = new Scanner(new File(fileName));
			//used to skip first line of file since it explains the file formatting
			scan.nextLine();
			while (scan.hasNextLine()) {
				//assigns the complete line from the csv file to a string
				String s = scan.nextLine();
				//array that contains the comma seperated values
				//regex is made to handle \" \" in lines to prevent improper formatting
				String[] fileLine = s.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
				//assigns third element to variable. With proper formatting, the artist name should fall under the third element
				String artist = fileLine[2];
				//checks if artist is already listed in HashMap
				if (hmap.containsKey(artist)) {
					//increments the Integer value for the artist,
					hmap.replace(artist, hmap.get(artist) + 1);
				}
				//adds new artist to HashMap and increases number of artists
				else {
					hmap.put(artist, 1);
					numberOfArtists += 1;
				}
			}
			scan.close();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	//Method to create and write file with artist
	void writeArtistList() {

		try {
		//creates new file
		File file = new File("Artists-WeekOf09032020.txt");
		//PrintWriter object with generic name to write into the text file.
		PrintWriter pw = new PrintWriter(file);
		//obtains all keys in HashMap and stores in a set
		Set<String> keys = hmap.keySet();
		//writes number of artists in file
		pw.println("Number of artists: " + numberOfArtists);
		//used to explain formatting within file
		pw.println("Formatting for file: \rArtist Name: number of apperances");
		//loop to write artists into file along with their number of occurances
		//get method retrieves the element(number of appearances) from the key (artist)
		for (String test: keys) {
			pw.println(test +  ": " + hmap.get(test));
		}
		//used to indicate that file has been written
		System.out.println("The list of artist has been written");
		pw.close();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}	
}
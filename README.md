# CISC3130-lab2
Java program written to read a spotify csv files and create an output file based on the artists in the file
and how many times they appear.  
## Implementation
This program uses a Scanner object to read a csv file, then splits the comma seperated values using
the .split() method. A custom regex code is used to handle any extra commas within the CSV entries. These values are stored in a String array so the artist name can be pulled from index
n (in this program n = 2.) The artist name is then stored in a HashMap using a String as the key and an 
integer as the value. I chose to use a HashMap since it easily allows checking for duplicates using the
.containsKey(String key) method. This also simplifies the process of writing the file; we can pull a list of all the
keys in the Hashmap using the .keySet() method, then print them into the file while using the .get(String key) method to retrieve the 
value assigned to the key. A PrintWriter is used to write these values into the output file. The file is structured to only show the artist name and their number of appearances for simplicity.

### Dependencies
* Written using Java 14
* Terminal to run commands for setup, may differ by OS used.
#### Set up
To run this program, you need to have a github account setup with an SSH key. Access to a terminal and git commands
are needed, unless your IDE of choice has git support. If you choose to run the program with this IDE,
the setup process will differ.  
1. Clone to your machine using 'git clone git@github.com:bertom1/CISC3130-lab2.git' 
2. Open the project directory with the command 'cd CISC3130-lab2'
3. To compile the program, use the command 'javac Main.java'
4. To run the program, use the command 'java Main'  
If a file not found error message is produced, then the file path may have to be used instead of the file name
used within the code. The file path can be taken from the location of the cloned repo on your local machine.
Possible path format is "./regional-global-weekly-latest.csv"

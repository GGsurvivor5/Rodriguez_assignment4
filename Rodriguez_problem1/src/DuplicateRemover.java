/*
 * Jonathan Rodriguez
 * COP3330
 * Hollander
 */


import java.io.*;
import java.util.*;

public class DuplicateRemover {
	
	public String uniqueWords;
	
	public void remove(String dataFile){
		
		try {
			File fileInput= new File(dataFile);
			Scanner read= new Scanner(fileInput);
			Set<String> newSet= new HashSet<String>();
			do{
				newSet.add(read.next());
			}
			while(read.hasNextLine());
			read.close();
			//System.out.println(newSet);
			uniqueWords= String.join(" ", newSet);
			//System.out.println(uniqueWords);
		}
		catch(FileNotFoundException e) {
			System.out.println("Error: File not found.");
			e.printStackTrace();
			System.exit(0);
		}
	}
		
			
	public void write(String outputFile) {
		
		try {
			File fileOutput= new File(outputFile);
			fileOutput.createNewFile();
			FileWriter fileOut= new FileWriter(fileOutput, false);
			fileOut.write(uniqueWords);
			fileOut.close();
		}
		catch(IOException e) {
			System.out.println("Error: write to file failed.");
			e.printStackTrace();
			System.exit(0);
		}
	}
}

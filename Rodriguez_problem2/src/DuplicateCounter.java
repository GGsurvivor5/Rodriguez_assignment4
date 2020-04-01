/*
 * Jonathan Rodriguez
 * COP3330
 * Hollander
 */

import java.io.*;
import java.util.*;

public class DuplicateCounter {

	public Integer wordCounter;
	public String uniqueWords;
	
	HashMap <String, Integer> wordMap= new HashMap <String, Integer>();
	
	public void count(String dataFile) {
		
		try {
			File fileInput= new File(dataFile);
			//HashMap <String, Integer> wordMap= new HashMap <String, Integer>();
			BufferedReader fileReader= null;
			fileReader= new BufferedReader(new FileReader(fileInput));
			String currentLine = fileReader.readLine();
			while(currentLine != null) {
				
				String[] singleWords= currentLine.toLowerCase().split(" ");
				for(String word : singleWords) {
					
					if(wordMap.containsKey(word)) {
						wordMap.put(word, wordMap.get(word)+1);
					}
					else {
						wordMap.put(word, 1);
					}
				}
				currentLine=fileReader.readLine();
			}
			fileReader.close();
			//for(Map.Entry<String, Integer> entry : wordMap.entrySet()) {
			//	uniqueWords=entry.getKey();
			//	wordCounter=entry.getValue();
			//}
			
		}
		catch(Exception e) {
			System.out.println("Error: File read failed. Check input file.");
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	public void write(String outputFile) {
		
		try {
			File fileOutput= new File(outputFile);
			fileOutput.createNewFile();
			FileWriter fileOut= new FileWriter(fileOutput, false);
			//fileOut.write(uniqueWords);
			for(Map.Entry<String, Integer> entry : wordMap.entrySet()) {
					uniqueWords=entry.getKey();
					wordCounter=entry.getValue();
					uniqueWords=uniqueWords.concat(": ");
					String nums=wordCounter.toString();
					nums=nums.concat(" ");
					fileOut.write(uniqueWords + nums);
			}
			fileOut.close();
		}
		catch(IOException e) {
			System.out.println("Error: write to file failed.");
			e.printStackTrace();
			System.exit(0);
		}
	}
}

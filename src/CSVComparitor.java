
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;



public class CSVComparitor {

	ArrayList<ArrayList<String>> listOfLists = new ArrayList<ArrayList<String>>();
	ArrayList<ArrayList<String>> listOfSupLists = new ArrayList<ArrayList<String>>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CSVComparitor obj = new CSVComparitor();
		obj.run();
		
		

	}

	
	
	public ArrayList<String> listFilesForFolder(final File folder, ArrayList<String> output) {
		
		
	    for (final File fileEntry : folder.listFiles()) {
	        if (fileEntry.isDirectory()) {

	        } else {
	        	String temp = "/" + fileEntry.getName();
	        	if (!fileEntry.getName().contains(".DS_Store")){
	        		output.add(folder.toString().concat(temp));
	        		//System.out.println(folder.toString().concat(fileEntry.getName()));
	        	}
	        }
	    }
	    return output;
	}
	
	


	    public static void printRow(int[] row) {
	        for (int i : row) {
	            System.out.print(i);
	            System.out.print("\t");
	        }
	        System.out.println();
	    }


	
	final File folder = new File("/Users/jaysimbol/Documents/BrightTALK/EmailLists/2016/NA/test");
	final File suppressionList = new File("/Users/jaysimbol/Desktop/SuppressionList/BrightTALKSuppressionList.csv");
	
	
	 public void run() {
		 
		 
		 
		 
			BufferedReader br = null;
			String line = "";
			String cvsSplitBy = ",";
			int counter = 0;
			ArrayList <String> listOfFiles = new ArrayList<String>();
			ArrayList <ArrayList<String>> listOfEmailLists = new ArrayList<ArrayList<String>>();
			
			listFilesForFolder(folder, listOfFiles);

			for (int x = 0; x < listOfFiles.size(); x++) {
				String csvFile = listOfFiles.get(x);
				ArrayList <String> listOfEmails = new ArrayList<String>();
				try {
					System.out.println(csvFile);
					br = new BufferedReader(new FileReader(csvFile));
					while ((line = br.readLine()) != null) {
						//System.out.println(x);
					    // use comma as separator
						String[] email = line.split(cvsSplitBy);
						//add email to list of emails
						listOfEmails.add(email[1]);
					}
					
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					if (br != null) {
						try {
							br.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
				
				listOfEmailLists.add(listOfEmails);
				//System.out.println("Email number = " + listOfFiles.get(x));
				//System.out.println("Email Size = " + listOfEmailLists.get(x).size());
			}
			
			//listOfLists = (ArrayList<String>) listOfEmailLists.clone();
			
			ArrayList<ArrayList<String>> comparitorListOfLists = listOfEmailLists;
			int numberOfEmailLists = listOfEmailLists.size();
			int numberOfEmailListsForIterating = numberOfEmailLists - 1;
			int[][] tableOfDuplicates = new int[numberOfEmailLists][numberOfEmailLists]; 
			
			//iterate through list of emails
			for (int x = 0; x < listOfEmailLists.size(); x++) {
				//System.out.println(listOfEmailLists.get(x));
				ArrayList<String> originalList = listOfEmailLists.get(x);
				int originalSize = originalList.size();
				
				//iterate list of other emails
				for (int y = x+1; y < listOfEmailLists.size(); y++ ) {
					ArrayList<String> workingOriginalList = (ArrayList<String>) originalList.clone();
					ArrayList<String> comparitorList = listOfEmailLists.get(y);
					workingOriginalList.removeAll(comparitorList);
					int dedupedSize = workingOriginalList.size();
					int duplicates = originalSize - dedupedSize;
					
					//Remove email header from the deduped count
					duplicates--;
					
					//add number of duplicates to the table of duplicates
					tableOfDuplicates[x][y] = duplicates;
					tableOfDuplicates[y][x] = duplicates;

					
					
				//end iterating list of other emails
				}
								
			//end of iteration through list of emails	
			}
			
			for (int z = 1; z <= listOfFiles.size(); z++) {
				String filenameAndNumber = z + ") " + listOfFiles.get(z-1).substring(listOfFiles.get(z-1).indexOf("t/")+2, listOfFiles.get(z-1).length());
				System.out.println(filenameAndNumber + " - " + (listOfEmailLists.get(z-1).size()-1));
			}
			
			System.out.println("\n");

	        for(int[] row : tableOfDuplicates) {
	            printRow(row);
	        }
	        
	       

	        
	        System.out.println("LULZ ALL DONE");
	        
	        
		  }
	 
	 
	 	

}

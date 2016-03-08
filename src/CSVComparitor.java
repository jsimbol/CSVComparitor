
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Arrays;



public class CSVComparitor {
	
	Hashtable<Integer, String> directory = new Hashtable<Integer, String>();

	HashSet<HashSet<String>> listOfLists = new HashSet<HashSet<String>>();
	HashSet<HashSet<String>> listOfSupLists = new HashSet<HashSet<String>>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CSVComparitor obj = new CSVComparitor();
		obj.run();
		
		

	}

	
	
	public HashSet<String> listFilesForFolder(final File folder, HashSet<String> output) {
		
		
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
	
	


	    public void printRow(int[] row, int s) {
	        
	    	int x = 0;
	    	for (int i : row) {
	    		
	    		if(s == 0 || x == 0) {
	    		
		        	if (directory.containsKey(i)) {
		        		String temp = directory.get(i);
		        		temp = temp.substring(temp.indexOf("_")+1, temp.length()-12);
		        		temp = temp.substring(temp.indexOf("_")+1, temp.length());
		        		temp = "ID: " + temp;
		        		while (temp.length() < 15) {
		        			temp = temp.concat(" ");
		        		}
		        		System.out.print(temp);
		        	}
		        	else {
		        		String temp = Integer.toString(i);
		        		while (temp.length() < 15) {
		        			temp = temp.concat(" ");
		        		}
		        		System.out.print(temp);
		        	}
	    		}
	    		else{
		    		String temp = Integer.toString(i);
	        		while (temp.length() < 15) {
	        			temp = temp.concat(" ");
	        		}
	    			System.out.print(temp);
	    		}
	            System.out.print("\t");
	            x++;
	        }
	        System.out.println();
	    }


	
	final File folder = new File("/Users/jaysimbol/Documents/BrightTALK/EmailLists/2016/NA/test");
	final File suppressionList = new File("/Users/jaysimbol/Desktop/SuppressionList/BrightTALKSuppressionList.csv");
	
	
	 public void run() {
		 
		 
			BufferedReader br = null;
			String line = "";
			String cvsSplitBy = ",";
			HashSet <String> listOfFiles = new HashSet<String>();
			HashSet <HashSet<String>> listOfEmailLists = new HashSet<HashSet<String>>();
			
			listFilesForFolder(folder, listOfFiles);

			Iterator listOfFilesIterator = listOfFiles.iterator();
			while(listOfFilesIterator.hasNext()){
				String csvFile = (String) listOfFilesIterator.next();
				HashSet <String> listOfEmails = new HashSet<String>();
				
				int temp = csvFile.indexOf("t/");
		    	temp++;
		    	temp++;
		    	String temp2 = csvFile.substring(temp, csvFile.length()-4);
		    	
				
				try {
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
				directory.put(listOfEmails.size()-1, temp2);
				listOfEmailLists.add(listOfEmails);
				//System.out.println("Email number = " + listOfFiles.get(x));
				//System.out.println("Email Size = " + listOfEmailLists.get(x).size());
			}
			
			//listOfLists = (HashSet<String>) listOfEmailLists.clone();
			
			HashSet<HashSet<String>> comparitorListOfLists = listOfEmailLists;
			int numberOfEmailLists = listOfEmailLists.size();
			int numberOfEmailListsForIterating = numberOfEmailLists - 1;
			int[][] tableOfDuplicates = new int[numberOfEmailLists+1][numberOfEmailLists+1]; 
			
			//iterate through list of emails
			Iterator listOfEmailsIterator = listOfEmailLists.iterator();
			int x = 0;
			while (listOfEmailsIterator.hasNext()){
				//System.out.println(listOfEmailLists.get(x));
				HashSet<String> originalList = (HashSet<String>) listOfEmailsIterator.next();
				int originalSize = originalList.size();
				int y = 0;
				//iterate list of other emails
				Iterator listOfEmailsIterator2 = listOfEmailLists.iterator();
				while (listOfEmailsIterator2.hasNext()){
					HashSet<String> workingOriginalList = (HashSet<String>) originalList.clone();
					HashSet<String> comparitorList = (HashSet<String>) listOfEmailsIterator2.next();
					workingOriginalList.removeAll(comparitorList);
					int dedupedSize = workingOriginalList.size();
					int duplicates = originalSize - dedupedSize;
					
					//Remove email header from the deduped count
					duplicates--;
					
					//add number of duplicates to the table of duplicates
					tableOfDuplicates[x+1][y+1] = duplicates;
					tableOfDuplicates[y+1][x+1] = duplicates;
					tableOfDuplicates[x+1][0] = originalList.size()-1;
					tableOfDuplicates[0][y+1] = comparitorList.size()-1;
					y++;
					
				//end iterating list of other emails
				}
				x++;
				
								
			//end of iteration through list of emails	
			}
			
			
			System.out.println("\n");
			int s = 0;
	        for(int[] row : tableOfDuplicates) {
	            printRow(row, s);
	            s++;
	        }
	        
	       

	        
	        System.out.println("Complete");
	        
	        
		  }
	 
	 
	 	

}

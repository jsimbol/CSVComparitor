import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.ArrayList;

public class Suppression extends Thread{
	private HashSet<String> supList;
	private String to;
	final static File folder = new File("/Users/jaysimbol/Documents/BrightTALK/EmailLists/2016/NA/test");
	final static File suppressionListFile = new File("/Users/jaysimbol/Desktop/SuppressionList/BrightTALKSuppressionList.csv");
	
	public Suppression(String to, HashSet<String> supList) {
		this.supList = supList;
		this.to = to;
	}
	
	public static ArrayList<String> listFilesForFolder(final File folder, ArrayList<String> output) {
		
		
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
	
	
	
	private static HashSet<String> createSuppressionArray() {
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		int counter = 0;
		HashSet <String> suppressionList = new HashSet<String>();
		
		try {
			
			br = new BufferedReader(new FileReader(suppressionListFile));
			while ((line = br.readLine()) != null) {
			
			    // use comma as separator
				String[] email = line.split(cvsSplitBy);
				
				email[0] = email[0].substring(1, email[0].length() - 1);
				//System.out.println(email[0]);
				
				//add email to list of emails
				suppressionList.add(email[0]);
				
				counter++;
			}
			//System.out.println(counter);
			
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
		return suppressionList;

	}
	
	
	@Override
	public void run() {
		//System.out.println(supList.size());
		//System.out.println("Hello " + to);
		BufferedReader fileReader = null;
		String lineForCSV = "";
		String csvSplitter = ",";
		ArrayList <String> listOfEmails = new ArrayList<String>();
		try {
			fileReader = new BufferedReader(new FileReader(to));
			while((lineForCSV = fileReader.readLine()) != null) {
				String[] email = lineForCSV.split(csvSplitter);
				listOfEmails.add(email[1]);
				//System.out.println("Still working for " + to);
			}
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("DONE with part 1");
		int beforeSize = listOfEmails.size();
		listOfEmails.removeAll(supList);
		//System.out.println("DONE WITH PART 2");
		int afterSize = listOfEmails.size();
		int totalUnsubscribes = beforeSize - afterSize;
		System.out.println(to + "\nTotal Size = " + beforeSize + "\n" + "Total Unsubscribes = " + totalUnsubscribes + "\n" + "SizeAfterUnsubscribes = " + afterSize + "\n\n");
		
		
	}
	
	public static void main(String[] args) {
		HashSet<String> supList = new HashSet<String>();
	    supList = createSuppressionArray();
	    //System.out.println("IM HERE" + supList.size());

		//createListofCSVFiles
		ArrayList<String> listOfFiles = new ArrayList<String>();
		ArrayList<ArrayList<String>> listOfEmailLists = new ArrayList<ArrayList<String>>();
		
		listFilesForFolder(folder, listOfFiles);
		for (String s: listOfFiles) {
			if ( !s.contains(".DS_Store")) {
				new Suppression(s, supList).start();
			}
			
		}
		
		
	}
	
}

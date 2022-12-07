package com.lockerspvtltd.project1.lockedme;
import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Option1{
	public int retrieval =0;
	public void RetrieveFiles() {
		if (retrieval==1) {
			//Entering path of directory
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter a path for the folder of which files to be extraxted: ");
			String path = sc.nextLine();
			//using directory path input specified by the user
		    File dir = new File(path);
		    /* To run operation for predefined directory.
			 File dir = new File("C:\\Users\\khush\\Desktop\\Simplilearn FSD\\FilesForProject1");*/
		    
		    	if(dir.isDirectory())
		    	{
		    		// Fetching the list from the directory
		    		File[] docs = dir.listFiles();
		    			if (docs.length>0) {
		    				// Sort files by name
		    				Arrays.sort(docs, new Comparator()
		    				{
		    					@Override
		    					public int compare(Object f1, Object f2) {
		    					return ((File) f1).getName().compareTo(((File) f2).getName());
		    					}
		    				});
		    				
			      //Prints the files in file name ascending order
			      System.out.println("After sorting by name in ascending order: ");
			      System.out.println("-------------------------------------------");
			      for(File file:docs){
			        System.out.println(file.getName());}
				}
		       else {
		    	   System.out.println("Folder with path: "+dir.getPath()+" is empty.");
		       		}
		    }
		 
		}
	}
				
}
public class Project1 {

	public static void main(String[] args) {
		Option1 O1 = new Option1();
		System.out.println("Enter 1 if you want to retrieve files from any given folder or else enter 0: ");
		Scanner sc = new Scanner(System.in);
		 O1.retrieval = sc.nextInt();
		 O1.RetrieveFiles();
	}

}

package com.lockerspvtltd.project1.lockedme;
import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class UserDetails{
	String name;
	String mail;
	String mob;
	public void setData() {
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter your name: ");
			this.name = scan.nextLine();
			System.out.println("Enter your Email ID: ");
			this.mail = scan.nextLine();
			System.out.println("Enter your Mobile no: ");
			this.mob = scan.nextLine();
		}
	public void getData() {
		System.out.println("-----------------------------------------------");
		System.out.println("All your details: ");
		System.out.println("Name: "+name+"\n"+"Email ID: "+mail+"\n"+"Mobile no: "+mob);
		System.out.println("-----------------------------------------------");
	}	
}

class Option1{
	public int retrieval =0;
	public void RetrieveFiles() {
		if (retrieval==1) {
			//Entering path of directory
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter a path for the folder of which files to be extracted: ");
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

class Option2 {
	int opt2;
	public void FileOps() {
		if (opt2==1) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter a file name to be added in the directory");
			String filename1 = sc.nextLine();
			File myFile1 = new File("C:\\Users\\khush\\Desktop\\Simplilearn FSD\\FilesForProject1\\"+filename1);
		
			try {
				myFile1.createNewFile();
				System.out.println("created this file");
			} catch (Exception e) {
				System.out.println("Unable to create this file");
				e.printStackTrace();
			}
		}else if (opt2==2) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter a file name to be deleted from the directory");
			String filename2 = sc.nextLine();
			File myFile2 = new File("C:\\Users\\khush\\Desktop\\Simplilearn FSD\\FilesForProject1\\"+filename2);
			if (myFile2.delete()) {
				System.out.println("file deleted: "+ myFile2);
			} else {
				System.out.println("error occured");
			}
		}else if (opt2==3) {
			// Create an object of the File class
			File myFile3 = new File("C:\\Users\\khush\\Desktop\\Simplilearn FSD\\FilesForProject1");

			// store all names with same name
			String[] flist = myFile3.list();
			int flag = 0;
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter name of the file to be searched in the directory");
			String filename3 = sc.nextLine();
			if (flist == null) {
				System.out.println("Directory is empty.");
			}
			else {
				// Linear search in the array
				for (int i = 0; i < flist.length; i++) {
					String filename = flist[i];
					if (filename.equals(filename3)) {
						System.out.println(filename3 + " found successfully in the directory.");
						flag = 1;
					}
				}
			}

			if (flag == 0) {
				System.out.println("File Not Found");
			}
		} else if (opt2==0) {
			System.out.println("Program exit.");
			System.exit(0);// will exit the method.
		} else {
			System.out.println("Invalid entry");
		}
	}
}
public class Project1 {

	public static void main(String[] args) {
		System.out.println("Welcome to LockedMe.com presented by Lockers Pvt Ltd.");
		System.out.println("This is developed by Khushboo Sharma");
		System.out.println("------------------------------------------------------");
		UserDetails ud = new UserDetails();
		ud.setData();
		ud.getData();
		Option1 O1 = new Option1();
		System.out.println("Enter 1 if you want to retrieve files from any given folder or else enter 0: ");
		Scanner sc = new Scanner(System.in);
		 O1.retrieval = sc.nextInt();
		 O1.RetrieveFiles();
		 Option2 O2 = new Option2();
		 System.out.println("Enter 1 to add a file in the directory");
		 System.out.println("Enter 2 to delte a file from the directory.");
		 System.out.println("Enter 3 to search for a file in the directory.");
		 System.out.println("Enter 0 to exit the program.");
		 O2.opt2 = sc.nextInt();
		 O2.FileOps();
	}

}

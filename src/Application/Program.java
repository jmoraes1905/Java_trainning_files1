package Application;

import java.io.File;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a folder path: ");
		String strPath = sc.nextLine();
		
		//We want to list all folders in a directory
		File path = new File(strPath);
		
		File[] folders = path.listFiles(File::isDirectory); //Similarly to list filtering using predicates, we use a reference methods syntax to specify our filter
		System.out.println("FOLDERS");
		for(File folder : folders) {
			System.out.println(folder);
		}
		//Now we want to list all files in the same directory
		
		File[] textFiles = path.listFiles(File::isFile);
		System.out.println("FILES");
		for(File textFile:textFiles) {
			System.out.println(textFile);
		}
		
		//finally we will create a new directory in the same directory path and print the new folders list if we succeed
		boolean success = new File(strPath +"\\subdir").mkdir();
		//Note that this method DOES NOT overwrite the directory. If you run the program a second time without previously deleting the subdir directory, the success variable WILL RETURN FALSE
		System.out.println("Directory created sucessfully? " + success);
		folders = path.listFiles(File::isDirectory);
		System.out.println("FOLDERS UPDATED");
		for(File folder: folders) {
			System.out.println(folder);
		}
		
		//Getting file's path information
		System.out.println("getName: " + path.getName());
		System.out.println("getParent: " + path.getParent());
		System.out.println("getPath: "+ path.getPath());
		sc.close();
	}

}

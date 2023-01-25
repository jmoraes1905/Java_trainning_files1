package Application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Program {

	public static void main(String[] args) {

		String path = "c:\\temp\\in.txt";
		//Eliminate declaration of file related objects by using block try-with-resources
		try(BufferedReader br = new BufferedReader(new FileReader(path))) {
			//Declaration and instantiation of buffered reader and file reader objects done at try block start 
			String line = br.readLine(); //String receives text file lines until file is over 
			while(line!=null) {
				System.out.println(line);
				line = br.readLine();
			}
		}
		catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		
	}

}

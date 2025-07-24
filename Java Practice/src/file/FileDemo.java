package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileDemo {
	
	public static void main(String[] args) {
		/*
		//File creation code
		File myFile = new File("sample.txt");
		try {
			if(myFile.createNewFile()) {
				System.out.println("File creation success");
			}
			else {
				System.out.println("File creation failed");
			}
		} catch (IOException e) {
			System.out.println("Error during file creation");
			e.printStackTrace();
		}
		
		//File writing
		try {
			//FileWriter fileWriter = new FileWriter("sample.txt");  //write from start
			FileWriter fileWriter = new FileWriter("sample.txt",true); //append to existing text
			fileWriter.write("This is first line.\nThis is second line.\n");
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		//File reading
		try {		
			File myFile = new File("sample.txt");
			Scanner sc = new Scanner(myFile);
			while(sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
			sc.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		*/
		
		//File Deleting
//		try {
//			File myFile = new File("sample.txt");
//			if(myFile.delete()) {
//				System.out.println("File deleted: " + myFile.getName());
//			}
//			else {
//				System.out.println("File deletion failed");
//			}
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//		}
	}
}

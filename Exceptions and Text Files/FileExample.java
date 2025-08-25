/*
 * FileExample.java
 * Demo File class
 */

import java.io.File;
import java.util.Scanner;

public class FileExample 
{
	public static void main(String[] args) 
	{
		// Read in file name from keyboard
		Scanner input = new Scanner(System.in);
		System.out.println("Enter file name (<enter> to stop):");
		String filename = input.nextLine();
		while (filename.length() > 0)
		{
			// Construct File object for given file
			File inputFile = new File(filename);
			if (inputFile.exists())
			{
				System.out.println("Length of file: " + inputFile.length());
				System.out.println("Readable? " + inputFile.canRead());
				System.out.println("Writable? " + inputFile.canWrite());
			}
			else
			{
				System.out.println("File does not exist");
			}
			System.out.println();

			System.out.println("Enter file name (<enter> to stop):");
			filename = input.nextLine();
		}
	}
}
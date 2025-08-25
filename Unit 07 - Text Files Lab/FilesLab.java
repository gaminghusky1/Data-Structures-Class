

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FilesLab 
{
	public static void main(String[] args) 
	{
		try
		{
			// run 70-point version
			processIntegers("test1.txt", "output1.txt");
			System.out.println();
			
			// run 85-point version
			testLines("test2a.txt", "output2a.txt");
			
			// run 85-point version
			testLines("test2b.txt", "output2b.txt");
			System.out.println();
			
			// run 100-point version - good data
			extractSubstrings("test3a.txt", "output3a.txt");		
			
			// run 100-point version - bad data
			extractSubstrings("test3b.txt", "output3b.txt");		
			System.out.println();
		}
		catch (IOException exc)
		{
			System.out.println("Exception occurred: " + exc.getMessage());
			exc.printStackTrace();			
		}
	}
	
	public static void processIntegers(String inFile, String outFile) 
	{
		System.out.println("Smallest and largest integers from " + inFile 
			+ " written to " + outFile);
	}
	
	public static void testLines(String inFile, String outFile) 
	{
		System.out.println("Lines from " + inFile + " written to " + outFile);
	}
	
	public static void extractSubstrings(String inFile, String outFile) 
	{
		System.out.println("Requested substrings from " + inFile + " written to " + outFile);
	}
	
	private static String getSubstring(int index1, int index2, String text)
	{
		return "";
	}
}
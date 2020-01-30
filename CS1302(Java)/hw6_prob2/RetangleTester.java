package prob2;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class RetangleTester {
	
	public static void main(String[] args) throws Exception{
		try {
			File inFile = new File( "src\\prob2\\rectangles.txt" );
			Scanner input = new Scanner(inFile);
			File outFile = new File( "src\\prob2\\illegalRectangles.txt");
			PrintWriter writer = new PrintWriter(outFile);


			while(input.hasNext()) {
				try {
					Rectangle r = new Rectangle(input.nextDouble(), input.nextDouble());
					System.out.println(r.toString());
					input.nextLine();
				}
				catch(IllegalRectangleException ire) {
					System.out.println(ire.getMessage());
					writer.println(ire.getMessage());
				}
			}
			input.close();
			writer.close();
		}	
		catch(Exception e) {
			System.out.print("File not found.");
		}

	}
}

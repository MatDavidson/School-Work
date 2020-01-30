package prob3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NumberAdder {

	public static void main(String[] args) {
		try {
			File inFile = new File( "src\\prob3\\values.txt" );
			reader(inFile);
			File inFile2 = new File( "src\\prob3\\values2.txt" );
			reader(inFile2);
		
		}	
		catch (Exception e) {
			System.out.println("File not found.");
		}
	}	
		public static void reader(File inFile) throws FileNotFoundException {
			int sum = 0;
			Scanner input = new Scanner(inFile);

			while(input.hasNext()) {
				String line = input.next();
				if(line.startsWith("s")) {
					int skip = Integer.parseInt(line.substring(1));
					for(int i = 0; i <= skip; i++) {
						input.nextLine();
					}
				}
				else {
					sum += Integer.parseInt(line);
				}
			}
			System.out.println("Sum=" + sum);


			input.close();
		}
	}	


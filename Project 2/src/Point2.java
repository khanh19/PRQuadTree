
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Khanh Pham <khanh19>
// -- Pham Quoc Cuong (cpham006)

import java.io.*;
import java.util.ArrayList;

/**
 * main class
 * 
 * @author Khanh Pham <khanh19>
 * @author Pham Quoc Cuong <cpham006>
 * @version 9/20/2021
 *
 */
public class Point2 {
	/**
	 * main method that take input file
	 * 
	 * @param args the input file
	 * @throws Exception if file is invalid
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new FileReader(args[0]));
		BufferedWriter output = new BufferedWriter(new FileWriter(args[1]));
		DatabaseHandler result = new DatabaseHandler(0, 1024, 0, 1024);
		try {
			String line = input.readLine();
			String[] command;
			SkipList<String, Point> list = new SkipList<String, Point>();
			while (line != null) {
				String str = line.replaceAll("^\\s+", "");
				command = str.split("\\s+");
				if (command[0].compareTo("insert") == 0) {
					if (command.length != 4) {
						throw new IllegalArgumentException("wrong amount of arguments");
					}
					String tempName = command[1];
					int tempX = Integer.parseInt(command[2]);
					int tempY = Integer.parseInt(command[3]);
					Point temp = new Point(tempName, tempX, tempY);
					output.write(result.insert(temp));
				}

				else if (command[0].compareTo("remove") == 0) {
					if (!(command.length == 2 || command.length == 3)) {
						throw new IllegalArgumentException("wrong amount of arguments");
					}
					else if(command.length == 2) {
						output.write(result.removeName(command[1]));
					}
					else if(command.length == 3){
						output.write(result.removePoint(Integer.parseInt(command[1]), Integer.parseInt(command[2])));
					}
				}

				else if (command[0].compareTo("regionsearch") == 0) {
					if (command.length == 5) {
						output.write("not done \n");
					}
				}
				else if(command[0].compareTo("duplicates") == 0) {
					output.write(result.duplicate());
				}
				else if (command[0].compareTo("search") == 0) {
					if (command.length == 2) {
						output.write(result.search(command[1]));
					}
				}

				else if (command[0].compareTo("dump") == 0) {
					if (command.length == 1) {
						output.write("SkipList dump: \n");
						output.write(result.dump());
					}
				}

				line = input.readLine();
			}
		} catch (Error e) {
			System.out.println("System is invalid");
		} finally {
			input.close();
			output.close();
		}
	}
}

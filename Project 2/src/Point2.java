
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
		try {
			String line = input.readLine();
			String[] command;
			SkipList<String, Point> list = new SkipList<String, Point>();
			while (line != null) {
				String str = line.replaceAll("^\\s+", "");
				command = str.split("\\s+");
				if (command[0].compareTo("insert") == 0) {
					if (command.length != 6) {
						System.out.print(command);
						throw new IllegalArgumentException("wrong amount of arguments");
					}
					System.out.print(command);
					//insertCom(list, command);
				}

				else if (command[0].compareTo("remove") == 0) {
					if (!(command.length == 5 || command.length == 2)) {
						throw new IllegalArgumentException("wrong amount of arguments");
					}
					//removeCom(list, command);
				}

				else if (command[0].compareTo("regionsearch") == 0) {
					if (command.length == 5) {
						//regionSearchCom(list, command);
					}
				}

				else if (command[0].compareTo("search") == 0) {
					if (command.length == 2) {
						//nameSearchCom(list, command);
					}
				}

				else if (command[0].compareTo("intersections") == 0) {
					if (command.length == 1) {
						System.out.println("Intersections pairs:");
						//list.intersection();
					}
				}

				else if (command[0].compareTo("dump") == 0) {
					if (command.length == 1) {
						System.out.println("SkipList dump: ");
						list.dump();
					}
				}

				line = input.readLine();
			}
		} catch (Error e) {
			System.out.println("System is invalid");
		} finally {
			input.close();
		}
	}
}


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
public class Rectangle1 {
    /**
     * main method that take input file
     * 
     * @param args
     *            the input file
     * @throws Exception
     *             if file is invalid
     */
    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new FileReader(args[0]));
        try {
            String line = input.readLine();
            String[] command;
            SkipList<String, Rectangle> list =
                new SkipList<String, Rectangle>();
            while (line != null) {
                String str = line.replaceAll("^\\s+", "");
                command = str.split("\\s+");
                if (command[0].compareTo("insert") == 0) {
                    if (command.length != 6) {
                        throw new IllegalArgumentException(
                            "wrong amount of arguments");
                    }
                    insertCom(list, command);
                }

                else if (command[0].compareTo("remove") == 0) {
                    if (!(command.length == 5 || command.length == 2)) {
                        throw new IllegalArgumentException(
                            "wrong amount of arguments");
                    }
                    removeCom(list, command);
                }

                else if (command[0].compareTo("regionsearch") == 0) {
                    if (command.length == 5) {
                        regionSearchCom(list, command);
                    }
                }

                else if (command[0].compareTo("search") == 0) {
                    if (command.length == 2) {
                        nameSearchCom(list, command);
                    }
                }

                else if (command[0].compareTo("intersections") == 0) {
                    if (command.length == 1) {
                        System.out.println("Intersections pairs:");
                        list.intersection();
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
        }
        catch (Error e) {
            System.out.println("System is invalid");
        }
        finally {
            input.close();
        }
    }


    /**
     * helper function to print the insert command
     * 
     * @param list
     *            SkipList that take from main
     * @param command
     *            the command in input file
     */
    public static void insertCom(
        SkipList<String, Rectangle> list,
        String[] command) {
        String name = command[1];
        int x = Integer.valueOf(command[2]);
        int y = Integer.valueOf(command[3]);
        int width = Integer.valueOf(command[4]);
        int height = Integer.valueOf(command[5]);
        Rectangle rec = new Rectangle(name, x, y, width, height);

        if (width <= 0 || height <= 0 || (x + width > 1024) || (x + width < 0)
            || (y + height > 1024) || (y + height < 0) || (x < 0) || (y < 0)) {
            System.out.println("Rectangle rejected: (" + name + ", " + x + ", "
                + y + ", " + width + ", " + height + ")");
            return;
        }
        KVPair<String, Rectangle> pair = new KVPair<String, Rectangle>(
            command[1], rec);
        list.insert(pair);
        System.out.println("Rectangle inserted: (" + name + ", " + x + ", " + y
            + ", " + width + ", " + height + ")");
    }


    /**
     * helper function to print the regionSearch function in SkipList
     * 
     * @param list
     *            the SkipList
     * @param command
     *            the command in input file
     */
    public static void regionSearchCom(
        SkipList<String, Rectangle> list,
        String[] command) {
        int x = Integer.valueOf(command[1]);
        int y = Integer.valueOf(command[2]);
        int width = Integer.valueOf(command[3]);
        int height = Integer.valueOf(command[4]);
        if (width <= 0 || height <= 0) {
            System.out.println("Rectangle rejected: (" + x + ", " + y + ", "
                + width + ", " + height + ")");
        }
        else {
            System.out.println("Rectangles intersecting region (" + x + ", " + y
                + ", " + width + ", " + height + "):");
            ArrayList<Rectangle> resultList = list.regionSearch(x, y, width,
                height);

            for (Rectangle rec : resultList) {
                System.out.println(rec.toString());
            }
        }

    }


    /**
     * helper function to print the search function
     * 
     * @param list
     *            the SkipList that take from input file
     * @param command
     *            the command in input file
     */
    public static void nameSearchCom(
        SkipList<String, Rectangle> list,
        String[] command) {
        ArrayList<Rectangle> result = list.search(command[1]);
        if (result == null) {
            System.out.println("Rectangle not found: " + command[1]);
            return;
        }
        System.out.println("Rectangle found: ");
        for (Rectangle rec : result) {
            System.out.println(rec.toString());
        }
    }


    /**
     * helper function to print the remove function
     * 
     * @param list
     *            the SkipList that take from input file
     * @param command
     *            the command in input file
     */
    public static void removeCom(
        SkipList<String, Rectangle> list,
        String[] command) {
        if (command.length == 2) {
            Rectangle remove = list.remove(command[1]);
            if (remove == null) {
                System.out.println("Rectangle not removed: " + "(" + command[1]
                    + ")");
                return;
            }
            System.out.println("Rectangle removed: " + remove.toString());
        }
        else {

            int x = Integer.valueOf(command[1]);
            int y = Integer.valueOf(command[2]);
            int width = Integer.valueOf(command[3]);
            int height = Integer.valueOf(command[4]);
            if (width <= 0 || height <= 0 || (x + width > 1024) || (x
                + width < 0) || (y + height > 1024) || (y + height < 0)
                || (x < 0) || (y < 0)) {
                System.out.println("Rectangle rejected: (" + x + ", " + y + ", "
                    + width + ", " + height + ")");
                return;
            }
            Rectangle remove = new Rectangle("", x, y, width, height);
            Rectangle obj = list.remove(remove);
            if (obj == null) {
                System.out.println("Rectangle not found: (" + x + ", " + y
                    + ", " + width + ", " + height + ")");
                return;
            }
            System.out.println("Rectangle removed: " + obj.toString());
        }
    }

}

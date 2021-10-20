
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Khanh Pham <khanh19>
// -- Pham Quoc Cuong (cpham006)

import java.util.ArrayList;
import java.util.Random;

/**
 * SkipList class
 * 
 * @author Khanh Pham <khanh19>
 * @author Pham Quoc Cuong <cpham006>
 * @version 9/20/2021
 *
 * @param <K>
 *            the key
 * @param <E>
 *            the value
 */
public class SkipList<K extends Comparable<K>, E> {
    private SkipNode<KVPair<K, E>> headNode;
    private int level;
    private int size;

    private static Random random = new Random();

    /**
     * default constructor
     */
    public SkipList() {
        headNode = new SkipNode<KVPair<K, E>>(null, 0);
        level = 0;
        size = 0;

    }


    /**
     * method to make random number for node's level
     * 
     * @return the random number
     */
    int randomLevel() {
        int lev;
        for (lev = 0; Math.abs(random.nextInt()) % 2 == 0; lev++) {

        }
        return lev;
    }


    /**
     * method to get the size of SkipList
     * 
     * @return the size
     */
    public int getSize() {
        return this.size;
    }


    /*
     * helper method to adjuct the node
     */
    private void adjustHead(int newLevel) {
        SkipNode<KVPair<K, E>> temp = headNode;
        headNode = new SkipNode<KVPair<K, E>>(null, newLevel);
        for (int i = 0; i <= level; i++) {
            headNode.getElevate()[i] = temp.getElevate()[i];
        }
        level = newLevel;
    }


    /**
     * method to insert the node into skipList
     * 
     * @param rec
     *            Node object
     */

    public void insert(KVPair<K, E> rec) {
        int newLevel = randomLevel();
        if (newLevel > level) {
            adjustHead(newLevel);
        }

        @SuppressWarnings("unchecked")
        SkipNode<KVPair<K, E>>[] update = new SkipNode[level + 1];
        SkipNode<KVPair<K, E>> x = headNode; // Start at header node
        for (int i = level; i >= 0; i--) {
            while ((x.getElevate()[i] != null) && (x.getElevate()[i].value()
                .getKey().compareTo(rec.getKey()) < 0)) {
                x = x.getElevate()[i];
            }
            update[i] = x;
        }
        x = new SkipNode<KVPair<K, E>>(rec, newLevel);
        for (int i = 0; i <= newLevel; i++) {
            x.getElevate()[i] = update[i].getElevate()[i];
            update[i].getElevate()[i] = x;
        }
        size++;
    }


    /**
     * method to remove the node from skipList
     * 
     * @param key
     *            the SkipNode's key
     * @return the node that we just remove, else return null
     */
    public E remove(K key) {
        SkipNode<KVPair<K, E>> removeNode = null;
        SkipNode<KVPair<K, E>> x = headNode;
        for (int i = level; i >= 0; i--) {
            while ((x.getElevate()[i] != null) && (x.getElevate()[i].value()
                .getKey().compareTo(key) < 0)) {
                x = x.getElevate()[i];
            }
            if ((x.getElevate()[i] != null) && (x.getElevate()[i].value()
                .getKey().compareTo(key) == 0)) {
                removeNode = x.getElevate()[i];
                break;
            }
        }

        if (removeNode != null) {
            x = headNode;
            for (int i = removeNode.getElevate().length - 1; i >= 0; i--) {
                while (x.getElevate()[i] != removeNode) {
                    x = x.getElevate()[i];
                }
                x.getElevate()[i] = removeNode.getElevate()[i];
            }

            size--;
            return removeNode.value().getValue();
        }
        return null;
    }


    /**
     * method to remove the node from skipList
     * 
     * @param coordinate
     *            the value
     * @return the value of node which was removed
     */
    public E remove(E coordinate) {
        SkipNode<KVPair<K, E>> x = headNode;
        SkipNode<KVPair<K, E>> rm = null;
        while (!(x.getElevate()[0] == null || x.getElevate()[0].value()
            .getValue().equals(coordinate))) {
            x = x.getElevate()[0];
        }
        if (x.getElevate()[0] != null) {
            rm = x.getElevate()[0];
        }
        if (rm == null) {
            return null;
        }
        x = headNode;
        for (int i = rm.getElevate().length - 1; i >= 0; i--) {
            while (x.getElevate()[i] != rm) {
                x = x.getElevate()[i];
            }
            x.getElevate()[i] = rm.getElevate()[i];
        }
        size--;
        return rm.value().getValue();
    }


    /**
     * method to search the node by key
     * 
     * @param name
     *            the node's key
     * @return the arrayList of the node that contains the same key
     */
    public ArrayList<E> search(K name) {
        SkipNode<KVPair<K, E>> x = headNode;
        for (int i = level; i >= 0; i--) {
            while ((x.getElevate()[i] != null) && (x.getElevate()[i].value()
                .getKey().compareTo(name) < 0)) {
                x = x.getElevate()[i];
            }
        }
        x = x.getElevate()[0];
        if ((x != null) && (x.value().getKey().compareTo(name) == 0)) {
            ArrayList<E> resultList = new ArrayList<E>();
            while ((x != null) && (x.value().getKey().compareTo(name) == 0)) {
                resultList.add(x.value().getValue());
                x = x.getElevate()[0];
            }
            return resultList;
        }
        else {
            return null;
        }
    }


    // /**
    //  * the method to find intersect node
    //  * 
    //  * @param x
    //  *            the x dimension
    //  * @param y
    //  *            the y dimension
    //  * @param width
    //  *            the width of rectangle
    //  * @param height
    //  *            the height of rectangle
    //  * @return the arrayList that intersect
    //  */
    // public ArrayList<E> regionSearch(int x, int y, int width, int height) {
    //     SkipNode<KVPair<K, E>> tmp = headNode;
    //     ArrayList<E> resultList = new ArrayList<E>();
    //     int i = 0;
    //     while (i < size) {
    //         tmp = tmp.getElevate()[0];
    //         Rectangle innerRec = (Rectangle)tmp.value().getValue();
    //         if ((innerRec.getX() + innerRec.getWidth()) > x && (x
    //             + width) >= innerRec.getX() && (innerRec.getY() + innerRec
    //                 .getHeight()) > y && (y + height) > innerRec.getY()) {
    //             resultList.add(tmp.value().getValue());
    //         }
    //         i++;
    //     }
    //     return resultList;
    // }


    // /**
    //  * the method that find all pair of rectangle which intersect
    //  */

    // public void intersection() {
    //     SkipNode<KVPair<K, E>> temp = headNode;
    //     int i = 0;
    //     while (i < size) {
    //         int j = 0;
    //         temp = temp.getElevate()[0];
    //         Rectangle outerRec = (Rectangle)temp.value().getValue();
    //         SkipNode<KVPair<K, E>> temp1 = headNode;

    //         while (j < size) {
    //             temp1 = temp1.getElevate()[0];
    //             Rectangle innerRec = (Rectangle)temp1.value().getValue();
    //             if ((innerRec.getX() + innerRec.getWidth()) > outerRec.getX()
    //                 && (outerRec.getX() + outerRec.getWidth()) > innerRec.getX()
    //                 && (innerRec.getY() + innerRec.getHeight()) > outerRec
    //                     .getY() && (outerRec.getY() + outerRec
    //                         .getHeight()) > innerRec.getY() && temp1 != temp) {
    //                 System.out.println(temp.value().getValue().toString()
    //                     .replace(")", " ") + "|" + temp1.value().getValue()
    //                         .toString().replace("(", " "));
    //             }
    //             j++;
    //         }

    //         i++;
    //     }

    // }


    /**
     * the method to print all the skipNode
     */

    public void dump() {
        // for the header node
        System.out.println("Node has depth " + (level + 1) + ", Value (null)");
        SkipNode<KVPair<K, E>> node = headNode;
        int i = 0;
        while (i < size) {
            node = node.getElevate()[0];
            System.out.println("Node has depth " + node.getElevate().length
                + ", Value " + node.value().getValue().toString());
            i++;
        }
        System.out.println("SkipList size is: " + this.size);

    }
}

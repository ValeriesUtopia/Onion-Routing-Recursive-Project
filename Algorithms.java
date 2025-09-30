//worked on by, Gabriel and Valerie.
import java.io.InputStream;
import java.util.ArrayList;
import java.io.IOException;

//I got bored, so decided to "baby-proof" it bc end users have room temp iq a lot of the time.
public class Algorithms {

    private static ArrayList<Integer> userBinaryList = new ArrayList<Integer>();
    private ArrayList<Integer> solution = new ArrayList<Integer>();
    private ArrayList<Integer> finalList = new ArrayList<Integer>();

    public Algorithms(ArrayList<Integer> list) {
        userBinaryList = list;
        this.solution = peel(list);
    }
    //takes in binary from terminal
    public void streamToList(InputStream in) {
        /* The conditions of the while loop are for the following reasons

           1) it is checking for '\n' because it is using a stream to take in the data,
           meaning the data it is taking in is in bytes (ASCII) from the keyboard,
           so we are checking for a '\n' because once you press enter, you
           have finished your data input.

           2) the second part of the condition is checking for a "-1", this is a signal
           that there is no more data to read, so the while loop will stop once there isn't
           anymore data to read. The '-1' signals the end of the stream, aka no more data :)
         */
        /**
         * Reads a binary number from the terminal input stream into {@code userBinaryList}.
         *   Ensures the number has an odd length
         *   Ensures all digits are binary (0 or 1)
         *   Re-prompts the user if the input is invalid.
         * This method uses {@code System.in.read()} to capture the input one byte at a time.
         */

        while (true) {
            try {
                int BYTE;
                int digit;
                System.out.print("Enter your binary number, it must have an odd number of digits: ");
                while ((BYTE = System.in.read()) != '\n' && BYTE != -1) {
                    if (BYTE >= 48 && BYTE <= 57) {
                        digit = BYTE - 48;
                        userBinaryList.add(digit);
                    }
                }
                if (userBinaryList.size() % 2 != 0) {
                    //if the size is not odd tell user to follow instructions.
                    if (isAllBinary(userBinaryList)) {
                        break;
                    }
                    else {
                        //if the input given by the user isn't only 1's and 0's tell them to follow instructions.
                        userBinaryList.clear();
                        printXLines(1);
                        System.out.println("Binary numbers consist of a combination of 1's and 0's, " +
                                "\nPlease make sure your input is also a combination of 1's and 0's.");
                    }
                }
                else {
                    userBinaryList.clear();
                    printXLines(1);
                    System.out.println("Please re-read instructions and try again");
                }
            }
            catch (IOException e) {
                System.out.println("I/O ERROR: somethings wrong with reading the data :/");
            }
        }
    }

    public ArrayList<Integer> peel (ArrayList<Integer> list) {
        ArrayList<Integer> newList = new ArrayList<Integer>();
        if (list.size() == 1) {
            newList.add(flip(list.getFirst()));
            finalList.clear();
            finalList.addAll(newList);
            return newList;
        }
        else {
        ArrayList<Integer> innerList = new ArrayList<Integer>();
        for (int i = 1; i < list.size() - 1; i++) {
                innerList.add(list.get(i));
            }
        Algorithms algo = new Algorithms(innerList);
        ArrayList<Integer> innerSolution = algo.getSolution();

        ArrayList<Integer> complete = new ArrayList<>();
        complete.add(flip(list.getFirst()));
        complete.addAll(innerSolution);
        complete.add(flip(list.getLast()));

        finalList.clear();
        finalList.addAll(complete);
        return complete;
        }
    }

    public int flip (int num) {
        if (num == 1) {
            return 0;
        }
        else {
            return 1;
        }
    }

    public ArrayList<Integer> getSolution () {
        return solution;
    }

    /**
     * Checks whether all elements in the given list are binary digits (0 or 1).
     *
     * @param binaryInput the list to validate
     * @return {@code true} if all elements are 0 or 1; {@code false} otherwise
     */

    private static boolean isAllBinary(ArrayList<Integer> binaryInput) {
        boolean result = false;
        for (int i = 0; i < binaryInput.size(); i++) {
            if (binaryInput.get(i) == 0 || binaryInput.get(i) == 1) {
                result = true;
            }
            else {
                result = false;
            }
        }
        return result;
    }
     /**
     * Checks if the binary list is symmetrical (palindromic).
     *
     * @return {@code true} if the list reads the same forwards and backwards;
     *         {@code false} otherwise
     */

     public boolean equals(ArrayList<Integer> other) {
         if (finalList.size() != other.size()) {
             return false;
         }
         for (int i = 0; i < finalList.size(); i++) {
             if (!finalList.get(i).equals(other.get(i))) {
                 return false;
             }
         }
         return true;
     }
    /**
     * Returns a string representation of the binary list without brackets or commas.
     *
     * @return the binary number as a string
     */

    @Override
    public String toString(){
        String str = "";
        for (int i = 0; i < finalList.size(); i++){
            str += (finalList.get(i).toString());
        }
        return str.toString();
    }
    /**
     * Prints {@code x} blank lines to the console.
     * Used as a way to visually clear the terminal output.
     *
     * @param x the number of blank lines to print
     */
    //this is NOT NECESSARY JUST FOR CLEARING TERMINALS (error checking)
    private static void printXLines(int x){
        for (int i = 0; i < x; i++) {
            System.out.println();
        }
    }
}

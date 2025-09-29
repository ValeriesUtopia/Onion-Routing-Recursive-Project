//worked on by, Gabriel and Valerie.
import java.util.ArrayList;
import java.io.IOException;

//I got bored, so decided to "baby-proof" it bc end users have room temp iq a lot of the time.
public class testingAlgo {
    private static ArrayList<Integer> userBinaryList = new ArrayList<Integer>();
    
    //takes in binary from terminal
    private static void streamToList() {
        /* The conditions of the while loop are for the following reasons

           1) it is checking for '\n' because it is using a stream to take in the data,
           meaning the data it is taking in is in bytes (ASCII) from the keyboard,
           so we are checking for a '\n' because once you press enter, you
           have finished your data input.

           2) the second part of the condition is checking for a "-1", this is a signal
           that there is no more data to read, so the while loop will stop once there isn't
           anymore data to read. The '-1' signals the end of the stream, aka no more data :)
         */
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
            if (userBinaryList.size() % 2 == 0) {
                //if the size is not odd tell user to follow instructions.
                userBinaryList.clear();
                printXLines(1);
                System.out.println("Please re-read instructions and try again");
                streamToList();
            }
            else if (!isAllBinary(userBinaryList)) {
                //if the input given by the user isn't only 1's and 0's tell them to follow instructions.
                userBinaryList.clear();
                printXLines(1);
                System.out.println("Binary numbers consist of a combination of 1's and 0's, " +
                        "\nPlease make sure your input is also made of a combination of 1's and 0's.");
                streamToList();
            }
            else {
                return;
            }
        }
        catch (IOException e) {
            System.out.println("I/O ERROR: somethings wrong with reading the data :/");
        }
    }
    private static int getDigits (int number) {
        if (number == 0) {
            return 1;
        }
        return (int) Math.log10(number) + 1;
    }
    //bit-flip
    private static void flipRecursive(int increment) {
        //once the increment is half the size of the ArrayList, then it is in the middle of the ArrayList.
        if (increment == userBinaryList.size() / 2) {
            if (userBinaryList.get(increment) == 0) {
                //bitflip
                userBinaryList.set(increment, 1);
                return;
            }
            else {
                //bitflip
                userBinaryList.set(increment, 1);
                return;
            }
        }
        if (userBinaryList.get(increment) == 0) {
            //bitflip
            userBinaryList.set(increment, 1);

            if (userBinaryList.get(userBinaryList.size() - 1 - increment) == 1) {
                //bitflip
                userBinaryList.set(userBinaryList.size() - 1 - increment, 0);
                flipRecursive(increment + 1);
            }
            else {
                //bitflip
                userBinaryList.set(userBinaryList.size() - 1 - increment, 1);
                flipRecursive(increment + 1);
            }
        }
        else if (userBinaryList.get(increment) == 1) {
            //bitflip
            userBinaryList.set(increment, 0);

            if (userBinaryList.get(userBinaryList.size() - 1 - increment) == 1) {
                //bitflip
                userBinaryList.set(userBinaryList.size() - 1 - increment, 0);
                flipRecursive(increment + 1);
            }
            else {
                //bitflip
                userBinaryList.set(userBinaryList.size() - 1 - increment, 1);
                flipRecursive(increment + 1);
            }
        }
    }
    private static void printList(ArrayList<Integer> anyList) {
        System.out.print("[");
        for (int i = 0; i < anyList.size(); i++) {
            System.out.print(anyList.get(i));
        }
        System.out.println("]");
    }
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
    //this is NOT NECESSARY JUST FOR CLEARING TERMINALS (error checking)
    private static void printXLines(int x){
        for (int i = 0; i < x; i++) {
            System.out.println();
        }
    }
}

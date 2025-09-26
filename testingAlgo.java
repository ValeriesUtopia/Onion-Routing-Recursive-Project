//worked on by, Gabriel and Valerie.
import java.util.ArrayList;
import java.io.IOException;

//I got bored, so decided to "baby-proof" it bc end users have room temp iq a lot of the time.
public class testingAlgo {
    private static ArrayList<Integer> userBinaryList = new ArrayList<Integer>();
    public static void main(String[] args) {
        streamToList();
        System.out.print("Original Binary Number: ");
        printList(userBinaryList);

        flipRecursive(0);
        System.out.print("Flipped Binary Number: ");
        printList(userBinaryList);
    }
    //takes in binary from terminal
    private static void streamToList() {
        /* The conditions of the while loop are for the following reasons

           1) it is checking for '\n' because it is using a stream to take in the data,
           meaning the data it is taking in is in bytes (ASCII) from the keyboard,
           so we are checking for a '\n' because once you press enter, you
           have finished your data input.

           2) the second part of the condition is checking for a "-1", this is a signal
           that there is no more data to read, so the while loop will stop once there isnt
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
                print50Lines();
                System.out.println("Please re-read instructions and comply");
                streamToList();
            }
            else if (!isAllBinary(userBinaryList)) {
                //if the input given by the user isnt only 1's and 0's tell them to follow instructions.
                userBinaryList.clear();
                print50Lines();
                System.out.println("Binary numbers consist of a combination of 1's and 0's, " +
                        "\nmake sure your input is also made of a combination of 1's and 0's.");
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
    //I just added this part check it please - valerie
    private static void flipRecursive(int increment) {
        if (increment == userBinaryList.size()/2){
            if(userBinaryList.size()%2==0){ // <- the base case check condition should just be if the increment is at the halfway point (size / 2)
                int mid = userBinaryList.size()/2; // <- remember they can only ever enter an odd number so the mid should just be size / 2 in integer division
                userBinaryList.set(mid-1, (userBinaryList.get(mid)==0)?1:0);
                return;
            }
           int firstIndex = increment;
           int lastIndex = userBinaryList.size()-1-increment;
           userBinaryList.set(firstIndex, (userBinaryList.get(firstIndex)==0)?1:0);
           userBinaryList.set(lastIndex, (userBinaryList.get(lastIndex)==0)?1:0);
           flipRecursive(increment+1);
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
    private static void print50Lines(){
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}

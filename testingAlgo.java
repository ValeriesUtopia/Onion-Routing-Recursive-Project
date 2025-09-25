//worked on by Gabriel, Valerie
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

//FOR CONTEXT: int's work fine, I am using long bc I wanted to mess around and see how big the numbers could get :)
//also i got bored so decided to baby-proof it bc end users have room temp iq a lot of the time.
public class testingAlgo {
    private static ArrayList<Long> userBinaryList;
    private static ArrayList<Long> finalBinaryList;
    private static long userBinaryInput;
    private static long length;
    public static void main(String[] args) {
        userBinaryList = new ArrayList<Long>();
        Scanner scan = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("How many digits will your binary number have? [MUST BE ODD AND POSITIVE]");
                length = scan.nextLong();

                if (length % 2 != 0 && length > 0) {
                    break;
                }
                else {
                    //couldnt figure out how to clear terminal so im flooding with blank lines sorry not sorry (print50Lines() is my weapon of choice).
                    System.out.println("Please enter a valid number!");
                    print50Lines();
                }
            }
            catch (InputMismatchException e) {
                System.out.println("please enter an odd number im beggin u");
            }
        }
        while (true) {
            System.out.println("Please enter your binary number [MUST BE ODD]: ");
            try {
                userBinaryInput = scan.nextLong();
                binaryToArrayList(length);

                if (length == userBinaryList.size()) {
                    System.out.println("checking length: valid!");
                    if (isAllBinary(userBinaryList)) {
                        System.out.println("checking binary: valid!");
                        System.out.println("thanks for following instructions!");
                        break;
                    }
                    else {
                        System.out.println("Please enter odd binary numbers.");
                        print50Lines();
                    }
                }
                else {
                    System.out.println("Please make sure your inputted length matches the actual length of the binary number");
                    print50Lines();
                }
            }
            catch (InputMismatchException e) {
                System.out.println("please enter a odd binary number, it aint that difficult.");
            }
        }
        scan.close();
    }

    //weird algo to get it into a list bc programming hates leading zeros apparently >:(.
    private static void binaryToArrayList(long length) {
        if (length == 0) {
            //base case
            return;
        }
        //if the length the user gave and the length of the binary number doesn't match then there was a leading zero that was lost when storing the binary number.
        else if (length != getDigits(userBinaryInput)) {
            userBinaryList.add((long) 0);
            length--;
            binaryToArrayList(length);
        }
        else {
            //if the predicted and actual length match
            length--;
            long digit = (long) (int) (userBinaryInput / Math.pow(10, length));
            userBinaryList.add(digit);
            if (digit == 1) {
                userBinaryInput -= (long) Math.pow(10, length);
            }
            binaryToArrayList(length);
        }
    }
    private static int getDigits (long number) {
        if (number == 0) {
            return 1;
        }
        return (int) Math.log10(number) + 1;
    }
    //making flipping algo
    private static ArrayList<Long> flipBits(ArrayList<Long> binaryInput) {
        //to be coded
    }
    private static void printList(ArrayList<Long> anyList) {
        for (int i = 0; i < anyList.size(); i++) {
            System.out.print(anyList.get(i));
        }
    }
    private static boolean isAllBinary(ArrayList<Long> binaryInput) {
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
    //this is NOT NECESSARY JUST FOR BABY-PROOFING (error checking)
    private static void print50Lines(){
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}

import java.util.ArrayList;
import java.util.Scanner;

public class testingAlgo {
    private static ArrayList<Long> binaryList;
    private static long userBinaryInput;
    public static void main(String[] args) {
        binaryList = new ArrayList<Long>();
        System.out.println("How many digits will your binary number have? [MUST BE ODD]");
        Scanner scan = new Scanner(System.in);
        long length = scan.nextLong();

        System.out.println("Please enter your binary number [MUST BE ODD]: ");
        userBinaryInput = scan.nextLong();
        binaryToArrayList(length);
    }

    //weird algo to get it into a list bc programming hates leading zeros apparently >:(.
    private static void binaryToArrayList(long length) {
        if (length == 0) {
            return;
        }
        //if the length the user gave and the length of the binary doesn't match then there was a leading zero that was lost when storing the binary number.
        else if (length != getDigits(userBinaryInput)) {
            binaryList.add((long) 0);
            length--;
            binaryToArrayList(length);
        }
        else {
            //if the predicted and actual length match
            length--;
            long digit = (long) (int) (userBinaryInput / Math.pow(10, length));
            binaryList.add(digit);
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
}

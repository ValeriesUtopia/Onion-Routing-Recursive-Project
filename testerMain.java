// coded by Valerie

    /**
     * The main method where program execution begins.
     *
     * @param args command-line arguments (not used)
     */
    
public class testerMain {

public static void main(String[] args) {

        testingAlgo.streamToList();
        System.out.print("Original Binary Number: ");
        testingAlgo.printList(testingAlgo.getUserBinaryList());

        testingAlgo.flipRecursive(0);
        System.out.print("Flipped Binary Number: ");
        testingAlgo.printList(testingAlgo.getUserBinaryList());
    }

}
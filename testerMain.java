public class testerMain {
   public static void main(String[] args) {
    
        streamToList();
        System.out.print("Original Binary Number: ");
        printList(userBinaryList);

        flipRecursive(0);
        System.out.print("Flipped Binary Number: ");
        printList(userBinaryList);
    } 
}
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        try {
            ArrayList<Integer> list = Algorithms.streamToList(System.in);
            Algorithms newAlgo = new Algorithms(list);
            System.out.println(newAlgo);
        }
        catch (IllegalArgumentException e) {
            System.out.println("Illegal Argument Caught!" + e.getMessage());
        }
    }
}

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
    public class Tester {
        @Test
        public void TEST () {
            ArrayList<Integer> list1 = new ArrayList<>();
            ArrayList<Integer> list2 = new ArrayList<>();
            list1.add(0);
            list1.add(1);
            list1.add(0);

            list1.add(1);
            list1.add(0);
            list1.add(1);
            assertArrayEquals(list1.toArray(), list2.toArray());
        }
    }
package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove(){
        AListNoResizing<Integer> al = new AListNoResizing();
        BuggyAList<Integer> bl = new BuggyAList<>();
        al.addLast(4);
        bl.addLast(4);
        al.addLast(5);
        bl.addLast(5);
        al.addLast(6);
        bl.addLast(6);
        assertEquals(al.removeLast(),bl.removeLast());
        assertEquals(al.removeLast(),bl.removeLast());
        assertEquals(al.removeLast(),bl.removeLast());
    }
    @Test
    public void randomizedTest(){
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> bugList = new BuggyAList<>();
        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                bugList.addLast(randVal);
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                int bugSize = bugList.size();
                assertEquals(size,bugSize);

            }else if (operationNumber == 2) {
                //getLast
                if(L.size()!=0){
                    assertEquals(L.getLast(),bugList.getLast());
                }
            }else if (operationNumber == 3) {
                //removeLast
                if(L.size()!=0){
                    assertEquals(L.removeLast(),bugList.removeLast());
                }
            }
        }
    }
}

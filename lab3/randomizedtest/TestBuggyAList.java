package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> expect = new AListNoResizing<>();
        BuggyAList<Integer> actuals = new BuggyAList<>();

        expect.addLast(4);
        expect.addLast(5);
        expect.addLast(6);

        actuals.addLast(4);
        actuals.addLast(5);
        actuals.addLast(6);

        assertEquals(expect.size(), actuals.size());

        assertEquals(expect.removeLast(), actuals.removeLast());
        assertEquals(expect.removeLast(), actuals.removeLast());
        assertEquals(expect.removeLast(), actuals.removeLast());
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> expecteds = new AListNoResizing<>();
        BuggyAList<Integer> actuals = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                expecteds.addLast(randVal);
                actuals.addLast(randVal);
                // System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int expectedsSize = expecteds.size();
                int actursizeSize = actuals.size();
                assertEquals(expectedsSize, actursizeSize);
            } else if (operationNumber == 2) {
                // getLast
                if (expecteds.size() > 0) {
                    assertEquals(expecteds.size(), actuals.size());
                    assertEquals(expecteds.getLast(), actuals.getLast());
                    // System.out.println("getLast(" + expecteds.getLast() + ")");
                }
            } else if (operationNumber == 3) {
                if (expecteds.size() > 0) {
                    assertEquals(expecteds.size(), actuals.size());
                    assertEquals(expecteds.removeLast(), actuals.removeLast());
                    // System.out.println("removeLast(" + expecteds.removeLast() + ")");
                }
            }
        }
    }
}

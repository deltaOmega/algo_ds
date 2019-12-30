import org.junit.Test;

import static org.junit.Assert.*;

public class NumberOfWaysTest {

    @Test
    public void numOfWays() {

        assertEquals(1, NumberOfWays.numOfWays(1));
        assertEquals(1, NumberOfWays.count);
        NumberOfWays.count = 0;
        assertEquals(2, NumberOfWays.numOfWays(2));
        assertEquals(1, NumberOfWays.count);
        NumberOfWays.count = 0;
        assertEquals(3, NumberOfWays.numOfWays(3));
        assertEquals(3, NumberOfWays.count);
        NumberOfWays.count = 0;
        assertEquals(5, NumberOfWays.numOfWays(4));
        assertEquals(5, NumberOfWays.count);
        NumberOfWays.count = 0;
        assertEquals(8, NumberOfWays.numOfWays(5));
        assertEquals(9, NumberOfWays.count);
        NumberOfWays.count = 0;
        assertEquals(13, NumberOfWays.numOfWays(6));
        assertEquals(15, NumberOfWays.count);
        NumberOfWays.count = 0;
    }

    @Test
    public void numOfWaysMemoization() {

        assertEquals(1, NumberOfWays.numOfWaysMemoization(1));
        assertEquals(1, NumberOfWays.count);
        NumberOfWays.count = 0;
        NumberOfWays.cache = new int[30];
        assertEquals(2, NumberOfWays.numOfWaysMemoization(2));
        assertEquals(1, NumberOfWays.count);
        NumberOfWays.count = 0;
        NumberOfWays.cache = new int[30];
        assertEquals(3, NumberOfWays.numOfWaysMemoization(3));
        assertEquals(3, NumberOfWays.count);
        NumberOfWays.count = 0;
        NumberOfWays.cache = new int[30];
        assertEquals(5, NumberOfWays.numOfWaysMemoization(4));
        assertEquals(5, NumberOfWays.count);
        NumberOfWays.count = 0;
        NumberOfWays.cache = new int[30];
        assertEquals(8, NumberOfWays.numOfWaysMemoization(5));
        assertEquals(7, NumberOfWays.count);
        NumberOfWays.count = 0;
        NumberOfWays.cache = new int[30];
        assertEquals(13, NumberOfWays.numOfWaysMemoization(6));
        assertEquals(9, NumberOfWays.count);
        NumberOfWays.count = 0;
        NumberOfWays.cache = new int[30];
    }

    @Test
    public void numOfWaysDpWithArr() {

        assertEquals(1, NumberOfWays.numOfWaysDpWithArr(1));
        assertEquals(2, NumberOfWays.numOfWaysDpWithArr(2));
        assertEquals(3, NumberOfWays.numOfWaysDpWithArr(3));
        assertEquals(5, NumberOfWays.numOfWaysDpWithArr(4));
        assertEquals(8, NumberOfWays.numOfWaysDpWithArr(5));
        assertEquals(13, NumberOfWays.numOfWaysDpWithArr(6));
    }

    @Test
    public void numOfWaysDpWithoutArr() {

        assertEquals(1, NumberOfWays.numOfWaysDpWithoutArr(1));
        assertEquals(2, NumberOfWays.numOfWaysDpWithoutArr(2));
        assertEquals(3, NumberOfWays.numOfWaysDpWithoutArr(3));
        assertEquals(5, NumberOfWays.numOfWaysDpWithoutArr(4));
        assertEquals(8, NumberOfWays.numOfWaysDpWithoutArr(5));
        assertEquals(13, NumberOfWays.numOfWaysDpWithoutArr(6));
    }
}
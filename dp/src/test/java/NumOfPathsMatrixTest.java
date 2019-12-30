import org.junit.Test;

import static org.junit.Assert.*;

public class NumOfPathsMatrixTest {

    @Test
    public void numOfPaths() {
        assertEquals(2, NumOfPathsMatrix.numOfPaths(1, 1));
        assertEquals(3, NumOfPathsMatrix.count);
        NumOfPathsMatrix.count = 0;
        assertEquals(6, NumOfPathsMatrix.numOfPaths(2, 2));
        assertEquals(11, NumOfPathsMatrix.count);
        NumOfPathsMatrix.count = 0;
        assertEquals(20, NumOfPathsMatrix.numOfPaths(3, 3));
        assertEquals(39, NumOfPathsMatrix.count);
        NumOfPathsMatrix.count = 0;

    }

    @Test
    public void numOfPathsMemoization() {
        assertEquals(2, NumOfPathsMatrix.numOfPathsMemoization(1, 1));
        assertEquals(3, NumOfPathsMatrix.count);
        NumOfPathsMatrix.count = 0;
        assertEquals(6, NumOfPathsMatrix.numOfPathsMemoization(2, 2));
        assertEquals(7, NumOfPathsMatrix.count);
        NumOfPathsMatrix.count = 0;
        assertEquals(20, NumOfPathsMatrix.numOfPathsMemoization(3, 3));
        assertEquals(11, NumOfPathsMatrix.count);
        NumOfPathsMatrix.count = 0;/*
        assertEquals(3, NumOfPathsMatrix.numOfPaths(3));
        assertEquals(3, NumOfPathsMatrix.count);
        NumOfPathsMatrix.count = 0;
        assertEquals(5, NumOfPathsMatrix.numOfPaths(4));
        assertEquals(5, NumOfPathsMatrix.count);
        NumOfPathsMatrix.count = 0;
        assertEquals(8, NumOfPathsMatrix.numOfPaths(5));
        assertEquals(9, NumOfPathsMatrix.count);
        NumOfPathsMatrix.count = 0;
        assertEquals(13, NumOfPathsMatrix.numOfPaths(6));
        assertEquals(15, NumOfPathsMatrix.count);
        NumOfPathsMatrix.count = 0;*/

    }

    @Test
    public void numOfPathsDpWithArr() {
        assertEquals(2, NumOfPathsMatrix.numOfPathsDpWithArr(1, 1));
        assertEquals(6, NumOfPathsMatrix.numOfPathsDpWithArr(2, 2));
        assertEquals(20, NumOfPathsMatrix.numOfPathsDpWithArr(3, 3));

    }

    @Test
    public void numOfPathsDpWithoutArr() {
        assertEquals(2, NumOfPathsMatrix.numOfPathsDpWithoutArr(1, 1));
        assertEquals(6, NumOfPathsMatrix.numOfPathsDpWithoutArr(2, 2));
        assertEquals(20, NumOfPathsMatrix.numOfPathsDpWithoutArr(3, 3));

    }
}
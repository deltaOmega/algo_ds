import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class MaxSumArrayTest {

    @Test
    public void maxSubArray() {
        int arr[] = {-2, 1 , -3, 4, -1, 2, 1, -5, 4};
        int max[] = MaxSumArray.maxSubArray(arr);
        assertArrayEquals(new int[]{4, -1, 2, 1}, max);

        int arr1[] = {-2, -1};
        max = MaxSumArray.maxSubArray(arr1);
        assertArrayEquals(new int[]{-1}, max);


        int arr2[] = {-1, -2};
        max = MaxSumArray.maxSubArray(arr2);
        assertArrayEquals(new int[]{-1}, max);
    }


    @Test
    public void maxSubArraySum() {
        int arr[] = {-2, 1 , -3, 4, -1, 2, 1, -5, 4};
        int max = MaxSumArray.maxSubArraySum(arr);
        assertEquals(6, max);


        int arr1[] = {-2, -1};
        max = MaxSumArray.maxSubArraySum(arr1);
        assertEquals(-1, max);


        int arr2[] = {-1, -2};
        max = MaxSumArray.maxSubArraySum(arr2);
        assertEquals(-1, max);
    }



}
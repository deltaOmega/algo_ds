import java.util.Arrays;

public class MaxSumArray {

    public static int[] maxSubArray(int[] arr)  {
        int prev = arr[0];
        int max = arr[0];
        int start = 0;
        int end = 1;
        for(int i = 1; i < arr.length; i++) {
            int tmp = prev + arr[i];
            if(tmp < arr[i]) {
                if(arr[i] > max) {
                    max = arr[i];
                    start = i;
                    end = i + 1;
                }
                prev = arr[i];
            } else {
                if(tmp >= max) {
                    max = tmp;
                    end = i + 1;
                }
                prev = tmp;
            }
        }
        int[] maxArr = new int[end - start];
        for(int i = start, j = 0; i < end; i++, j++) {
            maxArr[j] = arr[i];
        }
        return maxArr;
    }

    public static int maxSubArraySum(int[] arr) {
        int prev = arr[0];
        int max = arr[0];

        for(int i = 1; i < arr.length; i++) {
            int tmp = prev + arr[i];
            if(tmp < arr[i]) {
                if(arr[i] > max) {
                    max = arr[i];
                }
                prev = arr[i];
            } else {
                if(tmp >= max) {
                    max = tmp;
                }
                prev = tmp;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {-2, 1 , -3, 4, -1, 2, 1, -5, 4};
        int[] max = maxSubArray(arr);
        System.out.println(Arrays.toString(max));
        int maxVal = maxSubArraySum(arr);
        System.out.println(maxVal);

       int[] arr1 = {-1, -2};
       maxVal = maxSubArraySum(arr1);
        System.out.println(maxVal);
    }
}

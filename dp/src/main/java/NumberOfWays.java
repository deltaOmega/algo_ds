public class NumberOfWays {

    public static int count = 0;

    public static int numOfWays(int n) {
        count ++;

        if(n == 1){ return 1; }

        if(n == 2){ return 2; }

        return numOfWays(n-1) + numOfWays(n-2);

    }

    public static int[] cache = new int[30];

    public static int numOfWaysMemoization(int n) {
        count ++;
        if(cache[n] == 0) {
            if(n <= 2) {
                cache[n] = n;
            } else {
                cache[n] = numOfWaysMemoization(n-1) + numOfWaysMemoization(n-2);
            }
        }
        return cache[n];

    }

    public static int numOfWaysDpWithArr(int n) {

        if(n <= 2) return n;

        int[] arr = new int[n+1];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        for(int i = 3; i <= n; i++) {
            arr[i]= arr[i-1] + arr[i-2];
        }
        return arr[n];

    }

    public static int numOfWaysDpWithoutArr(int n) {

        if(n <= 2) return n;

        int prev = 1;
        int curr = 2;
        for(int i = 3; i <= n; i++) {
            int tmp = curr;
            curr = prev + curr;
            prev = tmp;
        }
        return curr;

    }
}

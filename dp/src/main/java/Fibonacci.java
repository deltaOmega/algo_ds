public class Fibonacci {
    public static int count = 0;

    public static int fib(int n) {
        count++;
        if(n==1 || n==2)
            return 1;
        return fib(n-1) + fib(n-2);
    }

    public static int[] cache = new int[100];
    public static int fibMemoization(int n) {
        count++;
        if(cache[n] == 0) {
            if (n == 1 || n == 2)
                cache[n] = 1;
            else cache[n] = fibMemoization(n - 1) + fibMemoization(n - 2);
        }
        return cache[n];
    }

    public static int fibDpWithArr(int n) {
        int[] arr = new int[n+1];
        arr[1] = arr[2] = 1;

        for(int i=3; i<=n; i++)
            arr[i] = arr[i-1]+arr[i-2];

        return arr[n];
    }

    public static int fibDpWithoutArr(int n) {
        if(n <= 2) return 1;
        int prev = 1, curr = 1;

        for(int i=3; i<=n; i++) {
            int temp = curr;
            curr = prev + curr;
            prev = temp;
        }

        return curr;
    }

}

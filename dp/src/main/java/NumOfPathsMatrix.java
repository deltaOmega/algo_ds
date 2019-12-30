public class NumOfPathsMatrix {
    public static int count = 0;

    public static int numOfPaths(int m, int n) {
        count++;
        if(m == 0 && n == 0) return 0;

        if(m == 0 || n == 0) return 1;

        int x = numOfPaths(m-1, n);

        int y = numOfPaths(m, n-1);

        return x+y;

    }

    public static int[][] cache = new int[30][30];

    public static int numOfPathsMemoization(int m, int n) {
        count++;
        if(cache[m][n] == 0) {
            if (m == 0 && n == 0) {
                cache[m][n] = 0;
            } else if (m == 0 || n == 0) {
                cache[m][n] = 1;
            } else {
                int x = numOfPathsMemoization(m - 1, n);
                int y = numOfPathsMemoization(m, n - 1);
                cache[m][n] = x + y;
            }
        }
        return cache[m][n];

    }


    public static int numOfPathsDpWithArr(int m, int n) {

        int[][] arr = new int[m+1][n+1];
        for(int i = 1; i <= m; i ++) {
            arr[0][i] = 1;
        }
        for(int i = 1; i <= n; i ++) {
            arr[i][0] = 1;
        }
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
             }
        }

        return arr[m][n];

    }

    public static int numOfPathsDpWithoutArr(int m, int n) {

        int[] prev = new int[m+1];
        int[] curr = new int[m+1];
        for(int i = 1; i <= m; i ++) {
            prev[i] = 1;
        }
        curr[0] = 1;
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                curr[j] = curr[j - 1] + prev[j];
             }
            prev = curr;
        }

        return curr[n];

    }

    public static void main(String[] args) {
        System.out.println(numOfPathsDpWithoutArr(3,3));
    }
}

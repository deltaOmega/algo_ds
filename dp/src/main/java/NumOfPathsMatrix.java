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

    public static int[][] blocked = new int[10][10];

    public static int numOfPathsWithBlocked(int m, int n) {

        if(blocked[m][n] == 1) { return 0; }

        if(m == 0 && n == 0) { return 1; }
        int x = 0;
        if(m != 0) {
            x = numOfPathsWithBlocked(m - 1, n);
        }

        int y = 0;
        if(n != 0) {
            y = numOfPathsWithBlocked(m, n-1);
        }

        return x+y;

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
        System.out.println("without blocking " + numOfPathsDpWithoutArr(3,3));

        System.out.println("without blocking no elements " + numOfPaths(3, 3));

        blocked[1][1] = 1;

        System.out.println("with blocking elements " + numOfPathsWithBlocked(3, 3));

        blocked[1][1] = 0;
        blocked[0][0] = 1;

        System.out.println("with blocking elements " + numOfPathsWithBlocked(3, 3));

        blocked[1][1] = 1;
        blocked[0][1] = 1;
        blocked[0][0] = 0;

        System.out.println("with blocking elements " + numOfPathsWithBlocked(3, 3));

        blocked[1][0] = 0;
        blocked[1][1] = 0;
        blocked[0][1] = 0;
        blocked[2][2] = 1;

        System.out.println("with blocking elements " + numOfPathsWithBlocked(3, 3));


        blocked[2][2] = 0;
        blocked[1][0] = 1;
        blocked[1][1] = 1;
        blocked[0][1] = 1;

        System.out.println("with blocking elements " + numOfPathsWithBlocked(3, 3));

    }
}

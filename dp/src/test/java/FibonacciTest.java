import org.junit.Test;

import static org.junit.Assert.*;

public class FibonacciTest {

    @Test
    public void fib() {
        assertEquals(1, Fibonacci.fib(2));
        assertEquals(1, Fibonacci.count);
        Fibonacci.count = 0;
        assertEquals(2, Fibonacci.fib(3));
        assertEquals(3, Fibonacci.count);
        Fibonacci.count = 0;
        assertEquals(21, Fibonacci.fib(8));
        assertEquals(41, Fibonacci.count);
        Fibonacci.count = 0;
        assertEquals(55, Fibonacci.fib(10));
        assertEquals(109, Fibonacci.count);
        Fibonacci.count = 0;
        assertEquals(610, Fibonacci.fib(15));
        assertEquals(1219, Fibonacci.count);
        Fibonacci.count = 0;

        assertEquals(6765, Fibonacci.fib(20));
        assertEquals(13529, Fibonacci.count);
        Fibonacci.count = 0;

        assertEquals(102334155, Fibonacci.fib(40));
        assertEquals(204668309, Fibonacci.count);
        Fibonacci.count = 0;
    }

    @Test
    public void fibMemoization() {

        assertEquals(1, Fibonacci.fibMemoization(2));
        assertEquals(1, Fibonacci.count);
        Fibonacci.count = 0;
        Fibonacci.cache = new int[100];
        assertEquals(2, Fibonacci.fibMemoization(3));
        assertEquals(3, Fibonacci.count);
        Fibonacci.count = 0;
        Fibonacci.cache = new int[100];
        assertEquals(5, Fibonacci.fibMemoization(5));
        assertEquals(7, Fibonacci.count);
        Fibonacci.count = 0;
        Fibonacci.cache = new int[100];
        assertEquals(21, Fibonacci.fibMemoization(8));
        assertEquals(13, Fibonacci.count);
        Fibonacci.count = 0;
        Fibonacci.cache = new int[100];
        assertEquals(55, Fibonacci.fibMemoization(10));
        assertEquals(17, Fibonacci.count);
        Fibonacci.count = 0;
        Fibonacci.cache = new int[100];
        assertEquals(610, Fibonacci.fibMemoization(15));
        assertEquals(27, Fibonacci.count);
        Fibonacci.count = 0;
        Fibonacci.cache = new int[100];

        assertEquals(6765, Fibonacci.fibMemoization(20));
        assertEquals(37, Fibonacci.count);
        Fibonacci.count = 0;
        Fibonacci.cache = new int[100];

        assertEquals(102334155, Fibonacci.fibMemoization(40));
        assertEquals(77, Fibonacci.count);
        Fibonacci.count = 0;
        Fibonacci.cache = new int[100];
    }

    @Test
    public void fibDpWithArr() {
        assertEquals(1, Fibonacci.fibDpWithArr(2));
        assertEquals(2, Fibonacci.fibDpWithArr(3));
        assertEquals(21, Fibonacci.fibDpWithArr(8));
        assertEquals(55, Fibonacci.fibDpWithArr(10));
        assertEquals(610, Fibonacci.fibDpWithArr(15));
        assertEquals(6765, Fibonacci.fibDpWithArr(20));
        assertEquals(102334155, Fibonacci.fibDpWithArr(40));
    }

    @Test
    public void fibDpWithoutArr() {
        assertEquals(1, Fibonacci.fibDpWithoutArr(2));
        assertEquals(2, Fibonacci.fibDpWithoutArr(3));
        assertEquals(21, Fibonacci.fibDpWithoutArr(8));
        assertEquals(55, Fibonacci.fibDpWithoutArr(10));
        assertEquals(610, Fibonacci.fibDpWithoutArr(15));
        assertEquals(6765, Fibonacci.fibDpWithoutArr(20));
        assertEquals(102334155, Fibonacci.fibDpWithoutArr(40));
    }

}
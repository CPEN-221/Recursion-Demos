import java.util.Map;
import java.util.HashMap;

/**
 * @author Mohammad Shahrad
 */

public class FibonacciRecursiveMem {
    static Map <Integer, Long> cache = new HashMap<>();

    public static void main(String[] args){
        int[] inputsToTest = new int[]{8, 32, 43};
        for (int input : inputsToTest){
            long output;
            long startTime;
            long endTime;

            startTime = System.nanoTime();
            output = RunFibonacciRecursiveMem(input);
            endTime = System.nanoTime();
            System.out.println( "RunFibonacciRecursiveMem("+input+") = "+output+", duration (us): "+(endTime-startTime)/1000 );
            startTime = System.nanoTime();
            output = RunFibonacciRecursiveMem(input);
            endTime = System.nanoTime();
            System.out.println( "2nd RunFibonacciRecursiveMem("+input+") = "+output+", duration (us): "+(endTime-startTime)/1000 );

            cache.clear();
            System.out.println( "------------------------------" );
        }
    }

    /**
     * Calculates the n'th Fibonacci number recursively
     * @param n a non-negative integer representing the sequence index
     * @return the n'th Fibonacci number where F(n)=F(n-1)+F(n-2) and F(1)=F(0)=1
     */
    static long RunFibonacciRecursive (int n){
        if (n==0){              // base case for n=0
            return 0;
        } else if (n==1) {      // base case for n=1
            return 1;
        } else {                // recursive step
            return RunFibonacciRecursive(n-1) + RunFibonacciRecursive(n-2);
        }
    }

    /**
     * Calculates the n'th Fibonacci number recursively and uses memoization
     * @param n a non-negative integer representing the sequence index
     * @return the n'th Fibonacci number where F(n)=F(n-1)+F(n-2) and F(1)=F(0)=1
     */
    static long RunFibonacciRecursiveMem (int n){
        if (cache.containsKey(n)){  // check if we had calculated it before
            return cache.get(n);
        }
        if (n==0){                  // base case for n=0
            cache.put(0, 0L);
            return 0;
        } else if (n==1) {          // base case for n=1
            cache.put(1, 1L);
            return 1;
        } else {                    // recursive step
            long result = RunFibonacciRecursiveMem(n-1) + RunFibonacciRecursiveMem(n-2);
            cache.put(n, result);
            return result;
        }
    }
}

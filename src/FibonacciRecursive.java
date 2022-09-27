/**
 * @author Mohammad Shahrad
 */

public class FibonacciRecursive {

    public static void main(String[] args){
        int[] inputsToTest = new int[]{8, 32, 43};
        for (int input : inputsToTest){
            long output;
            long startTime;
            long endTime;

            startTime = System.nanoTime();
            output = RunFibonacciRecursive(input);
            endTime = System.nanoTime();
            System.out.println( "RunFibonacciRecursive("+input+") = "+output+", duration (us): "+(endTime-startTime)/1000 );
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
}

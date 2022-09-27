import java.util.*;

/**
 * @author Mohammad Shahrad
 */

public class Fibonacci {
    static Map <Integer, Long> cache = new HashMap<>();

    public static void main(String[] args){
        int[] inputsToTest = new int[]{8, 32, 43};
        for (int input : inputsToTest){
            long output;
            long startTime;
            long endTime;

            startTime = System.nanoTime();
            output = RunFibonacci(input);
            endTime = System.nanoTime();
            System.out.println( "RunFibonacci("+input+") = "+output+", duration (us): "+(endTime-startTime)/1000 );

            cache.clear();
            System.out.println( "------------------------------" );
        }
    }

    /**
     * Calculates the n'th Fibonacci number
     * @param n a non-negative integer representing the sequence index
     * @return the n'th Fibonacci number where F(n)=F(n-1)+F(n-2) and F(1)=F(0)=1
     */
    static long RunFibonacci (int n){
        if (n==0){
            return 0;
        } else if (n==1) {
            return 1;
        } else {
            long n_1 = 1;
            long n_2 = 0;
            long sum = 0;
            for (int i=2; i<=n; i++){
                sum = n_1 + n_2;
                n_2 = n_1;
                n_1 = sum;
            }
            return sum;
        }
    }
}

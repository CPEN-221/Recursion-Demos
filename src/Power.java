/**
 * @author Mohammad Shahrad
 */

public class Power {

    public static void main(String[] args){
        int measurementCount = 50;
        double baseInputs = 0.89;
        int[] powerInputs = new int[]{10, 20, 40, 80, 160, 320, 640, 1280, 2560};
        long[] measurementSumP1 = new long[powerInputs.length];
        long[] measurementSumP2 = new long[powerInputs.length];

        for (int measurement=0; measurement<measurementCount; measurement++){
            for (int i=0; i<powerInputs.length; i++){
                long startTime;
                long endTime;
                double output;

                startTime = System.nanoTime();
                output = Power(baseInputs, powerInputs[i]);
                endTime = System.nanoTime();
                measurementSumP1[i] += endTime-startTime;
                System.out.println( "Power("+baseInputs+"^"+powerInputs[i]+") = "+output );

                startTime = System.nanoTime();
                output = PowerRecursive(baseInputs, powerInputs[i]);
                endTime = System.nanoTime();
                measurementSumP2[i] += endTime-startTime;
                System.out.println( "PowerRecursive("+baseInputs+"^"+powerInputs[i]+") = "+output );

            }
        }

        // printing out the measurement results
        System.out.println( "**** Performance Results ***" );
        for (int i=0; i<powerInputs.length; i++){
            System.out.println( "p = " + powerInputs[i]);
            System.out.println( "Power          - Average Duration (ns): " + measurementSumP1[i]/measurementCount );
            System.out.println( "PowerRecursive - Average Duration (ns): " + measurementSumP2[i]/measurementCount );
        }
    }

    static double Power(double x, int n){
        double result = 1;
        for(int i=0; i<n; i++){
            result *= x;
        }
        return result;
    }

    /*
    The recursive version of the power function with integer powers
     */
    static double PowerRecursive(double x, int n){
        if (n==0){
            return 1;
        }
        if (n==1){
            return x;
        }
        double partialRes = PowerRecursive(x, n>>1); // n>>1 means right-shifting by 1, which is division by two
        if (n%2==0){
            return partialRes * partialRes;
        } else {
            return partialRes * partialRes * x;
        }
    }
}

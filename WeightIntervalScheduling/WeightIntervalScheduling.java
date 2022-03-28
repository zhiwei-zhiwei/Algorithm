/*
* Writtem be Zhiwei Cao
* University of Wisconsin - Madison
* Course: COMP SCI 577
* Instructor: Dr. Marc Renault
* Date: Mar 28, 2022
*/
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class WeightIntervalScheduling {
    public static void main(String[] args){
        Scanner key = new Scanner(System.in);
        Long outLoop = Long.parseLong(key.nextLine());
        long[] result = new long[outLoop.intValue()];
        for (Long i = (long) 0; i < outLoop; i++) {
            Long jobs = Long.parseLong(key.nextLine());
            int[][] intInput = new int[jobs.intValue()][3];

            for (int k =  0; k < jobs; k++) {
                String input = key.nextLine();
                String[] arrInput = input.split(" ");
                for (int l = 0; l < 3; l++) {
                    intInput[k][l] = Integer.parseInt(arrInput[l]);
                }
            }

            WeightIntervalScheduling wis = new WeightIntervalScheduling();
            result[i.intValue()] = wis.WIS(intInput);
        }
        for (Long i = (long) 0; i < outLoop; i++) {
            System.out.println(result[i.intValue()]);
        }
    }

    public long WIS(int[][] inputArr){
        int res =  0;
        if(inputArr.length == 1) return inputArr[0][2];
        Arrays.sort(inputArr, Comparator.comparingDouble(o -> o[1])); // sort the array by the index 1
        long[] dp = new long[inputArr.length];
        dp[0] = inputArr[0][2];
        for (int i = 1; i < inputArr.length; i++) {
            long weight = inputArr[i][2];
            for (int j = i-1; j >= 0; j--) {
                if (inputArr[i][0] >= inputArr[j][1]){
                    weight += dp[j];
                    break; // as long as fit the if statement, stop the loop. Prevent to do more search.
//                    dp[j] = Math.max(dp[j-1],dp[i]+inputArr[j][2]);
//                    res = dp[j];
                }
            }
            dp[i] = Math.max(dp[i-1],weight);
        }
        return dp[inputArr.length-1];
    }

}

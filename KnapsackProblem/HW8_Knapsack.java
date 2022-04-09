import java.util.Scanner;

public class HW8_Knapsack {
    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);
        int outLoop = Integer.parseInt(key.nextLine());
        int[] sol = new int[outLoop];
        for (int i = 0; i < outLoop; i++) {
//            int[] bag = new int[2];
            String input = key.nextLine();
            String[] arrInput = input.split(" ");
            int items = Integer.parseInt(arrInput[0]);
            int capacity = Integer.parseInt(arrInput[1]);
            int[] weight = new int[items];
            int[] value = new int[items];
            for (int j = 0; j < items; j++) {
                String temp = key.nextLine();
                String[] tempArr = temp.split(" ");
                weight[j] = Integer.parseInt(tempArr[0]);
                value[j] = Integer.parseInt(tempArr[1]);
            }

            sol[i] = testweightbagproblem(weight, value, capacity);
        }
        for (int i = 0; i < outLoop; i++) {
            System.out.println(sol[i]);
        }
    }

    public static int testweightbagproblem(int[] weight, int[] value, int capacity){
        int len = weight.length;
        int[][] dp = new int[len + 1][capacity + 1];
        for (int i = 0; i <= len; i++){
            dp[i][0] = 0;
        }
        for (int i = 1; i <= len; i++){
            for (int j = 1; j <= capacity; j++){
                if (j < weight[i - 1]){
                    dp[i][j] = dp[i - 1][j];
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i - 1]] + value[i - 1]);
                }
            }
        }
//        System.out.println(dp[wlen][bagsize]);
        return dp[len][capacity];
    }
}

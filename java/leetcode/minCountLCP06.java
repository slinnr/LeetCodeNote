package main.Java.com.sunlin.leetcode;

public class minCountLCP06 {

    public static void main(String[] args) {
        int[] coins = {2,2,2,1,3,2};
        minCountLCP06 min = new minCountLCP06();
        int i = min.minCount(coins);
        System.out.println(i);
    }

    public int minCount(int[] coins) {

        if (coins == null || coins.length == 0){
            return 0;
        }
        int count = 0;
        for (int i = 0; i < coins.length ; i++){
            count = count + coins[i]/2 + coins[i]%2;
        }

        return count;
    }
}

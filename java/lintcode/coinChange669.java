package main.Java.com.sunlin.lintcode;

import static java.lang.Integer.MAX_VALUE;

public class coinChange669 {

    public static void main(String[] args) {
        coinChange669 coinChange = new coinChange669();
        int[] coins = {1,2,5};
        int i = coinChange.dpCoinChange(coins,11);
        System.out.println(i);
    }

    //动态规划
    int dpCoinChange(int[]coins , int x){

        if(coins == null || coins.length == 0 || x == 0){
            return -1;
        }

        int[] coinCounts =new int[x+1]; //开一个数组 ，数组coinCounts[i]表示拼出i需要的最少枚硬币。
        coinCounts[0] = 0; //边界条件，当拼0时需要0枚
        for (int i = 1; i <= x ; i++){ //算出拼出每个数需要的最少枚硬币
            coinCounts[i] = MAX_VALUE; //初始化为无穷大

            for (int j = 0; j < coins.length ; j++){//通过这个遍历，算出这些硬币拼出i的最小枚数

                if (i-coins[j] >= 0 && coinCounts[i-coins[j]] != MAX_VALUE){ //下面的代码的边界条件
                    coinCounts[i] = Math.min(coinCounts[i-coins[j]]+1,coinCounts[i]);//最关键的一行 找出最小的枚数
                }
            }
        }

        if (coinCounts[x] == Integer.MAX_VALUE){
            coinCounts[x] = -1;
        }
        return coinCounts[x];
    }


    //递归算法
    int coinChange(int x){

        if (x == 0){
            return 0;
        }

        int res = MAX_VALUE;

        if (x >= 1){
            res = Math.min(coinChange(x-1)+1,res);
        }

        if (x >= 2){
            res = Math.min(coinChange(x-2)+1,res);
        }

        if (x >= 5){
            res = Math.min(coinChange(x-5)+1,res);
        }
        return res;
    }
}

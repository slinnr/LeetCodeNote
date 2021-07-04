package main.Java.com.sunlin.剑指offer;

public class 剪绳子 {
    public static void main(String[] args) {
        剪绳子 cutRope = new 剪绳子();
        int res = cutRope.cuttingRope2(10);
        System.out.println(res);
    }
    public int cuttingRope(int n) {

        if (n <= 3){
            return n-1;
        }

        //开数组，array[i]中记录了i米的绳子剪成段的最大乘积
        int[] array = new int[n+1];
        array[1] = 1;
        array[2] = 2;
        array[3] = 3;

        for (int i = 4 ; i <= n ; i++){
            int max = 0;
            for (int j = 1 ; j <= i ; j++){

                int cutNum = Math.max(array[j]*array[i-j],j*(i-j));
                if (max < cutNum){
                    max = cutNum;
                }
            }
            array[i] = max;
        }
        for (int i = 1 ; i <= n ; i++){
            System.out.print(array[i]+"  ");
        }
        return array[n];
    }

    /*
    数论知识：1、所有大于1的数都可以由2和3相加可得
              2、对于该题，3越多，乘积就越大
              3、对于4，直接乘以4最大
     */
    public int cuttingRope2(int n) {

        if (n <= 3){
            return n-1;
        }

        int dev = n/3;
        int res = 1;
        for (int i = 1 ; i <= dev ; i++){
            res = res * 3;
        }
        return n%3 == 0? res:(n%3 == 1? (res/3)*4 : res*(n%3));
    }
}

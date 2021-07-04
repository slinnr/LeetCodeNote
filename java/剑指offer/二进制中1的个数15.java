package main.Java.com.sunlin.剑指offer;

public class 二进制中1的个数15 {
    public static void main(String[] args) {

        二进制中1的个数15 num = new 二进制中1的个数15();
        int res = num.hammingWeight(00000000000000000000000000001011 );
        System.out.println(res);
    }

    public int hammingWeight(int n) {

        if (n == 0){
            return 0;
        }
        int res = 0;

        while (n != 0){

            if ((n&1) == 1){
                res++;
            }
            n = n>>>1;
        }
        return res;
    }

}

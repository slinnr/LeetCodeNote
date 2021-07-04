package main.Java.com.sunlin.suanfa;

public class 位运算 {

    public static void main(String[] args) {
        位运算 weiyuns = new 位运算();
        Integer res = weiyuns.weiyunsuan(1000);
        System.out.println(res);
    }
    private Integer weiyunsuan(Integer value){

        if (value == 0){
            return 0;
        }

        Integer res = 0;
        while (value != 0){
            res++;
            value = value >> 1;
        }
        return res;
    }
}

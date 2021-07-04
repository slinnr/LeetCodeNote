package main.Java.com.sunlin.suanfa;

public class 斐波那契数列 {

    public static void main(String[] args) {
        斐波那契数列 list = new 斐波那契数列();
        Integer res1 = list.fbnq(9);
        Integer res2 = list.dpfbnq(9);
        System.out.println(res1);
        System.out.println(res2);
    }

    //递归实现
    public Integer fbnq(Integer value){

        if (value == 0){
            return 0;
        }
        if (value == 2 || value == 1){
            return 1 ;
        }

        return fbnq(value -1) + fbnq(value - 2);
    }

    public Integer dpfbnq(Integer value){

        if (value == 0){
            return 0;
        }
        if (value == 1 || value == 2)
            return 1;
        int last = 1;
        int next = 1;
        int res = 0;

        for (int i = 3 ; i <= value ; i++){
            res = last + next;
            last = next;
            next = res;
        }
        return res;
    }
}

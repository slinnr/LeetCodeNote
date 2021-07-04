package main.Java.com.sunlin.suanfa;

public class 上台阶问题 {

    public static void main(String[] args) {
        上台阶问题 upstart = new 上台阶问题();
        Integer res = upstart.upstart(44);
        System.out.println(res);
    }

    public Integer upstart(Integer num){

        if (num == 1 ){
            return 1;
        }

        if (num == 1){
            return 1;
        }

        int[] steps = new int[num+1];

        steps[0] = 1;
        steps[1] = 1;

        for (int i = 2 ; i <= num ; i++){

            steps[i] = steps[i-1]+steps[i-2];
        }
        return steps[num];
    }
}

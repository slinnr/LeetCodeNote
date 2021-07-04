package main.Java.com.sunlin.leetcode;

import java.util.ArrayList;
import java.util.List;
//分蛋糕问题
public class Cake {

    public static void main(String[] args) {
        Cake cake = new Cake();
        Integer res = cake.cake2(15);
        System.out.println(res);
    }

    public Integer cake(Integer n){

        if (n == 0){
            return 0;
        }
        int[] cakes = new int[n];
        int i = 0;
        int res = 0;
        while (true) {
            //向右
            while (i < n && cakes[i] == -1) {
                i++;

                if (i == n) {
                    return res;
                }
            }
            int j = 0;
            for (; i < cakes.length; i++) {

                if (cakes[i] == 0){
                    j++;
                }
                if (j % 2 == 0) {
                    cakes[i] = -1;
                    res = i + 1;
                }
            }
            i--;
            //向左
            while (i >= 0 && cakes[i] == -1) {
                i--;

                if (i < 0) {
                    return res;
                }
            }
            i++;
            int o = 0;
            for (; i < cakes.length; i--) {

                if (cakes[i] == 0)
                    o++;

                if (o % 2 == 0) {
                    cakes[i] = -1;
                    res = i + 1;
                }
            }
        }
    }

    public Integer cake2(Integer n){

        if (n == 0) return 0;

        List<Integer> cakes = new ArrayList(n);

        for (int i = 1; i <= n; i++) {
            cakes.add(i);
        }

        while (true){
            int index = 0;

            //向右
            while (index < cakes.size()){

                if (cakes.size() == 1){
                    return cakes.get(0);
                }
                cakes.remove(index);

                index++;
            }
            index = index-2;
            //向左
            while (index >= 0 ){

                if (cakes.size() == 1){
                    return cakes.get(0);
                }
                cakes.remove(index);

                index = index-2;
            }
        }

    }
}

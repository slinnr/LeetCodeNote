package main.Java.com.sunlin.suanfa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 桶排序 {

    public static void main(String[] args) {
        桶排序 bucketSort = new 桶排序();
        int[] values = {5,3,6,9,4,1,6312,5,6};
        List res = bucketSort.bucketSort(values);
        System.out.println(res);
    }

    public List bucketSort(int[] values){

        if (values.length == 0){
            return new ArrayList();
        }
        int len = values.length;
        //寻找最大值和最小值
        int max = -Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            if (values[i] > max){
                max = values[i];
            }
            if (values[i] < min){
                min = values[i];
            }
        }
        if (max == min){
            return Arrays.asList(values);
        }
        int n = max - min;
        int bucketNum = n/5+1;
        List<List<Integer>> buckets =new ArrayList<>(bucketNum);
        List<Integer> res = new ArrayList<>();
        //初始化桶
        for (int i = 0 ; i < bucketNum ; i++){
            buckets.add(new ArrayList<>());
        }

        //将数组放入桶中
        for (int i = 0 ; i < len ; i++){
            buckets.get((values[i] - min)/n).add(values[i]);
        }

        //对桶中的数据进行排序
        for (int i = 0 ; i < bucketNum ; i++){
            Collections.sort(buckets.get(i));
        }

        for (int i = 0 ; i < bucketNum ; i++)
        {
            for (Integer value : buckets.get(i)){
                res.add(value);
            }
        }
        return res;
    }
}

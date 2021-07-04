package main.Java.com.sunlin.suanfa;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
快排
 */
public class FastSort {

    public static void main(String[] args) {
        FastSort fastSort = new FastSort();
        List<Integer> list = new ArrayList<>(10);
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(70);
        list.add(-97);
        list.add(-7);
        list.add(77);
        list.add(-7);
        list.add(7);
        list.add(-47);
        list.add(700);
        List<Integer> integers = fastSort.quickSort(list, 0, list.size() - 1);
        System.out.println(integers);
    }


    public List<Integer> quickSort(List<Integer> list, int low , int high){

        if (low < high){
            Integer index = fastSort(list, low, high);

            fastSort(list,low,index);
            fastSort(list,index+1,high);
        }
        return list;
    }

    public Integer fastSort(List<Integer> list , int low , int high){
       int temp = list.get(low);

       while (low < high){

           while (low < high && list.get(high) >= temp){
               high--;
           }
           list.set(low,list.get(high));
           while (low < high && list.get(low) <= temp){
               low++;
           }
           list.set(high,list.get(low));
       }
       list.set(low,temp);

       return low;
    }
}

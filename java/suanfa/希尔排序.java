package main.Java.com.sunlin.suanfa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 希尔排序 {

    public static void main(String[] args) {
        希尔排序 shell = new 希尔排序();
        int[] values = {5,3,6,9,4,1,6312,5,6};
        int[] ints = shell.shellSort(values);
        for (int num :ints) {
            System.out.println(num);
        }

    }
    public int[] shellSort(int[] values){

        if (values.length == 0 || values.length == 1){
            return values;
        }

        int len = values.length;
        for (int h = len/2 ; h > 0 ; h/=2){
            for (int i = h ; i < len ; i++){
                insert(values,h,i);
            }
        }
        return values;
    }
    //将i插入到正确的位置
    public void insert(int[] arr , int h , int i){

        int temp = arr[i];
        int k;
        for (k = i - h; k > 0 && temp < arr[k]; k -= h) {
            arr[k + h] = arr[k];
        }
        arr[k + h] = temp;
    }
}

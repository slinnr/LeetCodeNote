package main.Java.com.sunlin.剑指offer;

public class MinArray11 {

    public static void main(String[] args) {
        MinArray11 minArray = new MinArray11();
        int[] val = {1,3,5};
        Integer res = minArray.minArray2(val);
        System.out.println(res);
    }

    public Integer minArray2(int[] values){

        int res = values[0];

        for (int i = 1; i < values.length ; ++i){

            if (values[i] < values[0]){
                res = values[i];
            }
        }
        return res;
    }

    public Integer minArray(int[] values){

        int head = 0;
        int end = values.length-1;
        int mid = 0;

        while (head < end){

            if (end - head == 1){
                mid = end;
                break;
            }

            mid = (head+end)/2;

            if (values[head] == values[mid] && values[head] == values[end]){
                return findMinByOrder(values);
            }
            if (values[mid] > values[head]){
                head = mid;
            }else{
                end = mid;
            }
        }

        return values[mid];
    }

    private Integer findMinByOrder(int[] values) {

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < values.length ; i++){

            if (min > values[i]){
                min = values[i];
            }
        }
        return min;
    }
}

package main.Java.com.sunlin.suanfa;

public class 堆排序 {

    public static void main(String[] args) {
        堆排序 head = new 堆排序();
        int[] values = {1,2,3,4,50,6,7,8,9};
        head.createHead(values);
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }
    }
    public int[] createHead(int[] arr){

        int n = arr.length;
        //构建大顶堆
        for (int i = n - 1 ; i >= 0; i--) {
            downAdjust(arr, i, n - 1);
        }
        //进行堆排序
        for (int i = n - 1; i >= 1; i--) {
            // 把堆顶元素与最后一个元素交换
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            // 把打乱的堆进行调整，恢复堆的特性
            downAdjust(arr, 0, i - 1);
        }
        return arr;
    }

    private void swap(int[] values, int i, int i1) {
        int temp = values[i];
        values[i] = values[i1];
        values[i1] = temp;
    }

    //下沉操作
    public void downAdjust(int[] arr, int parent, int n) {
        //临时保存要下沉的元素
        int temp = arr[parent];
        //定位左孩子节点的位置
        int child = 2 * parent + 1;
        //开始下沉
        while (child <= n) {
            // 如果右孩子节点比左孩子大，则定位到右孩子
            if(child + 1 <= n && arr[child] < arr[child + 1])
                child++;
            // 如果孩子节点小于或等于父节点，则下沉结束
            if (arr[child] <= temp ) break;
            // 父节点进行下沉
            arr[parent] = arr[child];
            parent = child;
            child = 2 * parent + 1;
        }
        arr[parent] = temp;
    }
}

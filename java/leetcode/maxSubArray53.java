package main.Java.com.sunlin.leetcode;

public class maxSubArray53 {

    public static void main(String[] args) {
        maxSubArray53 maxSubArray53 = new maxSubArray53();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int i = maxSubArray53.maxSubArray(nums);
        System.out.println(i);
    }

    public int maxSubArray(int[] nums) {
        int[] sum =new int[nums.length];
        int res = nums[0];
        sum[0] = nums[0];
        for (int i = 1 ;i < nums.length ; i++){
            sum[i] = 0;
            sum[i] = Math.max(sum[i-1]+nums[i],nums[i]);
            res = sum[i]>res?sum[i]:res;
        }
        return res;
    }
}

package main.Java.com.sunlin.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
  三数之和
 */
public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> lists = threeSum.threeSum(nums);
        System.out.println(lists);
    }

    public List<List<Integer>> threeSum(int[] nums) {

        if (nums == null || nums.length < 3){
            return new ArrayList<>();
        }
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0 ; i<nums.length ; i++){

            if (nums[i] > 0 || i == nums.length-2) break;

            if (i > 0 && nums[i] == nums[i-1]) continue;

            int j = i + 1 , k = nums.length - 1;

            while (j < k){
                if (nums[i] + nums[j] + nums[k] > 0){
                    while (j < --k && nums[i] + nums[j] + nums[k] > 0);
                }
                if (nums[i] + nums[j] + nums[k] < 0){
                    while (++j < k && nums[i] + nums[j] + nums[k] < 0);
                }
                if (j < k && nums[i] + nums[j] + nums[k] == 0){
                    res.add(new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[k])));
                    while (j < k && nums[k] == nums[k-1]) --k;
                    while (j < k && nums[j] == nums[j+1]) ++j;
                    k--;j++;
                }
            }


        }
        return res;
    }

}

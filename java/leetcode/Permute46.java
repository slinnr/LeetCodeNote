package main.Java.com.sunlin.leetcode;

import java.util.*;

public class Permute46 {
    public static void main(String[] args) {
        Permute46 permute46 = new Permute46();
        int[] nums = {1,2,3};
        List<List<Integer>> res = permute46.permute(nums);
        System.out.println(res);
    }


    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        if (n == 0){
            return null;
        }
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<Integer>();
        List<Integer> input = new ArrayList<>();
        boolean[] isUse = new boolean[n];
        int depth = 0;
        for (int num : nums){
            input.add(num);
        }
        dfs(n , depth , input , path , isUse , res);
        return res;
    }

    private void dfs(int len , int depth, List<Integer> input, Deque<Integer> path, boolean[] isUse , List<List<Integer>> res) {

        if (depth == len){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {

            if (isUse[i]){
                continue;
            }

            isUse[i] = true;
            path.addLast(input.get(i));
            dfs(len, depth+1, input, path, isUse, res);
            isUse[i] = false;
            path.removeLast();
        }
    }
}

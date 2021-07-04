package main.Java.com.sunlin.leetcode;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {

    public static void main(String[] args) {

    }

    public List<List<Integer>> permute(int[] values){
        int len = values.length;

        if (len == 0){
            return null;
        }
        List<List<Integer>> res = new ArrayList<>();//存放全排列后的结果
        Deque<Integer> path = new ArrayDeque<>();//走过的路径
        List<Integer> input = new ArrayList<>();//
        boolean[] isUse = new boolean[len];
        int depth = 0;

        dfs(len , depth , values , path , isUse , res);
        return res;
    }

    private void dfs(int len, int depth, int[] values, Deque<Integer> path, boolean[] isUse, List<List<Integer>> res) {

        //递归出口
        if (depth == len){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0 ; i <len ; i++){

            if (isUse[i]){
                continue;
            }

            isUse[i] = true;
            path.addLast(values[i]);
            //开始递归
            dfs(len,depth+1,values,path,isUse,res);
            //回溯
            isUse[i] = false;
            path.removeLast();
        }
    }

}

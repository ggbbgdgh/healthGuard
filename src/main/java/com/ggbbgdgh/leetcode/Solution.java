package com.ggbbgdgh.leetcode;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.diffWaysToCompute("2-1-1"));
        System.out.println(solution.diffWaysToCompute("2*3-4*5"));
    }

    public List<Integer> diffWaysToCompute(String expression) {
        /**
         1.先进行词法分析，解析出数字和操作符
         2.遍历所有操作符，每次处理操作符，然后进行递归。
         4.将结果放到一个集合中
         */
        //1.词法分析，解析出数字和操作符
        List<Integer> nums = new ArrayList<>();
        List<Character> ops = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < expression.length(); ) {
            if ("-+*".contains("" + expression.charAt(i))) {
                ops.add(expression.charAt(i++));
            } else if (expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {
                Integer num = 0;
                while (i < expression.length() && expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {
                    num = num * 10 + expression.charAt(i++) - '0';
                }
                nums.add(num);
            }
        }
        diffWaysToCompute(result, nums, ops);
        return new ArrayList(result);
    }

    public void diffWaysToCompute(List<Integer> result, List<Integer> nums, List<Character> ops) {
        if (nums.size() == 1) {
            result.add(nums.get(0));
            return;
        }
        //2.遍历所有操作符，每次处理操作符，然后进行递归。
        for (int i = 0; i < ops.size(); i++) {
            //合并nums[i], nums[i+1],将结果存到新List中
            List<Integer> mergeNums = new ArrayList<>();
            List<Character> mergeOps = new ArrayList<>();
            for (int n : nums) {
                mergeNums.add(n);
            }
            for (Character op : ops) {
                mergeOps.add(op);
            }
            char op = mergeOps.get(i);
            if (op == '-') {
                mergeNums.set(i, mergeNums.get(i) - mergeNums.get(i + 1));
            } else if (op == '+') {
                mergeNums.set(i, mergeNums.get(i) + mergeNums.get(i + 1));
            } else if (op == '*') {
                mergeNums.set(i, mergeNums.get(i) * mergeNums.get(i + 1));
            } else {
                throw new RuntimeException("Unkonw op:" + mergeOps.get(i));
            }
            mergeNums.remove(i + 1);
            mergeOps.remove(i);
            diffWaysToCompute(result, mergeNums, mergeOps);
        }

    }
}
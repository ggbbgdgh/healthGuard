package com.ggbbgdgh.leetcode.lc227;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.calculate("1+1+1"));
    }

    public int calculate(String s) {
        List<Integer> nums = new ArrayList<>();
        List<Character> ops = new ArrayList<>();
        int num = 0;
        for(char c : s.toCharArray()) {
            if(c >= '0' && c <= '9') {
                num = 10 * num + c - '0';
            }else if (c == '+' || c == '-' || c == '*' || c == '/') {
                ops.add(c);
                nums.add(num);
                num = 0;
            }
        }
        nums.add(num);

        List<Character> opsAM = new ArrayList<>();
        for(int i = 0; i < ops.size(); i++) {
            if(ops.get(i) == '*') {
                nums.set(i, nums.get(i) * nums.get(i +1));
                nums.remove(i + 1);
            } else if(ops.get(i) == '/') {
                nums.set(i, nums.get(i) / nums.get(i +1));
                nums.remove(i + 1);
            } else {
                opsAM.add(ops.get(i));
            }
        }
        ops = opsAM;
        for(int i = 0; i < ops.size(); i++) {
            if(ops.get(i) == '+') {
                nums.set(i, nums.get(i) + nums.get(i +1));
                nums.remove(i + 1);
            } else if(ops.get(i) == '-') {
                nums.set(i, nums.get(i) - nums.get(i +1));
                nums.remove(i + 1);
            }
        }
        return nums.get(0);
    }
}
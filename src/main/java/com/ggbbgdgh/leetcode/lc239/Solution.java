package com.ggbbgdgh.leetcode.lc239;

import java.util.Arrays;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //这里当作一个环的存储结构，最后个位置用kIndex表示
        int kIndex = 0;
        int kMaxIndex = 0;
        int[] kArray = new int[k];
        //初始化数据
        int i = 0;
        for( ; i < k; i++ ) {
            if(nums[kMaxIndex] <= nums[i]) {
                kMaxIndex = i;
            }
            kArray[i] = nums[i];
        }
        kIndex = k -1;

        int[] result = new int[nums.length -k + 1];
        result[0] = nums[kMaxIndex];
        for(;i < nums.length;i++ ) {
            //替换一个值
            kIndex = (kIndex + 1) % k;
            kArray[kIndex] = nums[i];
            if(kIndex == kMaxIndex) {
                //被替换，重新查一次最大值
                for(int j = 0; j < kArray.length; j++) {
                    if(kArray[j] >= kArray[kMaxIndex]) {
                        kMaxIndex = j;
                    }
                }
            } else {
                if(kArray[kIndex] >= kArray[kMaxIndex]) {
                    kMaxIndex = kIndex;
                }
            }
            result[i - k + 1] = kArray[kMaxIndex];
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.maxSlidingWindow(new int[] {1,3,-1,-3,5,3,6,7}, 3)));
    }
}
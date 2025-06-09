package com.ggbbgdgh.leetcode.lc205;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isIsomorphic("egg", "add"));
        System.out.println(solution.isIsomorphic("foo", "bar"));
    }

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        if(s == null && t == null) {
            return true;
        }
        if(s.isEmpty() && t.isEmpty()) {
            return true;
        }
        if(s.length() != t.length()) {
            return false;
        }
        for(int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if(map.get(sc) == null) {
                if(map.get(tc) == null) {
                    map.put(sc, tc);
                } else {
                    return false;
                }
            } else {
                if(map.get(tc) == null) {
                    return false;
                } else if(map.get(sc) != map.get(tc)) {
                    return false;
                }
            }
        }
        return true;
    }
}
package com.gj.models;

import java.util.*;
//clase Solution
//soluciones a problemas de leetcode
public class Solution {
    //problema 3: Longest Substring Without Repeating Characters
    public static int lengthOfLongestSubstring(String s) {
        if(s.isEmpty()){
            return 0;
        }

        var substrings = new ArrayList<String>();
        var longitudes = new ArrayList<Integer>();

        for(char letra: s.toCharArray()){
            var vistas = new LinkedHashSet<Character>();
            vistas.add(letra);
            for(int j = s.indexOf(letra) + 1; j < s.length(); j++){
                if(!vistas.add(s.charAt(j))){
                    break;
                }
            }
            StringBuilder sub = new StringBuilder();
            for(char vista : vistas){
                sub.append(vista);
            }
            substrings.add(sub.toString());
            s = s.substring(s.indexOf(letra) + 1);
        }

        for (String substring : substrings) {
            System.out.println(substring);
            longitudes.add(substring.length());
        }
        return Collections.max(longitudes);
    }

    //problema 4: Median of Two Sorted Arrays
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double median;
        var combined = new ArrayList<Integer>();
        for(int num : nums1) {
            combined.add(num);
        }
        for(int num : nums2) {
            combined.add(num);
        }
        Collections.sort(combined);
        if(combined.size() % 2 == 0){
            int mid1 = combined.size() / 2;
            int mid2 = mid1 - 1;
            median = (combined.get(mid1) + combined.get(mid2)) / 2.0;
            return median;
        } else {
            int mid = combined.size() / 2;
            median = combined.get(mid);
            return median;
        }
    }


}


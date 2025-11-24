package com.gj;


import com.gj.models.*;

import java.util.ArrayList;
import java.util.Arrays;

import static com.gj.models.Maximo.maximo;
import static com.gj.models.ProgresionGeometrica.progresion;


public class Main {
    public static void main(String[] args) {
        //pruebas de las funciones de practica y leetcode
        System.out.println(maximo(35,2,4));

        var secuencia = new ArrayList<>(Arrays.asList(5, 15, 45, 135, 405));
        System.out.println(progresion(secuencia));

        var arr = new int[]{2, 4, 8, 10, 20, 22};
        System.out.println(ProgresionGeometrica.alternar(arr));

        var str = "aab";
        System.out.println(Solution.lengthOfLongestSubstring(str));

        var nums1 = new int[]{1, 3};
        var nums2 = new int[]{2};
        System.out.println(Solution.findMedianSortedArrays(nums1, nums2));
    }
}

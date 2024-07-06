package main.java.com.efostach.arrays;

import java.util.*;

public class SherlockAndArray {
    public static void main(String[] args) {
        System.out.println(balancedSums(List.of(1)));
        System.out.println(balancedSums(List.of(1,0)));
        System.out.println(balancedSums(List.of(0,0,1)));
        System.out.println(balancedSums(List.of(1,0,0)));
        System.out.println(balancedSums(List.of(5,6,8,11)));
        System.out.println(balancedSums(List.of(0,3,0)));
        System.out.println(balancedSums(List.of(3,0,1,2)));
        System.out.println(balancedSums(List.of(0,8,8,8)));
        System.out.println(balancedSums(List.of(1,1,2,0,2,1,1)));
        System.out.println(balancedSums(List.of(0,8,8,8,8)));
    }

    static String balancedSums(List<Integer> arr) {
        int i = 0;
        int j = arr.size() - 1;
        var subR = 0;
        var subL = 0;

        /* The approach sums up array elements from both ends trying to keep them even.
           There are two pointers that go through an array simultaneously from both ends.
           So that this approach gives complexity O(n) with just a single pass through array.
        */
        while (j != i) {
            // Second condition covers corner case when some elements are zero.
            //  ____1______    __________________2____________________
            if (subR > subL || subR == subL && arr.get(i) < arr.get(j)) {
                subL += arr.get(i++);
            } else {
                subR += arr.get(j--);
            }
        }

        if (subR == subL) {
            return "YES";
        }

        return "NO";
    }
}

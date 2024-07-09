package main.java.com.efostach.arrays;

import java.util.ArrayList;
import java.util.List;

public class EvenFibonacciNumbers {
    public static void main(String[] args) {
        System.out.println(getSumOfEvenFibonacciNumbers(List.of(100L)));
        System.out.println(getSumOfEvenFibonacciNumbers(List.of(100L, 8L, 100L)));
        System.out.println(getSumOfEvenFibonacciNumbers(List.of(1L, 10L, 100L)));
        System.out.println(getSumOfEvenFibonacciNumbers(List.of(400_000_000_000_000L)));
    }
    /* The approach calculates only even Fibonacci numbers and their sum.
       This approach gives time complexity O(n).

       From time complexity optimization perspective cash of even numbers can be used as reading is quicker than write operation.
       In this case cash would increase space complexity.
    */
    public static List<Long> getSumOfEvenFibonacciNumbers(List<Long> arr) {
        List<Long> resultList = new ArrayList<>();

        for (Long element : arr) {
            // Initiation of first two even numbers to be able to calculate third one in a row
            Integer last = 2;
            Integer beforeLast = 0;
            Integer next = 0;
            Integer sum = 0;

            while (element > next) {
                beforeLast = last;
                last = next;
                sum += next;

                // Calculates only even Fibonacci numbers
                next = last * 4 + beforeLast;
            }
            resultList.add(Long.valueOf(sum));
        }

        return resultList;
    }
}

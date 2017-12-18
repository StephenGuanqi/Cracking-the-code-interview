package com.guanqiy;

import java.util.Map;

public class Main {

    public static void main(String[] args) {
        int[] nums = {1,1,-1,1};

        if (nums == null || nums.length == 0) {
            System.out.println(-1);;
        }

        // best case O(n)   1,1,1,1,1,1,.... find 0
        int start = 0,  end = nums.length - 1;
        int target = nums[end];
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > target) {
                start = mid + 1;
            } else if (nums[mid] < target) {
                end = mid;
            } else { // nums[mid] == target
                end--;
            }
        }

        System.out.println(nums[start]);

        int dividend = -2147483648;
        int divisor = -1;
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        System.out.println(a); // 2147483648
        System.out.println(b); // 1
        int c = Math.abs(dividend);
        int d = Math.abs(divisor);
        System.out.println(c);//-2147483648
        System.out.println(d);// 1

        System.out.println(-1 * -2147483648);
    }
}

package com.lt.calulate;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 力扣题库
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成
 */
public class DoublePointer {


    public static void main(String[] args) {
        Integer[] nums = new Integer[]{1, 1, 2, 3, 4};

        calculateWithBase(nums);

        calculateWithBaseAnother(nums);

        calculateWithJava(nums);
    }

    private static void calculateWithBaseAnother(Integer[] nums) {

        int count = 0;
        for (int right = 1; right < nums.length; right++) {

            if (nums[right] == nums[right - 1]) {
                count++;
            }

            nums[right - count] = nums[right];
        }

        for (int i = 0; i < nums.length - 1; i++) {
            System.out.println(nums[i]);
        }
    }

    private static void calculateWithJava(Integer[] nums) {

        //nums是对象数组才可以使用
        Arrays.asList(nums).stream().collect(Collectors.toSet()).forEach(num -> {
            System.out.println(num);
        });
    }

    private static int calculateWithBase(Integer[] nums) {

        int left = 0;
        for (int right = 1; right < nums.length; right++) {

            if (nums[left] != nums[right]) {
                nums[++left] = nums[right];
            }
        }
        for (int i = 0; i < left + 1; i++) {
            System.out.println(nums[i]);
        }
        return ++left;
    }


}

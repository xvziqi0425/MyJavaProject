package com.huawei.it.v1_sort;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
    }

    public static void QuickSortTest() throws Exception {
        // 正常情况
        testQuickSort_NormalCase();

        // 已经有序的数组
        testQuickSort_AlreadySorted();

        // 逆序数组
        testQuickSort_ReverseSorted();

        // 单个元素的数组
        testQuickSort_SingleElement();

        // 空数组
        testQuickSort_EmptyArray();

        // 所有元素相同的数组
        testQuickSort_AllEqualElements();

        // 包含负数的数组
        testQuickSort_NegativeNumbers();

        // 包含正数、负数和零的数组
        testQuickSort_MixedNumbers();
    }

    // 验证普通情况
    public static void testQuickSort_NormalCase() throws Exception {
        int[] arr = {3, 6, 8, 10, 1, 2, 1};
        int[] expected = {1, 1, 2, 3, 6, 8, 10};
        QuickSort.quickSort(arr, 0, arr.length - 1);
        verifySortResult("Normal Case", arr, expected);
    }

    // 验证已经有序的数组
    public static void testQuickSort_AlreadySorted() throws Exception {
        int[] arr = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        QuickSort.quickSort(arr, 0, arr.length - 1);
        verifySortResult("Already Sorted", arr, expected);
    }

    // 验证逆序数组
    public static void testQuickSort_ReverseSorted() throws Exception {
        int[] arr = {5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5};
        QuickSort.quickSort(arr, 0, arr.length - 1);
        verifySortResult("Reverse Sorted", arr, expected);
    }

    // 验证单个元素的数组
    public static void testQuickSort_SingleElement() throws Exception {
        int[] arr = {42};
        int[] expected = {42};
        QuickSort.quickSort(arr, 0, 0);
        verifySortResult("Single Element", arr, expected);
    }

    // 验证空数组
    public static void testQuickSort_EmptyArray() throws Exception {
        int[] arr = {};
        int[] expected = {};
        QuickSort.quickSort(arr, 0, arr.length - 1);
        verifySortResult("Empty Array", arr, expected);
    }

    // 验证所有元素相同的数组
    public static void testQuickSort_AllEqualElements() throws Exception {
        int[] arr = {7, 7, 7, 7, 7};
        int[] expected = {7, 7, 7, 7, 7};
        QuickSort.quickSort(arr, 0, arr.length - 1);
        verifySortResult("All Equal Elements", arr, expected);
    }

    // 验证包含负数的数组
    public static void testQuickSort_NegativeNumbers() throws Exception {
        int[] arr = {-3, -1, -2, -5, -4};
        int[] expected = {-5, -4, -3, -2, -1};
        QuickSort.quickSort(arr, 0, arr.length - 1);
        verifySortResult("Negative Numbers", arr, expected);
    }

    // 验证包含正数、负数和零的数组
    public static void testQuickSort_MixedNumbers() throws Exception {
        int[] arr = {0, -1, 2, -3, 4};
        int[] expected = {-3, -1, 0, 2, 4};
        QuickSort.quickSort(arr, 0, arr.length - 1);
        verifySortResult("Mixed Numbers", arr, expected);
    }

    // 验证排序结果是否正确
    private static void verifySortResult(String testCase, int[] actual, int[] expected) throws Exception {
        if (Arrays.equals(actual, expected)) {
            System.out.println(testCase + ": Passed");
        } else {
            throw new Exception("error");
//            System.out.println(testCase + ": Failed");
//            System.out.println("Expected: " + Arrays.toString(expected));
//            System.out.println("Actual: " + Arrays.toString(actual));
        }
    }
}



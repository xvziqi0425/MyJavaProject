package com.huawei.it.v1_sort;

import java.util.Arrays;


public class Sorter {
    public static void main(String[] args) throws Exception {
        QuickSortTest();
    }


    /**
     * 定基准、双指针（找大小+交换）、基准元素归位、递归左右
     */
    public static void quickSort(int[] a, int left, int right) {
        // 递归终止
        if (left >= right) {
            return;
        }
        // 定基准
        int pivot = a[left];

        // 双指针
        // 从右向左移动j，找到第一个小于基准元素的值
        // 从左向右移动i，找到第一个大于基准元素的值
        // 交换找到的两个元素，使得小于基准的元素在左边，大于基准的元素在右边
        int i = left;
        int j = right;
        while (i < j) {
            for (; i < j && a[j] >= pivot; j--) ;
            for (; i < j && a[i] <= pivot; i++) ;
            swap(a, i, j);
        }

        // 将基准元素放到正确的位置（即i和j相遇的位置）
        swap(a, left, i);
        quickSort(a, left, i - 1);
        quickSort(a, i + 1, right);
    }

    private static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
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
        Sorter.quickSort(arr, 0, arr.length - 1);
        verifySortResult("Normal Case", arr, expected);
    }

    // 验证已经有序的数组
    public static void testQuickSort_AlreadySorted() throws Exception {
        int[] arr = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        Sorter.quickSort(arr, 0, arr.length - 1);
        verifySortResult("Already Sorted", arr, expected);
    }

    // 验证逆序数组
    public static void testQuickSort_ReverseSorted() throws Exception {
        int[] arr = {5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5};
        Sorter.quickSort(arr, 0, arr.length - 1);
        verifySortResult("Reverse Sorted", arr, expected);
    }

    // 验证单个元素的数组
    public static void testQuickSort_SingleElement() throws Exception {
        int[] arr = {42};
        int[] expected = {42};
        Sorter.quickSort(arr, 0, 0);
        verifySortResult("Single Element", arr, expected);
    }

    // 验证空数组
    public static void testQuickSort_EmptyArray() throws Exception {
        int[] arr = {};
        int[] expected = {};
        Sorter.quickSort(arr, 0, arr.length - 1);
        verifySortResult("Empty Array", arr, expected);
    }

    // 验证所有元素相同的数组
    public static void testQuickSort_AllEqualElements() throws Exception {
        int[] arr = {7, 7, 7, 7, 7};
        int[] expected = {7, 7, 7, 7, 7};
        Sorter.quickSort(arr, 0, arr.length - 1);
        verifySortResult("All Equal Elements", arr, expected);
    }

    // 验证包含负数的数组
    public static void testQuickSort_NegativeNumbers() throws Exception {
        int[] arr = {-3, -1, -2, -5, -4};
        int[] expected = {-5, -4, -3, -2, -1};
        Sorter.quickSort(arr, 0, arr.length - 1);
        verifySortResult("Negative Numbers", arr, expected);
    }

    // 验证包含正数、负数和零的数组
    public static void testQuickSort_MixedNumbers() throws Exception {
        int[] arr = {0, -1, 2, -3, 4};
        int[] expected = {-3, -1, 0, 2, 4};
        Sorter.quickSort(arr, 0, arr.length - 1);
        verifySortResult("Mixed Numbers", arr, expected);
    }

    // 验证排序结果是否正确
    private static void verifySortResult(String testCase, int[] actual, int[] expected) throws Exception {
        if (Arrays.equals(actual, expected)) {
            System.out.println(testCase + ": Passed");
        } else {
            throw new Exception("error");
        }
    }
}

package com.huawei.it.v1_sort;

import static com.huawei.it.v1_sort.Test.QuickSortTest;

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
}

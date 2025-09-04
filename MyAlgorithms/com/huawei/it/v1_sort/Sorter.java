package com.huawei.it.v1_sort;

import static com.huawei.it.v1_sort.Test.QuickSortTest;

public class Sorter {
    public static void main(String[] args) throws Exception {
        QuickSortTest();
    }


    public static void quickSort(int[] a, int left, int right) {
        // 递归终止条件：如果左边界大于或等于右边界，说明子数组已经有序或为空，直接返回
        if (left >= right) {
            return;
        }
        // 选择基准元素（这里选择最左边的元素作为基准）
        int pivot = a[left];
        // 初始化两个指针，i指向左边界，j指向右边界
        int i = left;
        int j = right;
        // 使用双指针法进行分区操作
        while (i < j) {
            // 从右向左移动j，找到第一个小于基准元素的值
            for (; i < j && a[j] >= pivot; j--) ;
            // 从左向右移动i，找到第一个大于基准元素的值
            for (; i < j && a[i] <= pivot; i++) ;
            // 交换找到的两个元素，使得小于基准的元素在左边，大于基准的元素在右边
            swap(a, i, j);
        }
        // 将基准元素放到正确的位置（即i和j相遇的位置）
        swap(a, left, i);
        // 递归地对基准元素左边的子数组进行排序
        quickSort(a, left, i - 1);
        // 递归地对基准元素右边的子数组进行排序
        quickSort(a, i + 1, right);
    }

    private static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}

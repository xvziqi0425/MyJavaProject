package com.huawei.it.v1_sort;

import static com.huawei.it.v1_sort.Test.QuickSortTest;

public class QuickSort {
    public static void main(String[] args) throws Exception {
        QuickSortTest();
    }


    public static void quickSort(int[] a, int left, int right) {
        if (left >= right) { // 递归终止
            return;
        }
        int pivot = a[left]; // 选择基准元素（这里选择最左边的元素）
        int i = left;
        int j = right;
        while (i < j) {
            for (; i < j && a[j] >= pivot; j--) ;
            for (; i < j && a[i] <= pivot; i++) ;
            swap(a, i, j);
        }
        swap(a, left, i); // 漏了, 交换锚点元素和碰撞元素
        quickSort(a, left, i - 1);
        quickSort(a, i + 1, right);
    }

    private static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}

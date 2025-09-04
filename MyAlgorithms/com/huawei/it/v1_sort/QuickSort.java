package com.huawei.it.v1_sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5}; // Java声明数组
        quickSort(arr, 0, 2);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] a, int left, int right) {
        if (left >= right) {
            return;
        }
        int i = left;
        int j = right;
        while (i < j) {
            for (; i < j && a[j] >= a[left]; j--) ;
            for (; i < j && a[i] <= a[right]; i++) ;
            if (i >= j) {
                continue;
            }
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

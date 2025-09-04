package com.huawei.it.v1_sort;

public class Sort {
    public static void main(String[] args) {
        int[] arr = {1, 3}; // Java声明数组
        quickSort(arr, 0, 2);
        System.out.println(arr);
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int i = left;
        int j = right;
        for (; i < j; ) {
            for (; i <= j && arr[j] < arr[left]; j--) ;
            for (; i <= j && arr[i] > arr[right]; i++) ;
            if (i >= j) {
                continue;
            }
            swap(arr, i, j);
        }
        quickSort(arr, left, i - 1);
        quickSort(arr, i + 1, right);
    }

    public static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}

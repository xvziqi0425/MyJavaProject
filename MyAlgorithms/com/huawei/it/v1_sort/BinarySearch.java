package com.huawei.it.v1_sort;

public class BinarySearch {
    public static void main(String[] args) throws Exception {
        testBinarySearch();
    }

    /**
     * 二分法：双指针
     */
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) { // 两个都一样也要移动。确认唯一元素是目标值。
            int mid = left + ((right - left) >> 1);
            // 如果目标值偏小，则移动左指针
            // 如果目标值偏大，则移动右指针
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    // 验证用例
    public static void testBinarySearch() throws Exception {
        // 测试普通情况
        testSearch_NormalCase();
        // 测试目标元素在数组开头
        testSearch_TargetAtStart();
        // 测试目标元素在数组末尾
        testSearch_TargetAtEnd();
        // 测试目标元素不存在
        testSearch_TargetNotFound();
        // 测试空数组
        testSearch_EmptyArray();
        // 测试单个元素且存在
        testSearch_SingleElementFound();
        // 测试单个元素且不存在
        testSearch_SingleElementNotFound();
        // 测试空数组（null）
        testSearch_NullArray();
        // 测试重复元素
        testSearch_DuplicateElements();
        // 测试大数组
        testSearch_LargeArray();
    }

    // 验证普通情况
    private static void testSearch_NormalCase() throws Exception {
        int[] nums = {1, 3, 5, 7, 9};
        int result = search(nums, 5);
        verify(result, 2, "Normal Case");
    }

    // 验证目标元素在数组开头
    private static void testSearch_TargetAtStart() throws Exception {
        int[] nums = {1, 3, 5, 7, 9};
        int result = search(nums, 1);
        verify(result, 0, "Target at Start");
    }

    // 验证目标元素在数组末尾
    private static void testSearch_TargetAtEnd() throws Exception {
        int[] nums = {1, 3, 5, 7, 9};
        int result = search(nums, 9);
        verify(result, 4, "Target at End");
    }

    // 验证目标元素不存在
    private static void testSearch_TargetNotFound() throws Exception {
        int[] nums = {1, 3, 5, 7, 9};
        int result = search(nums, 4);
        verify(result, -1, "Target Not Found");
    }

    // 验证空数组
    private static void testSearch_EmptyArray() throws Exception {
        int[] nums = {};
        int result = search(nums, 5);
        verify(result, -1, "Empty Array");
    }

    // 验证单个元素且存在
    private static void testSearch_SingleElementFound() throws Exception {
        int[] nums = {5};
        int result = search(nums, 5);
        verify(result, 0, "Single Element Found");
    }

    // 验证单个元素且不存在
    private static void testSearch_SingleElementNotFound() throws Exception {
        int[] nums = {5};
        int result = search(nums, 3);
        verify(result, -1, "Single Element Not Found");
    }

    // 验证空数组（null）
    private static void testSearch_NullArray() throws Exception {
        int[] nums = null;
        int result = search(nums, 5);
        verify(result, -1, "Null Array");
    }

    // 验证重复元素
    private static void testSearch_DuplicateElements() throws Exception {
        int[] nums = {1, 3, 5, 5, 7, 9};
        int result = search(nums, 5);
        verify(result == 2 || result == 3, true, "Duplicate Elements");
    }

    // 验证大数组
    private static void testSearch_LargeArray() throws Exception {
        int[] nums = new int[1000000];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i;
        }
        int result = search(nums, 999999);
        verify(result, 999999, "Large Array");
    }

    // 验证结果是否正确
    private static void verify(int actual, int expected, String testCase) throws Exception {
        if (actual == expected) {
            System.out.println(testCase + ": Passed");
        } else {
            throw new Exception("error");
        }
    }

    // 验证布尔结果是否正确
    private static void verify(boolean actual, boolean expected, String testCase) throws Exception {
        if (actual == expected) {
            System.out.println(testCase + ": Passed");
        } else {
            throw new Exception("error");
        }
    }
}

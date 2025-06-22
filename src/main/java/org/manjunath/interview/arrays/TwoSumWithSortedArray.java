package org.manjunath.interview.arrays;

public class TwoSumWithSortedArray {

    /**
     * Method to get two indices of the integers resulting in the target value as sum.
     * This method finds the indices using the Binary search.
     *
     * @param arr    Array of sorted integers
     * @param target the target value.
     * @return array with the indices of integers which result in target sum.
     */
    public int[] twoSumWithBinarySearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            // calculate the reminder required from target using current array value.
            int reminder = target - arr[i];

            // Get the reminder index for the reminder value.
            int index = getReminderIndex(arr, reminder);
            if (index == -1 || index == i) {
                continue;
            } else {
                return new int[]{i + 1, index + 1};
            }
        }
        return new int[]{};
    }

    /**
     * Method used to find the index of key value from the array using the binary search.
     *
     * @param arr Sorted array of integers.
     * @param key target key value which need to be searched in array.
     * @return index of target key from array.
     */
    private int getReminderIndex(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (key == arr[mid]) {
                return mid;
            } else if (key > arr[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }


    /**
     * Method to get two indices of the integers resulting in the target value as sum.
     * The method uses 2 pointers which will traverse the array from left and right
     * to find the proper indices. If the arr[left] and arr[right] is greater than the target,
     * then decrement the right index, else if arr[left] and arr[right] is lesser than the target,
     * then increment the left index, otherwise return the array with indices.
     *
     * @param arr    Array of sorted integers
     * @param target The target sum value.
     * @return array with the indices of integers which result in target sum.
     */
    public int[] twoSumWithPointers(int[] arr, int target) {
        // Initialize the left and right indices
        int left = 0;
        int right = arr.length - 1;

        // As long as the left pointer is not greater than right pointer
        while (left < right) {
            // Calculate the sum for left and right pointer values.
            int sum = arr[left] + arr[right];

            // If sum is lesser than the target value, then increment the left pointer.
            if (sum < target) {
                left++;
            } else if (sum > target) {
                // If sum is greater than the target value, then decrement the right pointer.
                right--;
            } else {
                // if sum is equal to target value, then return the array with indices
                return new int[]{left + 1, right + 1};
            }
        }
        return new int[]{};
    }
}

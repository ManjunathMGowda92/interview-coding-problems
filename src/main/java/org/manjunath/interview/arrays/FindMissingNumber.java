package org.manjunath.interview.arrays;

public class FindMissingNumber {

    /**
     * Method to find the missing number in an array ranging from 1 to n,
     * where one number will be missed. Method uses the XOR operation to find the missing
     * number.
     *
     * @param arr Input integer array from 1 to n (with one element missing).
     * @return Missing integer of the array.
     */
    public int missingNumWithXor(int[] arr) {
        int xor1 = 0, xor2 = 0;
        int n = arr.length + 1;

        for (int j : arr) {
            xor1 ^= j;
        }

        for (int i = 1; i <= n; i++) {
            xor2 ^= i;
        }

        return xor1 ^ xor2;
    }

    /**
     * Method to find the missing number from array, where missing number will be provided as 0
     * in the array. The method uses mathematical expression for finding sum of n integers and
     * subtracts it by the actual numbers given in the array.
     *
     * @param arr Input integer array
     * @return missing element from array
     */
    public int findMissingNumber(int[] arr) {
        int n = arr.length;
        int expectedSum = n * (n + 1) / 2;

        int actualSum = 0;
        for (int i : arr) {
            actualSum += i;
        }

        return expectedSum - actualSum;
    }
}

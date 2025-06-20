package org.manjunath.interview.arrays;

public class ProductOfArrayElementsExceptSelf {


    public int[] findProduct(int[] nums) {
        // Create 2 arbitrary arrays of same length
        int[] prefixArr = new int[nums.length];
        int[] postfixArr = new int[nums.length];

        // Add the left product into the prefixArray
        // [1, 2, 3, 4] => then left product will come as [1, 1, 2, 6] (First index element is kept as 1)
        int product = 1;
        for (int i = 0; i < nums.length; i++) {
            prefixArr[i] = product;
            product = product * nums[i];
        }

        // Add the right product into the postfixArray
        // [1, 2, 3, 4] => then left product will come as [24, 12, 4, 1] (Last index element is kept as 1)
        product = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            postfixArr[i] = product;
            product *= nums[i];
        }

        // Now calculate final product with respective indices product
        int[] finalResult = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            finalResult[i] = prefixArr[i] * postfixArr[i];
        }

        return finalResult;
    }

    public int[] productExceptSelf(int[] nums) {
        // Create an array to store the product
        int[] result = new int[nums.length];

        // Create 2 variable to store the prefix product and postfix product.
        int prefix = 1, postfix = 1;

        // Iterate from left to right on Array and store the product of previous
        // in current index (First index should be populated with 1)
        for (int i = 0; i < nums.length; i++) {
            result[i] = prefix;
            prefix *= nums[i];
        }

        // Iterate from right to left on Array and store the product of right elements and
        // current existing value (last index element should be multiplied with 1)
        for (int i = nums.length -1; i>= 0; i--) {
            result[i] = result[i] * postfix;
            postfix *= nums[i];
        }

        return result;
    }
}

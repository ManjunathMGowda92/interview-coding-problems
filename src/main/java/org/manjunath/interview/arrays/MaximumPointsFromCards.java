package org.manjunath.interview.arrays;

/**
 * Class to find the maximum points that can be obtained from the given array of cards.
 * Each index will provide the value of each card, and we need to find the maximum value
 * can be obtained by using k number of cards at a time.
 * <br>
 * Condition: The cards can be selected from left or right or (some from left and right). Cards
 * cannot be picked from the middle (even they are consecutive)
 * <br>
 * <p>Ex: Consider arr = [6, 2, 3, 4, 7, 2, 1, 7, 1] and k = 4 (we can choose 4 cards at a time)
 * We can pick the first 4 cards (6, 2, 3, 4) or last 4 cards (2, 1, 7, 1) or some cards from left
 * and right combinations like (6, 2, 3, 1) / (6, 2, 7, 1) / (6, 1, 7, 1). Out of all these combinations
 * we need to find the group which can produce maximum points.
 * </p>
 */
public class MaximumPointsFromCards {

    public int maxPointsFromCards(int[] cards, int k) {
        // initialize leftSum, rightSum and maxSum variables.
        // leftSum will store the sum of left k elements from array, and rightSum
        // stores the last k elements sum, and maxSum stores maximum sum obtained.
        int leftSum = 0, rightSum = 0, maxSum;

        // iterate the cards array and get the sum of first k cards.
        for (int i = 0; i < k; i++) {
            leftSum += cards[i];
        }

        // Assign the left to maxSum (as still we are not calculated the rightSum)
        maxSum = leftSum;

        int rightIndex = cards.length - 1;
        // Iterate the array from k-1 position to 0-th position to remove one element
        // from the leftSum and add one element from right array to rightSum to calculate the maxSum.
        for (int i = k - 1; i >= 0; i--) {
            leftSum -= cards[i];
            rightSum += cards[rightIndex];
            rightIndex--;

            maxSum = Math.max(maxSum, (leftSum + rightSum));
        }
        return maxSum;
    }
}

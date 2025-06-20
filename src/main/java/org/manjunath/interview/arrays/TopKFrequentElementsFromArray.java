package org.manjunath.interview.arrays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

public class TopKFrequentElementsFromArray {

    public int[] findTopKFrequent(int[] nums, int k) {
        // if the k (i.e. count of most frequent elements) equal to array length, then simply return array
        if (k == nums.length) {
            return nums;
        }

        // Create a map to hold the count of elements.
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Sort the map based on count of elements.
        LinkedHashMap<Integer, Integer> sortedMap = map.entrySet()
                .stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newvalue) -> oldValue,
                        LinkedHashMap::new
                ));

        // Create an array with length k
        int[] frequentValues = new int[k];

        // fetch all the keys into the List
        List<Integer> keys = new ArrayList<>(sortedMap.keySet());

        // Add only first k elements from list to array
        for (int i = 0; i < k; i++) {
            frequentValues[i] = keys.get(i);
        }

        // return the array
        return frequentValues;
    }


    public int[] findTopKFrequentWithHeap(int[] nums, int k) {
        // if the k (i.e. count of most frequent elements) equal to array length, then simply return array
        if (k == nums.length) {
            return nums;
        }

        // Create a map to hold the count of elements.
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // Create a Priority queue to work as Heap, by passing the comparator object for data insertion.
        // Comparator :- (a, b) -> countMap.get(a) - countMap.get(b)
        Queue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(countMap::get));

        // insert each key from Map to heap. If the heap size is exceeding the k value, then
        // remove the top element from queue (i.e. which is inserted first)
        for (int num : countMap.keySet()) {
            heap.add(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        // Copy the heap elements into an array
        int[] frequentValue = new int[k];
        for (int i = 0; i < k; i++) {
            frequentValue[i] = heap.poll();
        }

        return frequentValue;
    }
}

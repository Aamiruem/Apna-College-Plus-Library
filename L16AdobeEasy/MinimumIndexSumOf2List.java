

import java.util.*;

public class MinimumIndexSumOf2List {
    public List<String> findRestaurant(String[] list1, String[] list2) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        int minSum = Integer.MAX_VALUE;

        // Store the index of each restaurant in list1 in a hashmap
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        // Check each restaurant in list2
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) { // If the restaurant is also in list1
                int sum = map.get(list2[i]) + i; // Calculate the index sum
                if (sum < minSum) {
                    minSum = sum;
                    res.clear();
                    res.add(list2[i]);
                } else if (sum == minSum) {
                    res.add(list2[i]);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] list1 = {"Shanghai", "Tokyo", "Paris", "Rome"};
        String[] list2 = {"London", "Tokyo", "Sydney", "Rome"};

        MinimumIndexSumOf2List solution = new MinimumIndexSumOf2List(); // Fix applied
        List<String> result = solution.findRestaurant(list1, list2);

        // Print the result
        System.out.println("Common restaurants with the smallest index sum: " + result);
    }
}

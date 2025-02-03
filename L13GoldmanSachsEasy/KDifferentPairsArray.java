// import java.util.*;
// public class KDifferentPairsArray {
//     public static void main(String[] args) {
//         try (Scanner sc = new Scanner(System.in)) {
//             int n = sc.nextInt();
//             int k = sc.nextInt();
//             int[] arr = new int[n];
            
//             for (int i = 0; i < n; i++) {
//                 arr[i] = sc.nextInt();
//             }
            
//             Map<Integer, Integer> m = new HashMap<>();
//             for (int x : arr) {
//                 m.put(x, m.getOrDefault(x, 0) + 1);
//             }
            
//             int ans = 0;
//             for (Integer x : m.keySet()) {
//                 if ((k == 0 && m.get(x) > 1) || (k != 0 && m.containsKey(x + k))) {
//                     ans++;
//                 }
//             }
            
//             System.out.print(ans);
//         }
//     }
// }













import java.util.*;

public class KDifferentPairsArray {

    public static void main(String[] args) {
        // Define array and k manually
        int[] arr = {1, 5, 3, 4, 2};  // Example array
        int k = 2;  // Example difference

        // Store occurrences of elements in a HashMap
        Map<Integer, Integer> m = new HashMap<>();
        for (int x : arr) {
            m.put(x, m.getOrDefault(x, 0) + 1);
        }

        int ans = 0;
        for (Integer x : m.keySet()) {
            if ((k == 0 && m.get(x) > 1) || (k != 0 && m.containsKey(x + k))) {
                ans++;
            }
        }

        System.out.print(ans);
    }
}

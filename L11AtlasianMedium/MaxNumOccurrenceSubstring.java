
// import java.util.*;

// public class MaxNumOccurrenceSubstring {

//     public static void main(String[] args) {
//         String s = "aababcaab";
//         int maxuniq = 2;
//         int minsize = 3;
//         @SuppressWarnings("unused")
//         int maxsize = 4;
//         int n = s.length();

//         Map<Character, Integer> freq = new HashMap<>();
//         Map<String, Integer> substrCount = new HashMap<>();

//         for (int i = 0; i < minsize; i++) {
//             freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0) + 1);
//         }

//         String temp = s.substring(0, minsize);
//         if (freq.size() <= maxuniq) {
//             substrCount.put(temp, substrCount.getOrDefault(temp, 0) + 1);
//         }

//         int ans = 1;
//         for (int i = minsize; i < n; i++) {
//             char c = s.charAt(i);
//             char remove = s.charAt(i - minsize);

//             if (freq.get(remove) == 1) {
//                 freq.remove(remove);
//             } else {
//                 freq.put(remove, freq.get(remove) - 1);
//             }

//             freq.put(c, freq.getOrDefault(c, 0) + 1);

//             if (freq.size() <= maxuniq) {
//                 temp = s.substring(i - minsize + 1, i + 1);
//                 substrCount.put(temp, substrCount.getOrDefault(temp, 0) + 1);
//                 ans = Math.max(ans, substrCount.get(temp));
//             }
//         }

//         System.out.println(ans);
//     }
// }

import java.util.HashMap;
import java.util.Map;

public class MaxNumOccurrenceSubstring {
    public static void main(String[] args) {
        String s = "aababcaab";
        int maxuniq = 2;
        int minsize = 3;
        @SuppressWarnings("unused")
        int maxsize = 4;
        int n = s.length();
        
        Map<Character, Integer> freq = new HashMap<>();
        Map<String, Integer> substrCount = new HashMap<>();
        
        for (int i = 0; i < minsize; i++) {
            freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0) + 1);
        }
        
        String temp = s.substring(0, minsize);
        if (freq.size() <= maxuniq) {
            substrCount.put(temp, substrCount.getOrDefault(temp, 0) + 1);
        }
        
        int ans = 1;
        for (int i = minsize; i < n; i++) {
            char c = s.charAt(i);
            char remove = s.charAt(i - minsize);
            
            if (freq.get(remove) == 1) {
                freq.remove(remove);
            } else {
                freq.put(remove, freq.get(remove) - 1);
            }
            
            freq.put(c, freq.getOrDefault(c, 0) + 1);
            
            if (freq.size() <= maxuniq) {
                temp = s.substring(i - minsize + 1, i + 1);
                substrCount.put(temp, substrCount.getOrDefault(temp, 0) + 1);
                ans = Math.max(ans, substrCount.get(temp));
            }
        }
        
        System.out.println(ans);
    }
}

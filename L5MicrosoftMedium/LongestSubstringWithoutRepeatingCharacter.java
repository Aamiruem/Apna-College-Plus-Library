
import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacter {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        int n = s.length();
        int i = 0, j = 0;
        int ans = 0;

        while (i < n) {
            char currentChar = s.charAt(i);
            freq.put(currentChar, freq.getOrDefault(currentChar, 0) + 1);

            while (freq.get(currentChar) > 1) {
                char startChar = s.charAt(j);
                freq.put(startChar, freq.get(startChar) - 1);
                j++;
            }

            ans = Math.max(ans, i - j + 1);
            i++;
        }

        return ans;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacter obj = new LongestSubstringWithoutRepeatingCharacter();
        System.out.println(obj.lengthOfLongestSubstring("abcabcbb")); // Output: 3
        System.out.println(obj.lengthOfLongestSubstring("bbbbb")); // Output: 1
        System.out.println(obj.lengthOfLongestSubstring("pwwkew")); // Output: 3
        System.out.println(obj.lengthOfLongestSubstring("")); // Output: 0
        System.out.println(obj.lengthOfLongestSubstring("abcdef")); // Output: 6
    }
}

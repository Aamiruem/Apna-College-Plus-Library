
import java.util.PriorityQueue;

public class RecognizeString {

    public String reorganizeString(String s) {
        int[] charCounts = new int[26];

        // Count the frequency of each character
        for (char c : s.toCharArray()) {
            charCounts[c - 'a']++;
        }

        // Max heap to store characters and their frequencies
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));

        // Add all characters with non-zero frequencies to the priority queue
        for (int i = 0; i < 26; i++) {
            if (charCounts[i] > 0) {
                pq.offer(new int[]{i + 'a', charCounts[i]});
            }
        }

        StringBuilder str = new StringBuilder();

        // Initialize with the most frequent character
        int[] block = pq.poll();
        str.append((char) block[0]);
        block[1]--;

        while (!pq.isEmpty()) {
            int[] next = pq.poll();
            str.append((char) next[0]);
            next[1]--;

            // Re-add the previous block if it still has remaining frequency
            if (block[1] > 0) {
                pq.offer(block);
            }

            // Update the block to the current character
            block = next;
        }

        // If the last character still has remaining frequency, it's invalid
        if (block[1] > 0) {
            return "";
        }

        return str.toString();
    }

    public static void main(String[] args) {
        RecognizeString s = new RecognizeString();
        System.out.println(s.reorganizeString("aab")); // Output: "aba"
        System.out.println(s.reorganizeString("aaab")); // Output: ""
    }
}

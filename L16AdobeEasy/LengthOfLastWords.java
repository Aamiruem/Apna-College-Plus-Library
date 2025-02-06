public class LengthOfLastWords {
    public int lengthOfLastWord(String s) {
        s = s.trim(); // Remove trailing spaces
        int lastSpace = s.lastIndexOf(' '); // Find the last space
        return s.length() - lastSpace - 1; // Compute the last word's length
    }

    // Time Complexity: O(n)
    // Auxiliary Space Complexity: O(1)
    // same code as above
    public int lengthOfLastWords(String s) {
        int count = 0;
        // Start from the end of the string
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                count++;
            } else {
                if (count > 0) {
                    return count; // Return if a word has started
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        LengthOfLastWords solution = new LengthOfLastWords();

        // Example test cases
        System.out.println( "Length of last word: " + solution.lengthOfLastWords("Hello World")); // Output: 5
        System.out.println( "Length of last word: " + solution.lengthOfLastWords("  fly me   to   the moon  ")); // Output: 4
        System.out.println(solution.lengthOfLastWords("luffy is still joyboy")); // Output: 6
        System.out.println( "Length of last word: joyboy" + solution.lengthOfLastWords("a")); // Output: 1
    }
}

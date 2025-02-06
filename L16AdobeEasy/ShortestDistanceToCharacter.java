
public class ShortestDistanceToCharacter {

    public static int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] result = new int[n];
        int prev = Integer.MIN_VALUE / 2;

        // Left to right pass
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == c) {
                prev = i;
            }
            result[i] = i - prev;
        }

        // Right to left pass
        prev = Integer.MAX_VALUE / 2;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                prev = i;
            }
            result[i] = Math.min(result[i], prev - i);
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "loveleetcode";
        char c = 'e';
        int[] distances = shortestToChar(s, c);
        for (int dist : distances) {
            System.out.print(dist + " ");
        }
    }
}

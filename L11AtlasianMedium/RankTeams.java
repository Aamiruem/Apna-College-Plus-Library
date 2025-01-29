
import java.util.*;

public class RankTeams {

    static Map<Character, int[]> track = new HashMap<>();

    // Custom comparator to sort teams based on votes
    public static int compareTeams(char a, char b) {
        int n = track.get(a).length;
        for (int j = 0; j < n; j++) {
            if (track.get(a)[j] > track.get(b)[j]) {
                return -1; // Higher rank wins

                        }if (track.get(a)[j] < track.get(b)[j]) {
                return 1;  // Lower rank loses

                    }}
        return Character.compare(a, b); // Lexicographical order if ranks are equal
    }

    public static String rankTeams(String[] votes) {
        int n = votes[0].length();

        // Initialize tracking map
        for (char c : votes[0].toCharArray()) {
            track.put(c, new int[n]);
        }

        // Count votes for each position
        for (String vote : votes) {
            for (int j = 0; j < n; j++) {
                track.get(vote.charAt(j))[j]++;
            }
        }

        // Create a list of teams and sort them using the comparator
        List<Character> teams = new ArrayList<>(track.keySet());
        teams.sort(RankTeams::compareTeams);

        // Convert list to string
        StringBuilder result = new StringBuilder();
        for (char c : teams) {
            result.append(c);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String[] votes = {"ABC", "ACB", "ABC", "ACB", "ACB"};
        System.out.println(rankTeams(votes)); // Expected Output: "ACB"
    }
}

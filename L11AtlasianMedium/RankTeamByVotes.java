
import java.util.*;

public class RankTeamByVotes {

    public static void main(String[] args) {
        String[] votes = new String[5];
        votes[0] = "ABC";
        votes[1] = "ACB";
        votes[2] = "ABC";
        votes[3] = "ACB";
        votes[4] = "ACB";

        Map<Character, int[]> track = new HashMap<>();
        int length = votes[0].length();

        // Initialize the ranking map
        for (String vote : votes) {
            for (int j = 0; j < length; j++) {
                char ch = vote.charAt(j);
                track.putIfAbsent(ch, new int[length]);
                track.get(ch)[j]++;
            }
        }

        // Create a list of characters (teams)
        List<Character> list = new ArrayList<>(track.keySet());

        // Sort the teams based on ranking
        Collections.sort(list, (a, b) -> {
            for (int j = 0; j < length; j++) {
                if (track.get(a)[j] != track.get(b)[j]) {
                    return track.get(b)[j] - track.get(a)[j]; // Higher votes come first
                }
            }
            return a - b; // If votes are the same, sort lexicographically
        });

        // Build the result string
        StringBuilder sb = new StringBuilder();
        for (char ch : list) {
            sb.append(ch);
        }

        // Print the result
        System.out.println(sb.toString());
    }
}

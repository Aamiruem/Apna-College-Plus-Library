
// import java.util.*;

// public class OnlineElections {

//      List<int[]> leaderTimes; // Stores (leader, time)

//     public OnlineElections(int[] persons, int[] times) {
//         leaderTimes = new ArrayList<>();
//         Map<Integer, Integer> voteCount = new HashMap<>();
//         int leader = -1;
//         int maxVotes = 0;

//         for (int i = 0; i < persons.length; i++) {
//             voteCount.put(persons[i], voteCount.getOrDefault(persons[i], 0) + 1);
//             int votes = voteCount.get(persons[i]);

//             if (votes >= maxVotes) {
//                 if (leader != persons[i]) { // If new leader is different, store it
//                     leader = persons[i];
//                     leaderTimes.add(new int[]{leader, times[i]});
//                 }
//                 maxVotes = votes;
//             }
//         }
//     }

//     public int query(int t) {
//         int left = 0, right = leaderTimes.size() - 1;
//         int ans = -1;

//         while (left <= right) {
//             int mid = (left + right) / 2;
//             if (leaderTimes.get(mid)[1] <= t) {
//                 ans = leaderTimes.get(mid)[0]; // Update answer
//                 left = mid + 1; // Search right
//             } else {
//                 right = mid - 1; // Search left
//             }
//         }
//         return ans;
//     }

//     public static void main(String[] args) {
//         int[] persons = new int[7];
//         int[] times = new int[7];

//         persons[0] = 0;
//         persons[1] = 1;
//         persons[2] = 1;
//         persons[3] = 0;
//         persons[4] = 0;
//         persons[5] = 1;
//         persons[6] = 0;

//         times[0] = 0;
//         times[1] = 5;
//         times[2] = 10;
//         times[3] = 15;
//         times[4] = 20;
//         times[5] = 25;
//         times[6] = 30;

//         OnlineElections obj = new OnlineElections(persons, times);

//         // Example Queries
//         System.out.println(obj.query(3));  // Output: 0
//         System.out.println(obj.query(12)); // Output: 1
//         System.out.println(obj.query(25)); // Output: 1
//         System.out.println(obj.query(30)); // Output: 0
//     }
// }

















import java.util.*;

public class OnlineElections {

    // Inner class to store leader and time
    class Vote {

        int person, time;

        Vote(int p, int t) {
            this.person = p;
            this.time = t;
        }
    }

    List<Vote> v; // Stores leader changes over time

    public OnlineElections(int[] persons, int[] times) {
        v = new ArrayList<>();
        Map<Integer, Integer> count = new HashMap<>();
        int leader = -1;
        int votes = 0;

        for (int i = 0; i < persons.length; i++) {
            int p = persons[i];
            int c = count.getOrDefault(p, 0) + 1;
            count.put(p, c);

            if (c >= votes) {
                if (leader != p) { // Only add new leader changes
                    leader = p;
                    v.add(new Vote(p, times[i]));
                }
                votes = c;
            }
        }
    }

    public int query(int t) {
        int left = 0, right = v.size() - 1;
        int ans = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (v.get(mid).time <= t) {
                ans = v.get(mid).person;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] persons = {0, 1, 1, 0, 0, 1, 0};
        int[] times = {0, 5, 10, 15, 20, 25, 30};

        OnlineElections obj = new OnlineElections(persons, times);

        // Example Queries
        System.out.println(obj.query(3));  // Output: 0
        System.out.println(obj.query(17)); // Output: 1
        System.out.println(obj.query(27)); // Output: 1
        System.out.println(obj.query(30)); // Output: 0
    }
}

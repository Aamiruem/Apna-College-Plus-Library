import java.util.*;
public class MergeInterval {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> ans = new ArrayList<>();
        for (int[] interval : intervals) {
            if (ans.isEmpty() || ans.getLast()[1] < interval[0]) {
                ans.add(interval);
            } else {
                ans.set(ans.size() - 1, new int[] { ans.getLast()[0], Math.max(ans.getLast()[1], interval[1]) });
            }
        }
        return ans.toArray(new int[ans.size()][2]);
    }
    public static void main(String[] args) {
        MergeInterval mi = new MergeInterval();
        int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        System.out.println(Arrays.deepToString(mi.merge(intervals)));

        // Test case 1
        int[][] intervals1 = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        int[][] result1 = mi.merge(intervals1); 
        int[][] expected1 = { { 1, 6 }, { 8, 10 }, { 15, 18 } };
        if (Arrays.deepEquals(result1, expected1)) {
            System.out.println("Test case 1 passed");
        }
        else {
            System.out.println("Test case 1 failed");
        }
        System.out.println(Arrays.deepToString(mi.merge(intervals1)));

        // Test case 2
        int[][] intervals2 = { { 1, 4 }, { 4, 5 } };
        int[][] result2 = mi.merge(intervals2);
        int[][] expected2 = { { 1, 5 } };
        if (Arrays.deepEquals(result2, expected2)) {
            System.out.println("Test case 2 passed");
        }
        else {
            System.out.println("Test case 2 failed");
        }
        System.out.println(Arrays.deepToString(mi.merge(intervals2)));

        // Test case 3
        int[][] intervals3 = { { 1, 4 }, { 2, 3 } };
        int[][] result3 = mi.merge(intervals3);
        int[][] expected3 = { { 1, 4 } };
        if (Arrays.deepEquals(result3, expected3)) {
            System.out.println("Test case 3 passed");
        }
        else {
            System.out.println("Test case 3 failed");
        }
        System.out.println(Arrays.deepToString(mi.merge(intervals3)));

    }
}

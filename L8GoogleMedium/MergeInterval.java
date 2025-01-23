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
    }
}

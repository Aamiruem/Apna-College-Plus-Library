// package L2AmazonMedium;

public class MinimumSwap {
    public static int minimumSwaps(String s) {
        int count0 = 0, count1 = 0, miss0 = 0, miss1 = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                count0++;
            } else {
                count1++;
            }
        }
        if (Math.abs(count0 - count1) > 1) {
            return -1;
        }
        for (int i = 0; i < s.length(); i += 2) {
            if (s.charAt(i) != '0') {
                miss0++;
            } else {
                miss1++;
            }
        }
        return count0 == count1 ? Math.min(miss0, miss1) : count0 > count1 ? miss0 : miss1;
    }
    public static void main(String[] args) {
        String s = "00110"; // Example input string
        int minSwaps = minimumSwaps(s);
        System.out.println("Minimum number of swaps required: " + minSwaps);
    }
}

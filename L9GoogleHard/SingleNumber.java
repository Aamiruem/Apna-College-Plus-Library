// public class SingleNumber {
//     public int singleNumber(int[] nums) {
//         int result = 0;
//         for (int num : nums) {
//             result ^= num;
//         }
//         return result;
//     }
    
//     public static void main(String[] args) {
//         SingleNumber singleNumber = new SingleNumber();
//         int[] nums = { 2, 1, 2, 1, 4 };
//         System.out.println(singleNumber.singleNumber(nums)); // Expected output: 4
//     }
// }











import java.util.ArrayList;

public class SingleNumber {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(2);
        nums.add(1);
        nums.add(2);
        nums.add(1);
        nums.add(4);
        int n = 5;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans ^= nums.get(i);
        }
        System.out.println(ans);
    }
}

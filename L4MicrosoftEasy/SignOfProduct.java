// public class SignOfProduct {
//     public int arraySignOfProduct(int nums[]) {
//         int product = 1;
//         for (int i = 0; i < nums.length; i++) {
//             product *= nums[i];
//         }
//         if (product > 0) {
//             return 1;
//         } else if (product < 0) {
//             return -1;
//         } else {
//             return 0;
//         }
//     }
//     public static void main(String[] args) {
//         SignOfProduct sp = new SignOfProduct();
//         int[] nums = {1, 2, 3, 4, 5};
//         System.out.println(sp.arraySignOfProduct(nums));
//     }
// }








public class SignOfProduct {
    public int arraySignOfProduct(int nums[]) {
        int count = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                return 0;
            } else if (nums[i] < 0) {
                count++;
            }
        }
        // return count % 2 == 0 ? 1 : -1;
        // or

        if (count%2 == 1) {
            return -1;
        } else {
            return 1;
        }
    }
    public static void main(String[] args) {
        SignOfProduct sp = new SignOfProduct();
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(sp.arraySignOfProduct(nums));
    }
}

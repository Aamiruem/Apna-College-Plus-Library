
// import java.util.Scanner;

// public class TeamCount {

//     public static void main(String[] args) {
//         // Read the number of elements in the array
//         try ( // Create a Scanner object to read input from the user
//                 Scanner sc = new Scanner(System.in)) {
//             // Read the number of elements in the array
//             int n = sc.nextInt();
//             // Create an array to store the elements
//             int[] arr = new int[n];
//             // Populate the array with user input
//             for (int i = 0; i < n; i++) {
//                 arr[i] = sc.nextInt();
//             }   int ls, lg, rs, rg;
//             // Variable to store the final answer
//             int ans = 0;
//             // Iterate over each element in the array
//             for (int j = 0; j < n; j++) {
//                 // Initialize counters for the current element
//                 ls = 0; // Count of elements smaller than arr[j] to the left of j
//                 lg = 0; // Count of elements larger than arr[j] to the left of j
//                 rs = 0; // Count of elements smaller than arr[j] to the right of j
//                 rg = 0; // Count of elements larger than arr[j] to the right of j
                
//                 // Iterate over the array to count the smaller and larger elements
//                 for (int i = 0; i < n; i++) {
//                     if (i < j) {
//                         // If the current index is to the left of j
//                         if (arr[i] < arr[j]) {
//                             ls++;
//                         }else if (arr[i] > arr[j]) {
//                             lg++;
//                         }
//                     } else if (i > j) {
//                         // If the current index is to the right of j
//                         if (arr[i] < arr[j]) {
//                             rs++;
//                         }else if (arr[i] > arr[j]) {
//                             rg++;
//                         }
//                     }
//                 }
                
//                 // Update the answer based on the counts
//                 ans += ls * rg + rs * lg;
//             }   // Print the final answer
//             System.out.println(ans);
//             // Close the Scanner object
//         }
//     }
// }












public class TeamCount {
    public static void main(String[] args) {
        // Predefined array (you can change this array as needed)
        int[] arr = {2, 5, 3, 4, 1};
        int n = arr.length; // Number of elements in the array

        // Variables to count the number of elements smaller and larger than the current element
        int ls, lg, rs, rg;
        
        // Variable to store the final answer
        int ans = 0;

        // Iterate over each element in the array
        for (int j = 0; j < n; j++) {
            // Initialize counters for the current element
            ls = 0; // Count of elements smaller than arr[j] to the left of j
            lg = 0; // Count of elements larger than arr[j] to the left of j
            rs = 0; // Count of elements smaller than arr[j] to the right of j
            rg = 0; // Count of elements larger than arr[j] to the right of j

            // Iterate over the array to count the smaller and larger elements
            for (int i = 0; i < n; i++) {
                if (i < j) {
                    // If the current index is to the left of j
                    if (arr[i] < arr[j]) ls++;
                    else if (arr[i] > arr[j]) lg++;
                } else if (i > j) {
                    // If the current index is to the right of j
                    if (arr[i] < arr[j]) rs++;
                    else if (arr[i] > arr[j]) rg++;
                }
            }

            // Update the answer based on the counts
            ans += ls * rg + rs * lg;
        }

        // Print the final answer
        System.out.println(ans);
    }
}

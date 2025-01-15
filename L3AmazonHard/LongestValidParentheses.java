
import java.util.Stack;

public class LongestValidParentheses {

    static int findMaxLen(String str) {
        int n = str.length();
        Stack<Integer> st = new Stack<>();
        st.push(-1); // Initialize the stack with -1 to handle the base case
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == '(') {
                st.push(i); // Push the index of '('
            } else {
                st.pop(); // Pop for ')'
                if (st.isEmpty()) {
                    st.push(i); // Push current index as a base for future matches
                } else {
                    ans = Math.max(ans, i - st.peek()); // Calculate the length
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String str = ")()())";
        System.out.println(findMaxLen(str)); // Output: 4
    }
}

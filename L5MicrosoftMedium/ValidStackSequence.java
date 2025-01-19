import java.util.Stack ;
public class ValidStackSequence {
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            Stack<Integer> stack = new Stack<>();
            int n = pushed.length;
            int j = 0;

            for (int i = 0; i < n; i++) {
                stack.push(pushed[i]); // Push the current element onto the stack

                // Pop elements from the stack if they match the popped sequence
                while (!stack.isEmpty() && stack.peek() == popped[j]) {
                    stack.pop();
                    j++;
                }
            }

            // If the stack is empty and all elements are matched, return true
            return stack.isEmpty() && j == n;
        }

        public static void main(String[] args) {
            ValidStackSequence s = new ValidStackSequence();
            int[] pushed = {1, 2, 3, 4, 5};
            int[] popped = {4, 5, 3, 2, 1};
            System.out.println(s.validateStackSequences(pushed, popped)); // Output: true

            int[] pushed2 = {1, 2, 3, 4, 5};
            int[] popped2 = {4, 3, 5, 1, 2};
            System.out.println(s.validateStackSequences(pushed2, popped2)); // Output: false
        }
    }

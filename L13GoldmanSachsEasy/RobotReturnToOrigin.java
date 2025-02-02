// Robot Return to Origin in Java 
// The problem asks if a robot returns to its starting position after executing a series of moves:

// 'U' → Up
// 'D' → Down
// 'L' → Left
// 'R' → Right
// To return to the origin:
// ✅ The number of 'U' moves must equal 'D' moves.
// ✅ The number of 'L' moves must equal 'R' moves.







public class RobotReturnToOrigin {

    public static boolean judgeCircle(String moves) {
        int x = 0, y = 0;

        for (char move : moves.toCharArray()) {
            if (move == 'U') {
                y++; 
            }else if (move == 'D') {
                y--; 
            }else if (move == 'L') {
                x--; 
            }else if (move == 'R') {
                x++;
            }
        }

        return x == 0 && y == 0;
    }

    public static void main(String[] args) {
        String moves = "UDLR"; // Example input
        System.out.println(judgeCircle(moves)); // Output: true
    }
}





// Explanation
// Maintain (x, y) coordinates where:
// 'U' increases y, 'D' decreases y
// 'L' decreases x, 'R' increases x
// If final (x, y) == (0, 0), return true, else return false.
// Time Complexity: O(N)
// Space Complexity: O(1)


public class RobotBoundedCircle {

    public static boolean isRobotBounded(String instructions) {
        // Initial position and direction
        int x = 0, y = 0;
        int dirX = 0, dirY = 1; // Facing north

        // Iterate through each instruction
        for (char ch : instructions.toCharArray()) {
            if (ch == 'G') {
                // Move forward in the current direction
                x += dirX;
                y += dirY;
            } else if (ch == 'L') {
                // Turn 90 degrees to the left
                int temp = dirX;
                dirX = -dirY;
                dirY = temp;
            } else if (ch == 'R') {
                // Turn 90 degrees to the right
                int temp = dirX;
                dirX = dirY;
                dirY = -temp;
            }
        }

        // Check if the robot is back at the origin or not facing north
        return (x == 0 && y == 0) || (dirX != 0 || dirY != 1);
    }

    public static void main(String[] args) {
        String instructions = "GGLLGG";
        System.out.println(isRobotBounded(instructions)); // Output: true
    }
}

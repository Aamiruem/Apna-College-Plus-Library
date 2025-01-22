
import java.util.ArrayList;
import java.util.List;

public class PascalTriangleKthRow {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1); // The first element is always 1

        for (int i = 1; i <= rowIndex; i++) {
            // Update the row from the back to maintain O(rowIndex) space
            for (int j = row.size() - 1; j > 0; j--) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
            row.add(1); // Append 1 at the end for the new row
        }

        return row;
    }

    public static void main(String[] args) {
        PascalTriangleKthRow solution = new PascalTriangleKthRow();

        // Test case 1
        int rowIndex1 = 3;
        System.out.println("Row index " + rowIndex1 + ": " + solution.getRow(rowIndex1));

        // Test case 2
        int rowIndex2 = 5;
        System.out.println("Row index " + rowIndex2 + ": " + solution.getRow(rowIndex2));
    }
}

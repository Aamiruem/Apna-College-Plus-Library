
import java.util.Arrays;

public class WordSearch {
    public int[] getRow(int n) {
        int[] row = new int[n+1];
        row[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = i; j > 0; j--) {

                row[j] += row[j - 1];
            }
        }
        return row;
    }
    
    public static void main(String[] args) {
        WordSearch ws = new WordSearch();
        int[] row1 = ws.getRow(0);
        System.out.println(Arrays.toString(row1));

        int[] row2 = ws.getRow(1);
        System.out.println(Arrays.toString(row2));

        int[] row3 = ws.getRow(3);
        System.out.println(Arrays.toString(row3));

        int[] row4 = ws.getRow(5);
        System.out.println(Arrays.toString(row4));
    }
}

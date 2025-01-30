
public class MinRotatedSortedArray {
    public static void main(String[] args) {
        int[] temp = new int[5];
        temp[0] = 3;
        temp[1] = 4;
        temp[2] = 5;
        temp[3] = 1;
        temp[4] = 2;
        int n = temp.length;
        int s = 0;
        int e = n - 1;

        while (s <= e) {
            int mid = (s + e) / 2;
            int prev = (mid - 1 + n) % n;
            int next = (mid + 1) % n;

            if (temp[mid] <= temp[next] && temp[mid] <= temp[prev]) {
                System.out.println(temp[mid]);
                break;
            } else if (temp[mid] <= temp[e]) {
                e = mid - 1;
            } else if (temp[mid] >= temp[s]) {
                s = mid + 1;
            }
        }
    }
}

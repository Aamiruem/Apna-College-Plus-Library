
// public class CakeCut {

//     public static double maxPieceArea(double length, double width) {
//         // Calculate the maximum area of a piece after horizontal and vertical cuts
//         return (length * width) / 4.0;
//     }

//     public static void main(String[] args) {
//         double length = 10.0; // Length of the cake
//         double width = 5.0;   // Width of the cake

//         double maxArea = maxPieceArea(length, width);
//         System.out.println("Maximum area of a piece of cake: " + maxArea);
//     }
// }







import java.util.*;

public class CakeCut {

    public int maxArea(int h, int w, List<Integer> hc, List<Integer> vc) {
        // Sort the horizontal and vertical cuts
        Collections.sort(hc);
        Collections.sort(vc);

        List<Integer> vd = new ArrayList<>();
        List<Integer> hd = new ArrayList<>();
        vd.add(0);  // Add the first gap (from the edge to the first vertical cut)
        hd.add(0);  // Add the first gap (from the edge to the first horizontal cut)

        // Calculate the gaps between consecutive vertical cuts
        for (int i = 0; i < vc.size() - 1; i++) {
            vd.add(vc.get(i + 1) - vc.get(i));
        }

        // Calculate the gaps between consecutive horizontal cuts
        for (int i = 0; i < hc.size() - 1; i++) {
            hd.add(hc.get(i + 1) - hc.get(i));
        }

        // Add the gaps from the last cut to the edge
        vd.add(w - vc.get(vc.size() - 1));
        hd.add(h - hc.get(hc.size() - 1));

        // Calculate the maximum vertical and horizontal gaps
        int l = Collections.max(vd);
        int b = Collections.max(hd);

        // Modulo value
        int m = (int) (Math.pow(10, 9) + 7);

        // Calculate the maximum area and return it modulo m
        long result = (long) l * b % m;
        return (int) result;
    }

    public static void main(String[] args) {
     CakeCut solution = new CakeCut();
        int h = 4;  // Height of the cake
        int w = 5;  // Width of the cake
        List<Integer> hc = Arrays.asList(1, 2);  // Horizontal cuts at y = 1 and y = 2
        List<Integer> vc = Arrays.asList(1, 3);  // Vertical cuts at x = 1 and x = 3

        int maxArea = solution.maxArea(h, w, hc, vc);
        System.out.println("Maximum Area: " + maxArea);
    }
}


public class ArrangingCoins {
public static void main(String[] args) {
    
    int n = 5;
    int ans = (int) (Math.sqrt(2 * n + 0.25) - 0.5);// Calculate the square root of 2n + 0.25 and subtract 0.5
    System.out.println(ans);
}
}

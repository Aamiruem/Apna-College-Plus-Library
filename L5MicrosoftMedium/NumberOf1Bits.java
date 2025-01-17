
public class NumberOf1Bits {

    // Method to count the number of 1 bits in an integer
    public int hammingWeight(int n) {
        int count = 0; // Initialize the count of 1 bits
        while (n != 0) {
            count += n & 1; // Check the least significant bit
            n = n >>> 1;    // Unsigned right shift to process the next bit
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOf1Bits obj = new NumberOf1Bits();
        int n = 11; // Binary representation: 1011
        System.out.println("Number of 1 bits: " + obj.hammingWeight(n)); // Output: 3
    }
}

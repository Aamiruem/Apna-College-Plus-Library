public class UpperToLowerCases {
    public String toLowerCase(String s) {
        // Use StringBuilder for efficient string manipulation
        StringBuilder result = new StringBuilder(s);

        // Iterate through each character in the string
        for (int i = 0; i < result.length(); i++) {
            // Check if the character is an uppercase letter
            if (result.charAt(i) >= 'A' && result.charAt(i) <= 'Z') {
                // Convert the uppercase letter to lowercase by adding 32
                result.setCharAt(i, (char) (result.charAt(i) + 32));
            }
        }

        // Convert StringBuilder back to a String and return it
        return result.toString();
    }

    public static void main(String[] args) {
        // Initialize the string
        String str = "Hello, World!";

        // Create an object of the ToLowerCase class
        UpperToLowerCases converter = new UpperToLowerCases();

        // Call the toLowerCase method and store the result
        String result = converter.toLowerCase(str);

        // Print the lowercase string to the console
        System.out.println("Lowercased string: " + result);
    }
}

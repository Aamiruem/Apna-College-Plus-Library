public class DefangingIPAddress {
    public static String defangIPAddress(String Address) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < Address.length(); i++) {
            if (Address.charAt(i) == '.') {
                str.append("[.]");
            } else {
                str.append(Address.charAt(i));
            }
        }
        return str.toString();

    }
    
    public static void main(String[] args) {
        System.out.println(defangIPAddress("1.1.1.1")); // Output: "1[.]1[.]1[.]1"
    }
}

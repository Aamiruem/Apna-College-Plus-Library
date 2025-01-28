// // package L11AtlasianMedium;

// import java.util.*;

// class Node {

//     int value;
//     Map<String, Node> next;

//     Node(int value) {
//         this.value = value;
//         this.next = new HashMap<>();
//     }
// }

// public class FileSystem {

//     @SuppressWarnings("FieldMayBeFinal")
//     private Node root;

//     public FileSystem() {
//         root = new Node(0);
//     }

//     public boolean createPath(String path, int value) {
//         Node cur = root;
//         path = path + "/"; // Append '/' to handle the last segment
//         int pos = 1;

//         while (pos < path.length()) {
//             int end = path.indexOf('/', pos);
//             String name = path.substring(pos, end);

//             if (end + 1 == path.length()) { // Last segment
//                 if (cur.next.containsKey(name)) {
//                     return false; // Path already exists
//                 }
//                 cur.next.put(name, new Node(value));
//                 return true;
//             }

//             if (!cur.next.containsKey(name)) {
//                 return false; // Parent path does not exist
//             }

//             cur = cur.next.get(name);
//             pos = end + 1;
//         }

//         return true;
//     }

//     public int get(String path) {
//         Node cur = root;
//         path = path + "/"; // Append '/' to handle the last segment
//         int pos = 1;

//         while (pos < path.length()) {
//             int end = path.indexOf('/', pos);
//             String name = path.substring(pos, end);

//             if (!cur.next.containsKey(name)) {
//                 return -1; // Path does not exist
//             }

//             cur = cur.next.get(name);
//             pos = end + 1;
//         }

//         return cur.value;
//     }

//     public static void main(String[] args) {
//         FileSystem obj = new FileSystem();
//         System.out.println(obj.createPath("/leet", 1));          // Output: true (1)
//         System.out.println(obj.createPath("/leet/code", 2));     // Output: true (1)
//         System.out.println(obj.get("/leet"));                   // Output: 1
//         System.out.println(obj.get("/leet/code"));              // Output: 2
//         System.out.println(obj.createPath("/leet/code", 3));    // Output: false (0, already exists)
//         System.out.println(obj.get("/leet/code"));              // Output: 2
//     }
// }










import java.util.*;

class FileSystem {
    class TrieNode {
        String name;
        int value = -1;
        Map<String, TrieNode> mp = new HashMap<>();

        TrieNode(String name) {
            this.name = name;
        }
    }

    TrieNode root;

    public FileSystem() {
        root = new TrieNode(" ");
    }

    public boolean createPath(String path, int value) {
        String[] components = path.split("/");
        TrieNode cur = root;

        for (int i = 1; i < components.length; i++) {
            if (!cur.mp.containsKey(components[i])) {
                if (i == components.length - 1) { // Last component
                    cur.mp.put(components[i], new TrieNode(components[i]));
                } else {
                    return false; // Parent path does not exist
                }
            }
            cur = cur.mp.get(components[i]);
        }

        if (cur.value != -1) {
            return false; // Path already exists
        }

        cur.value = value;
        return true;
    }

    public int get(String path) {
        String[] components = path.split("/");
        TrieNode cur = root;

        for (int i = 1; i < components.length; i++) {
            if (!cur.mp.containsKey(components[i])) {
                return -1; // Path does not exist
            }
            cur = cur.mp.get(components[i]);
        }

        return cur.value;
    }

    public static void main(String[] args) {
        FileSystem obj = new FileSystem();
        System.out.println(obj.createPath("/leet", 1));          // Output: true (1)
        System.out.println(obj.createPath("/leet/code", 2));     // Output: true (1)
        System.out.println(obj.get("/leet"));                   // Output: 1
        System.out.println(obj.get("/leet/code"));              // Output: 2
        System.out.println(obj.createPath("/leet/code", 3));    // Output: false (0, already exists)
        System.out.println(obj.get("/leet/code"));              // Output: 2
    }
}

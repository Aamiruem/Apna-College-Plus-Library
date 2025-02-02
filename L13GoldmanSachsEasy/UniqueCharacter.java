// package L13GoldmanSachsEasy;


import java.util.Scanner;
public class UniqueCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int arr[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = 0;
        }
        for (char ch : s.toCharArray()) {
            arr[ch - 'a']++;
        }
        int ans =-1;
        for(int i = 0; i < s.length(); i++) {
            if(arr[s.charAt(i) - 'a'] == 1) {
                ans = i;
                break;
            }
        }
        System.out.println(ans);
    }
}

import java.util.Stack;
import java.util.Scanner;

public class PalindromeCheckerClass {

    // Stack-based palindrome check
    public static boolean stackPalindrome(String input) {
        String str = input.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            stack.push(c);
        }

        for (char c : str.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }
        return true;
    }

    // Two-pointer palindrome check
    public static boolean twoPointerPalindrome(String input) {
        String str = input.replaceAll("\\s+", "").toLowerCase();
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Stack Algorithm Timing
        long start1 = System.nanoTime();
        boolean stackResult = stackPalindrome(input);
        long end1 = System.nanoTime();
        long stackTime = end1 - start1;

        // Two Pointer Algorithm Timing
        long start2 = System.nanoTime();
        boolean pointerResult = twoPointerPalindrome(input);
        long end2 = System.nanoTime();
        long pointerTime = end2 - start2;

        System.out.println("\nResults:");
        System.out.println("Stack Method Result: " + stackResult);
        System.out.println("Execution Time (Stack): " + stackTime + " ns");

        System.out.println("\nTwo Pointer Method Result: " + pointerResult);
        System.out.println("Execution Time (Two Pointer): " + pointerTime + " ns");

        sc.close();
    }
}
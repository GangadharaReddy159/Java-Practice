public class JavaStrings {

    public static void main(String[] args) {

        //reverse a string using string builder
        String s1 = "Advanced";
        String reversed = new StringBuilder(s1).reverse().toString();
        System.out.println("Reversed string----------: " + reversed);

        //find if a string is palindrome using string builder
        String s2 = "madam";
        String reversed2 = new StringBuilder(s2).reverse().toString();
        boolean isPalindrome = s2.equals(reversed2);
        System.out.println("Is palindrome----------: " + isPalindrome);
    }
}

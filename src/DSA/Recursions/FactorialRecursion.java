package DSA.Recursions;

class Solution1{
    public int factorial(int n){
        if(n==0) return 1;
        return n*factorial(n-1);

    }
}

public class FactorialRecursion {
    public static void main(String[] args) {
        int n =4;
        Solution1 solution = new Solution1();
        int result = solution.factorial(n);
        System.out.println("Factorial of "+n+" is: "+result);

        System.out.println("---Iterative approach---");
        int factorial = 1;
        for(int i=1;i<=n;i++) {
            factorial *= i;
        }
        System.out.println("Factorial of "+n+" is: "+factorial);
    }
}

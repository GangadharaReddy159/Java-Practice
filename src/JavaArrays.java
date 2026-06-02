import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.stream;

public class JavaArrays {
    public static void main(String[] args) {

        //calculate the missing number
        int[] arr = {1,0,3,4,5};
        int currentSum = Arrays.stream(arr).sum();
        int n = arr.length;
        int expectedSum = n*(n+1)/2;
        int missingNumber = expectedSum-currentSum;
        System.out.println("Missing number is: " + missingNumber);

        //sort the given array
        int[] a = {4,1,8,2,4,0,5,3,7,9};
        int[] b = stream(a).sorted().toArray();
        System.out.println("Sorted array: " + Arrays.toString(b));

        //find the maximum consecutive 'a' count in the given string
        String str = "aababaaacaad";
        char[] c = str.toCharArray();
        int tempCount=0;
        int totalCount =0;
        for(int i=0;i<c.length;i++) {
            if (c[i] == 'a') {
                tempCount++;
                totalCount = Math.max(totalCount, tempCount);
            } else {
                tempCount = 0;
            }
        }

        System.out.println("Maximum consecutive 'a' count: " + totalCount);

        //find the number of digits in the given number
        int N = 2345678;
        int result = countDigit(N);
        System.out.println("Number of digits in " + N + " is: " + result);

        //reverse a number
        int correct = 6789;
        int reverse = 0;
        while(correct != 0) {
            int lastDigit = correct % 10;
            reverse = reverse * 10 + lastDigit;
            correct /= 10;
        }
        System.out.println("Reverse of the number is: " + reverse);

        //GCD of numbers using Euclidean algorithm
        int n1=20;
        int n2=15;
        int gcd = findGCDofNumber(n1,n2);
        System.out.println("GCD of " + n1 + " and " + n2 + " is: " + gcd);

        //find if a number is an Armstrong number or not
        int num1 = 153;
        int len = (int)(Math.log10(num1) + 1);
        int sum = 0;
        int temp = num1;
        while(temp != 0) {
            int lastDigit = temp % 10;
            sum += Math.pow(lastDigit, len);
            temp /= 10;
        }
        if(sum == num1) {
            System.out.println(num1 + " is an Armstrong number.");
        } else {
            System.out.println(num1 + " is not an Armstrong number.");
        }

        //find the divisors of a number
        int d = 36;
        List<Integer> divisors = new ArrayList<>();
        for(int i=1;i<=(int)(Math.sqrt(d));i++){
            if(d%i==0){
                divisors.add(i);
                if(i!=d/i) divisors.add(d/i);
            }
        }
        System.out.println("Divisors of " + d + " are: " + divisors);

        int p = 2;
        boolean prime = findPrimeOrNot(p);
        System.out.println(p + " is prime: " + prime);

    }

    private static boolean findPrimeOrNot(int p) {
        int cnt=0;
        for(int i=1;i<=(int)(Math.sqrt(p));i++){
            if(p%i==0){
                cnt++;
                if(i!=p/i) cnt++;
            }
        }
        return cnt>2 ? false : true;
    }

    private static int findGCDofNumber(int n1, int n2) {
        while(n1>0 && n2>0) {
            if(n1>n2) {
                n1 = n1 - n2;
            } else {
                n2 = n2 - n1;
            }
        }
        return n1==0 ? n2 : n1;
    }

    private static int countDigit(int n) {

        int count = (int)(Math.log10(n) + 1);
        return count;
    }
}

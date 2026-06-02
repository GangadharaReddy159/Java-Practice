import java.util.Arrays;

import static java.util.Arrays.stream;

public class JavaArrays {
    public static void main(String[] args) {
        int[] arr = {1,0,3,4,5};
        int currentSum = Arrays.stream(arr).sum();
        int n = arr.length;
        int expectedSum = n*(n+1)/2;
        int missingNumber = expectedSum-currentSum;
        System.out.println("Missing number is: " + missingNumber);

        int[] a = {4,1,8,2,4,0,5,3,7,9};
        int[] b = stream(a).sorted().toArray();
        System.out.println("Sorted array: " + Arrays.toString(b));

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

        int N = 2345678;
        int result = countDigit(N);
        System.out.println("Number of digits in " + N + " is: " + result);
    }

    private static int countDigit(int n) {

        int count = (int)(Math.log10(n) + 1);
        return count;
    }
}

package DSA.Hashing;

import java.util.Arrays;
import java.util.Scanner;

public class SampleHashing {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] hash = new int[n];
        for (int j = 0; j < n; j++) {
            hash[arr[j]] += 1;
        }

        System.out.println(Arrays.toString(hash));


        int q = sc.nextInt();
        while (q-- != 0) {
            int number;
            number = sc.nextInt();
            // fetching:
            System.out.println(hash[number]);
        }
    }
}

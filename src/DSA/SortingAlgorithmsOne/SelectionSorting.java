package DSA.SortingAlgorithmsOne;

import java.util.Arrays;

public class SelectionSorting {
    public static void main(String[] args) {
        int[] arr = {13,9,36,4,16,8,24};
        int min =0;
        for(int i=0;i<arr.length-1;i++){
            min=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[min])
                    min=j;
            }
            int temp = arr[i];
            arr[i]=arr[min];
            arr[min]=temp;

        }
        for(int a:arr)
            System.out.print(a+" ");
    }
}

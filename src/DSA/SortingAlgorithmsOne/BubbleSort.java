package DSA.SortingAlgorithmsOne;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {13,9,36,4,16,8,24};
        int n = arr.length;
        boolean didSwap = false;
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<i;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    didSwap=true;
                }
                if(!didSwap)
                    break;
            }
        }
        for(int a:arr)
            System.out.print(a+" ");
    }
}

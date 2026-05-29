package DSA;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {2,4,6,8,10,12,14,16,18,20};
        int target = 6;
        int result = MylinearSearch(arr, target);
        System.out.println("Element found at index: " + result);
    }

    public static int MylinearSearch(int[] arr, int target){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==target) return i;
        }
        return -1;
    }
}

package DSA.SearchAlgorithms;


public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {3,5,7,9,11,13,15,17,19,21};
        int target = 9;
        int result = MyBinarySearch(arr, target);
        System.out.println("hello");
        System.out.println("Element found at index: " + result);
    }

    public static int MyBinarySearch(int[] arr, int target){
        int left = 0;
        int right=arr.length-1;
        while(left<=right){
            int mid=left+right/2;
            if(arr[mid]==target) {
                return mid;
            }
            else if(arr[mid]<target){
                left=mid+1;
            }
            else if(arr[mid]>target){
                right=mid-1;
            }
        }
        return -1;
    }

}

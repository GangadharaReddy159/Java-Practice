package DSA;

import java.util.Arrays;
import java.util.HashSet;
import java.util.OptionalInt;

import static java.util.Arrays.stream;

public class MyArrays {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println(7/2);
        System.out.println(1%10);

        int largest = stream(arr).max().getAsInt();
        System.out.println(largest);
        int max = arr[0];
        for(int i:arr){
            if(i>max){
                max=i;
            }
        }
        System.out.println(max);

        int[] nums = {1,2,3,4,5};
        int n = nums.length;
        int[] res = new int[n];
        res[0]=0;
        for(int i=1;i<n;i++){
            res[i]=res[i-1]+nums[i-1];
        }
        System.out.println(Arrays.toString(res));

        int right = 0;
        for(int i=n-1;i>=0;i--){
            res[i]=res[i]+right;
            right+=nums[i];
        }
        System.out.println(Arrays.toString(res));

        int[] res2 = new int[n];
        int sum =0;
        for(int num:nums){
            sum+=num;
        }
        for(int i=0;i<n;i++){
            res2[i]=sum-nums[i];
        }
        System.out.println(Arrays.toString(res2));

        int[] mixed = {3,1,-2,-5,2,-4};
        int l = mixed.length;
        int[] orderd = new int[l];
        int p=0;
        int ne=1;
        for(int i:mixed){
            if(i<0){
                orderd[p]=i;
                p+=2;
            }
            else if(i>0){
                orderd[ne]=i;
                ne+=2;
            }
        }
        System.out.println(Arrays.toString(orderd));

        double average1 = Arrays.stream(arr).average().orElse(0);
        System.out.println(average1);

        int[] given = {2,20,4,10,3,4,5};
        HashSet<Integer> base = new HashSet<>();
        int start=given[0];
        int startMin =0;
        for(int g:given){
            if(!base.contains(g)){
                base.add(g);
            }
            if(!base.contains(g-1) && g<=start) {
                start = g;
            }
        }

        System.out.println(start);


    }
}

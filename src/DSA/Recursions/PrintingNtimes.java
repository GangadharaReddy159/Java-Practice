package DSA.Recursions;

class Solution{
    public void printNTimes(String s,int count,int N){
        if(count==N) return;
        System.out.println(s);
        printNTimes(s,count+1,N);
    }
}


public class PrintingNtimes {
    public static void main(String[] args) {
        String str = "venkat";
        int N = 3;
        Solution solution = new Solution();
        solution.printNTimes(str,0,N);

    }
}

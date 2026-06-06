package DSA.Recursions;

class Recursion{
    public void printN(int n, int count){
        if(count==n) return;
        System.out.print(count+1+" ");
        printN(n, count+1);
    }
}

public class PrintNNumbers {
    public static void main(String[] args) {
        int n = 5;
        Recursion recursion = new Recursion();
        recursion.printN(n,0);

    }
}

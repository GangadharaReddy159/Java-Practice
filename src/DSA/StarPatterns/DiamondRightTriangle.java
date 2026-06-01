package DSA.StarPatterns;

public class DiamondRightTriangle {
    public static void main(String[] args) {
        int n=5;
        upward(n);
        downward(n);
    }

    private static void downward(int n) {
        for(int i=0;i<n;i++){
            for(int j=0;j<n-i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void upward(int n) {
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

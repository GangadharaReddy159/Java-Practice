package DSA.StarPatterns;

public class DiamondGapStarPattern {
    public static void main(String[] args) {
        int n =5;
        printStartPattern(n);
        printEndPattern(n);

    }

    private static void printStartPattern(int n) {
        for(int i=0;i<n;i++){
            for(int j=0;j<n-i;j++){
                System.out.print("*");
            }

            for(int j=0;j<2*i;j++){
                System.out.print(" ");
            }
//            for(int j=0;j<2*i;j++){
//                System.out.print(" ");
//            }

            for(int j=0;j<n-i;j++){
                System.out.print("*");
            }
            System.out.println();

        }
    }

    private static void printEndPattern(int n) {
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                System.out.print("*");
            }

            for(int j=0;j<2*(n-i)-2;j++){
                System.out.print(" ");
            }
//            for(int j=0;j<2*i;j++){
//                System.out.print(" ");
//            }

            for(int j=0;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();

        }
    }
}

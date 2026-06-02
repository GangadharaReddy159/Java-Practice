package DSA.StarPatterns;

public class InverseAlphabetTriangle {
    public static void main(String[] args) {
        int n=5;
        char c='A';
        for(int i=0;i<n;i++){
            for(int j=0;j<n-i;j++){
                System.out.print((char)(j+c)+" ");
            }
            System.out.println();
        }
    }
}

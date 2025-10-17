package oct15;

public class Pattern_Using_Recursion {
    public static void main(String[] args) {
        topToBot(5, 0);
        System.out.println();
        botToTop(4, 0);
        
    }
    private static void topToBot(int n, int i){
        if(n==0){
            return;
        }
        if(i<n){
            System.out.print('*');
            topToBot(n, i+1);
        }
        else{
            System.out.println();
            topToBot(n-1, 0);
        }
    }
    private static void botToTop(int n, int i){
        if(n==0){
            return;
        }
        if(i<n){
            botToTop(n, i+1);
            System.out.print('*');
        }
        else{
            botToTop(n-1, 0);
            System.out.println();
        }
    }
}


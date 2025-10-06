package oct5;

public class Nto1and1toN {
    public static void main(String[] args) {
        int n = 5;
        OnetoN(n);
        System.out.println();
        NtoOne(n);
    }
    public static void OnetoN(int n){
        if(n==0){
            return;
        }
        OnetoN(n-1);
        System.out.print(n);
    }
    public static void NtoOne(int n){
        if(n==0){
            return;
        }
        System.out.print(n);
        NtoOne(n-1);
    }
}

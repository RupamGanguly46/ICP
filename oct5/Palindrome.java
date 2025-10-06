package oct5;

public class Palindrome {
    public static void main(String[] args) {
        String a = "abcba";
        String b = "abccba";
        System.out.println(isPal(a,0,a.length()-1));
        System.out.println(isPal(b, 0, b.length()-1));
    }
    public static boolean isPal(String a, int s, int e){
        if(s>=e){
            return true;
        }
        if(a.charAt(s)==a.charAt(e)){
            return isPal(a, s+1, e-1);
        }
        else{
            return false;
        }
    }
}

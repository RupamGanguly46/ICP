package oct5;

public class subseqPrint {
    public static void main(String[] args) {
        String s = "abc";
        helper("", s);
    }
    public static void helper(String p, String up){
        if(up.length()==0){
            System.out.println(p);
            return;
        }
        char c = up.charAt(0);
        helper(p+c, up.substring(1));
        helper(p, up.substring(1));
    }
}

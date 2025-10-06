package oct5;
public class removeCharUsingRecur2 {
    public static void main(String[] args) {
        String up = "batball";
        System.out.println(helper(up, ""));
    }
    public static String helper(String up, String p){
        if(up.length()==0){
            return p;
        }
        char c = up.charAt(0);
        if(c=='a'){
            return helper(up.substring(1), p);
        }
        else{
            return helper(up.substring(1), p+c);
        }
    }
}

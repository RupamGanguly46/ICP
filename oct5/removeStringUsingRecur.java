package oct5;

public class removeStringUsingRecur {
    public static void main(String[] args) {
        String s = "meappleappleme";
        System.out.println(helper(s));
    }
    public static String helper(String s){
        if(s.length()==0){
            return "";
        }
        if(s.startsWith("apple")){
            return helper(s.substring(5));
        }
        else{
            return s.charAt(0) + helper(s.substring(1));
        }
    }
}

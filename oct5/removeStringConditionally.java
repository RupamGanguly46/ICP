package oct5;

public class removeStringConditionally {
    public static void main(String[] args) {
        String s = "appappleappleapp";
        System.out.println(helper(s));
    }
    public static String helper(String s){
        if(s.length()==0){
            return "";
        }
        if(!s.startsWith("apple") && s.startsWith("app")){
            return helper(s.substring(3));
        }
        else{
            return s.charAt(0) + helper(s.substring(1));
        }
    }
}

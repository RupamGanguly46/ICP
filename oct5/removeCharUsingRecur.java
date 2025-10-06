package oct5;

public class removeCharUsingRecur {
        public static void main(String[] args) {
        String s = "baccad";
        System.out.print(helper(s));
    }
    public static String helper(String s){
        if(s.length()==0){
            return "";
        }
        char c = s.charAt(0);
        if(c == 'a'){
            return helper(s.substring(1));
        }
        else{
            return c + helper(s.substring(1));
        }
    }
    
}

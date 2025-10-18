package oct17;

public class Count_Permutations {
    public static void main(String[] args) {
        String s = "abc";
        System.out.println(count("", s));
    }
    private static int count(String p, String up){
        if(up.length()==0) return 1;
        int count = 0;
        char c = up.charAt(0);
        for(int i=0; i<p.length()+1; i++){
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            count += count(f+c+s, up.substring(1));
        }
        return count;
    }
}

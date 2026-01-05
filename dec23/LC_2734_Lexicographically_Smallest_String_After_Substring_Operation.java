package dec23;

public class LC_2734_Lexicographically_Smallest_String_After_Substring_Operation {
    public String smallestString(String s) {
        int i = 0;
        int len = s.length();
        StringBuilder sb = new StringBuilder();

        while(i<len && s.charAt(i)=='a') i++;

        if(i==len){
            sb.append(s, 0, i-1);
            sb.append('z');
            return sb.toString();
        }
        
        sb.append(s, 0, i);
        while(i<len && s.charAt(i)!='a'){
            sb.append( (char) (s.charAt(i) - 1) );
            i++;
        }
        sb.append(s, i, len);

        return sb.toString();
    }
}

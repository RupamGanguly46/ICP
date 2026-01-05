package dec22;

public class LC_3582_Generate_Tag_for_Video_Caption {
    class Solution {
        public String generateTag(String caption) {
            char[] out = new char[100];
            int len = 0;

            out[len++] = '#';
            boolean space = false;

            for (int i = 0; i < caption.length() && len < 100; i++) {
                char ch = caption.charAt(i);

                if(ch == ' '){
                    space = true;
                    continue;
                }
                
                if( (ch|32) < 'a' || (ch|32) > 'z' ) continue;

                if(len == 1){
                    ch |= 32;
                } 
                else if(space){
                    ch &= ~32;
                } 
                else{
                    ch |= 32;
                }

                out[len++] = ch;
                space = false;
            }

            return new String(out, 0, len);
        }
    }

}

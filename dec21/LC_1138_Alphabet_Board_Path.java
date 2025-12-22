package dec21;

public class LC_1138_Alphabet_Board_Path {
    class Solution {
        public String alphabetBoardPath(String target) {
            StringBuilder sb = new StringBuilder();
            int curx=0, cury=0;
            for(int i=0; i<target.length(); i++){
                int tarx = (target.charAt(i) - 'a') / 5;
                int tary = (target.charAt(i) - 'a') % 5;

                // Won't move down or right first as we can fall out of the maze
                while(curx>tarx){
                    sb.append('U');
                    curx--;
                }
                while(cury>tary){
                    sb.append('L');
                    cury--;
                }
                while(curx<tarx){
                    sb.append('D');
                    curx++;
                }
                while(cury<tary){
                    sb.append('R');
                    cury++;
                }
                sb.append('!');   
            }

            return sb.toString();
        }
    }
}

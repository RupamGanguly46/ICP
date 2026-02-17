public class LC_2509_Cycle_Length_Queries_in_a_Tree {
    class Solution {
        public int solve(int x, int y){
            // A cycle has minimum length of 1 (One node in a cycle)
            int count = 1;
            while(x!=y){
                if(x>y){
                    x/=2;
                }
                else{
                    y/=2;
                }
                count++;
            }
            return count;
        }
        public int[] cycleLengthQueries(int n, int[][] queries) {
            int q = queries.length;
            int[] answer = new int[q];
            for(int i=0; i<q; i++){
                answer[i] = solve(queries[i][0], queries[i][1]);
            }
            return answer;
        }
    }    
}

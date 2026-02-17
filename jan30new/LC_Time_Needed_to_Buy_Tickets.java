public class LC_Time_Needed_to_Buy_Tickets {
    class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<int[]> q = new LinkedList<>();

        for(int i=0; i<tickets.length; i++){
            q.offer(new int[] {i, tickets[i]});
        }

        int time = 0;

        while(!q.isEmpty()){
            int[] rm = q.poll();
            time++;
            rm[1]--;
            if(rm[1]==0){
                if(rm[0] == k){
                    return time;
                }
            }
            else{
                q.offer(rm);
            }
        }

        return time;
    }
}
}

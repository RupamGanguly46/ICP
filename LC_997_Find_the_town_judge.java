public class LC_997_Find_the_town_judge {
    public static int findJudge(int n, int[][] trust) {
        int[] doesTrust = new int[n+1];
        int[] isTrusted = new int[n+1];

        for(int[] relation: trust){
            doesTrust[relation[0]]++;
            isTrusted[relation[1]]++;
        }

        for(int j = 1; j <= n; j++){
            if(doesTrust[j]==0 && isTrusted[j]==n-1){
                return j;
            }
        }
        
        return -1;
    }

    public static void main(String[] args){
        int[][] trust = {{1, 3}, {2, 3}, {3, 1}};
        System.out.println(findJudge(3, trust));

        int[][] trust2 = {{1, 3}, {2, 3}};
        System.out.println(findJudge(3, trust2));
    }
}
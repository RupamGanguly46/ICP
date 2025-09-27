public class LC_904_Fruit_into_baskets {
    public int totalFruit(int[] fruits) {
        int curmax = 0;
        int maxx = 0;
        int A = -1;
        int B = -1;
        int countB = 0;

        for(int fruit: fruits){
            if(fruit==A || fruit==B){
                curmax++;
            }
            else{
                curmax = countB + 1;
            }

            if(fruit == B){
                countB++;
            }
            else{
                A = B;
                B = fruit;
                countB = 1;
            }

            maxx = Math.max(maxx, curmax);
        }
        return maxx;
    }
}
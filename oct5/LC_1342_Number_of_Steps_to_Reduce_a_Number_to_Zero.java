package oct5;

public class LC_1342_Number_of_Steps_to_Reduce_a_Number_to_Zero {
    public int numberOfSteps(int num) {
        return helper(num, 0);
    }
    public int helper(int num, int steps){
        if(num==0){
            return steps;
        }
        if(num%2==0){
            return helper(num/2, steps+1);
        }
        else{
            return helper(num-1, steps+1);
        }
    }
}
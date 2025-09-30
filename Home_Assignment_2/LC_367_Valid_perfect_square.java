package Home_Assignment_2;
public class LC_367_Valid_perfect_square {
    public boolean isPerfectSquare(int num) {
        int low = 1;
        int high = (int) Math.pow(2, 31) - 1;
        while(low<=high){
            int mid = low + (high-low)/2;
            long squarredMid = (long) Math.pow(mid, 2);

            if(num == squarredMid){
                return true;
            }
            else if(num < squarredMid){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return false;
    }
}
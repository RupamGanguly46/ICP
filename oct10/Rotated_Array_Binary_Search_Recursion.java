package oct10;
public class Rotated_Array_Binary_Search_Recursion {
    public static void main(String[] args) {
        // Array where first half is sorted and contains target.
        int[] arr1 = {3, 4, 5, 6, 1, 2};
        int target1 = 4;
        System.out.println(bins(arr1, target1, 0, arr1.length-1));
        
        // Array where first half is sorted, but does'nt contain target.
        int[] arr2 = {3, 4, 5, 6, 1, 2};
        int target2 = 1;
        System.out.println(bins(arr2, target2, 0, arr2.length-1));

        
        // Array where first half is not sorted, and has target.
        int[] arr3 = {5, 6, 1, 2, 3, 4};
        int target3 = 6;
        System.out.println(bins(arr3, target3, 0, arr3.length-1));


        // Array where first half is not sorted, and doesn't have target.
        int[] arr4 = {5, 6, 1, 2, 3, 4};
        int target4 = 3;
        System.out.println(bins(arr4, target4, 0, arr4.length-1));

    }
    private static int bins(int[] arr, int target, int s, int e){
        if(s>e) return -1;

        int mid = s + (e-s)/2;
        if(arr[mid]==target) return mid;

        if(arr[s]<=arr[mid]){
            if(target>=arr[s] && target<arr[mid]){
                return bins(arr, target, s, mid-1);
            }
            else{
                return bins(arr, target, mid+1, e);
            }
        }
        else{
            if(target<=arr[e] && target>arr[mid]){
                return bins(arr, target, mid+1, e);
            }
            else{
                return bins(arr, target, s, mid-1);
            }
        }
    }
}

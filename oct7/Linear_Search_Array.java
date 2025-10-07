package oct7;

import java.util.ArrayList;

public class Linear_Search_Array {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 3, 4};
        // ArrayList<Integer> ans = new ArrayList<>();
        System.out.println(foundiall2(arr, 2, 0));
    }
    public static boolean found(int[] arr, int target, int i){
        if(i>=arr.length){
            return false;
        }
        return arr[i]==target || found(arr, target, i+1);
    }
    public static int foundifirst(int[] arr, int target, int i){
        if(i>=arr.length){
            return -1;
        }
        if(arr[i]==target) return i;
        else return foundifirst(arr, target, i+1);
    }
    public static int foundilast(int[] arr, int target, int i){
        if(i<0){
            return -1;
        }
        if(arr[i]==target) return i;
        else return foundifirst(arr, target, i+1);
    }
    public static ArrayList<Integer> foundiall(int[] arr, int target, int i, ArrayList<Integer> al){
        if(i>=arr.length){
            return al;
        }
        if(arr[i]==target) al.add(i);
        return foundiall(arr, target, i+1, al);
    }
    public static ArrayList<Integer> foundiall2(int[] arr, int target, int i){
        ArrayList<Integer> al = new ArrayList<>();
        if(i>=arr.length){
            return al;
        }
        if(arr[i]==target) al.add(i);
        al.addAll(foundiall2(arr, target, i+1));
        return al;
    }

}

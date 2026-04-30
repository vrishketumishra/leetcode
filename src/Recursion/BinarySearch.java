package Recursion;

public class BinarySearch {
    public static void main(String[] args){
        int[] arr= {12,3,23,23,22,45,55,35,32,45};
        System.out.println(BS(arr,45,0,arr.length));
    }
    static int BS(int[] arr, int target, int s, int e){
        int m=s+(e-s)/2;
        if(arr[m]==target){
            return m;
        }
        else if(target<arr[m]){
            BS(arr,target,s,m-1);
        }
        else{
            BS(arr,target,m+1,e);
        }
        return -1;
    }
}

package BinarySearch;
public class RotatedBinarySearchII {
    public static void main(String[] args){
        int arr[]={19,19,191,1,1,1,2,3,4,5,6,7,8,9,11,15,17};
        int target=15;
        System.out.println(search(arr,target));
    }
    public static boolean search(int[] arr, int target) {
        int s=0;
        int e=arr.length-1;
        while(s<=e){
            int m=s+(e-s)/2;
            if(arr[m]==target){
                return true;
            }
            if(arr[s]==arr[m] && arr[m]==arr[e]){
                s++;
                e--;
                continue;
            }
            if(arr[s]<=arr[m]){
                if(arr[s]<=target && arr[m]>target){
                    e=m-1;
                }
                else{
                    s=m+1;
                }
            }
            else{
                if(arr[m]<=target && arr[e]>=target){
                    s=m+1;
                }
                else{
                    e=m-1;
                }
            }

        }
        return false;
    }
}

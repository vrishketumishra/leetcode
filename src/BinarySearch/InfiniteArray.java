package BinarySearch;
public class InfiniteArray {
    public static void main() {
        int[] arr={1,2,3,4,5,6,7,8,9,11,15,17};
        int target=15;
        System.out.println(ans(arr,target));


    }
    static int ans(int[] arr, int target){
        // first find the range
        // first start with a box of size 2
        int s=0;
        int e=0;
        // condition for the target to lie in the range
        while(e < arr.length &&target>arr[e]){
            int temp=e+1;// this is my new start
            // double the box value
            // end = previous end + sizeofbox*2
            e=e+(e-s+1)*2;
            s=temp;
        }
        return BinarySearch(arr,target,s,e);
    }
    static int BinarySearch(int[] arr,int target, int start, int end){
        while(start<=end){
            int mid= start + (end-start)/2;
            if(target<arr[mid]){
                end=mid-1;
            }
            else if(target>arr[mid]){
                start=mid+1;
            }
            else{
                return mid;
            }
        }
        return -1;

    }

}

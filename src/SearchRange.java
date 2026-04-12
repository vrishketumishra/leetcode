import java.util.Arrays;

public class SearchRange {
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,7,8,9,16,16,17};
        int target=16;

        int[] result = searchRange(arr,target);
        System.out.println(Arrays.toString(result));
    }

    public static int[] searchRange(int[] arr, int target) {
        int[] ans={-1,-1};
        ans[0]=search(arr,target,true);
        if(ans[0]!=-1){
            ans[1]=search(arr,target,false);
        }
        return ans;
    }

    static int search(int[] arr,int target,boolean FirstStart){
        int ans=-1;
        int s=0;
        int e=arr.length-1;

        while(s<=e){
            int mid=s+(e-s)/2;

            if(target<arr[mid]){
                e=mid-1;
            }
            else if(target>arr[mid]){
                s=mid+1;
            }
            else{
                ans=mid;
                if(FirstStart){
                    e=mid-1;
                }
                else{
                    s=mid+1;
                }
            }
        }
        return ans;
    }
}
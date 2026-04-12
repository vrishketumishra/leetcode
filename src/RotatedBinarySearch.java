public class RotatedBinarySearch {
    public static void main(String[] args){
        int arr[]={19,20,211,2,3,4,5,6,7,8,9,11,15,17};
        int target=20;
        System.out.println(RBS(arr,target));
    }
    //This function works for Non-Duplicate Array
    static int RBS(int[] nums,int target){
        int s=0;
        int e=nums.length-1;;
        while(s<=e){
            int m=s+(e-s)/2;
            if(nums[m]==target){
                return m;
            }
            if(nums[m]<=nums[e]){
                if(nums[m]<=target && nums[e]>=target){
                    s=m+1;
                }
                else{
                    e=m-1;
                }
            }
            else if(nums[s]<=nums[m]){
                if(nums[s]<=target && nums[m]>target){
                    e=m-1;
                }
                else{
                    s=m+1;
                }
            }
        }
        return -1;

    }

}

package TwoPointer_SlindingWindow;

public class MaximumPointsObtainFromCards {
    static void main() {
        int[] cardPoints = {1,2,3,4,5,6,1};
        int k=4;
        System.out.println(maxScore(cardPoints,k));
    }
    public static int maxScore(int[] nums, int k) {
        int lsum=0;
        int rsum=0;
        int maxSum=0;
        int n=nums.length;
        for(int i=0;i<=k-1;i++){
            lsum=lsum +nums[i];
            maxSum=lsum;
        }
        int rightIndex=n-1;
        for(int i=k-1;i>=0;i--){
            lsum=lsum-nums[i];
            rsum=rsum+nums[rightIndex];
            rightIndex=rightIndex-1;
            maxSum=Math.max(maxSum,lsum+rsum);
        }
        return maxSum;
    }
}

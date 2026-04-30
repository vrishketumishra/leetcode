package TwoPointer_SlindingWindow;

public class MaxConsecutiveOnes3 {
    static void main() {
        int[] arr={1,1,1,0,0,0,1,1,1,1,0};
        int k=2;
        System.out.println(longestOnes(arr,k));
    }
    public static int longestOnes(int[] arr, int k) {
        int l=0;
        int r=0;
        int zeroes=0;
        int maxLen=0;
        int len=0;
        while(r<arr.length){
            if(arr[r]==0){
                zeroes++;
            }
            while(zeroes>k){
                if(arr[l]==0){
                    zeroes--;
                }
                l++;
            }
            if(zeroes<=k){
                len=r-l+1;
                maxLen=Math.max(len,maxLen);
                r++;
            }
        }
        return maxLen;
    }
}

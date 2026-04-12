public class CeilingBS {
    public static void main() {
        int arr[]={1,2,3,4,5,6,7,8,9,11,15,17};
        int target=16;
        int ans=(Celing(arr,target));
        System.out.println(arr[ans]);
    }
    static int Celing(int[] arr,int target){
        if(target>arr[arr.length-1]){
            return -1;
        }
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
        }
        return s;
    }
}

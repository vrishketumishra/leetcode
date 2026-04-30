package BinarySearch;
public class SingleNonDuplicate {
    public static void main() {
//You are given a sorted array consisting of only integers where every element
// appears exactly twice, except for one element which appears exactly once.
//Return the single element that appears only once.
//Your solution must run in O(log n) time and O(1) space.
        int arr[]={1,1,2,3,3,4,4,8,8};
        System.out.println(singleNonDuplicateBS(arr));

    }
    static int singleNonDuplicateBS(int[] arr) {
        int s=0;
        int e=arr.length-1;
        while(s<e){
            int m=s+(e-s)/2;
            if(m%2==1){
                m--;
            }
            if(arr[m]==arr[m+1]){
                s=m+2;
            }
            else{
                e=m;
            }
        }
        return arr[s];
    }
}


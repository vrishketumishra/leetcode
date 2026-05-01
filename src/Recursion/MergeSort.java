package Recursion;

import java.util.Arrays;

public class MergeSort{
    public static void main() {
        int[] arr={4,3,2,3,100};
        arr = Merge(arr);
        System.out.println(Arrays.toString(arr));
    }
    static int[] Merge(int[] arr){
        if(arr.length==1){
            return arr;
        }
        int mid=arr.length/2;

        int[] left= Merge(Arrays.copyOfRange(arr,0,mid));
        int[] right= Merge(Arrays.copyOfRange(arr,mid,arr.length));
         return merge(left,right);
    }
    private static int[] merge(int[] first, int[] second){
        int[] mix=new int[first.length + second.length];
        int i=0;//pointer for first array
        int j=0;//pointer for second array
        int k=0;//pointer for final array
        // we are trying to for any of the array to get outof bound below here
        while(i<first.length && j< second.length){
            if(first[i]<second[j]){
                mix[k]=first[i];
                i++;
            } else{
                mix[k] = second[j];
                j++;
            }
            k++;
        }
        //it may be possible that one of the array is not complete or finished
        //copy the remaining elements
        while(i<first.length){
            mix[k]=first[i];
            i++;
            k++;
        }
        while(j<second.length) {
            mix[k] = second[j];
            j++;
            k++;
        }
        return mix;
    }
    //we can also do with index rather than using Arrays.copyofRange
}

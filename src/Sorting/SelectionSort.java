package Sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {1, 23, 2, 34, 31, 5, 4, 56};
        System.out.println(Arrays.toString(Selection(arr)));
    }
    static int[] Selection(int[] arr){
        for(int i=0;i<arr.length;i++){
            int last=arr.length-i-1;
            int maxIndex=getMaxIndex(arr,0,last);
            int temp=arr[maxIndex];
            arr[maxIndex]=arr[last];
            arr[last]=temp;
        }
        return arr;
    }
    static int getMaxIndex(int[] arr,int start,int end){
        int ans=start;
        for(int i=start;i<=end;i++){
            if(arr[ans]<arr[i]){
                ans=i;
            }
        }
        return ans;
    }
}

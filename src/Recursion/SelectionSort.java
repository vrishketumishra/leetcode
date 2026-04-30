package Recursion;

import java.util.Arrays;

public class SelectionSort {
    static void main() {
        int[] arr={4,3,2,3,10};
        Selection(arr,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    static void Selection(int[] arr, int last ){
        int Max=0;
        if(last==0){
            return;
        }
        Max=getMaxIndex(arr,last);
        swap(arr,Max,last);
        Selection(arr,last-1);
    }
    static int getMaxIndex(int[] arr, int last){
        int max=0;
        for(int i=0;i<=last;i++){
            if(arr[i]>arr[max]){
                max=i;
            }
        }
        return max;
    }
    static void swap(int[] arr, int a, int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}

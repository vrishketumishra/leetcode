package Sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args){
            int[] arr={1,23,2,34,31,5,4,56};
            System.out.println(Arrays.toString(Insertion(arr)));
    }
    public static int[] Insertion(int[] arr){
        for(int i=1;i<arr.length;i++){
            int key=arr[i];
            int j=i-1;
            while(j>=0 && arr[j]>key){
                arr[j+1]=arr[j];
                j=j-1;
            }
            arr[j+1]=key;
        }
        return arr;
    }
}

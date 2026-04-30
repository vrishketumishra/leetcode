package Sorting;

import java.util.Arrays;
//works only if elements are 1 to n
public class CyclicSort {
    public static void main(String[] args){
        int[] arr={1,5,3,4,2};
        System.out.println(Arrays.toString(cyclic(arr)));
    }
    public static int[] cyclic(int[] arr){
        int i=0;
        while(i<arr.length){
            int correct=arr[i]-1;
            if(arr[i]!=arr[correct]){
                int temp=arr[correct];
                arr[correct]=arr[i];
                arr[i]=temp;
            }
            else{
                i++;
            }
        }
        return arr;
    }
}

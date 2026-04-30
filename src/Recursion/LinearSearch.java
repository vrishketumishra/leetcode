package Recursion;

public class LinearSearch {
    static void main() {
        int[] arr={1,23,24,3,45,56,59,60,70};
        System.out.println(LS(arr,56,0));
    }
    static int LS(int[] arr, int target, int index){
        if(index==arr.length){
            return -1;
        }
        if(arr[index]==target){
            return index;
        }
//Similarly we can do for All index as well if there are many using list and giving a parameter of list in the
// function and doing "list.add();" to return the n. and function goes in with recursion
          return  LS(arr, target, index + 1);

    }

}

package Recursion;

public class Sort {
    static void main() {
        int[] arr={1,23,24,34,45,56,59,60,70};
        System.out.println(sorted(arr,0));
    }
    static boolean sorted(int[] arr,int index){
        if(index==arr.length-1){
            return true;
        }
        return arr[index]<arr[index+1] && sorted(arr,index+1);
    }

}

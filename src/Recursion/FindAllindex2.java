package Recursion;

import java.util.ArrayList;

public class FindAllindex2 {
    static void main() {
        int[] arr={1,23,24,56,3,45,56,59,60,70,56};
        System.out.println(findAllindex(arr,56,0));
    }
    static ArrayList<Integer> findAllindex(int[] arr, int target, int index){
        ArrayList<Integer> list=new ArrayList<>();
        if(index==arr.length){
            return list;
        }
        if(arr[index]==target){
            list.add(index);
        }
        ArrayList<Integer> ansfromBelowCalls= findAllindex(arr,target,index+1);
        list.addAll(ansfromBelowCalls);
        return list;
    }
}

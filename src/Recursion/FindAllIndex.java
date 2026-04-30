package Recursion;

import java.util.ArrayList;

public class FindAllIndex{
    static void main(String[] args) {
        int[] arr={1,2,3,4,5,6};
        System.out.println(findallindex2(arr,6,0));
    }
         static ArrayList<Integer> findallindex(int[] arr, int target, int index, ArrayList<Integer> list){
            if(index==arr.length){
                return list;
            }
            if(arr[index]==target){
                 list.add(index);
            }
//Similarly we can do for All index as well if there are many using list and giving a parameter of list in the
// function and doing "list.add();" to return the n. and function goes in with recursion
        return  findallindex(arr, target, index + 1,list);

    }


//**returning the list but don't take it in argument
static ArrayList<Integer> findallindex2(int[] arr, int target, int index){
    ArrayList<Integer> list=new ArrayList<>();
    if(index==arr.length){
        return list;
    }
    if(arr[index]==target){
        list.add(index);
    }
   ArrayList<Integer> ansFrimBelowCalls= findallindex2(arr, target, index + 1);
    list.addAll(ansFrimBelowCalls);
    return list;
}
}

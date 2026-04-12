    public class helloworld {
    public static void main(String[] args) {
        int[] arr = {2, 5, 4, 3, 1};

        cyclic(arr);

        for (int num : arr) {
            System.out.print(num + " ");
        }


    }

    static void bubble(int[] arr) {
        //run the step n-1 times
        for (int i = 0; i < arr.length; i++) {
            boolean swapped = false;
            //for each step max item will come at the lastindex;
            for (int j = 1; j < arr.length - i; j++) {
                //swap if it is smaller than previous
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }

    }

    static void selection(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            //find the max in remaining and swap with correct
            int last = arr.length - i - 1;
            int maxIndex = getMaxIndex(arr, 0, last);
            swap(arr,maxIndex,last);
        }
    }

    static int getMaxIndex(int[] arr, int start, int end) {
        int max = start;
        for (int i = start; i <= end; i++) {
            if (arr[max] < arr[i]) {
                max = i;
            }
        }
        return max;
    }

    static void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
    static void insertion(int[] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=i;j>0;j--){
                if(arr[j]<arr[j-1]){
                    swap(arr,j,j-1);
                }
                else{
                    break;
                }
            }
        }
    }
    static void cyclic(int[] arr){
        int i=0;
        while(i<arr.length){
            int correct=arr[i]-1;
            if(arr[i]!=arr[correct]){
                swap(arr,i,correct);
            }
            else{
                i++;
            }
        }
    }
}
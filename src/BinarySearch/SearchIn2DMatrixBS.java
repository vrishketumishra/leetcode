package BinarySearch;
//You are given an m x n integer matrix, matrix with the following two properties:
//Each row is sorted in non-decreasing order.
//The first integer of each row is greater than the last integer of the previous row.
public class SearchIn2DMatrixBS {
    public static void main() {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int target=30;
        System.out.println(searchMatrix(matrix,target));
    }
    static public boolean searchMatrix(int[][] matrix, int target) {
        int s=0;
        int n=matrix.length;
        int m=matrix[0].length;
        int e=n*m-1;
        while(s<=e){
            int mid=s+(e-s)/2;
            int row=mid/m;
            int col=mid%m;
            if(matrix[row][col]==target){
                return true;
            }
            else if(matrix[row][col]<target){
                s=mid+1;
            }
            else{
                e=mid-1;
            }

        }
        return false;
    }
}

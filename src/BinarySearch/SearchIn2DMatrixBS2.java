package BinarySearch;
//240
//Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix.
// This matrix has the following properties:
//Integers in each row are sorted in ascending from left to right.
//Integers in each column are sorted in ascending from top to bottom.
public class SearchIn2DMatrixBS2 {
    public static void main(String[] args) {
       int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
       int target = 13;
        System.out.println(searchMatrix(matrix,target));
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
 if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        int m = matrix[0].length;
        int n = matrix.length;
        int row = 0;
        int col = m - 1;
        while (row < n && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }
}

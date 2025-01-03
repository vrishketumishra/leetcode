class Solution832 {
    public int[][] flipAndInvertImage(int[][] image) {
        for (int[] row : image) {
            int i = 0, j = row.length - 1;
            while (i <= j) {
                if (row[i] == row[j]) {
                    row[i] ^= 1;
                    row[j] ^= 1;
                }
                i++;
                j--;
            }
        }
        return image;
    }
}
{
}

// Problem: https://leetcode.com/problems/image-smoother/
class Solution {
    public int applySmoother(int[][] img, int row, int col) {
        int n = img.length, m = img[0].length;
        int sum = 0;
        int cnt = 0;
        
        for(int i = -1; i <= 1; i++) {
            for(int j = -1; j <= 1; j++) {
                int newRow = row + i;
                int newCol = col + j;
                
                // If within the boundaries, add it to the sum.
                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m){
                    sum += img[newRow][newCol];
                    cnt++;
                }
            }
        }

        return (int)Math.floor((double)sum / cnt);
    }

    public int[][] imageSmoother(int[][] img) {
        int n = img.length, m = img[0].length;
        int res[][] = new int[n][m];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                res[i][j] = applySmoother(img, i, j);
            }
        }

        return res;
    }
}

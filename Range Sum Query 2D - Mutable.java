public class NumMatrix {

    // for each row, store sum of num[row][0] - num[row][i]
    private int[][] rowSum;
    
    public NumMatrix(int[][] matrix) {
        if (matrix.length != 0 && matrix[0].length != 0) {
            rowSum = new int[matrix.length][matrix[0].length];
            for (int i = 0; i < matrix.length; i++) {
                int sum = 0;
                for (int j = 0; j < matrix[0].length; j++) {
                    sum += matrix[i][j];
                    rowSum[i][j] = sum;
                }
            }
        }
    }

    public void update(int row, int col, int val) {
        // influence all sum in row and after col
        int pre = col > 0 ? rowSum[row][col] - rowSum[row][col - 1] : rowSum[row][col];
        for (int j = col; j < rowSum[0].length; j++) {
            rowSum[row][j] += val - pre;
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        // for each row, sum(col1, col2) = sum(0, col2) - sum(0, col1 - 1)
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            sum += rowSum[i][col2];
            if (col1 > 0) {
                sum -= rowSum[i][col1 - 1];
            }
        }
        return sum;
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.update(1, 1, 10);
// numMatrix.sumRegion(1, 2, 3, 4);

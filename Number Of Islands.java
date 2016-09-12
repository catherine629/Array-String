public class Solution {
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int island = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    island++;
                    processIsland(grid, i, j);
                }
            }
        }
        return island;
    }
    private void processIsland(char[][] grid, int i, int j) {
        grid[i][j] = '0';
        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        for (int[] dire: directions) {
            if (i + dire[0] < grid.length && i + dire[0] >= 0 &&
                j + dire[1] < grid[0].length && j + dire[1] >= 0 &&
                grid[i+dire[0]][j+dire[1]] == '1') {
                processIsland(grid, i + dire[0], j + dire[1]);
            }
        }
    }
}

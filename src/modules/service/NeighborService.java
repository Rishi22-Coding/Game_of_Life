package modules.service;

public class NeighborService {
  // Directions for 8 possible neighbors
  private static final int[] dRow = {0, 0, -1, 1, -1, 1, -1, 1};
  private static final int[] dCol = {1, -1, 0, 0, 1, -1, -1, 1};

  public int countLiveNeighbors(int[][] grid, int row, int col) {
    int count = 0;
    int rows = grid.length;
    int cols = grid[0].length;

    // Check all 8 possible neighbors
    for (int i = 0; i < 8; i++) {
      int newRow = row + dRow[i];
      int newCol = col + dCol[i];
      if (isValidNeighbor(newRow, newCol, rows, cols) && Math.abs(grid[newRow][newCol]) == 1) {
        count++;
      }
    }
    return count;
  }

  private boolean isValidNeighbor(int row, int col, int rows, int cols) {
    return row >= 0 && row < rows && col >= 0 && col < cols;
  }
}

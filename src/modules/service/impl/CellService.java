package modules.service.impl;

import modules.service.ICellService;

public class CellService implements ICellService {
  public int getCellState(int[][] grid, int row, int col) {
    return grid[row][col];
  }

  public void setCellState(int[][] grid, int row, int col, int state) {
    grid[row][col] = state;
  }

  public int updateCellState(int liveNeighbors, int currentState) {
    if ((liveNeighbors > 3 || liveNeighbors < 2) && currentState == 1) {
      // Cell dies
      return -1;
    }
    if (liveNeighbors == 3 && currentState == 0) {
      // Cell becomes alive
      return 2;
    }
    // No change
    return currentState;
  }

  public int finalizeCellState(int cellState) {
    // Alive
    if (cellState >= 1) return 1;

    // Dead
    if (cellState == -1) return 0;

    // No change
    return cellState;
  }
}

package modules.service.impl;

import modules.service.ICellService;
import modules.service.IGridService;
import modules.service.INeighborService;

public class GridService implements IGridService {
  private final INeighborService neighborService;
  private final ICellService cellService;
  private int[][] grid;

  public GridService(INeighborService neighborService, ICellService cellService) {
    this.neighborService = neighborService;
    this.cellService = cellService;
  }

  public int[][] getGrid() {
    return grid;
  }

  public void setGrid(int[][] newGrid) {
    this.grid = newGrid;
  }

  public void updateGrid(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;

    // First pass: mark cells for the next state
    for (int row = 0; row < n; row++) {
      for (int col = 0; col < m; col++) {
        int liveNeighbors = neighborService.countLiveNeighbors(grid, row, col);

        int currentState = cellService.getCellState(grid, row, col);
        int newState = cellService.updateCellState(liveNeighbors, currentState);

        cellService.setCellState(grid, row, col, newState);
      }
    }

    // Finalize the cell states (if needed)
    for (int row = 0; row < n; row++) {
      for (int col = 0; col < m; col++) {
        int finalizedState = cellService.finalizeCellState(grid[row][col]);
        cellService.setCellState(grid, row, col, finalizedState);
      }
    }
  }

  public boolean validateGrid(int[][] actualGrid, int[][] expectedGrid) {
    if (actualGrid.length != expectedGrid.length || actualGrid[0].length != expectedGrid[0].length) {
      return false;
    }

    for (int i = 0; i < actualGrid.length; i++) {
      for (int j = 0; j < actualGrid[i].length; j++) {
        if (actualGrid[i][j] != expectedGrid[i][j]) {
          return false;
        }
      }
    }
    return true;
  }
}

package modules.service;

public class GridService {
  private final NeighborService neighborService;
  private final CellService cellService;

  public GridService(NeighborService neighborService, CellService cellService) {
    this.neighborService = neighborService;
    this.cellService = cellService;
  }

  public void updateGrid(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;

    // First pass: mark cells for next state
    for (int row = 0; row < n; row++) {
      for (int col = 0; col < m; col++) {
        int liveNeighbors = neighborService.countLiveNeighbors(grid, row, col);
        grid[row][col] = cellService.updateCellState(liveNeighbors, grid[row][col]);
      }
    }

    // Second pass: finalize cell states
    for (int row = 0; row < n; row++) {
      for (int col = 0; col < m; col++) {
        grid[row][col] = cellService.finalizeCellState(grid[row][col]);
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

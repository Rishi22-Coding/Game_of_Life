package modules.model;

public class Grid {
  private final Cell[][] cells;

  public Grid(int rows, int cols) {
    cells = new Cell[rows][cols];
  }

  public Cell[][] getCells() {
    return cells;
  }

  public void setCell(int row, int col, Cell cell) {
    cells[row][col] = cell;
  }
}

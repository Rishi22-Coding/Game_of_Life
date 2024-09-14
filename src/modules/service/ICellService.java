package modules.service;

public interface ICellService {
    int getCellState(int[][] grid, int row, int col);
    void setCellState(int[][] grid, int row, int col, int state);
    int updateCellState(int liveNeighbors, int currentState);
    int finalizeCellState(int cellState);
}

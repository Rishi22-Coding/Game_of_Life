package modules.service;

public interface IGridService {
    int[][] getGrid();
    void setGrid(int[][] newGrid);
    void updateGrid(int[][] grid);
    boolean validateGrid(int[][] actualGrid, int[][] expectedGrid);
}

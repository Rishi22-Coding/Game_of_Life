package modules.service;

public interface IGridService {
    void updateGrid(int[][] grid);
    boolean validateGrid(int[][] actualGrid, int[][] expectedGrid);
}

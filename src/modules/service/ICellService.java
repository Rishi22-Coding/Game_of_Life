package modules.service;

public interface ICellService {
    int updateCellState(int liveNeighbors, int currentState);
    int finalizeCellState(int cellState);
}

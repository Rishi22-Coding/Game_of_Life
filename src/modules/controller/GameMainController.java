package modules.controller;

import modules.common.IInputReader;
import modules.common.IOutputWriter;
import modules.service.IGridService;

public class GameMainController {
    private final IGridService gridService;
    private final IOutputWriter outputWriter;
    private final IInputReader inputReader;

    public GameMainController(IGridService gridService, IOutputWriter outputWriter, IInputReader inputReader) {
        this.gridService = gridService;
        this.outputWriter = outputWriter;
        this.inputReader = inputReader;
    }

    public void startGame() {
        int[][] grid = inputReader.readGrid();

        // initial
        System.out.println("Initial Grid:");
        outputWriter.printGrid(grid);

        // logic
        gridService.updateGrid(grid);
        System.out.println("Grid after 1 tick:");
        outputWriter.printGrid(grid);

        // end
        System.out.println("Game Over!");
    }
}

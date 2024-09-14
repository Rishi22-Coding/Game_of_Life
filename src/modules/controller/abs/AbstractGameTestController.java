package modules.controller.abs;

import modules.common.IOutputWriter;
import modules.service.IGridService;

public abstract class AbstractGameTestController {
    protected final IOutputWriter outputWriter;
    protected final IGridService gridService;

    public AbstractGameTestController(IOutputWriter outputWriter, IGridService gridService) {
        this.outputWriter = outputWriter;
        this.gridService = gridService;
    }

    // Non-static common method to run pattern tests
    protected void runPatternTest(String testName, int[][] initialGrid, int[][] expectedGrid) {
        System.out.println("\nRunning test: " + testName);

        // Set the initial grid
        gridService.setGrid(initialGrid);

        // Print the initial grid
        System.out.println("Initial Grid:");
        outputWriter.printGrid(initialGrid);

        // Update the grid using GridService
        gridService.updateGrid(initialGrid);

        // Fetch the updated grid from GridService
        int[][] updatedGrid = gridService.getGrid();

        // Check the result
        System.out.println("Grid after 1 tick:");
        outputWriter.printGrid(updatedGrid);

        // Validate the output
        if (gridService.validateGrid(updatedGrid, expectedGrid)) {
            System.out.println(testName + " PASSED");
        } else {
            System.out.println(testName + " FAILED");
        }
    }

    // Abstract method to be implemented by subclasses
    public abstract void runAllTests();
}

package modules.controller.abs;

import modules.common.output.IOutputWriter;
import modules.service.IGridService;

public abstract class AbstractGameTestController {
    protected final IOutputWriter outputWriter;
    protected final IGridService gridService;

    public AbstractGameTestController(IOutputWriter outputWriter, IGridService gridService) {
        this.outputWriter = outputWriter;
        this.gridService = gridService;
    }

    // Non-static common method to run pattern tests
    protected void runPatternTest(String testName, int[][] grid, int[][] expectedGrid) {
        System.out.println("\nRunning test: " + testName);
        System.out.println("Initial Grid:");
        outputWriter.printGrid(grid);

        // Update the grid using GridService
        gridService.updateGrid(grid);

        // Check the result
        System.out.println("Grid after 1 tick:");
        outputWriter.printGrid(grid);

        // Validate the output
        if (gridService.validateGrid(grid, expectedGrid)) {
            System.out.println(testName + " PASSED");
        } else {
            System.out.println(testName + " FAILED");
        }
    }

    // Abstract method to be implemented by subclasses
    public abstract void runAllTests();
}

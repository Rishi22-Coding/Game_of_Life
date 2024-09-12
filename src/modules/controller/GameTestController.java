package modules.controller;

import modules.common.output.OutputWriter;
import modules.service.GridService;

public class GameTestController {
  private final OutputWriter outputWriter;
  private final GridService gridService;

  public GameTestController(OutputWriter outputWriter, GridService gridService) {
    this.outputWriter = outputWriter;
    this.gridService = gridService;
  }

  // Run all test cases
  public void runAllTests() {
    runBlockPatternTest();
    runBoatPatternTest();
    runBlinkerPatternTest();
    runToadPatternTest();
  }

  // Test 1: Block Pattern (Still life)
  public void runBlockPatternTest() {
    int[][] grid = {
        {0, 0, 0},
        {0, 1, 1},
        {0, 1, 1}
    };

    int[][] expectedGrid = {
        {0, 0, 0},
        {0, 1, 1},
        {0, 1, 1}
    };

    runTest("Block Pattern (Still Life)", grid, expectedGrid);
  }

  // Test 2: Boat Pattern (Still life)
  public void runBoatPatternTest() {
    int[][] grid = {
        {0, 1, 1},
        {1, 0, 1},
        {0, 1, 0}
    };

    int[][] expectedGrid = {
        {0, 1, 1},
        {1, 0, 1},
        {0, 1, 0}
    };

    runTest("Boat Pattern (Still Life)", grid, expectedGrid);
  }

  // Test 3: Blinker Pattern (Oscillator)
  public void runBlinkerPatternTest() {
    int[][] grid = {
        {0, 0, 0},
        {1, 1, 1},
        {0, 0, 0}
    };

    int[][] expectedGrid = {
        {0, 1, 0},
        {0, 1, 0},
        {0, 1, 0}
    };

    runTest("Blinker Pattern (Oscillator)", grid, expectedGrid);
  }

  // Test 4: Toad Pattern (Two-Phase Oscillator)
  public void runToadPatternTest() {
    int[][] grid = {
        {0, 0, 0, 0, 0},
        {0, 1, 1, 1, 0},
        {0, 0, 1, 1, 1},
        {0, 0, 0, 0, 0}
    };

    int[][] expectedGrid = {
        {0, 0, 1, 0, 0},
        {0, 1, 0, 0, 1},
        {0, 1, 0, 0, 1},
        {0, 0, 0, 1, 0}
    };

    runTest("Toad Pattern (Two-Phase Oscillator)", grid, expectedGrid);
  }

  // Helper method to run a single test case
  private void runTest(String testName, int[][] initialGrid, int[][] expectedGrid) {
    System.out.println("\nRunning test: " + testName);
    System.out.println("Initial Grid:");
    outputWriter.printGrid(initialGrid);

    // Update the grid using the GridService
    gridService.updateGrid(initialGrid);

    // Check the result
    System.out.println("Grid after 1 tick:");
    outputWriter.printGrid(initialGrid);

    // Validate the output
    if (gridService.validateGrid(initialGrid, expectedGrid)) {
      System.out.println(testName + " PASSED");
    } else {
      System.out.println(testName + " FAILED");
    }
  }
}

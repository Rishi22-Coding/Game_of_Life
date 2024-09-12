package modules.common.output.impl;

import modules.common.output.IOutputWriter;

public class OutputWriter implements IOutputWriter {
  public void printGrid(int[][] grid) {
    for (int[] row : grid) {
      for (int cell : row) {
        System.out.print(cell + " ");
      }
      System.out.println();
    }
  }
}

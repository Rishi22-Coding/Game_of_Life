package modules.common.impl;

import modules.common.IOutputWriter;

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

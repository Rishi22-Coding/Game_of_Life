package modules.common.output;

public class OutputWriter {
  public void printGrid(int[][] grid) {
    for (int[] row : grid) {
      for (int cell : row) {
        System.out.print(cell + " ");
      }
      System.out.println();
    }
  }
}

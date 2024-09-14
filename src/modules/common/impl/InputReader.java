package modules.common.impl;

import modules.common.IInputReader;

import java.util.Scanner;

public class InputReader implements IInputReader {
    public int[][] readGrid() {
        Scanner scanner = new Scanner(System.in);

        // Get grid size from the user
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of columns:");
        int cols = scanner.nextInt();

        int[][] grid = new int[rows][cols];

        // Get initial grid configuration
        System.out.println("Enter the initial configuration (0 for dead, 1 for alive):");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.println("Cell (" + i + "," + j + "):");
                grid[i][j] = scanner.nextInt();
            }
        }

        return grid;
    }
}

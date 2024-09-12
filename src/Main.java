import modules.common.output.OutputWriter;
import modules.controller.GameTestController;
import modules.service.GridService;
import modules.service.CellService;
import modules.service.NeighborService;

public class Main {
  public static void main(String[] args) {
    System.out.println("Welcome to the Game of Life!");

    OutputWriter outputWriter = new OutputWriter();
    NeighborService neighborService = new NeighborService();
    CellService cellService = new CellService();
    GridService gridService = new GridService(neighborService, cellService);

    GameTestController gameController = new GameTestController(outputWriter, gridService);
    gameController.runAllTests();
  }
}
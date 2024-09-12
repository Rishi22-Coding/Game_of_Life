import modules.common.output.IOutputWriter;
import modules.common.output.impl.OutputWriter;
import modules.controller.GameTestController;
import modules.service.ICellService;
import modules.service.IGridService;
import modules.service.INeighborService;
import modules.service.impl.GridService;
import modules.service.impl.CellService;
import modules.service.impl.NeighborService;

public class Main {
  public static void main(String[] args) {
    System.out.println("Welcome to the Game of Life!");

    IOutputWriter outputWriter = new OutputWriter();
    INeighborService neighborService = new NeighborService();
    ICellService cellService = new CellService();
    IGridService gridService = new GridService(neighborService, cellService);

    GameTestController gameController = new GameTestController(outputWriter, gridService);
    gameController.runAllTests();
  }
}
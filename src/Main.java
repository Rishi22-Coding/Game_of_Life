import modules.common.IInputReader;
import modules.common.IOutputWriter;
import modules.common.impl.InputReader;
import modules.common.impl.OutputWriter;
import modules.controller.GameMainController;
import modules.service.ICellService;
import modules.service.IGridService;
import modules.service.INeighborService;
import modules.service.impl.GridService;
import modules.service.impl.CellService;
import modules.service.impl.NeighborService;

public class Main {
  public static void main(String[] args) {
    IOutputWriter outputWriter = new OutputWriter();
    INeighborService neighborService = new NeighborService();
    ICellService cellService = new CellService();
    IGridService gridService = new GridService(neighborService, cellService);
    IInputReader inputReader = new InputReader();

    // Instantiate the main controller with the input reader
    GameMainController gameMainController = new GameMainController(gridService, outputWriter, inputReader);

    // Start the game
    gameMainController.startGame();
  }
}
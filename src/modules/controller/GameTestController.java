package modules.controller;

import modules.common.output.IOutputWriter;
import modules.controller.abs.AbstractGameTestController;
import modules.service.IGridService;

public class GameTestController extends AbstractGameTestController {

    public GameTestController(IOutputWriter outputWriter, IGridService gridService) {
        super(outputWriter, gridService);
    }

    @Override
    public void runAllTests() {
        runPatternTest("Block Pattern (Still Life)",
                new int[][]{
                        {0, 0, 0},
                        {0, 1, 1},
                        {0, 1, 1}
                },
                new int[][]{
                        {0, 0, 0},
                        {0, 1, 1},
                        {0, 1, 1}
                }
        );

        runPatternTest("Boat Pattern (Still Life)",
                new int[][]{
                        {0, 1, 1},
                        {1, 0, 1},
                        {0, 1, 0}
                },
                new int[][]{
                        {0, 1, 1},
                        {1, 0, 1},
                        {0, 1, 0}
                }
        );

        runPatternTest("Blinker Pattern (Oscillator)",
                new int[][]{
                        {0, 0, 0},
                        {1, 1, 1},
                        {0, 0, 0}
                },
                new int[][]{
                        {0, 1, 0},
                        {0, 1, 0},
                        {0, 1, 0}
                }
        );

        runPatternTest("Toad Pattern (Two-Phase Oscillator)",
                new int[][]{
                        {0, 0, 0, 0, 0},
                        {0, 1, 1, 1, 0},
                        {0, 0, 1, 1, 1},
                        {0, 0, 0, 0, 0}
                },
                new int[][]{
                        {0, 0, 1, 0, 0},
                        {0, 1, 0, 0, 1},
                        {0, 1, 0, 0, 1},
                        {0, 0, 0, 1, 0}
                }
        );
    }
}
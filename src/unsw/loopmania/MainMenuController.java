package unsw.loopmania;

import java.io.IOException;
import javafx.fxml.FXML;

/**
 * controller for the main menu.
 * TODO = you could extend this, for example with a settings menu, or a menu to load particular maps.
 */
public class MainMenuController {
    private LoopManiaWorldController loopManiaWorldController;
    public MainMenuController(LoopManiaWorldController loopManiaWorldController) {
        this.loopManiaWorldController = loopManiaWorldController;
    }

    /**
     * facilitates switching to main game
     */
    private MenuSwitcher gameSwitcher;

    public void setGameSwitcher(MenuSwitcher gameSwitcher){
        this.gameSwitcher = gameSwitcher;
    }

    /**
     * facilitates switching to main game upon button click
     * @throws IOException
     */
    @FXML
    private void switchToStandard() throws IOException {
        loopManiaWorldController.setGameMode("standard");
        gameSwitcher.switchMenu();
    }

    /**
     * facilitates switching to main game upon button click
     * @throws IOException
     */
    @FXML
    private void switchToSurvival() throws IOException {
        loopManiaWorldController.setGameMode("survival");
        gameSwitcher.switchMenu();
    }

    /**
     * facilitates switching to main game upon button click
     * @throws IOException
     */
    @FXML
    private void switchToBerserker() throws IOException {
        loopManiaWorldController.setGameMode("berserker");
        gameSwitcher.switchMenu();
    }
}

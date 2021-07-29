package unsw.loopmania;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ShopController {

    private MenuSwitcher gameSwitcher;

    public void setGameSwitcher(MenuSwitcher gameSwitcher) {
        this.gameSwitcher = gameSwitcher;
    }

    @FXML
    private Button returnButton;

    @FXML
    void handleReturnButton(ActionEvent event) {
        gameSwitcher.switchMenu();
    }

}

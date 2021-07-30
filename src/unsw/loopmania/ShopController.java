package unsw.loopmania;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ShopController {
    private MenuSwitcher gameSwitcher;
    private LoopManiaWorldController loopManiaWorldController;
    public ShopController(LoopManiaWorldController loopManiaWorldController) {
        this.loopManiaWorldController = loopManiaWorldController;
    }

    public void setGameSwitcher(MenuSwitcher gameSwitcher) {
        this.gameSwitcher = gameSwitcher;
    }

    @FXML
    private Button returnButton;

    @FXML
    void handleReturnButton(ActionEvent event) {
        gameSwitcher.switchMenu();
    }
    
    @FXML
    void purchaseSword(ActionEvent event) {
        loopManiaWorldController.purchaseItem(0);
    }

    @FXML
    void purchaseStake(ActionEvent event) {
        loopManiaWorldController.purchaseItem(1);
    }

    @FXML
    void purchaseStaff(ActionEvent event) {
        loopManiaWorldController.purchaseItem(2);
    }

    @FXML
    void purchaseArmour(ActionEvent event) {
        loopManiaWorldController.purchaseItem(3);
    }

    @FXML
    void purchaseShield(ActionEvent event) {
        loopManiaWorldController.purchaseItem(4);
    }

    @FXML
    void purchaseHelmet(ActionEvent event) {
        loopManiaWorldController.purchaseItem(5);
    }

    @FXML
    void purchasePotion(ActionEvent event) {
        loopManiaWorldController.purchaseItem(6);
    }
}

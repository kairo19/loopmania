package unsw.loopmania;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.util.converter.NumberStringConverter;

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
    private Text insufficientFunds;

    @FXML
    void handleReturnButton(ActionEvent event) {
        gameSwitcher.switchMenu();
    }
    
    @FXML
    void purchaseSword(ActionEvent event) {
        loopManiaWorldController.purchaseItem(0, this);
    }

    @FXML
    void purchaseStake(ActionEvent event) {
        loopManiaWorldController.purchaseItem(1, this);
    }

    @FXML
    void purchaseStaff(ActionEvent event) {
        loopManiaWorldController.purchaseItem(2, this);
    }

    @FXML
    void purchaseArmour(ActionEvent event) {
        loopManiaWorldController.purchaseItem(3, this);
    }

    @FXML
    void purchaseShield(ActionEvent event) {
        loopManiaWorldController.purchaseItem(4, this);
    }

    @FXML
    void purchaseHelmet(ActionEvent event) {
        loopManiaWorldController.purchaseItem(5, this);
    }

    @FXML
    void purchasePotion(ActionEvent event) {
        loopManiaWorldController.purchaseItem(6, this);
    }

    public Text getInsufficientFunds() {
        return insufficientFunds;
    }
}

package unsw.loopmania;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class ShopController {
    private MenuSwitcher gameSwitcher;
    private MenuSwitcher shopSwitcher;
    private LoopManiaWorldController loopManiaWorldController;

    public ShopController(LoopManiaWorldController loopManiaWorldController) {
        this.loopManiaWorldController = loopManiaWorldController;
    }

    public void setGameSwitcher(MenuSwitcher gameSwitcher) {
        this.gameSwitcher = gameSwitcher;
    }

    public void setShopSwitcher(MenuSwitcher shopSwitcher) {
        this.shopSwitcher = shopSwitcher;
    }

    @FXML
    private Text warningText;

    @FXML
    void handleReturnButton(ActionEvent event) {
        gameSwitcher.switchMenu();
    }

    @FXML
    void goToSellShop(ActionEvent event) {
        loopManiaWorldController.getLoopManiaWorld().updateSellingItems();
        shopSwitcher.switchMenu();
    }
    
    @FXML
    void purchaseSword(ActionEvent event) {
        warningText.setVisible(false);
        loopManiaWorldController.purchaseItem(0, this);
        loopManiaWorldController.getLoopManiaWorld().updateSellingItems();
    }

    @FXML
    void purchaseStake(ActionEvent event) {
        warningText.setVisible(false);
        loopManiaWorldController.purchaseItem(1, this);
    }

    @FXML
    void purchaseStaff(ActionEvent event) {
        warningText.setVisible(false);
        loopManiaWorldController.purchaseItem(2, this);
    }

    @FXML
    void purchaseArmour(ActionEvent event) {
        warningText.setVisible(false);
        loopManiaWorldController.purchaseItem(3, this);
    }

    @FXML
    void purchaseShield(ActionEvent event) {
        warningText.setVisible(false);
        loopManiaWorldController.purchaseItem(4, this);
    }

    @FXML
    void purchaseHelmet(ActionEvent event) {
        warningText.setVisible(false);

        loopManiaWorldController.purchaseItem(5, this);
    }

    @FXML
    void purchasePotion(ActionEvent event) {
        warningText.setVisible(false);
        loopManiaWorldController.purchaseItem(6, this);
    }

    public Text getWarningText() {
        return warningText;
    }
}

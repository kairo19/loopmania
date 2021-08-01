package unsw.loopmania;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.util.converter.NumberStringConverter;

public class ShopSellController {
    private MenuSwitcher shopSwitcher;
    private MenuSwitcher gameSwitcher;
    private LoopManiaWorldController loopManiaWorldController;

    public ShopSellController(LoopManiaWorldController loopManiaWorldController) {
        this.loopManiaWorldController = loopManiaWorldController;
    }

    public void setShopSwitcher(MenuSwitcher shopSwitcher) {
        this.shopSwitcher = shopSwitcher;
    }

    public void setGameSwitcher(MenuSwitcher gameSwitcher) {
        this.gameSwitcher = gameSwitcher;
    }

    private LoopManiaWorld getLoopManiaWorld() {
        return loopManiaWorldController.getLoopManiaWorld();
    }

    @FXML
    private Text nSwords;

    @FXML
    private Text nStakes;

    @FXML
    private Text nStaffs;

    @FXML
    private Text nArmours;

    @FXML
    private Text nShields;

    @FXML
    private Text nHelmets;

    @FXML
    private Text nPotions;

    @FXML
    public void returnToLMA(ActionEvent event) {
        gameSwitcher.switchMenu();
    }

    @FXML
    public void returnToShop(ActionEvent event) {
        shopSwitcher.switchMenu();
    }

    @FXML
    public void sellArmour(ActionEvent event) {

    }

    @FXML
    public void sellHelmet(ActionEvent event) {

    }

    @FXML
    public void sellPotion(ActionEvent event) {

    }

    @FXML
    public void sellShield(ActionEvent event) {

    }

    @FXML
    public void sellStaff(ActionEvent event) {

    }

    @FXML
    public void sellStake(ActionEvent event) {

    }

    @FXML
    public void sellSword(ActionEvent event) {
        // decrease counter value by 1 
        getLoopManiaWorld().sellSword();
        // remove from inventory
    }

    @FXML
    public void initialize() {
        nSwords.textProperty().bindBidirectional(getLoopManiaWorld().getnSwords(), new NumberStringConverter());
    }
}

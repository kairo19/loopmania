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
        getLoopManiaWorld().sellArmour();

    }

    @FXML
    public void sellHelmet(ActionEvent event) {

        getLoopManiaWorld().sellHelmet();
    }

    @FXML
    public void sellPotion(ActionEvent event) {
        getLoopManiaWorld().sellPotion();

    }

    @FXML
    public void sellShield(ActionEvent event) {
        getLoopManiaWorld().sellShield();

    }

    @FXML
    public void sellStaff(ActionEvent event) {
        getLoopManiaWorld().sellStaff();

    }

    @FXML
    public void sellStake(ActionEvent event) {
        getLoopManiaWorld().sellStake();

    }

    @FXML
    public void sellSword(ActionEvent event) {
        // decrease counter value by 1 
        getLoopManiaWorld().sellSword();
        // remove from inventory
        getLoopManiaWorld().removeItemByTypeInUnequippedInventoryItems("Sword");
    }

    @FXML
    public void initialize() {
        nSwords.textProperty().bindBidirectional(getLoopManiaWorld().getnSwords(), new NumberStringConverter());
        nStakes.textProperty().bindBidirectional(getLoopManiaWorld().getnStakes(), new NumberStringConverter());
        nStaffs.textProperty().bindBidirectional(getLoopManiaWorld().getnStaffs(), new NumberStringConverter());
        nArmours.textProperty().bindBidirectional(getLoopManiaWorld().getnArmours(), new NumberStringConverter());
        nShields.textProperty().bindBidirectional(getLoopManiaWorld().getnShields(), new NumberStringConverter());
        nHelmets.textProperty().bindBidirectional(getLoopManiaWorld().getnHelmets(), new NumberStringConverter());
        nPotions.textProperty().bindBidirectional(getLoopManiaWorld().getnPotions(), new NumberStringConverter());
    }
}

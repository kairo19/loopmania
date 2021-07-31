package unsw.loopmania;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class ShopSellController {
    MenuSwitcher shopSwitcher;
    MenuSwitcher gameSwitcher;

    public void setShopSwitcher(MenuSwitcher shopSwitcher) {
        this.shopSwitcher = shopSwitcher;
    }

    public void setGameSwitcher(MenuSwitcher gameSwitcher) {
        this.gameSwitcher = gameSwitcher;
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
    void returnToLMA(ActionEvent event) {
        gameSwitcher.switchMenu();
    }

    @FXML
    void returnToShop(ActionEvent event) {
        shopSwitcher.switchMenu();
    }

    @FXML
    void sellArmour(ActionEvent event) {

    }

    @FXML
    void sellHelmet(ActionEvent event) {

    }

    @FXML
    void sellPotion(ActionEvent event) {

    }

    @FXML
    void sellShield(ActionEvent event) {

    }

    @FXML
    void sellStaff(ActionEvent event) {

    }

    @FXML
    void sellStake(ActionEvent event) {

    }

    @FXML
    void sellSword(ActionEvent event) {

    }

}

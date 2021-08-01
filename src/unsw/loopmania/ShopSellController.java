package unsw.loopmania;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.converter.NumberStringConverter;
import javafx.util.Duration;


public class ShopSellController {
    private MenuSwitcher shopSwitcher;
    private MenuSwitcher gameSwitcher;
    private LoopManiaWorldController loopManiaWorldController;
    
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
    private Text statusText;
    @FXML
    private Text currentGold;
    @FXML
    private Text dogeCoinValue;
    @FXML
    private VBox helpMenu;
    @FXML
    private VBox dogeCoinContainer;

    /**
     * Creates controller of ShopSellView.
     * @param loopManiaWorldController Main controller of game.
     */
    public ShopSellController(LoopManiaWorldController loopManiaWorldController) {
        this.loopManiaWorldController = loopManiaWorldController;
    }

    /**
     * @param shopSwitcher Switcher that alternates from shopview and shopsellview.
     */
    public void setShopSwitcher(MenuSwitcher shopSwitcher) {
        this.shopSwitcher = shopSwitcher;
    }

    /**
     * @param gameSwitcher Switcher that alternates from shopsellview and lmw view
     */
    public void setGameSwitcher(MenuSwitcher gameSwitcher) {
        this.gameSwitcher = gameSwitcher;
    }

    private LoopManiaWorld getLoopManiaWorld() {
        return loopManiaWorldController.getLoopManiaWorld();
    }

    /**
     * Method is triggered when button clicked to go to lmw view.
     * @param event 
     */
    @FXML
    public void returnToLMA(ActionEvent event) {
        gameSwitcher.switchMenu();
    }

    /**
     * Method is triggered when button clicked to go back to shopview.
     * @param event 
     */
    @FXML
    public void returnToShop(ActionEvent event) {
        shopSwitcher.switchMenu();
    }

    /**
     * Checks for available armour in unequipped inventory.
     * If exists, latest armour entity is removed from unequipped inventory.
     * If not, a warning text appears.
     * @param event
     */
    @FXML
    public void sellArmour(ActionEvent event) {
        if (getLoopManiaWorld().getnArmours().get() != 0) {
            getLoopManiaWorld().sellArmour();
            getLoopManiaWorld().removeItemByTypeInUnequippedInventoryItems("Armour");
        } else {
            displayWarningText();
        }

    }

    /**
     * Checks for available helmet in unequipped inventory.
     * If exists, latest helmet entity is removed from unequipped inventory.
     * If not, a warning text appears.
     * @param event
     */
    @FXML
    public void sellHelmet(ActionEvent event) {
        if (getLoopManiaWorld().getnHelmets().get() != 0) {
            getLoopManiaWorld().sellHelmet();
            getLoopManiaWorld().removeItemByTypeInUnequippedInventoryItems("Helmet");
        } else {
            displayWarningText();
        }
    }

    /**
     * Checks for available potion in unequipped inventory.
     * If exists, latest potion entity is removed from unequipped inventory.
     * If not, a warning text appears.
     * @param event
     */
    @FXML
    public void sellPotion(ActionEvent event) {
        if (getLoopManiaWorld().getnPotions().get() != 0) {
            getLoopManiaWorld().sellPotion();
            getLoopManiaWorld().removeItemByTypeInUnequippedInventoryItems("HealthPotion");
        } else {
            displayWarningText();
        }

    }

    /**
     * Checks for available shield in unequipped inventory.
     * If exists, latest shield entity is removed from unequipped inventory.
     * If not, a warning text appears.
     * @param event
     */
    @FXML
    public void sellShield(ActionEvent event) {
        if (getLoopManiaWorld().getnShields().get() != 0) {
            getLoopManiaWorld().sellShield();
            getLoopManiaWorld().removeItemByTypeInUnequippedInventoryItems("Shield");
        } else {
            displayWarningText();
        }

    }

    /**
     * Checks for available staff in unequipped inventory.
     * If exists, latest staff entity is removed from unequipped inventory.
     * If not, a warning text appears.
     * @param event
     */
    @FXML
    public void sellStaff(ActionEvent event) {
        if (getLoopManiaWorld().getnStaffs().get() != 0) {
            getLoopManiaWorld().sellStaff();
            getLoopManiaWorld().removeItemByTypeInUnequippedInventoryItems("Staff");
        } else {
            displayWarningText();
        }

    }

    /**
     * Checks for available stake in unequipped inventory.
     * If exists, latest stake entity is removed from unequipped inventory.
     * If not, a warning text appears.
     * @param event
     */
    @FXML
    public void sellStake(ActionEvent event) {
        if (getLoopManiaWorld().getnStakes().get() != 0) {
            getLoopManiaWorld().sellStake();
            getLoopManiaWorld().removeItemByTypeInUnequippedInventoryItems("Stake");
        } else {
            displayWarningText();
        }

    }

    /**
     * Checks for available sword in unequipped inventory.
     * If exists, latest sword entity is removed from unequipped inventory.
     * If not, a warning text appears.
     * @param event
     */
    @FXML
    public void sellSword(ActionEvent event) {
        if (getLoopManiaWorld().getnSwords().get() != 0) {
            // decrease counter value by 1 
            getLoopManiaWorld().sellSword();
            // remove from inventory
            getLoopManiaWorld().removeItemByTypeInUnequippedInventoryItems("Sword");
        } else  {
            displayWarningText();
        }
    }

    @FXML
    public void sellDogeCoin(ActionEvent event) {
        getLoopManiaWorld().sellDogieCoin();
        setDogeCoinContainerVisible(false);
    }

    /**
     * Method is triggered when entity/item specified does not exist within unequipped inventory.
     * Status text is set to be visible and soon after invisible.
     */
    public void displayWarningText() {
        statusText.setVisible(true);
        // reset visibility
        PauseTransition visiblePause = new PauseTransition(Duration.seconds(1));
        visiblePause.setOnFinished(e -> {
            statusText.setVisible(false);
        });
        visiblePause.play(); 
    }

    @FXML
    public void closeHelpMenu(ActionEvent event) {
        helpMenu.setVisible(false);
    }

    @FXML
    public void toggleHelpMenu(ActionEvent event) {
        helpMenu.setVisible(true);
    }

    @FXML
    public void setDogeCoinContainerVisible(boolean booleanValue) {
        dogeCoinContainer.setVisible(booleanValue);
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
        currentGold.textProperty().bindBidirectional(getLoopManiaWorld().getgoldProperty(), new NumberStringConverter());
        dogeCoinValue.textProperty().bindBidirectional(getLoopManiaWorld().getDoggieProperty(), new NumberStringConverter());
    }
}

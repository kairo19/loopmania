package unsw.loopmania;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.util.converter.NumberStringConverter;

public class ShopController {
    private MenuSwitcher gameSwitcher;
    private MenuSwitcher shopSwitcher;
    private LoopManiaWorldController loopManiaWorldController;
    @FXML
    private Text warningText;
    @FXML
    private Text currentGold;

    /**
     * @param loopManiaWorldController main controller of game
     */
    public ShopController(LoopManiaWorldController loopManiaWorldController) {
        this.loopManiaWorldController = loopManiaWorldController;
    }

    /**
     * @param gameSwitcher switcher that alternates from shopview and loopmaniaworldview
     */
    public void setGameSwitcher(MenuSwitcher gameSwitcher) {
        this.gameSwitcher = gameSwitcher;
    }

    /**
     * @param shopSwitcher swtitcher that alternated from shopview and shopsellview
     */
    public void setShopSwitcher(MenuSwitcher shopSwitcher) {
        this.shopSwitcher = shopSwitcher;
    }

    public LoopManiaWorld getLoopManiaWorld() {
        return loopManiaWorldController.getLoopManiaWorld();
    }

    
    /**
     * method is triggered when button clicked to go to lmw view
     * @param event 
     */
    @FXML
    public void handleReturnButton(ActionEvent event) {
        gameSwitcher.switchMenu();
    }

    /**
     * method is triggered when button clicked to go to shop sell view
     * @param event
     */
    @FXML
    public void goToSellShop(ActionEvent event) {
        loopManiaWorldController.getLoopManiaWorld().updateSellingItems();  // update quantities of nSwords, nStakes, ... in inventory
        shopSwitcher.switchMenu();
    }
    
    /**
     * method is triggered when button clicked to purchase sword
     * @param event
     */
    @FXML
    public void purchaseSword(ActionEvent event) {
        loopManiaWorldController.purchaseItem(0, this);
    }

    /**
     * method is triggered when button clicked to purchase stake
     * @param event
     */
    @FXML
    public void purchaseStake(ActionEvent event) {
        loopManiaWorldController.purchaseItem(1, this);
    }

    /**
     * method is triggered when button clicked to purchase staff
     * @param event
     */
    @FXML
    public void purchaseStaff(ActionEvent event) {
        loopManiaWorldController.purchaseItem(2, this);
    }

    /**
     * method is triggered when button clicked to purchase armour
     * @param event
     */
    @FXML
    public void purchaseArmour(ActionEvent event) {
        loopManiaWorldController.purchaseItem(3, this);
    }

    /**
     * method is triggered when button clicked to purchase shield
     * @param event
     */
    @FXML
    public void purchaseShield(ActionEvent event) {
        loopManiaWorldController.purchaseItem(4, this);
    }

    /**
     * method is triggered when button clicked to purchase helmet
     * @param event
     */
    @FXML
    public void purchaseHelmet(ActionEvent event) {
        loopManiaWorldController.purchaseItem(5, this);
    }

    /**
     * method is triggered when button clicked to purchase potion
     * @param event
     */
    @FXML
    public void purchasePotion(ActionEvent event) {
        loopManiaWorldController.purchaseItem(6, this);
    }

    public Text getWarningText() {
        return warningText;
    }

    public void initialize() {
        currentGold.textProperty().bindBidirectional(getLoopManiaWorld().getgoldProperty(), new NumberStringConverter());
    }
}

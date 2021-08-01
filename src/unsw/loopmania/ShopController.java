package unsw.loopmania;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
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
    @FXML
    private VBox helpMenu;

    /**
     * Creates controller of ShopView.
     * @param loopManiaWorldController Main controller of game.
     */
    public ShopController(LoopManiaWorldController loopManiaWorldController) {
        this.loopManiaWorldController = loopManiaWorldController;
    }

    /**
     * @param gameSwitcher Switcher that alternates from shopview and loopmaniaworldview.
     */
    public void setGameSwitcher(MenuSwitcher gameSwitcher) {
        this.gameSwitcher = gameSwitcher;
    }

    /**
     * @param shopSwitcher Swtitcher that alternated from shopview and shopsellview.
     */
    public void setShopSwitcher(MenuSwitcher shopSwitcher) {
        this.shopSwitcher = shopSwitcher;
    }

    public LoopManiaWorld getLoopManiaWorld() {
        return loopManiaWorldController.getLoopManiaWorld();
    }

    
    /**
     * Method is triggered when button clicked to go to lmw view
     * @param event 
     */
    @FXML
    public void handleReturnButton(ActionEvent event) {
        gameSwitcher.switchMenu();
    }

    /**
     * Method is triggered when button clicked to go to shop sell view
     * @param event
     */
    @FXML
    public void goToSellShop(ActionEvent event) {
        loopManiaWorldController.getLoopManiaWorld().updateSellingItems();  // update quantities of nSwords, nStakes, ... in inventory
        shopSwitcher.switchMenu();
    }
    
    /**
     * Method is triggered when button clicked to purchase sword
     * @param event
     */
    @FXML
    public void purchaseSword(ActionEvent event) {
        loopManiaWorldController.purchaseItem(0, this);
    }

    /**
     * Method is triggered when button clicked to purchase stake
     * @param event
     */
    @FXML
    public void purchaseStake(ActionEvent event) {
        loopManiaWorldController.purchaseItem(1, this);
    }

    /**
     * Method is triggered when button clicked to purchase staff
     * @param event
     */
    @FXML
    public void purchaseStaff(ActionEvent event) {
        loopManiaWorldController.purchaseItem(2, this);
    }

    /**
     * Method is triggered when button clicked to purchase armour
     * @param event
     */
    @FXML
    public void purchaseArmour(ActionEvent event) {
        loopManiaWorldController.purchaseItem(3, this);
    }

    /**
     * Method is triggered when button clicked to purchase shield
     * @param event
     */
    @FXML
    public void purchaseShield(ActionEvent event) {
        loopManiaWorldController.purchaseItem(4, this);
    }

    /**
     * Method is triggered when button clicked to purchase helmet
     * @param event
     */
    @FXML
    public void purchaseHelmet(ActionEvent event) {
        loopManiaWorldController.purchaseItem(5, this);
    }

    /**
     * Method is triggered when button clicked to purchase potion
     * @param event
     */
    @FXML
    public void purchasePotion(ActionEvent event) {
        loopManiaWorldController.purchaseItem(6, this);
    }

    @FXML
    void closeHelpMenu(ActionEvent event) {
        helpMenu.setVisible(false);
    }

    @FXML
    void toggleHelpMenu(ActionEvent event) {
        helpMenu.setVisible(true);
    }

    public Text getWarningText() {
        return warningText;
    }

    public void initialize() {
        currentGold.textProperty().bindBidirectional(getLoopManiaWorld().getgoldProperty(), new NumberStringConverter());
    }
}

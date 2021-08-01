package unsw.loopmania;

import java.io.File;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

/**
 * the main application
 * run main method from this class
 */
public class LoopManiaApplication extends Application {
    // TODO = possibly add other menus?

    /**
     * the controller for the game. Stored as a field so can terminate it when click exit button
     */
    private LoopManiaWorldController mainController;
    Parent gameRoot;


    // private Media media= new Media(new File("src/music/Age of War - Theme Soundtrack.mp3").toURI().toString());
    // private MediaPlayer mediaPlayer = new MediaPlayer(media);
    // private Media menuMedia = new Media(new File("src/music/C418 - Door - Minecraft Volume Alpha.mp3").toURI().toString());
    // private MediaPlayer menuMediaPlayer = new MediaPlayer(menuMedia);

    @Override
    public void start(Stage primaryStage) throws IOException {
        // set title on top of window bar
        primaryStage.setTitle("Loop Mania");

        // prevent human player resizing game window (since otherwise would see white space)
        // alternatively, you could allow rescaling of the game (you'd have to program resizing of the JavaFX nodes)
        primaryStage.setResizable(false);

        // load the main game
        LoopManiaWorldControllerLoader loopManiaLoader = new LoopManiaWorldControllerLoader("world_with_twists_and_turns.json");
        mainController = loopManiaLoader.loadController();
        FXMLLoader gameLoader = new FXMLLoader(getClass().getResource("LoopManiaView.fxml"));
        gameLoader.setController(mainController);
        gameRoot = gameLoader.load();

        // load the main menu
        MainMenuController mainMenuController = new MainMenuController(mainController);
        FXMLLoader menuLoader = new FXMLLoader(getClass().getResource("MainMenuView.fxml"));
        menuLoader.setController(mainMenuController);
        Parent mainMenuRoot = menuLoader.load();

        // load the shop menu
        ShopController shopController = new ShopController(mainController);
        FXMLLoader shopLoader = new FXMLLoader(getClass().getResource("ShopView.fxml"));
        shopLoader.setController(shopController);
        Parent shopRoot = shopLoader.load();

        // load the shop sell menu
        ShopSellController shopSellController = new ShopSellController(mainController);
        FXMLLoader shopSellLoader = new FXMLLoader(getClass().getResource("ShopSellView.fxml"));
        shopSellLoader.setController(shopSellController);
        Parent shopSellRoot = shopSellLoader.load();

        // create new scene with the main menu (so we start with the main menu)
        Scene menuScene = new Scene(mainMenuRoot);
        Scene shopScene = new Scene(shopRoot);
        Scene shopSellScene = new Scene(shopSellRoot);

        // menuMediaPlayer.play();

        // // set functions which are activated when button click to switch menu is pressed
        // // e.g. from main menu to start the game, or from the game to return to main menu
        mainController.setMainMenuSwitcher(() -> {
            switchToRoot(menuScene, mainMenuRoot, primaryStage);
        //     mediaPlayer.stop();
        //     menuMediaPlayer.setAutoPlay(true);  
        //     menuMediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        });
        
        mainController.setShopMenuSwitcher(() -> {switchToRoot(shopScene, shopRoot, primaryStage);});
        
        // purchasing scene switches
        shopController.setGameSwitcher(() -> {
            switchToRoot(menuScene, gameRoot, primaryStage);
            mainController.startTimer();
        });
        shopController.setShopSwitcher(() -> {
            switchToRoot(shopSellScene, shopSellRoot, primaryStage);
        });

        // selling scene switches
        shopSellController.setShopSwitcher(() -> {
            switchToRoot(shopScene, shopRoot, primaryStage);
        });
        shopSellController.setGameSwitcher(() -> {
            switchToRoot(menuScene, gameRoot, primaryStage);
            mainController.startTimer();
        });
         
        mainMenuController.setGameSwitcher(() -> {
            switchToRoot(menuScene, gameRoot, primaryStage);
            mainController.startTimer();
            // menuMediaPlayer.stop();
            // mediaPlayer.setAutoPlay(true);  
            // mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
            // mediaPlayer.setVolume(0.1);
        });
        
        // deploy the main onto the stage
        gameRoot.requestFocus();
        primaryStage.setScene(menuScene);
        primaryStage.show();
    }

    @Override
    public void stop(){
        // wrap up activities when exit program
        mainController.terminate();
    }

    public void newGame() throws IOException {
        LoopManiaWorldControllerLoader loopManiaLoader = new LoopManiaWorldControllerLoader("world_with_twists_and_turns.json");
        mainController = loopManiaLoader.loadController();
        FXMLLoader gameLoader = new FXMLLoader(getClass().getResource("LoopManiaView.fxml"));
        gameLoader.setController(mainController);
        gameRoot = gameLoader.load();
    }

    /**
     * switch to a different Root
     */
    private void switchToRoot(Scene scene, Parent root, Stage stage){
        scene.setRoot(root);
        root.requestFocus();
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

package in.hike.collatedData.Controller;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ControlledAppDataEntry extends Application {
	
	private Stage primaryStage;
    private AnchorPane appBase;


	@Override
	public void start(Stage primaryStage) {
		
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Collated App Data");
		
		initBaseLayout();
	}
	
	/**
     * Initializes the root layout.
     */
    public void initBaseLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ControlledAppDataEntry.class.getResource("../views/ConnectDevice.fxml"));
            appBase = (AnchorPane) loader.load();

            // Show the scene containing the root layout.
            Scene connectedDevicesScene = new Scene(appBase);
            primaryStage.setScene(connectedDevicesScene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }


	public static void main(String[] args) {
		launch(args);
	}
}

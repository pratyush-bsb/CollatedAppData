package in.hike.collatedData.Controller;

import in.hike.collatedData.services.ConnectedDevicesService;

import java.io.IOException;

import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class ConnectDeviceController {
	
	@FXML private Text actiontarget;
	@FXML private ProgressIndicator connectedDeviceSpinner;
    public Map<String, Map<String, String>> capturedDevices;

    @FXML
    void getConnectedDevicesList(ActionEvent event) {
    	getListOfAttachedDevices(event);
    }
    
    public void getListOfAttachedDevices(ActionEvent event) {
    	final ConnectedDevicesService serviceExample = new ConnectedDevicesService();

    	connectedDeviceSpinner.visibleProperty().bind(serviceExample.runningProperty());
        serviceExample.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent workerStateEvent) {
                String result = serviceExample.getValue();
                capturedDevices = serviceExample.getCapturedDevices();
                try {
					Parent devicesFoundParent = FXMLLoader.load(getClass().getResource("../views/DevicesFound.fxml"));

                    //pass captured devices data
                    DevicesFoundController devicesFoundController = fxmlLoader.<DevicesFoundController>getController();
                    devicesFoundController.setCapturedDevices(capturedDevices);
					Scene devicesFoundScene = new Scene(devicesFoundParent);
					
					Stage collatedAppStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                    collatedAppStage.setScene(devicesFoundScene);
                    collatedAppStage.show();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        serviceExample.setOnFailed(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent workerStateEvent) {
            	
            }
        });
        serviceExample.restart();
    }

}

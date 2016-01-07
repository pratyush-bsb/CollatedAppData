package in.hike.collatedData.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;

public class DevicesFoundController implements Initializable {

	public Map<String, Map<String, String>> devicesFound;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

	public void setCapturedDevices(Map<String, Map<String, String>> capturedDevices) {
		this.devicesFound = capturedDevices;
	}

}

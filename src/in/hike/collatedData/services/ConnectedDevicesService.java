package in.hike.collatedData.services;

import java.util.Map;

import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class ConnectedDevicesService extends Service<String> {
	
	public static Map<String, Map<String, String>> capturedDevices;
	
	@Override
	protected Task<String> createTask() {
		return new Task<String>() {
			@Override
			protected String call() throws Exception {
				String result = "";
				
				Map<String, String> temp = System.getenv();
				capturedDevices.put("d1", temp);
				return result;
				
			}
		};
	}
	
	public Map<String, Map<String, String>> getCapturedDevices() {
		return capturedDevices;
	}
}
package ftmk.rmi.sensor.manager;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

import ftmk.rmi.sensor.TemperatureSensor;

/**
 * This class manage value of temperature from the sensor.
 */
public class TemperatureSensorManager extends UnicastRemoteObject implements TemperatureSensor {

	private HashMap <String , Integer> loadTemperatureData()
	{
		HashMap <String , Integer> temperature = new HashMap<>();	
		
		//value into hash map
		temperature.put("Monday",32);
		temperature.put("Tuesday",31);
		temperature.put("Wednesday",33);
		temperature.put("Thursday",35);
		temperature.put("Friday",36);
		temperature.put("Saturday",33);
		temperature.put("Sunday",33);
		
		return temperature;
	}
	
	public TemperatureSensorManager() throws RemoteException {
		super();
	}

	@Override
	public int getTemperature() throws RemoteException {
		
		return 35;
	}

	@Override
	public int getTemperatureDay(String day) throws RemoteException {
		
		HashMap <String, Integer> temp = loadTemperatureData();
		int temperature = temp.get(day);

		return temperature;
	}

	@Override
	public float getAveTemperature() throws RemoteException {
		
		HashMap <String, Integer> temp = loadTemperatureData();
		
		int totalTemperature=0;
		for (int temperature : temp.values())
		{
			totalTemperature += temperature;
		}

		float aveTemperature = (float)totalTemperature/temp.size();
		return aveTemperature;
	}
}

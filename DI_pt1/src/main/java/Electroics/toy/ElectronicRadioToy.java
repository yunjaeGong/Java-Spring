package Electroics.toy;

import Electroics.battery.Battery;

public class ElectronicRadioToy {
	
	private Battery battery;
	
	public ElectronicRadioToy(Battery battery) {
		this.battery = battery;
	}
	
	public void setBattery(Battery battery) {
		this.battery = battery;
	}
	
}
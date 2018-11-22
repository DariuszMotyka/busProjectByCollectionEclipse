package com.dariuszmotyka.busProjectByCollection;

public class BusStop implements BusStopInterface {

	private String busStopName;
	
	public BusStop(String busStopName) {
		this.busStopName = busStopName;
	}
	
	public String getName() {
	    /**
	     * Metoda zwraca nazwę przystanku.
	     * @return nazwa przystanku
	     */
		return this.busStopName;
	}

}

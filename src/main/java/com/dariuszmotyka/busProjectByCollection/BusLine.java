package com.dariuszmotyka.busProjectByCollection;

import java.util.List;

public class BusLine implements BusLineInterface {

	private List<BusStopInterface> line;
	
	
	
	public List<BusStopInterface> getLine() {
		return line;
	}

	public BusLine(List<BusStopInterface> line) {
		this.line = line;
	}
	
	public int getNumberOfBusStops() {
	    /**
	     * Metoda zwraca liczbę przystanków, które wchodzą w jej skład.
	     * 
	     * @return liczba przystanków danej lini
	     */
		return this.line.size();
	}

	public BusStopInterface getBusStop(int number) {
	    /**
	     * Metoda zwraca obiekt reprezentujący przystanek o podanym numerze. Prawidłowe
	     * numery przystanów mieszczą się w przedziale od 0 do getNumberOfBusStops()-1.
	     * Tylko podanie błednego numeru przystanku spowoduje zwrócenie null.
	     * 
	     * @param number numer przystanku
	     * @return obiekt reprezentujący przystanek o numerze number
	     */
		if(number<0 || number>= this.line.size()) {
			return null;
		}
		return this.line.get(number);
	}


}

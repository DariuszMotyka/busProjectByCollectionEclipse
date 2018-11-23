package com.dariuszmotyka.busProjectByCollection;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.sound.sampled.LineListener;

public class PathFinder implements PathFinderInterface {

    private Map<Integer, BusLineInterface> lines = new TreeMap<>();
    private Map<Integer, BusAndBusStop> solutionsMap;
    
 //   private Map<Integer, List<BusAndBusStop>> solutionsMap;
    private Map<Integer, List<BusAndBusStop>> busAndBusStopConnection;
    private Map<BusStopInterface, BusStopInterface> busLineConnections;
    
    // nody
    private Map<String, BusStopInterface> allBusStops;
    
    public PathFinder() {
    	busAndBusStopConnection = new HashMap<>();
    	// generowanie połączeń
		busLineConnections = new HashMap<>();
		busLineConnections.put(new BusStop("A"), new BusStop("B"));
		busLineConnections.put(new BusStop("B"), new BusStop("C"));
		busLineConnections.put(new BusStop("C"), new BusStop("D"));
		busLineConnections.put(new BusStop("D"), new BusStop("E"));
		busLineConnections.put(new BusStop("E"), new BusStop("F"));
		busLineConnections.put(new BusStop("F"), new BusStop("G"));
		busLineConnections.put(new BusStop("H"), new BusStop("I"));
		busLineConnections.put(new BusStop("I"), new BusStop("C"));
		busLineConnections.put(new BusStop("C"), new BusStop("J"));
		busLineConnections.put(new BusStop("J"), new BusStop("K"));
		busLineConnections.put(new BusStop("L"), new BusStop("E"));
		busLineConnections.put(new BusStop("E"), new BusStop("M"));
		busLineConnections.put(new BusStop("M"), new BusStop("N"));
		busLineConnections.put(new BusStop("N"), new BusStop("O"));
		
	}
    
    private void addDataToBusAndBusTopConnection(BusLine line, BusInterface bus) {
    	for(int i=0;i<line.getLine().size();i++) {
    		busAndBusStopConnection.put(bus.getBusNumber(), new BusAndBusStop(bus.getBusNumber(),line.getBusStop(i)));
    	}
    }
	
	public void addLine(BusLineInterface line, BusInterface bus) {
		// dodanie linii
		
		lines.put(lines.size()-1, line);
		addDataToBusAndBusTopConnection(line,bus);
		
	    /**
	     * Metoda dodaje linię autobusową do serwisu. Ten sam autobus
	     * obsługuje linię w obu kierunkach.
	     * @param line linia autobusowa
	     * @param bus autobus, który ją obsługuje
	     */
	}

	public void find(BusStopInterface from, BusStopInterface to, int transfers) {
		/**
	     * Metoda zleca znalezienie połączenia autobusowego
	     * prowadzącego od przystanku from do przystanku to
	     * z uwzględnieniem podanej liczby przesiadek.
	     * Liczba przesiadek równa zero oznacza, że poszukiwane jest
	     * połączenie bezpośrednie.
	     * @param from przystanek początkowy
	     * @param to przystanek końcowy
	     * @param transfers liczba przesiadek
	     */

	}

	public int getNumerOfSolutions() {
		
		return 0;
		/**
	     * Liczba odnalezionych rozwiązań.
	     * @return liczba rozwiązań. Przed wykonaniem metody find
	     * metoda zwraca zawsze 0.
	     */
	}

	public int getBusStops(int solution) {

		return 0;
		/**
	     * Liczba przystanków autobusowych należących do rozwiązania
	     * o podanym numerze. Przystanek o numerze 0 to przystanek, od
	     * którego rozpoczynana jest podróż (from). Przystanek o numerze
	     * getNumerOfSolutions()-1 to przystanek końcowy (to).
	     * @param solution numer rozwiązania
	     * @return liczba przystanków.
	     */
	}

	public BusStopInterface getBusStop(int solution, int busStop) {

		return null;
		   /**
	     * Metoda zwraca przystanek o numerze busStop w rozwiązaniu
	     * o numerze solution.
	     * @param solution numer rozwiązania
	     * @param busStop numer przystanku w obrębie danego rozwiązania
	     * @return przystanek o podanych numerach identyfikacyjnych
	     */
	}

	public BusInterface getBus(int solution, int busStop) {

		return null;
		/**
	     * Dla wszystkich przystanków poza ostatnim, metoda zwraca autobus, który
	     * obsługuje połączenie z przystanku o numerze busStop do następnego.
	     * Dla przystanku ostatniego, autobus, który obsługiwał przejazd
	     * z przystanku busStop-2 do busStop-1 (czyli ostatniego).
	     * @param solution numer rozwiązania
	     * @param busStop numer przystanku w obrębie danego rozwiązania
	     * @return autobus, którym pasażer odjeżdża z danego przystanku lub
	     * w przypadku przystanku docelowego, autobus, z którego pasażer
	     * na tym przystanku wysiadł.
	     */
	}

}

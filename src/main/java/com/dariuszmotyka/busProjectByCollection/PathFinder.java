package com.dariuszmotyka.busProjectByCollection;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import javax.sound.sampled.LineListener;

public class PathFinder implements PathFinderInterface {

    
    //private Map<Integer, List<BusAndBusStop>> solutionsMap;
    
    //   private Map<Integer, List<BusAndBusStop>> solutionsMap;
	//private Map<Integer, BusLineInterface> lines = new TreeMap<>();
	private Map<Integer, BusLineInterface> lines = new TreeMap<>();
    private Map<Integer, BusAndBusStop> busAndBusStopConnection;
    private Map<BusStopInterface, BusStopInterface> busLineConnections;
    
    // nody
    private Map<String, BusStopInterface> allBusStops;
    //private List<BusStopInterface> allBusStops;
    
    public PathFinder() {
    	allBusStops = new HashMap<>();
    	//allBusStops = new LinkedList<>();
    	busAndBusStopConnection = new HashMap<>();
    	// generowanie połączeń
		busLineConnections = new HashMap<>();
		busLineConnections.put(new BusStop("A"), new BusStop("B"));
		busLineConnections.put(new BusStop("B"), new BusStop("A"));
		
		busLineConnections.put(new BusStop("B"), new BusStop("C"));
		busLineConnections.put(new BusStop("C"), new BusStop("B"));
		
		busLineConnections.put(new BusStop("C"), new BusStop("D"));
		busLineConnections.put(new BusStop("D"), new BusStop("C"));
		
		busLineConnections.put(new BusStop("D"), new BusStop("E"));
		busLineConnections.put(new BusStop("E"), new BusStop("D"));
		
		busLineConnections.put(new BusStop("E"), new BusStop("F"));
		busLineConnections.put(new BusStop("F"), new BusStop("E"));
		
		busLineConnections.put(new BusStop("F"), new BusStop("G"));
		busLineConnections.put(new BusStop("G"), new BusStop("F"));
		
		busLineConnections.put(new BusStop("H"), new BusStop("I"));
		busLineConnections.put(new BusStop("I"), new BusStop("H"));
		
		busLineConnections.put(new BusStop("I"), new BusStop("C"));
		busLineConnections.put(new BusStop("C"), new BusStop("I"));
		
		busLineConnections.put(new BusStop("C"), new BusStop("J"));
		busLineConnections.put(new BusStop("J"), new BusStop("C"));
		
		busLineConnections.put(new BusStop("J"), new BusStop("K"));
		busLineConnections.put(new BusStop("K"), new BusStop("J"));
		
		busLineConnections.put(new BusStop("L"), new BusStop("E"));
		busLineConnections.put(new BusStop("E"), new BusStop("L"));
		
		busLineConnections.put(new BusStop("E"), new BusStop("M"));
		busLineConnections.put(new BusStop("M"), new BusStop("E"));
		
		busLineConnections.put(new BusStop("M"), new BusStop("N"));
		busLineConnections.put(new BusStop("N"), new BusStop("M"));
		
		busLineConnections.put(new BusStop("N"), new BusStop("O"));
		busLineConnections.put(new BusStop("O"), new BusStop("N"));
		
	}
    
    private void addDataToBusAndBusTopConnection(BusLine line, BusInterface bus) {
    	int tmp = busAndBusStopConnection.size();
    	for(int i=0;i<line.getLine().size();i++) {
    		busAndBusStopConnection.put(tmp,new BusAndBusStop(bus.getBusNumber(),line.getBusStop(i)));
    		tmp++;
    	}
    }
    
    public void printBusLineConnections() {
    	System.out.println("Połączenia:");
    	for(Entry<BusStopInterface, BusStopInterface> isMap : busLineConnections.entrySet()) {
			System.out.println(isMap.getKey().getName()+" -> "+isMap.getValue().getName());
		}
    	System.out.println();
    }
    
    private void addDataToAllBusStops(BusLine line) {
    	if(allBusStops.isEmpty()){
    		for(int i=0;i<line.getNumberOfBusStops();i++) {
    			allBusStops.put(line.getBusStop(i).getName(),line.getBusStop(i));
    		}
    	}else {
    		boolean needToAdd;
    		for(int i=0;i<line.getNumberOfBusStops();i++) {
    			String tmpName = line.getBusStop(i).getName();
    			needToAdd = true;
    			for(Entry<String, BusStopInterface> isMap : allBusStops.entrySet()) {
    				if(isMap.getKey().equals(tmpName)) {
    					needToAdd = false;
    					break;
    				}
    			}
    			if(needToAdd) {
    				allBusStops.put(line.getBusStop(i).getName(),line.getBusStop(i));
    			}
    		}
    	}
    }  
    
    public void printAddDataToAllBusStops() {
    	System.out.println("Wszystkie przytsanki:");
    	for(Entry<String, BusStopInterface> isMap : allBusStops.entrySet()) {
    		System.out.println(isMap.getKey());
    	}
    }
    
    /*
    private void addDataToAllBusStops(BusLine line) {
    	if(allBusStops.isEmpty()){
    		for(int i=0;i<line.getNumberOfBusStops();i++) {
    			allBusStops.add(line.getBusStop(i));
    		}
    	}else {
    		boolean needToAdd;
    		for(int i=0;i<line.getNumberOfBusStops();i++) {
    			needToAdd = true;
    			for(int j=0;j<allBusStops.size();j++) {
    				if(line.getBusStop(i).getName().equals(allBusStops.get(j).getName())) {
    					needToAdd = false;
    					break;
    				}
    			}
    			if(needToAdd) {
    				allBusStops.add(line.getBusStop(i));
    			}
    		}
    	}
    }
    
    public void printAddDataToAllBusStops() {
    	System.out.println("Wszystkie przytsanki:");
    	for(BusStopInterface isMap : allBusStops) {
    		System.out.println(isMap.getName());
    	}
    }
    */
    /*
    private void addDataToAllBusStops(BusLine line) {
    	if(allBusStops.isEmpty()) {
    		for(int i=0;i<line.getNumberOfBusStops();i++) {
    			allBusStops.put(line.getBusStop(i).getName(), line.getBusStop(i));
    		}
    	}else {
        	for(int i=0;i<line.getLine().size();i++) {
    			boolean needAdd = true;
    			for(Entry<String, BusStopInterface> isMap : allBusStops.entrySet()) {
    				if(line.getBusStop(i).getName().equals(isMap.getKey())) {
    					needAdd = false;
    					break;
    				}
    			}
    			if(needAdd) {
					allBusStops.put(line.getBusStop(i).getName(), line.getBusStop(i));
				}
    		
        	}
    	}

    }
    */
    public void printLines() {
    	System.out.println("Dostępne linie:");
    	for(Entry<Integer, BusLineInterface> isMap : lines.entrySet()) {
			System.out.println("Linia:"+isMap.getKey());
			System.out.print("Trasa:");
			for(int i=0;i<isMap.getValue().getNumberOfBusStops();i++) {
					System.out.print(" - "+isMap.getValue().getBusStop(i).getName());
			}
			System.out.println();
		}
	
		System.out.println();
    }
    
	
	public void addLine(BusLineInterface line, BusInterface bus) {
		// dodanie linii
		
		lines.put(bus.getBusNumber(), line);
		addDataToBusAndBusTopConnection((BusLine)line,bus);
		addDataToAllBusStops((BusLine)line); // do poprawy
		
	
	
		/*
		for(Entry<String, BusStopInterface> isMap : allBusStops.entrySet()) {
			System.out.println(allBusStops.get(isMap).getName());
		}		
		*/
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

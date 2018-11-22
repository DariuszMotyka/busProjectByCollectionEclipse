package com.dariuszmotyka.busProjectByCollection;

import java.util.Objects;

public class BusAndBusStop {
    final int bus;
    final String busStop;

    BusAndBusStop(BusInterface bus, BusStopInterface busStop) {
        this(bus.getBusNumber(), busStop);
    }

    BusAndBusStop(int bus, BusStopInterface busStop) {
        this.bus = bus;
        //assertNotNull(busStop, "Zamiast przystanku jest null");
        this.busStop = busStop.getName();
    }

    @Override
    public String toString() {
        return "{" + bus + ", " + busStop + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        BusAndBusStop that = (BusAndBusStop) o;
        return bus == that.bus && Objects.equals(busStop, that.busStop);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bus, busStop);
    }
}

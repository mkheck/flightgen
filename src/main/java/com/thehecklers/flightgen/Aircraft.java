package com.thehecklers.flightgen;

import java.util.Objects;

public class Aircraft {
    private final String callsign, reg, flightno, type;
    private final int altitude, heading, speed;
    private final double lat, lon;

    public Aircraft(String callsign, String reg, String flightno, String type, int altitude, int heading, int speed, double lat, double lon) {
        this.callsign = callsign;
        this.reg = reg;
        this.flightno = flightno;
        this.type = type;
        this.altitude = altitude;
        this.heading = heading;
        this.speed = speed;
        this.lat = lat;
        this.lon = lon;
    }

    public String getCallsign() {
        return callsign;
    }

    public String getReg() {
        return reg;
    }

    public String getFlightno() {
        return flightno;
    }

    public String getType() {
        return type;
    }

    public int getAltitude() {
        return altitude;
    }

    public int getHeading() {
        return heading;
    }

    public int getSpeed() {
        return speed;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aircraft aircraft = (Aircraft) o;
        return altitude == aircraft.altitude && heading == aircraft.heading && speed == aircraft.speed && Double.compare(aircraft.lat, lat) == 0 && Double.compare(aircraft.lon, lon) == 0 && Objects.equals(callsign, aircraft.callsign) && reg.equals(aircraft.reg) && Objects.equals(flightno, aircraft.flightno) && Objects.equals(type, aircraft.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(callsign, reg, flightno, type, altitude, heading, speed, lat, lon);
    }

    @Override
    public String toString() {
        return "Aircraft{" +
                "callsign='" + callsign + '\'' +
                ", reg='" + reg + '\'' +
                ", flightno='" + flightno + '\'' +
                ", type='" + type + '\'' +
                ", altitude=" + altitude +
                ", heading=" + heading +
                ", speed=" + speed +
                ", lat=" + lat +
                ", lon=" + lon +
                '}';
    }
}

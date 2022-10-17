package no.hvl.dat100ptc.oppgave2;

import java.util.Arrays;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSData {

	private GPSPoint[] gpspoints;
	protected int antall = 0;

	public GPSData(int n) {

		// TODO - START
		gpspoints = new GPSPoint[n];
		antall = 0;

		// TODO - SLUTT
	}

	public GPSPoint[] getGPSPoints() {
		return this.gpspoints;
	}

	protected boolean insertGPS(GPSPoint gpspoint) {
		// TODO - START
		boolean insert = false;

		if (antall < gpspoints.length) {
			gpspoints[antall] = gpspoint;
			antall++;
			insert = true;
		}
		return insert;
	}

	// TODO - SLUTT

	public boolean insert(String time, String latitude, String longitude, String elevation) {
		// TODO - START
		// lage objekt for hver av

		GPSPoint gpspoint;
		
		int times = GPSDataConverter.toSeconds(time);
		double latitudes = Double.parseDouble(latitude);
		double longitudes = Double.parseDouble(longitude);
		double elevations = Double.parseDouble(elevation);
		
		gpspoint = new GPSPoint(times,latitudes,longitudes,elevations);
		
		boolean inserted = insertGPS(gpspoint);
		
		return inserted; 

	}

	// TODO - SLUTT
	public void print() {
	
		System.out.println("====== Konvertert GPS Data - START ======");

		// TODO - START
		
		for(GPSPoint a : gpspoints) {
			System.out.println(a.toString());
		}

		// TODO - SLUTT
		
		System.out.println("====== Konvertert GPS Data - SLUTT ======");
	}
	}


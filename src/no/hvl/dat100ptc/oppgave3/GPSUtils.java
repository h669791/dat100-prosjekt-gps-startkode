package no.hvl.dat100ptc.oppgave3;

import static java.lang.Math.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSUtils {

	public static double findMax(double[] da) {
		double max;
		max = da[0];
		for (double d : da) {
			if (d > max) {
				max = d;
			}
		}
		return max;
	}

	public static double findMin(double[] da) {
		// TODO - START
		double min;
		min = da[0];

		for (double d : da) {
			if (d < min) {
				min = d;
			}

		}
		return min;
	}
	// TODO - SLUTT

	public static double[] getLatitudes(GPSPoint[] gpspoints) {

		// TODO - START
		double[] latitudes = new double[gpspoints.length];
		for (int i = 0; i < gpspoints.length; i++) {
			latitudes[i] = gpspoints[i].getLatitude();
		}
		return latitudes;
		// TODO - SLUTT

	}

	public static double[] getLongitudes(GPSPoint[] gpspoints) {

		// TODO - START
		double[] longitude = new double[gpspoints.length];
		for (int i = 0; i < gpspoints.length; i++) {
			longitude[i] = gpspoints[i].getLongitude();
		}
		return longitude;

		// TODO - SLUTT

	}

	private static int R = 6371000; // jordens radius

	public static double distance(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		double d;
		// double latitude1, longitude1, latitude2, longitude2;

		// TODO - START
		double latitude1 = gpspoint1.getLatitude();
		double latitude2 = gpspoint2.getLatitude();
		double longitude1 = gpspoint1.getLongitude();
		double longitude2 = gpspoint2.getLongitude();

		double a = pow(sin(toRadians(latitude2 - latitude1) / 2), 2) + pow(sin(toRadians(longitude2 - longitude1) / 2), 2) * cos(toRadians(latitude1)) * cos(toRadians(latitude2));

		double c = 2 * (atan2(sqrt(a), sqrt(1 - a)));
		d = R * c;
		return d;
		// TODO - SLUTT
	}

	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		int secs;
		double speed;
		// TODO - START
		secs = gpspoint2.getTime() - gpspoint1.getTime();

		double distance = GPSUtils.distance(gpspoint1, gpspoint2);
		speed = (distance / secs) * 3.6;

		return speed;

		// TODO - SLUTT

	}

	public static String formatTime(int secs) {

		String timestr;
		String TIMESEP = ":";

		// TODO - START

		timestr = "";
		int HH = secs / 3600;
		int mm = (secs % 3600) / 60;
		int ss = secs % 60;
		String format = String.format("%02d" + TIMESEP + "%02d" + TIMESEP + "%02d", HH, mm, ss);
		timestr = String.format("%10s", format);
		return timestr;

		// TODO - SLUTT

	}

	private static int TEXTWIDTH = 10;

	public static String formatDouble(double d) {

		// TODO - START

		String str = " ";
		String streng = String.format("%.2f", d).replace(",", ".");
		str = String.format("%10s", streng);
		return str;
		// TODO - SLUTT

	}
}

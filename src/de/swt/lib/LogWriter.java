package de.swt.lib;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public abstract class LogWriter {
	private static File logFile = null;

	public static void createLogEintrag(String logText) {
		try {
			FileWriter writer = new FileWriter(logFile, true);
			BufferedWriter out = new BufferedWriter(writer);
			out.write(logText + "\r\n");
			out.flush();
			out.close();
			writer.close();

		} catch (Exception e) {
			System.out.println("Datei Schreiben Exception");
		}
	}

	public static void createLogDatei(File logFile) {
		try {
			LogWriter.logFile = logFile;
			FileWriter writer = new FileWriter(logFile);
			BufferedWriter out = new BufferedWriter(writer);
			out.write("IPv4-Adresse;Latenz in ms;Datum;Zeit" + "\r\n");
			out.flush();
			out.close();
			writer.close();
		} catch (Exception e) {
			System.out.println("Datei Schreiben Exception");
		}
	}
}

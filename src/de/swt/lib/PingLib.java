package de.swt.lib;

import java.io.IOException;
import java.net.InetAddress;

public abstract class PingLib {
	static private long timeStart = 0;
	static private long timeEnde = 0;
	static private long timeLatenz = 0;
	static private boolean istErreichbar = false;
	static private String myIP = "127.0.0.1";
	static private InetAddress inet;

	public static boolean PingMyIP() {
		try {

			timeStart = System.nanoTime();
			ping("8.8.4.4");
			timeEnde = System.nanoTime();
			timeLatenz = (timeEnde - timeStart) / 1000000;
			System.out.println(myIP + " " + timeLatenz + "ms" + " " + istErreichbar);
			return istErreichbar;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	private static boolean ping(String host) throws IOException, InterruptedException {
		boolean isWindows = System.getProperty("os.name").toLowerCase().contains("win");

		ProcessBuilder processBuilder = new ProcessBuilder("ping", isWindows ? "-n" : "-c", "1", host);
		Process proc = processBuilder.start();

		int returnVal = proc.waitFor();
		return returnVal == 0;
	}

}

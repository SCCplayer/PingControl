package de.swt.lib;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PingProzess {
	private List<String> command = new ArrayList<String>();
	static private int ID = 0;

	public PingProzess(String IPv4) {
		command.add("ping");
		command.add("-n");
		command.add("1");
		command.add(IPv4);
		ID++;
	}

	public String getPingText() {
		String s = null;
		String pingText = null;
		Process process = null;
		try {
			ProcessBuilder pb = new ProcessBuilder(command);
			process = pb.start();
			BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
			BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));
			while ((s = stdInput.readLine()) != null) {

				// System.out.println("Zeile eingelesen: " + s);
				if (s.startsWith("Antwort") == true || s.startsWith("Zeit") == true) {
					pingText = s;
				}
			}
			while ((s = stdError.readLine()) != null) {
				System.out.println("Standard-Fehler: " + s);

			}
		} catch (Exception e) {
			if (process != null) {
				process.destroyForcibly();
			}
			return pingText;
		}
		process.destroyForcibly();
		return pingText;
	}

	public int getID() {
		return ID;
	}

}
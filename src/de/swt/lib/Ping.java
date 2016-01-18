package de.swt.lib;

import java.util.ArrayList;
import java.util.List;

public class Ping {
	private List<String> command = new ArrayList<String>();

	public Ping(String IPv4) {
		command.add("ping");
		command.add("-n");
		command.add("1");
		command.add(IPv4);

	}

	public String getPingText() {
		String pingText = "";

		return pingText;
	}

}

// String s = null;
// File myFile = new File("H:\\Pingtest.txt");
//
// ProcessBuilder pb = new ProcessBuilder(command);
// pb.redirectOutput(myFile);
// Process process = pb.start();
//// pb.redirectInput(myFile);
//
// BufferedReader stdInput = new BufferedReader(new
// InputStreamReader(process.getInputStream()));
// BufferedReader stdError = new BufferedReader(new
// InputStreamReader(process.getErrorStream()));
//
//// read the output from the command
// System.out.println("Here is the standard output of the command:\n");
// while ((s = stdInput.readLine()) != null) {
//
// System.out.println(s + "Kai");
// }
//
//// read any errors from the attempted command
// System.out.println("Here is the standard error of the command (if any):\n");
// while ((s = stdError.readLine()) != null) {
// System.out.println(s);
// }
// process.destroyForcibly();
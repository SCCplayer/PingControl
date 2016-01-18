package de.swt.start;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class JavaPingExampleProgramm {

	public static void main(String args[]) throws IOException {
		// create the ping command as a list of strings
		JavaPingExampleProgramm ping = new JavaPingExampleProgramm();
		List<String> commands = new ArrayList<String>();
		commands.add("ping");
		commands.add("-n");
		commands.add("1");
		commands.add("127.0.0.1");
		ping.doCommand(commands);
	}

	public void doCommand(List<String> command) throws IOException {
		String s = null;
		File myFile = new File("H:\\Pingtest.txt");

		ProcessBuilder pb = new ProcessBuilder(command);
		pb.redirectOutput(myFile);
		Process process = pb.start();
		// pb.redirectInput(myFile);

		BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
		BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));

		// read the output from the command
		System.out.println("Here is the standard output of the command:\n");
		while ((s = stdInput.readLine()) != null) {

			System.out.println(s + "Kai");
		}

		// read any errors from the attempted command
		System.out.println("Here is the standard error of the command (if any):\n");
		while ((s = stdError.readLine()) != null) {
			System.out.println(s);
		}
		process.destroyForcibly();
	}

}

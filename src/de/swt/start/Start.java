package de.swt.start;

import de.swt.lib.PingLib;

public class Start {

	public static void main(String[] args) {
		for (int i = 0; i < 20; i++) {
			System.out.println(PingLib.PingMyIP());
		}
	}
}

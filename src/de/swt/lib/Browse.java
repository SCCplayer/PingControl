package de.swt.lib;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public abstract class Browse {
	private static JFileChooser fc = new JFileChooser();
	private static FileFilter csvFileFilter = new FileNameExtensionFilter("Textdatei", "csv");

	public static File getLogFile(JFrame parent) {
		File csvFile = null;
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fc.addChoosableFileFilter(csvFileFilter);
		fc.setFileFilter(csvFileFilter);
		int auswahl = fc.showOpenDialog(parent);
		if (auswahl == JFileChooser.APPROVE_OPTION) {
			if (fc.getSelectedFile().getPath().toLowerCase().endsWith(".csv")) {
				csvFile = fc.getSelectedFile();
			} else {
				csvFile = new File(fc.getSelectedFile().getPath() + ".csv");
			}
		}
		return csvFile;
	}

	public static File getLogFile() {
		File csvFile = null;
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fc.addChoosableFileFilter(csvFileFilter);
		fc.setFileFilter(csvFileFilter);
		int auswahl = fc.showOpenDialog(null);
		if (auswahl == JFileChooser.APPROVE_OPTION) {
			if (fc.getSelectedFile().getPath().toLowerCase().endsWith(".csv")) {
				csvFile = fc.getSelectedFile();
			} else {
				csvFile = new File(fc.getSelectedFile().getPath() + ".csv");
			}
		}
		return csvFile;
	}
}

package de.swt.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.swt.gui.ViewMain;

public class ActionlistenerViewMain implements ActionListener {

	ViewMain parent;

	public ActionlistenerViewMain(ViewMain parent) {
		this.parent = parent;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == parent.getBtnStart()) {
			parent.getTimerPingIntervall().setDelay(Integer.parseInt(parent.getTfPingIntervall().getText()));
			parent.getTimerPingIntervall().start();
		} else if (e.getSource() == parent.getBtnStop()) {
			parent.getTimerPingIntervall().stop();
		} else if (e.getSource() == parent.getTimerPingIntervall()) {
			System.out.println("Timer");
		}
	}
}

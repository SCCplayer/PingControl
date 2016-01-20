package de.swt.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.swt.gui.ViewMain;
import de.swt.lib.LogWriter;
import de.swt.lib.PingProzess;

public class ActionlistenerViewMain implements ActionListener {

	ViewMain parent;

	public ActionlistenerViewMain(ViewMain parent) {
		this.parent = parent;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == parent.getBtnStart()) {
			parent.getTimerPingIntervall().setDelay(Integer.parseInt(parent.getTfPingIntervall().getText()) * 1000);
			parent.setPing(new PingProzess(parent.getTfIPv4().getText()));
			parent.setTitle("PingCheck: " + parent.getTfIPv4().getText());
			LogWriter.createLogDatei();
			parent.getTimerPingIntervall().start();
		} else if (e.getSource() == parent.getBtnStop()) {
			parent.getTimerPingIntervall().stop();
			parent.setTitle("PingCheck");
		} else if (e.getSource() == parent.getTimerPingIntervall()) {
			// System.out.println(parent.getPing().getPingText() + new Date());
			parent.addLogeintrag();
		}
	}
}

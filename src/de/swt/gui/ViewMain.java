package de.swt.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

import de.swt.lib.Ping;
import de.swt.listener.ActionlistenerViewMain;

public class ViewMain extends JFrame {

	JPanel pnlCenter = new JPanel(new GridLayout(3, 2));
	JPanel pnlBtn = new JPanel(new FlowLayout());

	JLabel lblIPv4 = new JLabel("IP-Adresse:");
	JTextField tfIPv4 = new JTextField();

	JLabel lblPingIntervall = new JLabel("Ping Intervall in Sekunden:");
	JTextField tfPingIntervall = new JTextField();

	JLabel lblEmail = new JLabel("E-Mailadresse:");
	JTextField tfEmail = new JTextField();

	JButton btnStart = new JButton("Start Ping");
	JButton btnStop = new JButton("Stop Ping");

	ActionlistenerViewMain alvm = new ActionlistenerViewMain(this);

	Timer timerPingintervall = new Timer(1000, alvm);

	Ping p;

	public ViewMain()

	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		pnlCenter.add(lblIPv4);
		pnlCenter.add(tfIPv4);
		pnlCenter.add(lblPingIntervall);
		pnlCenter.add(tfPingIntervall);
		pnlCenter.add(lblEmail);
		pnlCenter.add(tfEmail);

		add(pnlCenter, BorderLayout.CENTER);

		btnStart.addActionListener(alvm);
		btnStop.addActionListener(alvm);
		pnlBtn.add(btnStart);
		pnlBtn.add(btnStop);

		add(pnlBtn, BorderLayout.SOUTH);

		setVisible(true);
		setSize(500, 500);
	}

	public String getIPv4() {
		return tfIPv4.getText();
	}

	public JButton getBtnStart() {
		return btnStart;
	}

	public JButton getBtnStop() {
		return btnStop;
	}

	public Timer getTimerPingIntervall() {
		return timerPingintervall;
	}

	public JTextField getTfIPv4() {
		return tfIPv4;
	}

	public JTextField getTfPingIntervall() {
		return tfPingIntervall;
	}

	public JTextField getTfEmail() {
		return tfEmail;
	}

	public void setPing(Ping myPing) {
		p = myPing;
	}
}

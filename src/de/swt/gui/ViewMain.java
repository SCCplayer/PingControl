package de.swt.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Date;
import java.util.LinkedList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import de.swt.lib.LogWriter;
import de.swt.lib.PingProzess;
import de.swt.listener.ActionlistenerViewMain;

public class ViewMain extends JFrame {

	LinkedList<String> listPingLog = new LinkedList<String>();
	DefaultListModel<String> listTest = new DefaultListModel<String>();
	JScrollPane spPingLog;

	JPanel pnlLog = new JPanel(new BorderLayout());
	JPanel pnlSouth = new JPanel(new BorderLayout());
	JPanel pnlCenter = new JPanel(new BorderLayout());
	JPanel pnlGrid = new JPanel(new GridLayout(3, 2));
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

	PingProzess p;

	public ViewMain()

	{
		pnlLog.add(new JList(listTest), BorderLayout.CENTER);
		spPingLog = new JScrollPane(pnlLog);
		spPingLog.setPreferredSize(new Dimension(200, 200));
		pnlCenter.add(spPingLog, BorderLayout.SOUTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		pnlGrid.setBorder(new EmptyBorder(5, 5, 5, 5));
		pnlLog.setBorder(new EmptyBorder(5, 5, 5, 5));

		pnlGrid.add(lblIPv4);
		pnlGrid.add(tfIPv4);
		pnlGrid.add(lblPingIntervall);
		pnlGrid.add(tfPingIntervall);
		pnlGrid.add(lblEmail);
		pnlGrid.add(tfEmail);

		// spPingLog.setPreferredSize(new Dimension(200, 500));
		// pnlCenter.add(new JList(listTest), BorderLayout.SOUTH);
		pnlCenter.add(pnlGrid, BorderLayout.CENTER);
		add(pnlCenter, BorderLayout.CENTER);

		pnlGrid.setPreferredSize(new Dimension(200, 200));

		btnStart.addActionListener(alvm);
		btnStop.addActionListener(alvm);
		pnlBtn.add(btnStart);
		pnlBtn.add(btnStop);

		add(pnlBtn, BorderLayout.SOUTH);

		tfIPv4.setText("10.20.30.91");
		tfPingIntervall.setText("1");
		tfEmail.setText("monitoring@swtue.de");
		setTitle("PingCheck");
		setVisible(true);
		setSize(600, 400);
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

	public void setPing(PingProzess myPing) {
		p = myPing;
	}

	public PingProzess getPing() {
		return p;
	}

	public void addLogeintrag() {
		String[] splitPingText;
		listPingLog.add(getPing().getPingText() + " " + new Date());
		listTest.addElement(listPingLog.getLast());

		splitPingText = listPingLog.getLast().split(" ");
		System.out.println(listPingLog.getLast());
		spPingLog.getVerticalScrollBar().setValue(spPingLog.getVerticalScrollBar().getMaximum());
		if (splitPingText[0].compareTo("Antwort") == 0) {
			LogWriter.createLogEintrag(splitPingText[2].replace(":", "") + ";"
					+ splitPingText[4].replace("ms", "").replace("Zeit=", "").replace("Zeit<", "") + ";"
					+ splitPingText[8] + ". " + splitPingText[7] + " " + splitPingText[11] + ";" + splitPingText[9]);
		}
	}
}

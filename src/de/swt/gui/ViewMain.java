package de.swt.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ViewMain extends JFrame {

	JPanel pnlIPv4Eingabe = new JPanel(new FlowLayout());
	JLabel lblIPv4 = new JLabel("IP-Adresse");
	JTextField tfIPv4 = new JTextField();

	JButton btnStart = new JButton("Start Ping");

	public ViewMain() {
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pnlIPv4Eingabe.add(lblIPv4);
		pnlIPv4Eingabe.add(tfIPv4);

	}
}

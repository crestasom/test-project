package com.example.demo;

import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class JDBCTest extends JFrame implements ActionListener {

	JButton btnConnect, btnClose;
	Connection con = null;

	public JDBCTest() {
		Panel p = new Panel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		btnConnect = new JButton("Connect");
		btnConnect.addActionListener(this);
		btnClose = new JButton("Close");
		btnClose.addActionListener(this);
		p.add(btnConnect);
		p.add(btnClose);
		add(p);
		pack();
		setVisible(true);

	}

	public static void main(String[] args) {
		new JDBCTest();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnConnect)) {
			if (con == null) {
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					con = DriverManager.getConnection("jdbc:sqlserver://10.10.10.114:1433;databaseName=saipaltech",
							"sa", "M0bilenumberPankaj123!@#");

				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}

		} else if (e.getSource().equals(btnClose)) {
			try {
				if (con != null && !con.isClosed()) {
					con.close();
					con = null;
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

}

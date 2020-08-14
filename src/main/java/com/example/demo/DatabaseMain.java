package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DatabaseMain {

	public static void main(String[] args) throws Exception {

		String url = "jdbc:sqlserver://10.10.10.3\\stech:1433;databaseName=saipaltech";
		String username = "sa";
		String password = "87175AdhikariM0bilenumber";
		String sql = "";
		Statement stmt;
		ResultSet rs;
		Connection con;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// 1. get the connection object
		con = (Connection) DriverManager.getConnection(url, username, password);
		// 2. prepare sql string
		sql = "SELECT * FROM vertex ";
		// 3. prepare sql statement to be executed
		stmt = (Statement) con.createStatement();
		// 4 get the resultset from execution
		rs = stmt.executeQuery(sql);
		/*
		 * use rs.get... to get the data from result rs. next check if there is data on
		 * next row also automatically moves the cursor to next row of data
		 */
		java.util.List<Vertex> vList = new ArrayList<>();
		while (rs.next()) {
			Vertex v = new Vertex();
			v.setId(rs.getInt(1));
			v.setName(rs.getString(2));
			v.setLati(rs.getDouble(3));
			v.setLogi(rs.getDouble(4));
			vList.add(v);
		}
		for (Vertex v : vList) {
			System.out.println(v);
		}

		rs.close();

//		stmt.close();
		con.close();
		System.out.println(rs);
	}

}

class Vertex {
	private int id;
	private String name;
	private double lati;
	private double logi;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getLati() {
		return lati;
	}

	public void setLati(double lati) {
		this.lati = lati;
	}

	public double getLogi() {
		return logi;
	}

	public void setLogi(double logi) {
		this.logi = logi;
	}

	@Override
	public String toString() {
		return "Vertex [id=" + id + ", name=" + name + ", lati=" + lati + ", logi=" + logi + "]";
	}

}
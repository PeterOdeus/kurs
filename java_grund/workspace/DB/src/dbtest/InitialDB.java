package dbtest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InitialDB {
	String url = "jdbc:derby://localhost:1527/sample;create=true";
	String user = "peter";
	String pwd = "peter";

	private void useDB() {
		createTable();
		insert();
		update();
		select();
	}

	private void select() {
		try{
			Connection db = DriverManager.getConnection(url, user, pwd);
			db.setAutoCommit(false);
			Statement s = db.createStatement();
			ResultSet rs = s.executeQuery("SELECT * FROM derbyDB");
			while (rs.next()) {
				System.out.format("Num: %d, Street: %s%n", rs.getInt(1), rs.getString(2));
			}
			s.close();
			db.commit();
			db.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void update() {
		Connection db;
		try {
			db = DriverManager.getConnection(url, user, pwd);

			db.setAutoCommit(false);
			Statement s = db.createStatement();
			s.execute("update derbyDB set num=180, addr='Grand Ave.' where num=1956");
			System.out.println("Updated 1956 Webster to 180 Grand");
			s.execute("update derbyDB set num=300, addr='Lakeshore Ave.' where num=180");
			System.out.println("Updated 180 Grand to 300 Lakeshore");
			s.close();
			db.commit();
			db.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void insert() {
		Connection db;
		try {
			db = DriverManager.getConnection(url, user, pwd);

			db.setAutoCommit(false);
			Statement s = db.createStatement();
			s.execute("insert into derbyDB values (1956,'Webster St.')");
			System.out.println("Inserted 1956 Webster");
			s.execute("insert into derbyDB values (1910,'Union St.')");
			System.out.println("Inserted 1910 Union");
			s.close();
			db.commit();
			db.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void createTable() {
		try {
			Connection db = DriverManager.getConnection(url, user, pwd);
			db.setAutoCommit(false);
			Statement s = db.createStatement();

			s.execute("create table derbyDB(num int, addr varchar(40))");
			System.out.println("Created table derbyDB");

			s.close();
			db.commit();
			db.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new InitialDB().useDB();
	}
}
